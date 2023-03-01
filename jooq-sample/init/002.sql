CREATE TABLE author
(
    id         INT PRIMARY KEY,
    first_name varchar(255),
    last_name  varchar(255),
    age        INT
) ENGINE = INNODB;

CREATE TABLE article
(
    id          INT PRIMARY KEY,
    title       varchar(255) not null,
    description varchar(255),
    author_id   INT,
    INDEX auth_ind (author_id),
    FOREIGN KEY (author_id)
        REFERENCES author (id)
        ON DELETE CASCADE
) ENGINE = INNODB;