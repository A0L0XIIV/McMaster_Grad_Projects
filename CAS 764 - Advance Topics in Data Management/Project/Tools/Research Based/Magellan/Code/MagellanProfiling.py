import py_entitymatching as em
import pandas as pd
import pandas_profiling
import os

# Get the datasets directory
#datasets_dir = 'B:\McMaster\CAS 764 - Advance Topics in Data Management\Project\Data\\restaurants1\csv_files'

print('Enter data file path:')
datasets_dir = input()

print('Enter filename: (without externsion .csv)')
filename = input()

# Get the path of the input table
path_A = datasets_dir + os.sep + filename + '.csv'

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

# Profile data with pandas profiling
profile = pandas_profiling.ProfileReport(A, title='Pandas Profiling Report', html={'style':{'full_width':True}})

# Save file as html file
profile.to_file(output_file= filename + "_profiling_report.html")

#JSON file save
#profile.to_file(output_file="your_report.json")