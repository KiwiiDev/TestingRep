CREATE TABLE customer (
    customer_id INT,
    firstnamysme VARCHAR(30) NOT NULL,
    lastname VARCHAR(30) NOT NULL,
    birtdate date NOT NULL,
    gender VARCHAR(1) NOT NULL,
    zipcode INT(5) NOT NULL,
    street VARCHAR(30) NOT NULL,
    housenumber VARCHAR(5) NOT NULL,
    city VARCHAR(30) NOT NULL,
    email VARCHAR(50),
    PRIMARY KEY(customer_id));