CREATE TABLE products (
  id INTEGER NOT NULL AUTO_INCREMENT PRIMARY KEY ,
  description varchar(255),
  price decimal(15,2)
);
CREATE INDEX products_description ON products(description);
