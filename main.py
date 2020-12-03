"""
This module is used for csv editing in the context of a lecture. 
"""
import pandas as pd
import os

working_dir = os.getcwd()
my_csv_train = pd.read_csv(f"{working_dir}/data/train.csv", ",")
my_csv_types = pd.read_csv(f"{working_dir}/data/types.csv", ",")
print(my_csv_train, my_csv_types)

my_csv_types["string"], my_csv_types["nominal"] = "", ""

my_csv_types.to_csv(f"{working_dir}/data/types.modified.csv")


for x in range(len(my_csv_train["Name"])):
	my_csv_train["Name"][x] = my_csv_train["Name"][x].split("\"")[0]

print(my_csv_train["Name"])

my_csv_train.to_csv(f"{working_dir}/data/train.modified.csv")


