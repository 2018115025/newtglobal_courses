from django.urls import path
from . import views

urlpatterns = [
    path('', views.home, name='home'),
    path('menu/', views.menu_list, name='menu_list'),
    path('menu/add/', views.add_menu_item, name='add_menu_item'),
    path('menu/edit/<int:menu_item_id>/', views.edit_menu_item, name='edit_menu_item'),
    path('menu/delete/<int:menu_item_id>/', views.delete_menu_item, name='delete_menu_item'),
    path('menu/update/<int:menu_item_id>/', views.update_dish_availability, name='update_dish_availability'),
    path('order/take/', views.take_order, name='take_order'),
    path('order/status/<int:order_id>/', views.update_order_status, name='update_order_status'),
    path('order/review/', views.review_orders, name='review_orders'),
    path('customer/add/', views.add_customer, name='add_customer'),
]
