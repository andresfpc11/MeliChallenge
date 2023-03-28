--Primera respuesta de negocio
with 
producto_vendido as (
    select	
        id_item,
        name as Producto,
        month(order_date) as Mes,
        count(id_item) as Total_Transacciones,
        row_number() over (partition by month(order_date) order by count(id_item) desc ) as Numero
    from 
        mydb.order
    where 
        YEAR(order_date)=2022 and 
        status = "completed" 
    group by 1,2
    order by 2,3
), 
total_ventas as	(
    select	
        month(o.order_date) as Mes,
        count(o.id_order) as Total_Transacciones, 
        sum(i.price) as Total_Ventas	
    from 
        mydb.order as o
        inner join mydb.item as i on o.id_item = i.id_item
    where 
        YEAR(o.order_date)=2022 and 
        o.status = "completed" 
    group by 1
) 
select 
    Mes,
    tv.Total_Transacciones,
    tv.Total_Ventas,
    pv.Producto
from 
	total_ventas as tv 
    join producto_vendido as pv on tv.Mes = pv.Mes
where pv.numero=1

--Segunda respuesta de negocio
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

--Tercera respuesta de negocio
SELECT id_category,
       description,
       created_date,
       updated_date
FROM
  (SELECT *,
          row_number() OVER (PARTITION BY id_category
                             ORDER BY updated_date DESC) AS dato
   FROM mydb.category_1) AS tabla
WHERE dato=1