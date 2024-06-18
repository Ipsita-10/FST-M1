REM   Script: Activity1_to_5
REM   scripts- activity 1 to 5

CREATE TABLE salesman(salesman_id int, salesman_name varchar2(20),salesman_city varchar2(20), commission int);

DESCRIBE salesman


CREATE TABLE salesman(salesman_id int, salesman_name varchar2(20),salesman_city varchar2(20), commission int);

DESCRIBE salesman


CREATE TABLE salesman(salesman_id int, salesman_name varchar2(20),salesman_city varchar2(20), commission int);

DESCRIBE salesman


DROP TABLE salesman;

CREATE TABLE salesman(salesman_id int PRIMARY KEY, salesman_name varchar2(20) NOT NULL,salesman_city varchar2(20), commission int);

DESCRIBE salesman


INSERT ALL 
    INTO salesman VALUES (5001, 'James Hoog', 'New York', 15) 
    INTO salesman VALUES (5002, 'Nail Knite', 'Paris', 13) 
    INTO salesman VALUES (5005, 'Pit Alex', 'London', 11) 
    INTO salesman VALUES (5006, 'McLyon', 'Paris', 14) 
    INTO salesman VALUES (5007, 'Paul Adam', 'New York', 13) 
    INTO salesman VALUES (5003, 'Lauson Hen', 'San Jose', 12) 
SELECT 1 FROM DUAL;

select * from salesman;

select salesman_id, salesman_city from salesman;

select * from salesman where salesman_city = 'Paris';

select salesman_id, commission from salesman where salesman_name = 'Paul Adam';

ALTER table salesman add (grade int);

UPDATE salesman set grade = 100;

select * from salesman;

UPDATE salesman set grade = 200 where salesman_city = 'Rome';

update salesman set salesman_city = 'Rome' where salesman_name = 'Paul Adam';

UPDATE salesman set grade = 200 where salesman_city = 'Rome';

DROP TABLE salesman;

CREATE TABLE salesman(salesman_id int PRIMARY KEY, salesman_name varchar2(20) NOT NULL,salesman_city varchar2(20), commission int);

DESCRIBE salesman


INSERT ALL 
    INTO salesman VALUES (5001, 'James Hoog', 'New York', 15) 
    INTO salesman VALUES (5002, 'Nail Knite', 'Paris', 13) 
    INTO salesman VALUES (5005, 'Pit Alex', 'London', 11) 
    INTO salesman VALUES (5006, 'McLyon', 'Paris', 14) 
    INTO salesman VALUES (5007, 'Paul Adam', 'Rome', 13) 
    INTO salesman VALUES (5003, 'Lauson Hen', 'San Jose', 12) 
SELECT 1 FROM DUAL;

select * from salesman;

select salesman_id, salesman_city from salesman;

select * from salesman where salesman_city = 'Paris';

select salesman_id, commission from salesman where salesman_name = 'Paul Adam';

ALTER table salesman add (grade int);

UPDATE salesman set grade = 100;

select * from salesman;

UPDATE salesman set grade = 200 where salesman_city = 'Rome';

UPDATE salesman set grade = 300 where salesman_name = 'James Hoog';

update salesman set salesman_name = 'Pierre' where salesman_name = 'McLyon';

select * from salesman;

