DROP TABLE IF EXISTS PAINTINGS;

CREATE TABLE PAINTINGS (
	ID INTEGER PRIMARY KEY AUTO_INCREMENT,
	NAME VARCHAR(25),
	shopid INTEGER 
);

CREATE TABLE if not exists shops (
	id INTEGER PRIMARY KEY AUTO_INCREMENT,
	name VARCHAR(25)
);
ALTER TABLE paintings
ADD FOREIGN KEY (shopid) REFERENCES shops(id);
