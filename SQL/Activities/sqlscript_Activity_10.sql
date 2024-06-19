REM   Script: Activity10
REM   4 problems from activity 10

select * from customers;

select * from orders;

select * from salesman;

create table customers ( customer_id int primary key, customer_name varchar(32), city varchar(20), grade int, salesman_id int) 
 
INSERT ALL INTO customers VALUES (3002, 'Nick Rimando', 'New York', 100, 5001) INTO customers VALUES (3007, 'Brad Davis', 'New York', 200, 5001) INTO customers VALUES (3005, 'Graham Zusi', 'California', 200, 5002) INTO customers VALUES (3008, 'Julian Green', 'London', 300, 5002) INTO customers VALUES (3004, 'Fabian Johnson', 'Paris', 300, 5006) INTO customers VALUES (3009, 'Geoff Cameron', 'Berlin', 100, 5003) INTO customers VALUES (3003, 'Jozy Altidor', 'Moscow', 200, 5007) INTO customers VALUES (3001, 'Brad Guzan', 'London', 300, 5005) SELECT 1 FROM DUAL;

INSERT ALL INTO customers VALUES (3002, 'Nick Rimando', 'New York', 100, 5001) INTO customers VALUES (3007, 'Brad Davis', 'New York', 200, 5001) INTO customers VALUES (3005, 'Graham Zusi', 'California', 200, 5002) INTO customers VALUES (3008, 'Julian Green', 'London', 300, 5002) INTO customers VALUES (3004, 'Fabian Johnson', 'Paris', 300, 5006) INTO customers VALUES (3009, 'Geoff Cameron', 'Berlin', 100, 5003) INTO customers VALUES (3003, 'Jozy Altidor', 'Moscow', 200, 5007) INTO customers VALUES (3001, 'Brad Guzan', 'London', 300, 5005) SELECT 1 FROM DUAL;

create table customers ( customer_id int primary key, customer_name varchar(32), city varchar(20), grade int, salesman_id int);

INSERT ALL INTO customers VALUES (3002, 'Nick Rimando', 'New York', 100, 5001) INTO customers VALUES (3007, 'Brad Davis', 'New York', 200, 5001) INTO customers VALUES (3005, 'Graham Zusi', 'California', 200, 5002) INTO customers VALUES (3008, 'Julian Green', 'London', 300, 5002) INTO customers VALUES (3004, 'Fabian Johnson', 'Paris', 300, 5006) INTO customers VALUES (3009, 'Geoff Cameron', 'Berlin', 100, 5003) INTO customers VALUES (3003, 'Jozy Altidor', 'Moscow', 200, 5007) INTO customers VALUES (3001, 'Brad Guzan', 'London', 300, 5005) SELECT 1 FROM DUAL;

select * from customers;

create table orders(  
    order_no int primary key, purchase_amount float, order_date date,  
    customer_id int, salesman_id int) ;

INSERT ALL  
    INTO orders VALUES(70001, 150.5, TO_DATE('2012/10/05', 'YYYY/MM/DD'), 3005, 5002)   
    INTO orders VALUES(70009, 270.65, TO_DATE('2012/09/10', 'YYYY/MM/DD'), 3001, 5005)  
    INTO orders VALUES(70002, 65.26, TO_DATE('2012/10/05', 'YYYY/MM/DD'), 3002, 5001)  
    INTO orders VALUES(70004, 110.5, TO_DATE('2012/08/17', 'YYYY/MM/DD'), 3009, 5003)  
    INTO orders VALUES(70007, 948.5, TO_DATE('2012/09/10', 'YYYY/MM/DD'), 3005, 5002)  
    INTO orders VALUES(70005, 2400.6, TO_DATE('2012/07/27', 'YYYY/MM/DD'), 3007, 5001)  
    INTO orders VALUES(70008, 5760, TO_DATE('2012/08/15', 'YYYY/MM/DD'), 3002, 5001)  
    INTO orders VALUES(70010, 1983.43, TO_DATE('2012/10/10', 'YYYY/MM/DD'), 3004, 5006)  
    INTO orders VALUES(70003, 2480.4, TO_DATE('2012/10/10', 'YYYY/MM/DD'), 3009, 5003)  
    INTO orders VALUES(70012, 250.45, TO_DATE('2012/06/27', 'YYYY/MM/DD'), 3008, 5002)  
    INTO orders VALUES(70011, 75.29, TO_DATE('2012/08/17', 'YYYY/MM/DD'), 3003, 5007)  
    INTO orders VALUES(70013, 3045.6, TO_DATE('2012/04/25', 'YYYY/MM/DD'), 3002, 5001)  
SELECT 1 FROM DUAL ;

select * from orders;

CREATE TABLE salesman(salesman_id int PRIMARY KEY, salesman_name varchar2(20) NOT NULL,salesman_city varchar2(20), commission int);

INSERT ALL INTO salesman VALUES (5001, 'James Hoog', 'New York', 15) INTO salesman VALUES (5002, 'Nail Knite', 'Paris', 13) INTO salesman VALUES (5005, 'Pit Alex', 'London', 11) INTO salesman VALUES (5006, 'McLyon', 'Paris', 14) INTO salesman VALUES (5007, 'Paul Adam', 'New York', 13) INTO salesman VALUES (5003, 'Lauson Hen', 'San Jose', 12) SELECT 1 FROM DUAL;

select * from salesman;

select * from orders;

select * from salesman s inner join customers c on s.salesman_id = c.salesman_id;

select c.customer_id, c.customer_name from customers c where c.salesman_id in (select s.salesman_id from salesman s where grade < 300) order by customer_id;

SELECT a.order_no, a.order_date, a.purchase_amount, b.customer_name AS "Customer Name", b.grade, c.salesman_name AS "Salesman", c.commission FROM orders a  
INNER JOIN customers b ON a.customer_id=b.customer_id  
INNER JOIN salesman c ON a.salesman_id=c.salesman_id;

select * from salesman;

select * from orders;

select * from customers;

select * from orders where salesman_id in (select salesman_id from customers where customer_id = 3007);

select * from orders where salesman_id = (select distinct salesman_id from orders where customer_id = 3007);

select * from orders where salesman_id = (select distinct salesman_id from customers where customer_id = 3007);

select * from orders where salesman_id in (select distinct salesman_id from customers where customer_id = 3007);

select * from orders where salesman_id in (select distinct salesman_id from orders where customer_id = 3007);

select * from orders where salesman_id = (select distinct salesman_id from orders where customer_id = 3007);

select * from orders where salesman_id = (select distinct salesman_id from customers where customer_id = 3007);

select * from customers;

select * from orders where salesman_id = 5001;

select * from salesman;

select * from orders where salesman_id in (select salesman_id from salesman where salesman_city = 'New York');

select * from salesman;

select * from orders;

select * from customers;

select count(customer_id) from customers where grade > (select avg(grade) from customers where city = 'New York');

select grade, count(*) from customers group by grade having grade > (select avg(grade) from customers where city = 'New York');

select * from orders where salesman_id = (select salesman_id, max(commission) from salesman group by salesman_id);

select * from orders where salesman_id in (select max(commission) from salesman group by salesman_id);

select * from orders where salesman_id in (select salesman_id from salesman where commission = (select max(commission) from salesman));

