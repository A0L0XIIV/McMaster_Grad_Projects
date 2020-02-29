import py_entitymatching as em
import pandas as pd
import os
import warnings
# Hide all future/pandas warnings
warnings.filterwarnings("ignore")

# Pandas setting for showing full table, all columns (without this most of them are hidden)
pd.options.display.max_columns = None
pd.options.display.max_rows = None

# WELCOME TO MY MAGELLAN RUN SCRIPT
print("\n-------------WELCOME TO MY MAGELLAN RUN SCRIPT-------------\n")

# Get the datasets directory
datasets_dir = 'B:\McMaster\CAS 764 - Advance Topics in Data Management\Project\Data\\'
print("- Dataset directory: " + datasets_dir)
print("- List of folders/files: ")
print(os.listdir(datasets_dir))
print("- Please enter new dataset folder name:")
datasets_dir += input()
print("- Dataset directory set to: " + datasets_dir)

dateset_dir_files = os.listdir(datasets_dir)
print("- List of files in dataset folder: ")
print(dateset_dir_files)

# Get the path of the input table A
print("- Enter an index for Table A file (0-x):")
file_index_A = input()
filename_A = dateset_dir_files[int(file_index_A)]
print("Table A file set to: " + filename_A)

# Get the path of the input table
path_A = datasets_dir + os.sep + filename_A

# Get the path of the input table B
print("- Enter an index for Table B file (0-x):")
file_index_B = input()
filename_B = dateset_dir_files[int(file_index_B)]
print("Table B file set to: " + filename_B)

# Get the path of the input table
path_B = datasets_dir + os.sep + filename_B

# Print Table A column names
A = em.read_csv_metadata(path_A)
print("- List of columns of Table A: ")
print(list(A.columns))
# Get the Table A id/primary key column name
print('- Enter Table A primary key column index (ex. 0):')
pk_A_index = input()
pk_A = A.columns[int(pk_A_index)]

# Print Table B column names
B = em.read_csv_metadata(path_B)
print("- List of columns of Table B: ")
print(list(B.columns))
# Get the Table B id/primary key column name
print('- Enter Table B primary key column index (ex. 0):')
pk_B_index = input()
pk_B = A.columns[int(pk_A_index)]

# READING TABLES AND SETTING METADATA
print("\n-------------READING TABLES AND SETTING METADATA-------------\n")

# Both read csv and set metadata id as ID column
#A = em.read_csv_metadata(path_A, key=pk_A)
#B = em.read_csv_metadata(path_B, key=pk_B)
em.set_key(A, pk_A)
em.set_key(B, pk_B)

# Number of tables
print('- Number of tuples in A: ' + str(len(A)))
print('- Number of tuples in B: ' + str(len(B)))
print('- Number of tuples in A X B (i.e the cartesian product): ' + str(len(A)*len(B)))

# Print first 5 tuples of tables
print(A.head())
print(B.head())

# Display the keys of the input tables
print("- Table A primary key: " + em.get_key(A))
print("- Table B primary key: " + em.get_key(B))

# DOWNSAMPLING
print("\n-------------DOWNSAMPING-------------\n")

print("- Do you want to use downsampling? (y or n):")
print("- Table A: " + str(len(A)) + ", Table B: " + str(len(B)))
print("- NOTE: Recommended if both tables have 100K+ tuples.")
is_downsample = input()
if(is_downsample == 'y'):
    print("- Size of the downsampled tables (ex. 200):")
    downsample_size = input()
    # If the tables are large we can downsample the tables like this
    A1, B1 = em.down_sample(A, B, downsample_size, 1, show_progress=False)
    print("- Length of Table A1" + len(A1))
    print("- Length of Table B1" + len(B1))

# BLOCKING
print("\n-------------BLOCKING-------------\n")

print("- Do you want to use blocking? (y or n):")
is_blocking = input()
if (is_blocking == 'y'):

    print(list(A.columns))
    print(list(B.columns))
    print("- Do both tables have the same columns? (y or n):")
    is_same_col = input()
    if(is_same_col == 'y'):
        C_attr_eq = []  # Attr Equ blocker result list
        C_overlap = []  # Overlap blocker result list
        # Loop for adding/combining new blockers
        while(True):
            print("- List of columns: ")
            print(list(A.columns))
            # Debug output table column selection
            print("- Enter the indexes of columns that you want to see in debug table (0-" + str(
                len(A.columns) - 1) + "):")
            out_attr = []
            for i in range(1, len(A.columns)):
                print("- Finish with empty character(enter+enter) " + str(i))
                add_to_attr = input()
                if (add_to_attr == ''):
                    break
                # Get indexes from user and add columns into out_attr list
                out_attr.append(A.columns[int(add_to_attr)])

            # Print output attributes
            print(out_attr)

            # Blocker selection
            print("\n- Do yo want to use Attribute Equivalence[ab] (same) or Overlap[ob] (similar) blocker (0-1):")
            blocker_selection = input()

            # ----- Attribute Equivalence Blocker -----
            if(blocker_selection == 'ab'):
                # Create attribute equivalence blocker
                ab = em.AttrEquivalenceBlocker()
                # Counter for indexes
                attr_eq_counter = 0

                # Loop for adding more columns/attributes into Attr Equ blocker
                while(True):
                    # List column names
                    print("- List of columns: ")
                    print(list(A.columns))
                    # Get blocking attribute/column
                    print("- Which column (w/ index) to use for equivalence blocking? (ex. 1):")
                    blocking_col_index = input()
                    blocking_col = A.columns[int(blocking_col_index)]

                    print("\n- Do you want to add missing values into blocking? (y or n):")
                    add_missing_val = input()
                    if(add_missing_val == 'y'):
                        add_missing_val = True
                    else:
                        add_missing_val = False

                    # First time using Attr Equ blocker, use A and B
                    if(attr_eq_counter == 0):
                        # Block using selected (blocking_col) attribute on A and B
                        C_attr_eq.append(ab.block_tables(A, B, blocking_col, blocking_col,
                                                         l_output_attrs=out_attr,
                                                         r_output_attrs=out_attr,
                                                         l_output_prefix='l_',
                                                         r_output_prefix='r_',
                                                         allow_missing=add_missing_val,
                                                         n_jobs=-1)
                                         )
                    # Not first time, add new constraint into previous candidate set
                    else:
                        # Block using selected (blocking_col) attribute on previous (last=-1) candidate set
                        C_attr_eq.append(ab.block_candset(C_attr_eq[-1],
                                                          l_block_attr=blocking_col,
                                                          r_block_attr=blocking_col,
                                                          allow_missing=add_missing_val,
                                                          n_jobs=-1,
                                                          show_progress=False)
                                         )

                    # DEBUG BLOCKING
                    print("\n- Attribute Equivalence Blocker Debugging...\n")
                    # Debug last blocker output
                    dbg = em.debug_blocker(C_attr_eq[-1], A, B, output_size=200)

                    # Display first few tuple pairs from the debug_blocker's output
                    print("\n- Blocking debug results:")
                    print(dbg.head())

                    attr_eq_counter += 1  # Increase the counter

                    # Continue to use Attribute Equivalence Blocker or not
                    print("\n- Length of candidate set: " + str(len(C_attr_eq[-1])))
                    print("- Do you want to add another column into Attribute Equivalence Blocker (y or n):")
                    is_cont_attr_eq = input()
                    if(is_cont_attr_eq == 'n'):
                        break


            # ----- Overlap Blocker -----
            elif(blocker_selection == 'ob'):
                # Create attribute equivalence blocker
                ob = em.OverlapBlocker()
                # Counter for indexes
                overlap_counter = 0

                # Loop for adding more columns/attributes into Overlap blocker
                while (True):
                    # List column names
                    print("- List of columns: ")
                    print(list(A.columns))
                    # Get blocking attribute/column
                    print("- Which column (w/ index) to use for overlap blocking? (ex. 1):")
                    blocking_col_index = input()
                    blocking_col = A.columns[int(blocking_col_index)]

                    print("\n- Do you want to add missing values into blocking? (y or n):")
                    add_missing_val = input()
                    if (add_missing_val == 'y'):
                        add_missing_val = True
                    else:
                        add_missing_val = False

                    print("\n- Enter the overlap size (# of tokens that overlap):")
                    overlap_size = input()

                    print("\n- Do you want to remove (a, an, the) from token set? (y or n):")
                    use_stop_words = input()
                    if (use_stop_words == 'y'):
                        use_stop_words = True
                    else:
                        use_stop_words = False

                    # First time using Overlap blocker, use A and B
                    if (overlap_counter == 0):
                        # Block using selected (blocking_col) attribute on A and B
                        C_overlap.append(ob.block_tables(A, B, blocking_col, blocking_col,
                                                         l_output_attrs=out_attr,
                                                         r_output_attrs=out_attr,
                                                         l_output_prefix='l_',
                                                         r_output_prefix='r_',
                                                         rem_stop_words=use_stop_words,
                                                         overlap_size=overlap_size,
                                                         allow_missing=add_missing_val,
                                                         n_jobs=-1)
                                         )
                    # Not first time, add new constraint into previous candidate set
                    else:
                        # Block using selected (blocking_col) attribute on previous (last=-1) candidate set
                        C_overlap.append(ob.block_candset(C_attr_eq[-1],
                                                          l_overlap_attr=blocking_col,
                                                          r_overlap_attr=blocking_col,
                                                          rem_stop_words=use_stop_words,
                                                          overlap_size=overlap_size,
                                                          allow_missing=add_missing_val,
                                                          n_jobs=-1,
                                                          show_progress=False)
                                         )

                    # DEBUG BLOCKING
                    print("\n- Overlap Blocker Debugging...\n")
                    # Debug last blocker output
                    dbg = em.debug_blocker(C_overlap[-1], A, B, output_size=200)

                    # Display first few tuple pairs from the debug_blocker's output
                    print("\n- Blocking debug results:")
                    print(dbg.head())

                    overlap_counter += 1  # Increase the counter

                    # Continue to use Attribute Equivalence Blocker or not
                    print("\n- Length of candidate set: " + str(len(C_overlap[-1])))
                    print("- Do you want to add another column into Overlap Blocker (y or n):")
                    is_cont_overlap = input()
                    if (is_cont_overlap == 'n'):
                        break


            print("\n- Do you want to add/use another blocker? (y or n):")
            blocker_decision = input()
            if(blocker_decision == 'n'):
                break

        # Combine/union blockers candidate sets
        if(C_attr_eq and C_overlap): # Both blocker types used
            C = em.combine_blocker_outputs_via_union([C_attr_eq[-1], C_overlap[-1]])
        elif(C_attr_eq): # Only AttrEquivalenceBlocker used
            C = C_attr_eq[-1]
        elif(C_overlap): # Only OverlapBlocker used
            C = C_overlap[-1]
        else: # Error
            C = []
        print("\n- Length of C: " + str(len(C)))

    else:
        print("\n- Sorry, this feature currently not supported. :(")


# SAMPLING&LABELING
print("\n-------------SAMPLING&LABELING-------------\n")

print("- Choose sampling size (eg. 450):")
sampling_size = input()
while(int(sampling_size) > len(C)):
    print("- Sampling size cannot be bigger than " + str(len(C)))
    sampling_size = input()

# Sample  candidate set
S = em.sample_table(C, int(sampling_size))

print("- New window will pop-up for " + sampling_size + " sized table.")
print("- If there is a match, change tuple's label value to 1")

# Label S
G = em.label_table(S, 'label')

#DEVELOPMENT AND EVALUATION
print("\n-------------DEVELOPMENT AND EVALUATION-------------\n")

# Split S into development set (I) and evaluation set (J)
IJ = em.split_train_test(G, train_proportion=0.7, random_state=0)
I = IJ['train']
J = IJ['test']

#SELECTING THE BEST MATCHER
print("\n-------------SELECTING THE BEST MATCHER-------------\n")

# Create a set of ML-matchers
dt = em.DTMatcher(name='DecisionTree', random_state=0)
svm = em.SVMMatcher(name='SVM', random_state=0)
rf = em.RFMatcher(name='RF', random_state=0)
lg = em.LogRegMatcher(name='LogReg', random_state=0)
ln = em.LinRegMatcher(name='LinReg')
nb = em.NBMatcher(name='NaiveBayes')

print("\n- 6 different ML-matchers created: DL, SVM, RF, LogReg, LinReg, NB")


print("\n- Creating features...")
# Generate features
feature_table = em.get_features_for_matching(A, B, validate_inferred_attr_types=False)

print("\n- Features list:")
# List the names of the features generated
print(feature_table['feature_name'])


print("\n- Converting the development set to feature vectors...")
# Convert the I into a set of feature vectors using feature_table
H = em.extract_feature_vecs(I,
                            feature_table=feature_table,
                            attrs_after='label',
                            show_progress=False)

print("\n- Feature table first rows:")
# Display first few rows
print(H.head())

# Primary key of tables
ltable_pk = "ltable_" + pk_A
rtable_pk = "rtable_" + pk_B

# Check if the feature vectors contain missing values
# A return value of True means that there are missing values
is_missing_values = any(pd.notnull(H))
print("\n- Does feature vector have missing values: " + str(is_missing_values))
if(is_missing_values):
    # Impute feature vectors with the mean of the column values.
    H = em.impute_table(H,
                        exclude_attrs=['_id', ltable_pk, rtable_pk, 'label'],
                        strategy='mean',
                        val_all_nans=0.0)
    #print("\n- Feature table first rows:")
    # Display first few rows
    #print(H.head())
    print("- Impute table function used for missing values.")


print("\n- Selecting the best matcher using cross-validation...")
# Select the best ML matcher using CV
result = em.select_matcher(matchers=[dt, rf, svm, ln, lg, nb],
                           table=H,
                           exclude_attrs=['_id', ltable_pk, rtable_pk, 'label'],
                           k=5,
                           target_attr='label',
                           metric_to_select_matcher='f1',
                           random_state=0
                           )
print("\n- Results:")
print(result['cv_stats'])

#DEBUGGING THE MATCHER
print("\n-------------DEBUGGING THE MATCHER-------------\n")

#  Split feature vectors into train and test
UV = em.split_train_test(H, train_proportion=0.5)
U = UV['train']
V = UV['test']

# Debug decision tree using GUI
em.vis_debug_rf(rf, U, V,
        exclude_attrs=['_id', ltable_pk, rtable_pk, 'label'],
        target_attr='label')

print("\n- Do you want to add another feature?")

H = em.extract_feature_vecs(I, feature_table=feature_table,
                            attrs_after='label', show_progress=False)

# Check if the feature vectors contain missing values
# A return value of True means that there are missing values
is_missing_values = any(pd.notnull(H))
print("\n- Does feature vector have missing values: " + str(is_missing_values))
if(is_missing_values):
    # Impute feature vectors with the mean of the column values.
    H = em.impute_table(H,
                        exclude_attrs=['_id', ltable_pk, rtable_pk, 'label'],
                        strategy='mean')
    print("\n- Feature table first rows:")
    # Display first few rows
    print(H.head())

# Select the best ML matcher using CV
result = em.select_matcher([dt, rf, svm, ln, lg, nb], table=H,
        exclude_attrs=['_id', ltable_pk, rtable_pk, 'label'],
        k=5,
        target_attr='label', metric_to_select_matcher='f1', random_state=0)

print("\n- Results:")
print(result['cv_stats'])

#EVALUATING THE MATCHING OUTPUT
print("\n-------------EVALUATING THE MATCHING OUTPUT-------------\n")

print("\n- Converting the evaluation set to feature vectors...")
# Convert J into a set of feature vectors using feature table
L = em.extract_feature_vecs(J, feature_table=feature_table,
                            attrs_after='label', show_progress=False)

# Check if the feature vectors contain missing values
# A return value of True means that there are missing values
is_missing_values = any(pd.notnull(L))
print("\n- Does feature vector have missing values: " + str(is_missing_values))
if(is_missing_values):
    # Impute feature vectors with the mean of the column values.
    L = em.impute_table(L,
                        exclude_attrs=['_id', ltable_pk, rtable_pk, 'label'],
                        strategy='mean')
    print("\n- Feature table first rows:")
    # Display first few rows
    print(L.head())


print("\n- Training the selected matcher...")
# Train using feature vectors from I
rf.fit(table=H,
       exclude_attrs=['_id', ltable_pk, rtable_pk, 'label'],
       target_attr='label')


print("\n- Predicting the matches...")
# Predict on L
predictions = rf.predict(table=L, exclude_attrs=['_id', ltable_pk, rtable_pk, 'label'],
              append=True, target_attr='predicted', inplace=False)


print("\n- Evaluating the prediction...")
# Evaluate the predictions
eval_result = em.eval_matches(predictions, 'label', 'predicted')
print(em.print_eval_summary(eval_result))

print("\n-------------END-------------\n")