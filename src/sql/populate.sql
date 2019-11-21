INSERT INTO credentials(username,password,enabled) VALUES ('guest','$2a$10$0.ESlGysrPaiW5HaapKwoehzWt5AibgbPPOvMhDv8D6H26QQ/CwhS', TRUE);
INSERT INTO credentials(username,password,enabled) VALUES ('admin','$2a$10$S/wlXEo/APzf.Sn1cO2p4.V12EJmaw.uzrHelMvkpuahjmHWnSafe', TRUE);
 
INSERT INTO authorities (id,username, authority) VALUES (1,'guest', 'ROLE_USER');
INSERT INTO authorities (id,username, authority) VALUES (2,'admin', 'ROLE_ADMIN');
INSERT INTO authorities (id,username, authority) VALUES (3,'admin', 'ROLE_USER');

INSERT INTO USERS(id,first_name,last_name,credentials) VALUES (1,'Charlo','Sensei','admin');

INSERT INTO category(id,description,name) VALUES (1,'Awesome Category','Essentials');
INSERT INTO product(id,activity,name,prod_no,on_bid,price,rent_per_hour,serial_number,category_id) VALUES (1,'Selling','Table','t1234',true,14500,0,'s1234',1);
-- 					Insert Product, Category data
