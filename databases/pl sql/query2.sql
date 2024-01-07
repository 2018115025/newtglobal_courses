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

-- triggers
create table t_temprature(
	t_id serial primary key,
	temprature integer,
	timing timestamp
)

-- create funtion for trigger
create or replace function fn_temp()
returns trigger 
LANGUAGE plpgsql
as
$$
-- if temprature< -10 them temprature=0;
	begin
		if new.temprature<10 then
		  new.temprature=0;
		end if;
		return new;
	end;
$$

-- create trigger
create trigger tr_temp
before insert
on t_temprature
for each row
execute procedure fn_temp();

insert into t_temprature (temprature,timing) values (20,now());
insert into t_temprature (temprature,timing) values (-20,now());
insert into t_temprature (temprature,timing) values (9,now());
insert into t_temprature (temprature,timing) values (2,now());

select * from t_temprature;

-- cursor
-- declare-open-fetch-close
select * from orders order by name;
-- list all orders using cursor
do
$$
	declare
		output_txt text;
		rec record;
		cur_allorders cursor
		for 
		select name from orders;
	begin
		open cur_allorders;
		loop
		fetch cur_allorders into rec;
		output_txt:=output_txt ||','||rec.name;
		end loop;
		raise notice 'movies are %',output_txt;
	end;
$$