select * from customers;
create table products(
	product_id integer primary key,
	product_name varchar(20) not null,
	price decimal,
	quantity integer
);
insert into products values (2,'mobile',10000.0,50),(3,'airpods',3000.0,60);
select  * from products;

create or replace function myfun(int,int) returns int as
'select $1*$2'
LANGUAGE SQL;
SELECT myfun(2,5);

create or replace function fun1() returns void as
$$
update products set product_name='charger' where product_id=1
$$
LANGUAGE SQL;

select fun1();
select * from products;
-- total price of all products
create or replace function total_sum() returns float as
$$
select sum(price) from products;
$$
LANGUAGE SQL;

select total_sum();

-- plsql
create or replace function total_sump() returns float as
$$
BEGIN
return sum(price) from products;
END
$$
LANGUAGE plpgsql;
SELECT total_sump();

-- block structure 
-- increament by 1
create or replace function fun2(integer) returns integer as
$body$
	DECLARE
	x alias for $1;
	Begin
		return x+1;
	End;
$body$
LANGUAGE plpgsql;
select fun2(3);

Do
$$
	DECLARE
	y varchar:='dhanush';
	x integer:=1;
	z time:=Now();
	BEGIN
	raise notice 'Hi,i am % % time is %',y,x,z;
	perform pg_sleep(4);
	raise notice 'after 2 sec time is: %',z;
	END;
$$
LANGUAGE plpgsql

-- find product name from product id
do
$$
	DECLARE
	product_title products.product_name%type; 
	begin
	select product_name from products into product_title where product_id=1 limit 1;
	raise notice 'product name is %',product_title;
	end;
$$

do
$$
	DECLARE
	record_row record; 
	begin
	select * from products into record_row where product_id=1 limit 1;
	raise notice 'product name is %',record_row.product_name;
	end;
$$

