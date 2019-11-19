DROP TABLE IF EXISTS credentials;

create table credentials
(
    username varchar(255) primary key NOT NULL,
    password varchar(255)             NOT NULL,
    enabled  boolean                  NOT NULL
);

DROP TABLE IF EXISTS authorities;

create table authorities
(
    id        int primary key AUTO_INCREMENT NOT NULL,
    username  varchar(255)                   NOT NULL,
    authority varchar(255)                   NOT NULL
);

DROP TABLE IF EXISTS users;

create table users
(
    id          int primary key AUTO_INCREMENT NOT NULL,
    first_name  varchar(255)                   NOT NULL,
    last_name   varchar(255)                   NOT NULL,
    credentials varchar(255)                   NOT NULL
);

ALTER TABLE users
    ADD CONSTRAINT CREDENTIALSREL FOREIGN KEY users (credentials) REFERENCES credentials (username);


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
					