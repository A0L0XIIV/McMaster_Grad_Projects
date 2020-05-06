import py_entitymatching as em
import pandas as pd
import os
from datetime import datetime
import re

pd.options.display.max_columns = None
pd.options.display.max_rows = None

# Script runtime measurement
startTime = datetime.now()

path_A = "B:\McMaster\CAS 764 - Advance Topics in Data Management\Project\Data\\products\\amazon_7col.csv"
path_B = "B:\McMaster\CAS 764 - Advance Topics in Data Management\Project\Data\\products\\walmart_7col.csv"

pk_A = "id"
pk_B = "id"

A = em.read_csv_metadata(path_A, key=pk_A)
B = em.read_csv_metadata(path_B, key=pk_B)

print("\n- Blockers...")

ab = em.AttrEquivalenceBlocker()

#Output attributes list
out_attr = ['brand', 'title', 'price', 'modelno', 'dimensions', 'weight']


ob = em.OverlapBlocker()

blocking_col = 'title'

add_missing_val = False
overlap_size = 5
use_world_level = True
q_gram_value = None
use_stop_words = True

C = ob.block_tables(A, B, l_overlap_attr=blocking_col,r_overlap_attr=blocking_col,l_output_attrs=out_attr,r_output_attrs=out_attr,rem_stop_words=use_stop_words,q_val=q_gram_value,word_level=use_world_level,overlap_size=overlap_size,allow_missing=add_missing_val,n_jobs=-1,show_progress=False)
len(C)


def price_10_percent_comparision(x, y):
    # get number attributes
    x_number = float(x['price'])
    y_number = float(y['price'])
    if x_number == 'NaN' or x_number == 'nan' or x_number == '':
        return False
    if y_number == 'NaN' or y_number == 'nan' or y_number == '':
        return False
    # Equal
    if(x_number == y_number):
        return False
    # X is larger and Y is less than 10% smaller
    elif(x_number > y_number and ((x_number * 0.9) <= y_number)):
        return False
    # Y is larger and X is less than 10% smaller
    elif (y_number > x_number and ((y_number * 0.9) <= x_number)):
        return False
    else:
        return True
		
def brand_match(ltuple, rtuple):
    if(isinstance(ltuple['brand'], str)):
        x = ltuple['brand'].split()[0].replace("'", "")
    else:
        return False
    if(isinstance(rtuple['brand'], str)):
        y = rtuple['brand'].split()[0].replace("'", "")
    else:
        return False
    if x == 'NaN' or x == 'nan' or x == '':
        return False
    if y == 'NaN' or y == 'nan' or y == '':
        return False
    if x != y:
        return True
    else:
        return False

		
bb = em.BlackBoxBlocker()

bb.set_black_box_function(brand_match)
C = bb.block_candset(C)
len(C)

bb.set_black_box_function(price_10_percent_comparision)
C = bb.block_candset(C)
len(C)


print("\n- Sampling and Labeling...")
S = em.sample_table(C, 100)

G = em.label_table(S, 'label')

print("\n- Split train&test...")
IJ = em.split_train_test(G, train_proportion=0.7, random_state=0)
I = IJ['train']
J = IJ['test']

ltable_pk = "ltable_" + pk_A
rtable_pk = "rtable_" + pk_B

print("\n- ML methods creation...")
dt = em.DTMatcher(name='DecisionTree', random_state=0)
svm = em.SVMMatcher(name='SVM', random_state=0)
rf = em.RFMatcher(name='RF', random_state=0)
lg = em.LogRegMatcher(name='LogReg', random_state=0)
ln = em.LinRegMatcher(name='LinReg')
nb = em.NBMatcher(name='NaiveBayes')

print("\n- Feature Table...")
feature_table = em.get_features_for_matching(A, B, validate_inferred_attr_types=False)

asd = input()

print("\n- Feature Table to Vector...")
H = em.extract_feature_vecs(I, feature_table=feature_table, attrs_after='label', show_progress=False)

print("\n- Feature Vector missing values...")
H = em.impute_table(H, exclude_attrs=['_id', ltable_pk, rtable_pk, 'label'], strategy='mean', val_all_nans=0.0)

print("\n- Calculate the results...")
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




























