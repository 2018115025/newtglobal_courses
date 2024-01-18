from django.shortcuts import render, redirect, get_object_or_404
from .models import MenuItem,Order
from .forms import MenuItemForm  # Make sure this line is correct

def home(request):
    return render(request, 'zomato_app/home.html')

def menu_list(request):
    menu_items = MenuItem.objects.all()  # Fetch all menu items
    context = {'menu_items': menu_items}
    return render(request, 'zomato_app/menu_list.html', context)

def add_menu_item(request):
    if request.method == 'POST':
        form = MenuItemForm(request.POST)
        if form.is_valid():
            form.save()
            return redirect('menu_list')
    else:
        form = MenuItemForm()
    return render(request, 'zomato_app/add_menu_item.html', {'form': form})

def edit_menu_item(request, menu_item_id):
    menu_item = get_object_or_404(MenuItem, pk=menu_item_id)
    if request.method == 'POST':
        form = MenuItemForm(request.POST, instance=menu_item)
        if form.is_valid():
            form.save()
            return redirect('menu_list')
    else:
        form = MenuItemForm(instance=menu_item)
    return render(request, 'zomato_app/edit_menu_item.html', {'form': form, 'menu_item': menu_item})

def delete_menu_item(request, menu_item_id):
    menu_item = get_object_or_404(MenuItem, pk=menu_item_id)
    if request.method == 'POST':
        menu_item.delete()
        return redirect('menu_list')
    return render(request, 'zomato_app/delete_menu_item.html', {'menu_item': menu_item})

def update_dish_availability(request, menu_item_id):
    menu_item = MenuItem.objects.get(id=menu_item_id)

    if request.method == 'POST':
        # Toggle the availability status
        menu_item.available = not menu_item.available
        menu_item.save()
        return redirect('menu_list')

    context = {'menu_item': menu_item}
    return render(request, 'zomato_app/update_dish_availability.html', context)

from django.shortcuts import render, redirect
from .forms import MenuItemForm, OrderForm
from .models import MenuItem, Order

# ... (other views)

from .forms import OrderForm
from django.contrib import messages

def take_order(request):
    if request.method == 'POST':
        form = OrderForm(request.POST)
        if form.is_valid():
            customer = form.cleaned_data['customer']
            selected_dishes = form.cleaned_data['selected_dishes']
            
            order = Order.objects.create(customer=customer)
            order.items.set(selected_dishes)
            
            messages.success(request, 'Order placed successfully!')
            return redirect('order_list')
    else:
        form = OrderForm()
    
    menu_items = MenuItem.objects.all()
    context = {'form': form, 'menu_items': menu_items}
    return render(request, 'zomato_app/take_order.html', context)




def update_order_status(request, order_id):
    order = Order.objects.get(id=order_id)

    if request.method == 'POST':
        new_status = request.POST['new_status']
        order.status = new_status
        order.save()
        return redirect('order_status', order_id=order.id)

    context = {'order': order}
    return render(request, 'zomato_app/update_order_status.html', context)

def review_orders(request):
    orders = Order.objects.all()
    context = {'orders': orders}
    return render(request, 'zomato_app/review_orders.html', context)

from django.shortcuts import render, redirect
from .forms import MenuItemForm, CustomerForm, OrderForm
from .models import MenuItem, Order, Customer

# ... (other views)

def add_customer(request):
    if request.method == 'POST':
        form = CustomerForm(request.POST)
        if form.is_valid():
            form.save()
            return redirect('home')
    else:
        form = CustomerForm()
    return render(request, 'zomato_app/add_customer.html', {'form': form})
