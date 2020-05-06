import py_entitymatching as em
import pandas as pd
import os
from datetime import datetime
import re

pd.options.display.max_columns = None
pd.options.display.max_rows = None

# Script runtime measurement
startTime = datetime.now()

path_A = "B:\McMaster\CAS 764 - Advance Topics in Data Management\Project\Data\\restaurants\\fodors.csv"
path_B = "B:\McMaster\CAS 764 - Advance Topics in Data Management\Project\Data\\restaurants\\zagats.csv"

pk_A = "id"
pk_B = "id"

A = em.read_csv_metadata(path_A, key=pk_A)
B = em.read_csv_metadata(path_B, key=pk_B)

print("\n- Blockers...")

ab = em.AttrEquivalenceBlocker()

#Output attributes list
out_attr = ['name', 'addr', 'city', 'phone', 'type']


add_missing_val = False

# Used A, if table columns are different - change
blocking_col = 'type'

# TABLE BLOCK
C=ab.block_tables(A, B, blocking_col,blocking_col,l_output_attrs=out_attr,r_output_attrs=out_attr,allow_missing=add_missing_val,n_jobs=-1)
len(C)


ob = em.OverlapBlocker()

blocking_col = 'name'

add_missing_val = False
overlap_size = 1
use_world_level = True
q_gram_value = None
use_stop_words = True

C = ob.block_candset(C, l_overlap_attr=blocking_col,r_overlap_attr=blocking_col,rem_stop_words=use_stop_words,q_val=q_gram_value,word_level=use_world_level,overlap_size=overlap_size,allow_missing=add_missing_val,n_jobs=-1,show_progress=False)
len(C)
"""
overlap_size = 3
use_world_level = False
q_gram_value = 3
use_stop_words = False

blocking_col = 'phone'

C = ob.block_candset(C, l_overlap_attr=blocking_col,r_overlap_attr=blocking_col,rem_stop_words=use_stop_words,q_val=q_gram_value,word_level=use_world_level,overlap_size=overlap_size,allow_missing=add_missing_val,n_jobs=-1,show_progress=False)
len(C)

overlap_size = 1
use_world_level = False
q_gram_value = 1

blocking_col = 'city'

C = ob.block_candset(C, l_overlap_attr=blocking_col,r_overlap_attr=blocking_col,rem_stop_words=use_stop_words,q_val=q_gram_value,word_level=use_world_level,overlap_size=overlap_size,allow_missing=add_missing_val,n_jobs=-1,show_progress=False)
len(C)


def name_first_letter_match(ltuple, rtuple):
    x = ltuple['name'].replace("'", "")[0]
    y = rtuple['name'].replace("'", "")[0]
    if x != y:
        return True
    else:
        return False
		
def city_first_letter_match(ltuple, rtuple):
    x = ltuple['city'].replace("'", "")[0]
    y = rtuple['city'].replace("'", "")[0]
    if x != y:
        return True
    else:
        print(x + " - " + y)
        return False
		
def first_address_number_match(ltuple, rtuple):
    x = ltuple['addr'].split()[0].replace("'", "")
    y = rtuple['addr'].split()[0].replace("'", "")
    if x != y:
        return True
    else:
        return False
		
def first_phone_number_match(ltuple, rtuple):
    x = re.split(' |-|/',ltuple['phone'])
    y = re.split(' |-|/',rtuple['phone'])
    if x != y:
        return True
    else:
        return False
		
bb = em.BlackBoxBlocker()

bb.set_black_box_function(name_first_letter_match)
C = bb.block_candset(C)
len(C)

bb.set_black_box_function(city_first_letter_match)
C = bb.block_candset(C)
len(C)

bb.set_black_box_function(first_address_number_match)
C = bb.block_candset(C)
len(C)

bb.set_black_box_function(first_phone_number_match)
C = bb.block_candset(C)
len(C)
"""

print("\n- Sampling and Labeling...")
S = em.sample_table(C, 50)

G = em.label_table(S, 'label')

IJ = em.split_train_test(G, train_proportion=0.7, random_state=0)
I = IJ['train']
J = IJ['test']

ltable_pk = "ltable_" + pk_A
rtable_pk = "rtable_" + pk_B

dt = em.DTMatcher(name='DecisionTree', random_state=0)
svm = em.SVMMatcher(name='SVM', random_state=0)
rf = em.RFMatcher(name='RF', random_state=0)
lg = em.LogRegMatcher(name='LogReg', random_state=0)
ln = em.LinRegMatcher(name='LinReg')
nb = em.NBMatcher(name='NaiveBayes')

feature_table = em.get_features_for_matching(A, B, validate_inferred_attr_types=False)

H = em.extract_feature_vecs(I, feature_table=feature_table, attrs_after='label', show_progress=False)

H = em.impute_table(H, exclude_attrs=['_id', ltable_pk, rtable_pk, 'label'], strategy='mean', val_all_nans=0.0)

result = em.select_matcher(matchers=[dt, rf, svm, ln, lg, nb], table=H, exclude_attrs=['_id', ltable_pk, rtable_pk, 'label'], k=5, target_attr='label', metric_to_select_matcher='f1', random_state=0)

print("\n- Matcher selection Results:")
print(result['cv_stats'])

UV = em.split_train_test(H, train_proportion=0.5)
U = UV['train']
V = UV['test']

em.vis_debug_rf(rf, U, V,
		exclude_attrs=['_id', ltable_pk, rtable_pk, 'label'],
		target_attr='label')
		
em.vis_debug_dt(dt, U, V,
		exclude_attrs=['_id', ltable_pk, rtable_pk, 'label'],
		target_attr='label')

L = em.extract_feature_vecs(J, feature_table=feature_table, attrs_after='label', show_progress=False)

L = em.impute_table(L, exclude_attrs=['_id', ltable_pk, rtable_pk, 'label'], strategy='mean', val_all_nans=0.0)


rf.fit(table=H, exclude_attrs=['_id', ltable_pk, rtable_pk, 'label'], target_attr='label')

dt.fit(table=H, exclude_attrs=['_id', ltable_pk, rtable_pk, 'label'], target_attr='label')

svm.fit(table=H, exclude_attrs=['_id', ltable_pk, rtable_pk, 'label'], target_attr='label')

lg.fit(table=H, exclude_attrs=['_id', ltable_pk, rtable_pk, 'label'], target_attr='label')

ln.fit(table=H, exclude_attrs=['_id', ltable_pk, rtable_pk, 'label'], target_attr='label')

nb.fit(table=H, exclude_attrs=['_id', ltable_pk, rtable_pk, 'label'], target_attr='label')


print("\n- Predicting the Random Forest matches...")

predictions_rf = rf.predict(table=L, exclude_attrs=['_id', ltable_pk, rtable_pk, 'label'], append=True, target_attr='predicted', inplace=False)

eval_result_rf = em.eval_matches(predictions_rf, 'label', 'predicted')
print(em.print_eval_summary(eval_result_rf))


print("\n- Predicting the Decision Tree matches...")

predictions_dt = dt.predict(table=L, exclude_attrs=['_id', ltable_pk, rtable_pk, 'label'], append=True, target_attr='predicted', inplace=False)

eval_result_dt = em.eval_matches(predictions_dt, 'label', 'predicted')
print(em.print_eval_summary(eval_result_dt))


print("\n- Predicting the SVM matches...")

predictions_svm = svm.predict(table=L, exclude_attrs=['_id', ltable_pk, rtable_pk, 'label'], append=True, target_attr='predicted', inplace=False)

eval_result_svm = em.eval_matches(predictions_svm, 'label', 'predicted')
print(em.print_eval_summary(eval_result_svm))


print("\n- Predicting the Logistic Regression matches...")

predictions_lg = lg.predict(table=L, exclude_attrs=['_id', ltable_pk, rtable_pk, 'label'], append=True, target_attr='predicted', inplace=False)

eval_result_lg = em.eval_matches(predictions_lg, 'label', 'predicted')
print(em.print_eval_summary(eval_result_lg))


print("\n- Predicting the Linear Regression matches...")

predictions_ln = ln.predict(table=L, exclude_attrs=['_id', ltable_pk, rtable_pk, 'label'], append=True, target_attr='predicted', inplace=False)

eval_result_ln = em.eval_matches(predictions_ln, 'label', 'predicted')
print(em.print_eval_summary(eval_result_ln))


print("\n- Predicting the Naive Bayes matches...")

predictions_nb = nb.predict(table=L, exclude_attrs=['_id', ltable_pk, rtable_pk, 'label'], append=True, target_attr='predicted', inplace=False)

eval_result_nb = em.eval_matches(predictions_nb, 'label', 'predicted')
print(em.print_eval_summary(eval_result_nb))


print("\n- Time elapsed:")
print(datetime.now() - startTime)




























