--create table
create table customers(
	customer_id serial primary key,
	first_name varchar(50) not null,
	last_name varchar(50),
	date_of_birth date
)
--insert into table
insert into customers values (1,'ram','kumar','2000-02-12');
insert into customers values (2,'prem','kumar','2003-02-12');
insert into customers values (3,'raj','kumar','2011-02-12');
insert into customers values (4,'dhanush','priyan','2001-02-12');
--view
select * from customers;
select * from customers where customer_id=1;
select * from customers where last_name like 'k%';
select * from customers order by first_name desc;
--foreign key relation
create table orders(
	order_id int primary key,
	name varchar(20) not null,
	price decimal default 0.0,
	c_id serial references customers(customer_id)
)
insert into orders values (1,'airpods',1000.0);
insert into orders values (2,'phone',10000.0,1);
insert into orders values (3,'tshirt',400,1);
insert into orders values (4,'laptop',31000,4);
insert into orders values (5,'shirt',800.0,4);

select * from orders;
--joins
select * from customers c inner join orders o on c.customer_id=o.c_id where c.customer_id=1;
--operations
select sum(price) from orders where c_id=1;
--group by
select first_name,last_name,sum(price) from customers c inner join orders o on c.customer_id=o.c_id group by customer_id;