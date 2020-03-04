import py_entitymatching as em
import pandas as pd
import os
import warnings
from datetime import datetime
# Script runtime measurement
startTime = datetime.now()

# Hide all future/pandas warnings
warnings.filterwarnings("ignore")

# Pandas setting for showing full table, all columns (without this most of them are hidden)
#pd.options.display.max_columns = None
#pd.options.display.max_rows = None
pd.set_option('display.max_rows', 500)
pd.set_option('display.max_columns', 500)
pd.set_option('display.width', 1000)


# BlackBox Blocker function
def price_10_percent_comparision(x, y):
    # get number attributes
    x_number = x['price']
    y_number = y['price']
    # Equal
    if(x_number == y_number):
        return True
    # X is larger and Y is less than 10% smaller
    elif(x_number > y_number and ((x_number * 0.9) <= y_number)):
        return True
    # Y is larger and X is less than 10% smaller
    elif (y_number > x_number and ((y_number * 0.9) <= x_number)):
        return True
    else:
        return False


def main():
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

        # Check if the 2 tables column names are the same
        if(list(A.columns) == list(B.columns)):
            C_attr_eq = []  # Attr Equ blocker result list
            C_overlap = []  # Overlap blocker result list
            C_blackbox = []  # BlackBox blocker result list

            # Left and right table attribute prefixes
            l_prefix = "ltable_"
            r_prefix = "rtable_"

            print("\n- List of columns: ")
            print(list(A.columns))
            # Labeling output table column selection
            print("\n- Enter the indexes of columns that you want to see in labeling table (0-" + str(
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

            # Loop for adding/combining new blockers
            while(True):
                # Blocker selection
                print("\n- Do yo want to use Attribute Equivalence[ab] (same), Overlap[ob] (similar) or Blackbox[bb] blocker:")
                blocker_selection = input()

                # ----- Attribute Equivalence Blocker -----
                if(blocker_selection == 'ab'):
                    # Create attribute equivalence blocker
                    ab = em.AttrEquivalenceBlocker()
                    # Counter for indexes
                    attr_eq_counter = 0
                    # Check if Overlap Blocker used before
                    if(C_overlap and not C_overlap[-1].empty):
                        print("\n- Do you want to work on Overlap Blocker candidate set or not (y or n):")
                        use_cand_set = input()
                        if (use_cand_set == 'y'):
                            C_attr_eq.append(C_overlap[-1])  # Add last output of ob
                            attr_eq_counter += 1  # For skipping block_table function in first time

                    # Check if BlackBox Blocker used before
                    if (C_blackbox and not C_blackbox[-1].empty):
                        print("\n- Do you want to work on BlackBox Blocker candidate set or not (y or n):")
                        use_cand_set = input()
                        if (use_cand_set == 'y'):
                            C_attr_eq.append(C_blackbox[-1])  # Add last output of ob
                            attr_eq_counter += 1  # For skipping block_table function in first time

                    # Loop for adding more columns/attributes into Attr Equ blocker
                    while(True):
                        # List column names
                        print("\n- List of columns: ")
                        print(list(A.columns))
                        # Get blocking attribute/column
                        print("\n- Which column (w/ index) to use for equivalence blocking? (ex. 1):")
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
                                                             l_output_prefix=l_prefix,
                                                             r_output_prefix=r_prefix,
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
                        dbg = em.debug_blocker(C_attr_eq[-1], A, B, output_size=200, n_jobs=-1)

                        # Display first few tuple pairs from the debug_blocker's output
                        print("\n- Blocking debug results:")
                        print(dbg.head())

                        attr_eq_counter += 1  # Increase the counter

                        # Continue to use Attribute Equivalence Blocker or not
                        print("\n- Length of candidate set: " + str(len(C_attr_eq[-1])))
                        print("- Add another column into Attribute Equivalence Blocker[a] OR Reset last blocker's output[r]:")
                        ab_next_operation = input()
                        if(not ab_next_operation.islower()):
                            ab_next_operation = ab_next_operation.lower()  # Lower case
                        # Continue using Attribute Equivalence Blocker
                        if(ab_next_operation == 'a'):
                            continue
                        # Reset/remove last blocker's output from candidate set list
                        elif(ab_next_operation == 'r'):
                            del C_attr_eq[-1]
                            print("\n- Last blocker output removed!")
                            print("- Continue to use Attribute Equivalence Blocker (y or n):")
                            ab_next_operation = input()
                            if(ab_next_operation == 'n'):
                                break
                        # Finish Attribute Equivalence Blocker
                        else:
                            break


                # ----- Overlap Blocker -----
                elif(blocker_selection == 'ob'):
                    # Create attribute equivalence blocker
                    ob = em.OverlapBlocker()
                    # Counter for indexes
                    overlap_counter = 0
                    # Check if Attribute Equivalence Blocker used before
                    if (C_attr_eq and not C_attr_eq[-1].empty):
                        print("\n- Do you want to work on Attribute Equivalence Blocker candidate set or not (y or n):")
                        use_cand_set = input()
                        if (use_cand_set == 'y'):
                            C_overlap.append(C_attr_eq[-1])  # Add last output of ab
                            overlap_counter += 1  # For skipping block_table function in first time

                    # Check if BlackBox Blocker used before
                    if (C_blackbox and not C_blackbox[-1].empty):
                        print("\n- Do you want to work on BlackBox Blocker candidate set or not (y or n):")
                        use_cand_set = input()
                        if (use_cand_set == 'y'):
                            C_overlap.append(C_blackbox[-1])  # Add last output of ob
                            overlap_counter += 1  # For skipping block_table function in first time

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

                        print("\n- Use words as a token? (y or n):")
                        use_world_level = input()
                        if (use_world_level == 'y'):
                            use_world_level = True
                            q_gram_value = None
                        else:
                            use_world_level = False
                            print("\n- Q-gram q value (ex. 2 --> JO HN SM IT H):")
                            q_gram_value = input()
                            q_gram_value = int(q_gram_value)

                        print("\n- Enter the overlap size (# of tokens that overlap):")
                        overlap_size = input()
                        overlap_size = int(overlap_size)

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
                                                             l_output_prefix=l_prefix,
                                                             r_output_prefix=r_prefix,
                                                             rem_stop_words=use_stop_words,
                                                             q_val=q_gram_value,
                                                             word_level=use_world_level,
                                                             overlap_size=overlap_size,
                                                             allow_missing=add_missing_val,
                                                             n_jobs=-1)
                                             )
                        # Not first time, add new constraint into previous candidate set
                        else:
                            # Block using selected (blocking_col) attribute on previous (last=-1) candidate set
                            C_overlap.append(ob.block_candset(C_overlap[-1],
                                                              l_overlap_attr=blocking_col,
                                                              r_overlap_attr=blocking_col,
                                                              rem_stop_words=use_stop_words,
                                                              q_val=q_gram_value,
                                                              word_level=use_world_level,
                                                              overlap_size=overlap_size,
                                                              allow_missing=add_missing_val,
                                                              n_jobs=-1,
                                                              show_progress=False)
                                             )

                        # DEBUG BLOCKING
                        print("\n- Overlap Blocker Debugging...\n")
                        # Debug last blocker output
                        dbg = em.debug_blocker(C_overlap[-1], A, B, output_size=200, n_jobs=-1)

                        # Display first few tuple pairs from the debug_blocker's output
                        print("\n- Blocking debug results:")
                        print(dbg.head())

                        overlap_counter += 1  # Increase the counter

                        # Continue to use Attribute Equivalence Blocker or not
                        print("\n- Length of candidate set: " + str(len(C_overlap[-1])))
                        print("- Add another column into Overlap Blocker[a] OR Reset last blocker's output[r]:")
                        ob_next_operation = input()
                        if (not ob_next_operation.islower()):
                            ob_next_operation = ob_next_operation.lower()  # Lower case
                        # Continue using Overlap Blocker
                        if (ob_next_operation == 'a'):
                            continue
                        # Reset/remove last blocker's output from candidate set list
                        elif (ob_next_operation == 'r'):
                            del C_overlap[-1]
                            print("\n- Last blocker output removed!")
                            print("- Continue to use Overlap Blocker (y or n):")
                            ob_next_operation = input()
                            if(ob_next_operation == 'n'):
                                break
                        # Finish Overlap Blocker
                        else:
                            break

                # ----- BlackBox Blocker -----
                elif (blocker_selection == 'bb'):
                    # Create attribute equivalence blocker
                    bb = em.BlackBoxBlocker()
                    # Counter for indexes
                    blackbox_counter = 0
                    # Check if Overlap Blocker used before
                    if (C_attr_eq and not C_attr_eq[-1].empty):
                        print("\n- Do you want to work on Attribute Equivalence Blocker candidate set or not (y or n):")
                        use_cand_set = input()
                        if (use_cand_set == 'y'):
                            C_blackbox.append(C_attr_eq[-1])  # Add last output of ob
                            blackbox_counter += 1  # For skipping block_table function in first time

                    # Check if Overlap Blocker used before
                    if (C_overlap and not C_overlap[-1].empty):
                        print("\n- Do you want to work on Overlap Blocker candidate set or not (y or n):")
                        use_cand_set = input()
                        if (use_cand_set == 'y'):
                            C_blackbox.append(C_overlap[-1])  # Add last output of ob
                            blackbox_counter += 1  # For skipping block_table function in first time

                    # Loop for adding more columns/attributes into BlackBox blocker
                    while (True):
                        # Set function
                        bb.set_black_box_function(number_10_percent_comparision)

                        # First time using Overlap blocker, use A and B
                        if (overlap_counter == 0):
                            # Block on A and B
                            C_blackbox.append(bb.block_tables(A, B,
                                                              l_output_attrs=out_attr,
                                                              r_output_attrs=out_attr,
                                                              l_output_prefix=l_prefix,
                                                              r_output_prefix=r_prefix,
                                                              n_jobs=-1,
                                                              show_progress=False)
                                             )
                        # Not first time, add new constraint into previous candidate set
                        else:
                            # Block on previous (last=-1) candidate set
                            C_blackbox.append(bb.block_candset(C_blackbox[-1],
                                                               n_jobs=-1,
                                                               show_progress=False)
                                             )

                        # DEBUG BLOCKING
                        print("\n- BlackBox Blocker Debugging...\n")
                        # Debug last blocker output
                        dbg = em.debug_blocker(C_blackbox[-1], A, B, output_size=200, n_jobs=-1)

                        # Display first few tuple pairs from the debug_blocker's output
                        print("\n- Blocking debug results:")
                        print(dbg.head())

                        blackbox_counter += 1  # Increase the counter

                        # Continue to use Attribute Equivalence Blocker or not
                        print("\n- Length of candidate set: " + str(len(C_blackbox[-1])))
                        print("- Add another column into BlackBox Blocker[a] OR Reset last blocker's output[r]:")
                        bb_next_operation = input()
                        if (not bb_next_operation.islower()):
                            bb_next_operation = bb_next_operation.lower()  # Lower case
                        # Continue using Overlap Blocker
                        if (bb_next_operation == 'a'):
                            continue
                        # Reset/remove last blocker's output from candidate set list
                        elif (bb_next_operation == 'r'):
                            del C_blackbox[-1]
                            print("\n- Last blocker output removed!")
                            print("- Continue to use BlackBox Blocker (y or n):")
                            bb_next_operation = input()
                            if (bb_next_operation == 'n'):
                                break
                        # Finish BlackBox Blocker
                        else:
                            break


                print("\n- Do you want to add/use another blocker? (y or n):")
                blocker_decision = input()
                if(blocker_decision == 'n'):
                    break

            print("\n- Which blocker output you want to use? (Attr Equ-ab, Overlap-ob, BlackBox-bb, Union-un)")
            blocker_output_selection = input()
            # Attribute Equ
            if(blocker_output_selection == "ab"):
                C = C_attr_eq[-1]
            # Overlap
            elif(blocker_output_selection == "ob"):
                C = C_overlap[-1]
                # Overlap
            elif (blocker_output_selection == "bb"):
                C = C_blackbox[-1]
            # Union of blockers
            elif(blocker_output_selection == "un"):
                # Combine/union blockers candidate sets
                print("\n- TODO: Unions Attr Equ and Overlap only!")
                if(C_attr_eq and C_overlap and not C_attr_eq[-1].empty and not C_overlap[-1].empty):  # Both blocker types used
                    C = em.combine_blocker_outputs_via_union([C_attr_eq[-1], C_overlap[-1]])
                    print("\n- Blockers candidate set outputs combined via union.")
                else:  # Error
                    C = []
                    print("\n- ERROR: Candidate set C is empty! Check blockers' results.")
            # Error
            else:
                C = []
                print("\n- ERROR: Candidate set C is empty! Check blockers' results.")
            print("\n- Length of C: " + str(len(C)))

        else:
            print("\n- 2 Tables column names are different, they must be the same")
            print(list(A.columns))
            print(list(B.columns))


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

    # Primary key of tables = prefix + pk = l_id, r_id
    ltable_pk = l_prefix + pk_A
    rtable_pk = r_prefix + pk_B

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

    print("\n- Time elapsed:")
    print(datetime.now() - startTime)

    print("\n-------------END-------------\n")

# Call main function
if __name__ == "__main__":
    main()