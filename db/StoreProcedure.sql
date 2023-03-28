CREATE PROCEDURE `procedure_daily_item`()
BEGIN
INSERT INTO mydb.dailyitem
(id_item, nombre_producto, cliente, nombre_cliente, price, status, email, end_date, created_date, updeted_date)
select  
	item.id_item,
    item.name as nombre_producto,
    customer.id_customer as cliente,
    customer.name as nombre_cliente,
	item.price,
    item.status,
    customer.email,
    item.end_date,
    now() as created_date,
    now() as updated_date
from mydb.item join mydb.customer
	on item.id_customer= customer.id_customer
where date(item.updated_date) >= date_add(current_date(),INTERVAL -1 DAY);
END