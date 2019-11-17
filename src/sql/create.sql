 
DROP TABLE IF EXISTS product;

create table product( id int primary key AUTO_INCREMENT NOT NULL,
						number varchar(25),
						name varchar(25)
					);

DROP TABLE IF EXISTS category;

create table category( ID int primary key AUTO_INCREMENT NOT NULL,
						name varchar(25),
						description varchar(25)
					);

ALTER TABLE product ADD  COLUMN categoryId BIGINT;
ALTER TABLE product ADD CONSTRAINT CATEGORYREL FOREIGN KEY (categoryId) REFERENCES category (id);
					