from django.shortcuts import render, redirect

data = {
    'name': '',
    'age': '',
    'city': '',
}

def create_view(request):
    if request.method == 'POST':
        data['name'] = request.POST.get('name')
        data['age'] = request.POST.get('age')
        data['city'] = request.POST.get('city')
        return redirect('/read')
    return render(request, 'create.html')

def read_view(request):
    return render(request, 'read.html', {'data': data})

def update_view(request):
    if request.method == 'POST':
        key = request.POST.get('key')
        if key in data:
            data[key] = request.POST.get('value')
        return redirect('/read')
    return render(request, 'update.html', {'data': data})

def delete_view(request):
    if request.method == 'POST':
        key = request.POST.get('key')
        if key in data:
            del data[key]
        return redirect('/read')
    return render(request, 'delete.html', {'data': data})
