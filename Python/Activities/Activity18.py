import pandas
dataframe = pandas.read_csv("sample.csv")
print(f"File content is: \n{dataframe}")
print(f"Usernames are: {dataframe["Usernames"]}")
print(f"Username in second row: {dataframe["Usernames"][1]} and Password in secind row is: {dataframe["Passwords"][1]}")
print(f"Usernames in ascending order: {dataframe.sort_values("Usernames")}")
print(f"Passwords in descending order: {dataframe.sort_values("Passwords", ascending = False)}")