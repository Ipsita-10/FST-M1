import pandas

dict = {
    "Usernames" : ["admin","Charles", "Deku"],
    "Passwords" : ["password", "Charl13", "AllMight"]
}

dataframe = pandas.DataFrame(dict)

print(dataframe)

dataframe.to_csv("sample.csv", index=False)