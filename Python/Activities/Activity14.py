def fibonacci(num):
    if num <= 1:
        return num
    else:
        return fibonacci(num -1) + fibonacci(num - 2)

number = input("How many fibonacci numbers do you want to generate? ")

if int(number)<=0 :
    print("Enter a postive number")
else:
    for i in range(1, int(number)):
        print(fibonacci(i))


    
