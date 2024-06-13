while True:
    user1 = input("User1: Enter stone or paper or scissor: ").lower()
    user2 = input("\nUser2: Enter stone or paper or scissor: ").lower()

    if (user1 == "stone" and user2 == "paper"):
        print("User1 WINS!!!")
    elif (user1 == "stone" and user2 == "scissor"):
        print("User1 WINS!!!")
    elif (user1 == "scissor" and user2 == "paper"):
        print("User1 WINS!!!")
    elif (user1 == "scissor" and user2 == "stone"):
        print("User2 WINS!!!")
    elif (user1 == "paper" and user2 == "scissor"):
        print("User2 WINS!!!")
    elif (user1 == "paper" and user2 == "stone"):
        print("User1 WINS!!!")
    elif user1 == user2:
        print("It's a Tie!!!")

    ask = input("Do you want to continue? yes/ no: ").lower()
    if ask == "yes":
        continue
    else:
        raise SystemExit


