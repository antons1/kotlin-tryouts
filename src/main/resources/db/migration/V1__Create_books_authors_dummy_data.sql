CREATE TABLE authors (
    id uuid UNIQUE NOT NULL PRIMARY KEY,
    firstname varchar(255) NOT NULL,
    lastname varchar(255) NOT NULL
);

CREATE TABLE books (
    id uuid UNIQUE NOT NULL PRIMARY KEY,
    authorId uuid NOT NULL,
    name varchar(255) NOT NULL,
    pagecount int NOT NULL,

    FOREIGN KEY(authorId)
        REFERENCES authors(id)
                   ON DELETE CASCADE
                   ON UPDATE CASCADE
);

INSERT INTO authors (id, firstname, lastname) VALUES
                                                  (gen_random_uuid(), 'Joshua', 'Bloch'),
                                                  (gen_random_uuid(), 'Bill', 'Bryson'),
                                                  (gen_random_uuid(), 'Douglas', 'Adams');

INSERT INTO books (id, authorId, name, pagecount) VALUES
                                                      (gen_random_uuid(), (SELECT id FROM authors WHERE firstname='Joshua'), 'Effective Java', 416),
                                                      (gen_random_uuid(), (SELECT id FROM authors WHERE firstname='Bill'), 'Down Under', 436),
                                                      (gen_random_uuid(), (SELECT id FROM authors WHERE firstname='Douglas'), 'Hitchhikers Guide to the Galaxy', 208);
