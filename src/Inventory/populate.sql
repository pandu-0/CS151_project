BEGIN TRANSACTION;
-- Inserting into Product, Dairy, and Retailer Tables
INSERT INTO Product (id, name, description, price) VALUES (1, 'Milk', 'Fresh whole milk', 2.99);
INSERT INTO Dairy (id, veganFriendly, daysToExpire) VALUES (1, 1, 25);
INSERT INTO Retailer (id, name, city, state, product_id, quantity_available) 
VALUES 
    (1, 'Bargain Bazaar', 'San Jose', 'CA', 1, 10),
    (2, 'Mosaic Mart', 'Santa Clara', 'CA', 1, 50);

INSERT INTO Product (id, name, description, price) VALUES (2, 'Cheese', 'Cheddar cheese', 5.99);
INSERT INTO Dairy (id, veganFriendly, daysToExpire) VALUES (2, 1, 30);
INSERT INTO Retailer (id, name, city, state, product_id, quantity_available) 
VALUES 
    (3, 'Jubilant Junction', 'San Bruno', 'CA', 2, 10),
    (2, 'Mosaic Mart', 'Santa Clara', 'CA', 2, 20);

INSERT INTO Product (id, name, description, price) VALUES (9, 'Yogurt', 'Greek yogurt', 1.99);
INSERT INTO Dairy (id, veganFriendly, daysToExpire) VALUES (9, 1, 29);
INSERT INTO Retailer (id, name, city, state, product_id, quantity_available) 
VALUES 
    (3, 'Jubilant Junction', 'San Bruno', 'CA', 9, 10),
    (2, 'Mosaic Mart', 'Santa Clara', 'CA', 9, 20);

INSERT INTO Product (id, name, description, price) VALUES (10, 'Butter', 'Unsalted butter', 4.99);
INSERT INTO Dairy (id, veganFriendly, daysToExpire) VALUES (10, 1, 40);
INSERT INTO Retailer (id, name, city, state, product_id, quantity_available) 
VALUES 
    (5, 'Harvest Haven', 'Milpitas', 'CA', 10, 15),
    (7, 'Bountiful Basket', 'Sunnyvale', 'CA', 10, 10);

-- Inserting into Product, Bakery, and Retailer Tables
INSERT INTO Product (id, name, description, price) VALUES (3, 'Bread', 'Whole grain bread', 3.99);
INSERT INTO Bakery (id, glutenFree, daysToExpire) VALUES (3, 0, 30);
INSERT INTO Retailer (id, name, city, state, product_id, quantity_available) 
VALUES 
    (5, 'Harvest Haven', 'Milpitas', 'CA', 3, 8),
    (7, 'Bountiful Basket', 'Sunnyvale', 'CA', 3, 20),
    (2, 'Mosaic Mart', 'Santa Clara', 'CA', 3, 1);


INSERT INTO Product (id, name, description, price) VALUES (4, 'Cake', 'Chocolate cake', 20.00);
INSERT INTO Bakery (id, glutenFree, daysToExpire) VALUES (4, 0, 10);
INSERT INTO Retailer (id, name, city, state, product_id, quantity_available) 
VALUES 
    (7, 'Bountiful Basket', 'Sunnyvale', 'CA', 4, 10),
    (3, 'Jubilant Junction', 'San Bruno', 'CA', 4, 10),
    (4, 'Elite Essentials', 'San Ramon', 'CA', 4, 0);

INSERT INTO Product (id, name, description, price) VALUES (11, 'Donut', 'Glazed donut', 1.50);
INSERT INTO Bakery (id, glutenFree, daysToExpire) VALUES (11, 1, 20);
INSERT INTO Retailer (id, name, city, state, product_id, quantity_available) 
VALUES 
    (1, 'Bargain Bazaar', 'San Jose', 'CA', 11, 13),
    (6, 'Dietary Depot', 'Union City', 'CA', 11, 19),
    (3, 'Jubilant Junction', 'San Bruno', 'CA', 11, 0);


INSERT INTO Product (id, name, description, price) VALUES (12, 'Bagel', 'Whole grain bagel', 1.00);
INSERT INTO Bakery (id, glutenFree, daysToExpire) VALUES (12, 0, 10);
INSERT INTO Retailer (id, name, city, state, product_id, quantity_available) 
VALUES 
    (5, 'Harvest Haven', 'Milpitas', 'CA', 12, 7),
    (6, 'Dietary Depot', 'Union City', 'CA', 12, 9),
    (7, 'Bountiful Basket', 'Sunnyvale', 'CA', 12, 13);

-- Inserting into Product, Produce, and Retailer Tables
INSERT INTO Product (id, name, description, price) VALUES (5, 'Apple', 'Fresh apple', 0.99);
INSERT INTO Produce (id, organic, weight) VALUES (5, 1, 0.2);
INSERT INTO Retailer (id, name, city, state, product_id, quantity_available) 
VALUES 
    (7, 'Bountiful Basket', 'Sunnyvale', 'CA', 5, 500),
    (2, 'Mosaic Mart', 'Santa Clara', 'CA', 5, 200),
    (5, 'Harvest Haven', 'Milpitas', 'CA', 5, 100);


INSERT INTO Product (id, name, description, price) VALUES (6, 'Banana', 'Fresh banana', 0.59);
INSERT INTO Produce (id, organic, weight) VALUES (6, 1, 0.15);
INSERT INTO Retailer (id, name, city, state, product_id, quantity_available) 
VALUES 
    (6, 'Dietary Depot', 'Union City', 'CA', 6, 150),
    (1, 'Bargain Bazaar', 'San Jose', 'CA', 6, 200),
    (3, 'Jubilant Junction', 'San Bruno', 'CA', 6, 330);


INSERT INTO Product (id, name, description, price) VALUES (13, 'Orange', 'Fresh orange', 0.80);
INSERT INTO Produce (id, organic, weight) VALUES (13, 0, 0.25);
INSERT INTO Retailer (id, name, city, state, product_id, quantity_available) 
VALUES 
    (2, 'Mosaic Mart', 'Santa Clara', 'CA', 13, 600),
    (7, 'Bountiful Basket', 'Sunnyvale', 'CA', 13, 350),
    (4, 'Elite Essentials', 'San Ramon', 'CA', 13, 195);

INSERT INTO Product (id, name, description, price) VALUES (14, 'Carrot', 'Fresh carrot', 0.60);
INSERT INTO Produce (id, organic, weight) VALUES (14, 0, 0.10);
INSERT INTO Retailer (id, name, city, state, product_id, quantity_available) 
VALUES 
    (5, 'Harvest Haven', 'Milpitas', 'CA', 14, 1000),
    (3, 'Jubilant Junction', 'San Bruno', 'CA', 14, 180),
    (1, 'Bargain Bazaar', 'San Jose', 'CA', 14, 200);

-- Inserting into Product, HouseholdEssentials, and Retailer Tables
INSERT INTO Product (id, name, description, price) VALUES (7, 'Toothpaste', 'Mint toothpaste', 3.49);
INSERT INTO HouseholdEssentials (id, environmentallyFriendly) VALUES (7, 1);
INSERT INTO Retailer (id, name, city, state, product_id, quantity_available) 
VALUES 
    (3, 'Jubilant Junction', 'San Bruno', 'CA', 7, 50),
    (7, 'Bountiful Basket', 'Sunnyvale', 'CA', 7, 40),
    (2, 'Mosaic Mart', 'Santa Clara', 'CA', 7, 10);

INSERT INTO Product (id, name, description, price) VALUES (8, 'Shampoo', 'Herbal shampoo', 5.49);
INSERT INTO HouseholdEssentials (id, environmentallyFriendly) VALUES (8, 1);
INSERT INTO Retailer (id, name, city, state, product_id, quantity_available) 
VALUES 
    (7, 'Bountiful Basket', 'Sunnyvale', 'CA', 8, 40),
    (1, 'Bargain Bazaar', 'San Jose', 'CA', 8, 80),
    (4, 'Elite Essentials', 'San Ramon', 'CA', 8, 40);

INSERT INTO Product (id, name, description, price) VALUES (15, 'Detergent', 'Laundry detergent', 7.99);
INSERT INTO HouseholdEssentials (id, environmentallyFriendly) VALUES (15, 1);
INSERT INTO Retailer (id, name, city, state, product_id, quantity_available) 
VALUES 
    (7, 'Bountiful Basket', 'Sunnyvale', 'CA', 15, 60),
    (5, 'Harvest Haven', 'Milpitas', 'CA', 15, 76),
    (1, 'Bargain Bazaar', 'San Jose', 'CA', 15, 42);

INSERT INTO Product (id, name, description, price) VALUES (16, 'Toilet Paper', 'Soft toilet paper', 6.49);
INSERT INTO HouseholdEssentials (id, environmentallyFriendly) VALUES (16, 1);
INSERT INTO Retailer (id, name, city, state, product_id, quantity_available) 
VALUES 
    (1, 'Bargain Bazaar', 'San Jose', 'CA', 16, 100),
    (6, 'Dietary Depot', 'Union City', 'CA', 16, 20),
    (4, 'Elite Essentials', 'San Ramon', 'CA', 16, 90);

COMMIT;