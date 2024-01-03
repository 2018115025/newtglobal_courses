i="enter a todo: "
list=[]
while True:
    inp=input(i)
    if inp=="exit":
        break
    list.append(inp)
    print(list)
