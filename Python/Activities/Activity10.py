user_numbers = input("Enter some numbers: ")

numbers = user_numbers.split(" ")

num_tuple = tuple(numbers)

print(num_tuple)

for num in num_tuple:
    if int(num)%5 == 0:
        print(f"Number divisible by 5: {num}")