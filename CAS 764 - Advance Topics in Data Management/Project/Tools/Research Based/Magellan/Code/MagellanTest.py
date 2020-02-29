import py_entitymatching as em
import pandas as pd
import os

# Get the datasets directory
datasets_dir = 'B:\McMaster\CAS 764 - Advance Topics in Data Management\Project\Data\\restaurants1\csv_files'
print("Is the data directory correct?(y or n)\n" + datasets_dir)
dir_check = input()
if(dir_check == 'n'):
    print ("Please enter new dataset directory:")
    datasets_dir = input()
    print ("Dataset directory set to: " + datasets_dir)

# Get the path of the input table
path_A = datasets_dir + os.sep + 'yelp.csv'
path_B = datasets_dir + os.sep + 'zomato.csv'

#A = em.read_csv_metadata(path_A)
# Display first 5 columns
#A.head()

# Display the 'type' of A = pandas.core.frame.DataFrame
#type(A)

# Set metadata id as ID column
#em.set_key(A, 'ID')

# Get the metadata that were set for table A
#em.get_key(A)

# Both read csv and set metadata id as ID column
A = em.read_csv_metadata(path_A, key='ID')
B = em.read_csv_metadata(path_B, key='ID')

