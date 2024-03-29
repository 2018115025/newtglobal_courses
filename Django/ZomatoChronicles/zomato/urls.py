# zomato/urls.py

from django.urls import path
from . import views

urlpatterns = [
    path('', views.home, name='home'),
    path('menu/', views.display_menu, name='menu'),
    path('add_dish/', views.add_dish, name='add_dish'),
    path('update_dish/<int:dish_id>/', views.update_availability, name='update_availability'),
    path('order/', views.take_order, name='take_order'),
    path('update_order/<int:order_id>/', views.update_order_status, name='update_order_status'),
    path('orders/', views.review_orders, name='review_orders'),
]
