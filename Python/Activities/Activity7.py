user_list = input("Enter list of elements:\n")
my_list = user_list.split(" ")
print(f"List entered by user is: {my_list}")

sum = 0
for list in my_list:
    sum = sum + int(list)

print(f"Sum of all elements = {sum}")