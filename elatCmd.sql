create database elatauth;
use elatauth;
select * from elatauth.user;
describe user;

alter table user
drop column id;
drop table user;

alter table user
add id int primary key AUTO_INCREMENT;

ALTER TABLE user
MODIFY COLUMN id INT AUTO_INCREMENT PRIMARY KEY;

SHOW CREATE TABLE user;

ALTER TABLE user DROP PRIMARY KEY;
ALTER TABLE user MODIFY COLUMN id INT AUTO_INCREMENT PRIMARY KEY;
select * from user;



-- SkinProduct stores information about skincare products
create table skinproducts(

	productID INT PRIMARY KEY,
    productname VARCHAR(100) NOT NULL,
    image blob,
    price DECIMAL(10, 2) NOT NULL,
    sectionid VARCHAR(100) Default 'product1'
    
);
drop table skinproducts;
delete from foodmodel;
select * from skinproducts;


insert into `skinproducts` (productID,productname,image,price,sectionid) 
values
 (1, 'HerbalLotion' , 'D:\imgfolder\prod1.jpeg', 6000,'product1'),
 (2,'HerbalFaceCream', 'D:\imgfolder\prod2.jpeg', 5000,'product1'),
 (3,'HerbalShampoo', 'D:\imgfolder\prod3.jpeg', 4000,'product1'),
 (4,'HerbalMask', 'D:\imgfolder\prod4.jpeg', 3000,'product1');
select * from skinproducts;
truncate table products;
select productName, sectionId from skinproducts;

-- FoodProduct stores information about food products
CREATE TABLE FoodProduct (
    productID INT PRIMARY KEY,
    productname VARCHAR(100) NOT NULL,
    image blob,
    description TEXT,
    price DECIMAL(10, 2) NOT NULL,
    sectionid VARCHAR(100) Default 'about1'
);
drop table FoodProduct;
insert into `FoodProduct` (productID,productname,image,price,description,sectionid) 
values
 (5,'Carrot', 'D:/imgfolder/carrot.jpeg', 600,'good for health','about1'),
 (6,'Beetroot','D:/imgfolder/beetroot.jpeg', 500,'good for health', 'about1'),
 (7,'Papaya', 'D:/imgfolder/papaya.jpeg', 400,'good for health', 'about1');
 select * from FoodProduct;
 
 select * from cartdetails;


-- DeliveryInformation stores delivery details
CREATE TABLE deliveryinformation (
    deliveryID INT PRIMARY KEY,
	id INT,
    address VARCHAR(200) NOT NULL,
    city VARCHAR(50) NOT NULL,
    pincode VARCHAR(20),
    firstname VARCHAR(50) NOT NULL,
    lastname VARCHAR(50) NOT NULL,
    email VARCHAR(100) NOT NULL,
    phone VARCHAR(20),
    CONSTRAINT fk_user_id FOREIGN KEY (id) REFERENCES user(id)
);
drop table DeliveryInformation;
 select * from DeliveryInformation;

INSERT INTO DeliveryInformation (deliveryID, userID, address, city, pincode,firstname,lastname,email,phone)
VALUES (1, 1, 'Udaipur', 'Hiranmangri', '313001','Sunil','Suthar','jangid.suil50@gmail.com',9529766678);
INSERT INTO DeliveryInformation (deliveryID, userID, address, city, pincode,firstname,lastname,email,phone)
VALUES (2, 1, 'Udaipur', 'Hiranmangri', '313001','Sunny','thar','suil50@gmail.com',9529766678);


-- CartDetails stores items in the user's cart
CREATE TABLE cartdetails (
    cartID INT PRIMARY KEY,
    id INT,
    productID INT,
    quantity INT NOT NULL,
    FOREIGN KEY (id) REFERENCES User(id)
    -- FOREIGN KEY (productID) REFERENCES skinproducts(productID) ON DELETE CASCADE  ,
--     FOREIGN KEY (productID) REFERENCES FoodProduct(productID) ON DELETE CASCADE
);
drop table CartDetails;
 select * from CartDetails;

INSERT INTO CartDetails (cartID, id, productID,price)
VALUES (2, 1, 1,200);
INSERT INTO CartDetails (cartID, userID, productID, quantity)
VALUES (2, 2, 2, 1000);
INSERT INTO CartDetails (cartID, userID, productID, quantity)
VALUES (3, 1, 1, 60);
INSERT INTO CartDetails (cartID, userID, productID, quantity)
VALUES (4, 1, 3, 50);

truncate table foodproducts; -- it will not work
delete from foodmodel;
drop table foodproducts; -- it will not work




SELECT
    skinproducts.productID,
    skinproducts.productName,
    skinproducts.image,
    skinproducts.price,
    skinproducts.sectionId
  --  CartDetails.quantity
FROM
    skinproducts
JOIN
    CartDetails ON skinproducts.productID = CartDetails.productID
WHERE
 CartDetails.id=1 and CartDetails.cartID=3; 
    
    
SELECT
    FoodProduct.productID,
    FoodProduct.productName,
    FoodProduct.description,
    FoodProduct.price,
    FoodProduct.sectionId
    -- CartDetails.quantity
FROM
    FoodProduct
JOIN
    CartDetails ON FoodProduct.productID = CartDetails.productID
WHERE
    CartDetails.id = 1 and CartDetails.cartID=2;
    
  
   SELECT
    DeliveryInformation.deliveryID,
    DeliveryInformation.id,
    DeliveryInformation.address,
    DeliveryInformation.city,
    DeliveryInformation.pincode,
    DeliveryInformation.firstname,
    DeliveryInformation.lastname,
    DeliveryInformation.email,
    DeliveryInformation.phone,
    skinproducts.productID,
    skinproducts.productname,
    skinproducts.sectionId,
    skinproducts.price AS productPrice
    -- CartDetails.quantity
FROM
    DeliveryInformation
JOIN
    CartDetails ON DeliveryInformation.id = CartDetails.id
JOIN
    skinproducts ON CartDetails.productID = skinproducts.productID
WHERE
    DeliveryInformation.id = 1;
    
    
    SELECT
    DeliveryInformation.deliveryID,
    DeliveryInformation.userID,
    DeliveryInformation.address,
    DeliveryInformation.city,
    DeliveryInformation.pincode,
    DeliveryInformation.firstName,
    DeliveryInformation.lastName,
    DeliveryInformation.email,
    DeliveryInformation.phone,
    FoodProduct.productID,
    FoodProduct.productName,
    FoodProduct.sectionId,
    FoodProduct.price AS productPrice,
    CartDetails.quantity
FROM
    DeliveryInformation
JOIN
    CartDetails ON DeliveryInformation.userID = CartDetails.userID
JOIN
    FoodProduct ON CartDetails.productID = FoodProduct.productID
WHERE
    DeliveryInformation.userID = 1;


 SELECT
    DeliveryInformation.deliveryID,
    DeliveryInformation.id,
    DeliveryInformation.address,
    DeliveryInformation.city,
    DeliveryInformation.pincode,
    DeliveryInformation.firstName,
    DeliveryInformation.lastName,
    DeliveryInformation.email,
    DeliveryInformation.phone,
    DeliveryInformation.pid,
    CartDetails.productID,
    CartDetails.cartid,
    CartDetails.productname,
    CartDetails.imagepath,
    CartDetails.price AS productPrice
    -- CartDetails.quantity
FROM
    DeliveryInformation
  --  join
--  	CartDetails ON DeliveryInformation.id = CartDetails.id
INNER JOIN
   CartDetails ON CartDetails.productID = DeliveryInformation.pid
WHERE
    DeliveryInformation.id = 1;
    
    
    
   



delimiter $$
create procedure fetchcartdeliverydetails(in checkid int)
begin

 SELECT
   --  DeliveryInformation.deliveryID,
   --  DeliveryInformation.id,
    DeliveryInformation.address,
    DeliveryInformation.city,
    DeliveryInformation.pincode,
    DeliveryInformation.firstname,
    DeliveryInformation.lastname,
    DeliveryInformation.email,
    DeliveryInformation.phone,
    DeliveryInformation.pid,
--     CartDetails.id,
    CartDetails.productid,
    CartDetails.cartid,
    CartDetails.productname,
    CartDetails.imagepath,
    CartDetails.price 
    -- CartDetails.quantity
FROM
    CartDetails
-- join
--  	CartDetails ON DeliveryInformation.pid = CartDetails.productID
INNER JOIN
   DeliveryInformation ON CartDetails.productid = DeliveryInformation.pid  
WHERE
   CartDetails.id  = DeliveryInformation.id ;
end$$
delimiter $$;


call fetchcartdeliverydetails(2);
select *from cartdeliverydetails;