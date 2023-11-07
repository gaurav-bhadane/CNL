import socket

while True:
    print("\nEnter your choice")
    print("1: Converting IP address to URL")
    print("2: Converting URL to IP address")
    print("3: Exit")
    i = int(input())

    if (i == 1):
        ip = input("Enter IP address: ")
        print(socket.gethostbyaddr(ip))

    elif (i == 2):
        host = input("Enter Host address: ")
        print(socket.gethostbyname(host))

    elif (i == 3):
        print("Exit successfully")
        break

    else:
        print("Invalid Input")