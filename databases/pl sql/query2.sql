create or replace function fun3() returns setof products as
$body$
	Begin
		return query select * from products;
	End;
$body$
LANGUAGE plpgsql;
select * from fun3();

-- if statements

create or replace function fun4(q integer) returns text as
$body$
	Begin
		if q<50 then
			return 'low';
		elsif q=50 then
			return 'medium';
		else
			return 'high';
		end if;	
	End;
$body$
LANGUAGE plpgsql;
select *,fun4(quantity) from products;

-- for loop
do
$$
	begin
	for i in 1..10
	loop
	raise notice 'i = %',i;
	end loop;
	end;
$$

do
$$
	begin
	for i in reverse 10..1 by 2
	loop
	raise notice 'i = %',i;
	end loop;
	end;
$$


do
$$
	declare
	rec record;
	begin
	for rec in select * from products
	loop
	raise notice 'id=% name=%',rec.product_id,rec.product_name;
	end loop;
	end;
$$


-- to connect to a database in terminal
-- \c db_name postgres(username)
-- psql -d db_name -U postgres
-- \q <= to came out from the database
-- \dt list all the tables
-- \l listv all databases
-- \d tb_name <=desc table
