INSERT INTO credentials(username,password,enabled) VALUES ('guest','$2a$10$0.ESlGysrPaiW5HaapKwoehzWt5AibgbPPOvMhDv8D6H26QQ/CwhS', TRUE);
INSERT INTO credentials(username,password,enabled) VALUES ('admin','$2a$10$S/wlXEo/APzf.Sn1cO2p4.V12EJmaw.uzrHelMvkpuahjmHWnSafe', TRUE);

INSERT INTO authorities (id,username, authority) VALUES (1,'guest', 'ROLE_USER');
INSERT INTO authorities (id,username, authority) VALUES (2,'admin', 'ROLE_ADMIN');
INSERT INTO authorities (id,username, authority) VALUES (3,'admin', 'ROLE_USER');

INSERT INTO USERS(id,first_name,last_name,credentials) VALUES (1,'Charlo','Sensei','admin');

INSERT INTO category(id,description,name) VALUES (1,'Awesome Category','Essentials');

#INSERT INTO product(id,productUrlImage,productDescription,activity,name,prod_no,on_bid,price,rent_per_hour,serial_number,category_id) VALUES (1,'Test Image','Test Category','Selling','Table','t1234',true,14500,0,'s1234',1);

#INSERT INTO product(id,activity,name,prod_no,on_bid,price,rent_per_hour,serial_number,category_id) VALUES (1,'Selling','Table','t1234',true,14500,0,'s1234',1);
-- 					Insert Product, Category data


INSERT INTO category(id,description,name) VALUES (2,'Awesome One','Essentials');
INSERT INTO category(id,description,name) VALUES (3,'Awesome Two','Electronics');
INSERT INTO category(id,description,name) VALUES (4,'Awesome Three','Clothes');
INSERT INTO category(id,description,name) VALUES (5,'Awesome Four','Phones');



INSERT INTO product(id,productUrlImage,productDescription,activity,name,prod_no,on_bid,price,rent_per_hour,serial_number,category_id) VALUES (3,'geeks.jpg','Test Category','Selling','Table','t1235',true,14500,0,'s1235',1);

INSERT INTO product(id,productUrlImage,productDescription,activity,name,prod_no,on_bid,price,rent_per_hour,serial_number,category_id) VALUES (4,'geeks.jpg','Test Category','Selling','Table','t1236',true,14500,0,'s1236',2);

INSERT INTO product(id,productUrlImage,productDescription,activity,name,prod_no,on_bid,price,rent_per_hour,serial_number,category_id) VALUES (5,'geeks.jpg','Test Category','Selling','Table','t1237',true,14500,0,'s1237',3);

INSERT INTO product(id,productUrlImage,productDescription,activity,name,prod_no,on_bid,price,rent_per_hour,serial_number,category_id) VALUES (6,'geeks.jpg','Test Category','Selling','Table','t1238',true,14500,0,'s1238',2);

INSERT INTO product(id,productUrlImage,productDescription,activity,name,prod_no,on_bid,price,rent_per_hour,serial_number,category_id) VALUES (7,'geeks.jpg','Test Category','Selling','Table','t1239',true,14500,0,'s1239',1);

INSERT INTO product(id,productUrlImage,productDescription,activity,name,prod_no,on_bid,price,rent_per_hour,serial_number,category_id) VALUES (8,'geeks.jpg','Test Category','Selling','Table','t1239',true,14500,0,'s1210',1);

INSERT INTO product(id,productUrlImage,productDescription,activity,name,prod_no,on_bid,price,rent_per_hour,serial_number,category_id) VALUES (9,'geeks.jpg','Test Category','Selling','Table','t1240',true,14500,0,'s1211',4);

INSERT INTO product(id,productUrlImage,productDescription,activity,name,prod_no,on_bid,price,rent_per_hour,serial_number,category_id) VALUES (10,'geeks.jpg','Test Category','Selling','Table','t1241',true,14500,0,'s1212',5);