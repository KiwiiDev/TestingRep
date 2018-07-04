LOAD DATA LOCAL INFILE '/home/ewekevin/Schreibtisch/webapp/src/main/resources/templates/kundendaten_swapped.csv'
INTO TABLE customer
FIELDS TERMINATED BY ';'
ENCLOSED BY '"'
LINES TERMINATED BY '\n'
IGNORE 1 LINES
(customer_id, firstname, lastname, @birthdate, gender, zipcode, street, housenumber, city, email)
SET birthdate = STR_TO_DATE(@birthdate, '%Y/%m/%d');