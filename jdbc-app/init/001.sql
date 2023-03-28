CREATE TABLE book
(
    id         INT AUTO_INCREMENT PRIMARY KEY,
    title      varchar(255),
    rating     INT
) ENGINE = INNODB;

INSERT INTO book(title) VALUES
                                  ('Orly imperium'),
                                  ('Orly imperium: Gladiator'),
                                  ('Orly imperium: Orly i Wilki')