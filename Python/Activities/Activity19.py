import pandas
from pandas import ExcelWriter

data = {"FirstName": ["Satvik", "Avinash", "Lahri"],
        "LastName": ["Shah", "Kati", "Rath"],
        "Email": ["satshah@example.com", "avinashk@example.com", "lahri.rath@example.com"],
        "PhoneNumber": ["4537829158", "5892184058", "4528727830"]
}

dataframe = pandas.DataFrame(data)
writer = ExcelWriter("sample.xlsx")
dataframe.to_excel(writer, "Sheet1", index = False)	
writer._save()