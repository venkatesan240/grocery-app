create database grocery;
use grocery;
create table user_register1(userid int(10) primary KEY auto_increment,name varchar(20) not null,password varchar(20) not null );
desc user_register;
insert into user_register(name,password)values("admin","admin@123");
select * from user_register;
 create table product1(productid int(10) primary key auto_increment,product varchar(20),quantity int(10),price int(10),amount int(10),totalamount int,userid int);
desc product;
alter table user_register add column address varchar(20), add column mobile long; 
truncate table user_register;
ALTER TABLE product DROP FOREIGN KEY product_ibfk_1;
delete from user_register ;
select * from product;
insert into product(product,quantity,price,amounproductt,totalamount,userid)values("almond",4,20,80,80,5);
delete from user_register where userid=3;
ALTER TABLE user_register DROP userid ;
SHOW CREATE TABLE user_register;

update user_register set name="manikandan",password="mani@123",address="tnagar",mobile=80564367896 where userid=6;
SELECT CONSTRAINT_NAME
FROM INFORMATION_SCHEMA.KEY_COLUMN_USAGE
WHERE TABLE_NAME = 'product' ;
select * from product;
desc product;
desc user_register;

alter table product1
  add constraint product_ibfk_1 foreign key (userid)
  references user_register1 (userid) on delete cascade;
drop table user_register;
drop table product;
alter table user_register1 rename register;
alter table product1 rename product;
select * from  register;
select * from product;
desc register;
alter table register add column mobile long;
desc product;
insert into register(name,password,address,mobile)values("admin","admin@123","madurai",6538674356);
ALTER TABLE register ADD CONSTRAINT UNIQUE (name); 
select userid,name,password from register  where name="admin";
create table admin(adminid int(10)  primary KEY auto_increment,name varchar(20) unique not null,password varchar(20) not null);
desc admin;
insert into admin(name,password)value("admin","admin@123");
select * from admin;
select * from register;
select * from product;

