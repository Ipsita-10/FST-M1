fruit_dictionary = {
    'mango': 200,
    'apple': 280,
    'banana': 50,
    'guava': 150,
    'grapes': 180,
    'watermelon': 150
}

fruit_name = input("Enter fruit to be searched: ")

if fruit_name in fruit_dictionary:
    print(f"Fruit {fruit_name} is present")
else:
    print(f"Fruit {fruit_name} is not present")