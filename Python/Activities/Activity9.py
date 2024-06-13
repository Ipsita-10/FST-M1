list1 = [22, 45, 6, 77, 13, 18, 10]
list2 = [34, 88, 9, 56, 93, 42]
list3 = []

for num in list1:
    if num%2 != 0 :
        list3.append(num)

for num in list2:
    if num%2 == 0:
        list3.append(num)

print(list3)