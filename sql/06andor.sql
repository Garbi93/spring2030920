
SELECT CustomerName, City, Country FROM customers
WHERE Country = 'spain';

SELECT CustomerName, City, Country FROM customers
WHERE City = 'madrid';

SELECT CustomerName, City, Country FROM customers
WHERE Country = 'spain' AND City = 'madrid';

SELECT CustomerName, City, Country FROM customers
WHERE Country != 'spain' AND City = 'madrid';

SELECT CustomerName, City, Country FROM customers
WHERE Country = 'spain' AND City != 'madrid';

SELECT CustomerName, City, Country FROM customers
WHERE Country != 'spain' AND City != 'madrid';

SELECT CustomerName, City, Country FROM customers
WHERE NOT (City = 'madrid' AND Country = 'spain');

SELECT CustomerName, City, Country FROM customers
WHERE City != 'madrid' OR Country !='spain';

SELECT CustomerName, City, Country FROM customers
WHERE City = 'madrid';
SELECT CustomerName, City, Country FROM customers
WHERE Country = 'spain';
SELECT CustomerName, City, Country FROM customers
WHERE City = 'madrid' or Country = 'spain';
SELECT CustomerName, City, Country FROM customers
WHERE Country = 'spain' OR Country = 'UK';

SELECT * FROM products
WHERE Price >= 10.00 AND Price <= 20.00;
SELECT * FROM customers
WHERE CustomerName >= 'c' AND CustomerName < 'd';
SELECT * FROM employees
WHERE BirthDate >= '1958-01-01' AND BirthDate < '1959-01-01';




