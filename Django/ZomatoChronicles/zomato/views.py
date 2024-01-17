from django.shortcuts import render
from .menu import get_menu

def home(request):
    return render(request, 'home.html')

def display_menu(request):
    menu = get_menu()
    return render(request, 'menu.html', {'menu': menu})

# zomato/views.py

def add_dish(request):
    from .menu import menu

    message = None  # Initialize the message variable

    if request.method == 'POST':
        dish_name = request.POST.get('dish_name')
        dish_price = float(request.POST.get('dish_price'))
        dish_available = request.POST.get('dish_available') == 'on'

        new_dish_id = max(menu.keys()) + 1
        new_dish = {'name': dish_name, 'price': dish_price, 'available': dish_available}
        menu[new_dish_id] = new_dish

        message = f'Dish "{dish_name}" added successfully!'  # Set the success message

    return render(request, 'add_dish.html', {'message': message})

# zomato/views.py

def update_availability(request, dish_id):
    from .menu import menu

    message = None  # Initialize the message variable


    if request.method == 'POST':
        dish = menu.get(int(dish_id))
        if dish:
            new_availability = request.POST.get('new_availability') == 'on'
            dish['available'] = new_availability
            message = f'Dish updated successfully!'  # Set the success message

    return render(request, 'update_availability.html', {'message': message})

# zomato/views.py

from django.shortcuts import render
from .menu import menu, order_history

def take_order(request):
    message = None  # Initialize the message variable

    if request.method == 'POST':
        customer_name = request.POST.get('customer_name')
        dish_ids = request.POST.getlist('dish_ids')

        order_dishes = []
        total_price = 0

        for dish_id in dish_ids:
            dish = menu.get(int(dish_id))
            if dish and dish['available']:
                order_dishes.append(dish)
                total_price += dish['price']

        order_id = len(order_history) + 1
        order = {'id': order_id, 'customer_name': customer_name, 'dishes': order_dishes, 'total_price': total_price}
        order_history.append(order)

        message = f'Order #{order_id} taken successfully! Total: ${total_price:.2f}'

    return render(request, 'take_order.html', {'menu': menu, 'message': message})

# zomato/views.py

def update_order_status(request, order_id):
    message=None
    if request.method == 'POST':
        new_status = request.POST.get('new_status')
        order = next((o for o in order_history if o['id'] == int(order_id)), None)
        if order:
            order['status'] = new_status
            message = f'Order #{order_id} updated successfully!'

    return render(request, 'update_order_status.html', {'order_id': order_id, 'message': message})


# zomato/views.py

def review_orders(request):
    return render(request, 'review_orders.html', {'order_history': order_history})
