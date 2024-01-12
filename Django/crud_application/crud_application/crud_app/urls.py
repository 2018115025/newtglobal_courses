from django.urls import path
from .views import create_view, read_view, update_view, delete_view

urlpatterns = [
    path('create', create_view, name='create'),
    path('read', read_view, name='read'),
    path('update', update_view, name='update'),
    path('delete', delete_view, name='delete'),
]
