todo=[]
while True:
    choice=int(input("choices:"+'\n'+" 1:add "+'\n'+" 2:show "+'\n'+" 3:edit "+'\n'+" 4:delete "+'\n'+" 0:exit "+'\n'+"enter a choice: "))
    match choice:
        case 1:
            t=input("enter a todo: ")
            todo.append(t)
            print("todo added successfully!")
        case 2:
            print("todos are: ")
            for index,t in enumerate(todo):
                row=f"{index+1}-{t}"
                print(row)
        case 3:
            i= int(input("enter a todo number: "))
            i=i-1
            new_todo=input("enter a new todo")
            todo[i]=new_todo
            print("todo edited successfully!")
        case 4:
            i = int(input("enter a todo number: "))
            i = i - 1
            todo.pop(i)
            print("todo deleted successfully!")
        case 0:
            print("thank u!")
            break

