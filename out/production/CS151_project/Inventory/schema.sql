BEGIN TRANSACTION;
CREATE TABLE IF NOT EXISTS "Retailer" (
	"id"	INTEGER,
	"name"	TEXT NOT NULL,
	"city"	TEXT NOT NULL,
	"state"	TEXT NOT NULL,
	"product_id"	INTEGER,
	"quantity_available"	INTEGER,
	FOREIGN KEY("product_id") REFERENCES "Product"("id")
);
CREATE TABLE IF NOT EXISTS "Product" (
	"id"	INTEGER,
	"name"	TEXT NOT NULL UNIQUE,
	"description"	TEXT NOT NULL,
	"price"	REAL,
	PRIMARY KEY("id")
);
CREATE TABLE IF NOT EXISTS "HouseholdEssentials" (
	"id"	INTEGER,
	"environmentallyFriendly"	INTEGER CHECK("environmentallyFriendly" IN (0, 1)),
	FOREIGN KEY("id") REFERENCES "Product"("id"),
	PRIMARY KEY("id")
);
CREATE TABLE IF NOT EXISTS "Produce" (
	"id"	INTEGER,
	"organic"	INTEGER CHECK("organic" IN (0, 1)),
	"weight"	REAL,
	FOREIGN KEY("id") REFERENCES "Product"("id"),
	PRIMARY KEY("id")
);
CREATE TABLE IF NOT EXISTS "Dairy" (
	"id"	INTEGER,
	"veganFriendly"	INTEGER CHECK("veganFriendly" IN (0, 1)),
	"daysToExpire" INTEGER,
	FOREIGN KEY("id") REFERENCES "Product"("id"),
	PRIMARY KEY("id")
);
CREATE TABLE IF NOT EXISTS "Bakery" (
	"id"	INTEGER,
	"glutenFree"	INTEGER CHECK("glutenFree" IN (0, 1)),
	"daysToExpire"	INTEGER,
	FOREIGN KEY("id") REFERENCES "Product"("id"),
	PRIMARY KEY("id")
);
COMMIT;
