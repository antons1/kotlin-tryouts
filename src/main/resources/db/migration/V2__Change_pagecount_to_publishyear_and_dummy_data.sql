ALTER TABLE books DROP COLUMN pagecount, ADD COLUMN publishyear varchar(4) NOT NULL DEFAULT 0, ALTER COLUMN id SET DEFAULT gen_random_uuid();
ALTER TABLE authors ALTER COLUMN id SET DEFAULT gen_random_uuid();

UPDATE books SET publishyear = '1979' WHERE name = 'Hitchhikers Guide to the Galaxy';
UPDATE books SET publishyear = '2000' WHERE name = 'Down Under';
UPDATE books SET publishyear = '2001', name = 'Effective Java: Programming Language Guide' WHERE name = 'Effective Java';

INSERT INTO books (authorid, name, publishyear)
VALUES
((SELECT id FROM authors WHERE firstname = 'Douglas'), 'The Restaurant at the End of the Universe', '1980'),
((SELECT id FROM authors WHERE firstname = 'Douglas'), 'So Long, and Thanks for All the Fish', '1980'),
((SELECT id FROM authors WHERE firstname = 'Douglas'), 'Life, the Universe and Everything', '1982'),
((SELECT id FROM authors WHERE firstname = 'Douglas'), 'Mostly Harmless', '1984'),
((SELECT id FROM authors WHERE firstname = 'Douglas'), 'Dirk Gently''s Holistic Detective Agency', '1987'),
((SELECT id FROM authors WHERE firstname = 'Douglas'), 'The Long Dark Teatime of the Soul ', '1988'),
((SELECT id FROM authors WHERE firstname = 'Bill'), 'The Penguin Dictionary of Troublesome Words', '1984'),
((SELECT id FROM authors WHERE firstname = 'Bill'), 'The Palace under the Alps and Over 200 Other Unusual, Unspoiled and Infrequently Visited Spots in 16 European Countries', '1985'),
((SELECT id FROM authors WHERE firstname = 'Bill'), 'The Lost Continent: Travels in Small-Town America', '1989'),
((SELECT id FROM authors WHERE firstname = 'Bill'), 'Mother Tongue: The English Language', '1990'),
((SELECT id FROM authors WHERE firstname = 'Bill'), 'A Short History of Nearly Everything', '2003'),
((SELECT id FROM authors WHERE firstname = 'Joshua'), 'Java Puzzlers: Traps, Pitfalls, and Corner Cases', '2005'),
((SELECT id FROM authors WHERE firstname = 'Joshua'), 'Java Concurrency in Practice', '2006');