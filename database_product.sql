CREATE DATABASE products;

USE products;

CREATE TABLE `products` (
  `code` varchar(40) NOT NULL,
  `description` varchar(100) NOT NULL,
  `price` double NOT NULL,
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


select * from products;

INSERT INTO PRODUCTS (code,description,price) VALUES ("8601","86 (the band) - True Life Songs and Pictures",14.95);
INSERT INTO PRODUCTS(code,description,price) VALUES ("pf01","Paddlefoot - The first CD",12.95);
INSERT INTO PRODUCTS(code,description,price) VALUES ("pf02","Paddlefoot - The second CD",14.95);
INSERT INTO PRODUCTS(code,description,price) VALUES ("jr01","Joe Rut - Genuine Wood Grained Finish",14.95);
