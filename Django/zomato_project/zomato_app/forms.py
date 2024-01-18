from django import forms
from .models import MenuItem,Order,Customer

class MenuItemForm(forms.ModelForm):
    class Meta:
        model = MenuItem
        fields = '__all__'

class OrderForm(forms.Form):
    customer = forms.ModelChoiceField(queryset=Customer.objects.all(), empty_label="Select a customer")
    selected_dishes = forms.ModelMultipleChoiceField(queryset=MenuItem.objects.all(), widget=forms.CheckboxSelectMultiple)

class CustomerForm(forms.ModelForm):
    class Meta:
        model = Customer
        fields = ['name', 'email']