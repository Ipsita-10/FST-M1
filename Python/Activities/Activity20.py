import pandas

dataframe = pandas.read_excel("sample.xlsx")
print(dataframe)

print(f"Number of rows and columns: {dataframe.shape}")

print(f"Data in email column: {dataframe["Email"]}")

print(f"Data sorted according to First names: {dataframe.sort_values("FirstName")}")

