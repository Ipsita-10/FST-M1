user_list = input("Enter list of elements:\n")
my_list = user_list.split(" ")
print(f"List entered by user is: {my_list}")
if my_list[0] == my_list[-1]:
    print(True)
