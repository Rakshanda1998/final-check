-- Include table data insertion, updation, deletion and select scripts

-----------------------------------------------------------------------
-- Adding Movies in Movie Table
-----------------------------------------------------------------------
INSERT INTO movie_item
VALUES
(1, 'Avatar', 2787965087,'Yes', '2017-03-15','Science Fiction', 'Yes'),
(2, 'The Avengers', 1518812988, 'Yes', '2017-02-23','Superhero', 'No'),
(3, 'Titanic', 2187463944, 'Yes', '2017-08-21','Romance', 'No'),
(4, 'Jurassic World', 1671713208, 'No','2017-07-02', 'Science Fiction', 'Yes'),
(5, 'Avengers: End Game', 2750760348, 'Yes','2020-11-02', 'Superhero', 'Yes');

------------------------------------------
-- Displaying Movie Table
------------------------------------------
select         
 mv_title as Title,
 mv_gross as Gross,
 mv_active as Active,
 mv_date_of_launch as Date_of_Launch,
 mv_genre as Genre,
 mv_has_teaser as Teaser
from movie_item;


-----------------------------------------------------------------------
-- Edit Movie Table
-----------------------------------------------------------------------
update movie_item 
set mv_title='The War',mv_genre='Tragedy',mv_active='No'
where mv_id=1;

-----------------------------------------
-- Displaying Movie Table
-----------------------------------------
select         
 mv_title as Title,
 mv_gross as Gross,
 mv_active as Active,
 mv_date_of_launch as Date_of_Launch,
 mv_genre as Genre,
 mv_has_teaser as Teaser
from movie_item;


-----------------------------------------------------------------------
-- Displaying Customer List in Movie Table
-----------------------------------------------------------------------
select mv_title,me_has_teaser,mv_gross,mv_genre
from movie_item
where mv_active='Yes' and mv_date_of_launch <= current_date();


-----------------------------------------------------------------------
-- Setting User Name and Id
-----------------------------------------------------------------------
INSERT INTO user
VALUES
(1,'Rekha'),
(2,'Raksha'),
(3,'Smita');

-----------------------------------------
-- Displaying User Movie Table
-----------------------------------------
SELECT          
 us_id AS Id,
 us_title AS Title
FROM user;



-----------------------------------------------------------------------
-- Add To Favorite
-----------------------------------------------------------------------
INSERT INTO favorite(ft_us_id,ft_pr_id)
VALUES
(1,1),
(2,5),
(1,4),
(2,2),
(2,3),
(1,1);

-----------------------------------------
-- Displaying User Movie Table
-----------------------------------------
SELECT 
 ft_id as Title,
 ft_us_id AS Gross,
 ft_pr_id AS Genre 
FROM favorite;



-----------------------------------------------------------------------
-- Show Favorite Movies
-----------------------------------------------------------------------
SELECT mv_title,mv_has_teaser,mv_gross
FROM movie_item
INNER JOIN favorite
ON ft_pr_id=mv_id
WHERE ft_us_id=2;

-----------------------------------------
-- Displaying User Movie Table
-----------------------------------------
SELECt
 ft_id as Title,
 ft_us_id AS Gross,
 ft_pr_id AS Genre 
FROM favorite;



-----------------------------------------------------------------------
-- Total Number of Favorite Movies
-----------------------------------------------------------------------
SELECT COUNT(mv_title) AS no_of_favorites
FROM movie_item
INNER JOIN favorite
ON ft_pr_id=mv_id
WHERE ft_us_id=2;



-----------------------------------------------------------------------
-- Delete from Favorite Items
-----------------------------------------------------------------------
DELETE FROM favorite
WHERE ft_us_id=1
AND ft_pr_id=1
LIMIT 1;


-----------------------------------------------------------------------
-- View Deleted Favorite Movies
-----------------------------------------------------------------------
SELECT mv_title,mv_has_teaser,mv_gross
FROM movie_item
INNER JOIN favorite
On ft_pr_id=mv_id
WHERE ft_us_id=2;


-----------------------------------------------------------------------
-- Show Total Number of Favorite Movies
-----------------------------------------------------------------------
SELECT COUNT(mv_title) AS no_of_favorites
FROM movie_item
INNER JOIN favorite
ON ft_pr_id=mv_id  
WHERE ft_us_id=2;

