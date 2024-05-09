# CS151: Project Grocery MarketPlace

## Overview 

--- 

- An application coded in Java, using various key Object-Oriented Design principles like encapsulation,
  inheritance, polymorphism, and abstraction.
- The application is a simple GroceryMarket place simulation (much like a DoorDash).

---

## How to Run

---

1. Download this Repository as a [**zip**](https://github.com/pandu-0/CS151_project/archive/refs/heads/main.zip) file and **extract** it
2. Open your preferred command prompt application. We used `Terminal` in Mac
3. Change current working directory using `cd` to the **zip** file you just extracted
4. run the command below

```shell
java -classpath out/production/CS151_project:src/Inventory/sqlite-jdbc-3.45.3.0.jar:src/Inventory/slf4j-api-2.0.13.jar:src/Inventory/slf4j-simple-2.0.7.jar Main
```

Example run:
```
pandu@Pandus-MacBook-Pro ~ % cd Downloads/CS151_project-main

pandu@Pandus-MacBook-Pro CS151_project-main % ls
CS151_project.iml	out			readme.md		src

pandu@Pandus-MacBook-Pro CS151_project-main % pwd
/Users/pandu/Downloads/CS151_project-main

# this is where the program is ran
pandu@Pandus-MacBook-Pro CS151_project-main % java -classpath out/production/CS151_project:src/Inventory/sqlite-jdbc-3.45.3.0.jar:src/Inventory/slf4j-api-2.0.13.jar:src/Inventory/slf4j-simple-2.0.7.jar Main

HIII!!

Welcome to the Grocery Marketplace! :)


What category of Products would you like to browse today?

Categories:
    1. Dairy
    2. Bakery
    3. House Hold
    4. Produce

Enter the Category Name you want to browse exactly as you see it in the list: Dairy


Understood! ;)

Dairy Products:
-ID-	              -Name-	            -Description-	    -Price-
   1	                Milk	         Fresh whole milk	      2.99
   2	              Cheese	           Cheddar cheese	      5.99
   9	              Yogurt	             Greek yogurt	      1.99
  10	              Butter	          Unsalted butter	      4.99

Which Product would you like to purchase?
Enter id of Product exactly: 
```