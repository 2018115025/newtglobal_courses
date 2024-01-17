# zomato/menu.py

menu = {
    1: {'name': 'Pasta', 'price': 8.99, 'available': True},
    2: {'name': 'Pizza', 'price': 10.99, 'available': True},
    3: {'name': 'Burger', 'price': 6.99, 'available': True},
    # Add more dishes as per your choice
}

order_history = []  # Initialize the order history list

def get_menu():
    return menu
