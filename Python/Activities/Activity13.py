def sum(numbers):
    sum = 0
    for num in numbers:
        sum = sum + num
    return sum
    
numbersList = [30, 25, 50, 45, 60]

print(sum(numbersList))