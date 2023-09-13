-- liquibase formatted sql
-- changeset k_shvetsova:1 context:create_table
CREATE TABLE if not exists books
(
    id             BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    name           VARCHAR(255) NOT NULL UNIQUE,
    description    VARCHAR(320),
    published_year int4         NULL
);

CREATE TABLE if not exists authors
(
    id          BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    name        VARCHAR(255) NOT NULL,
    last_name   VARCHAR(320),
    father_name VARCHAR(320),
    description VARCHAR,
    birth_day   timestamp    NULL,
    dead_day    timestamp    NULL
);

ALTER TABLE authors ADD CONSTRAINT authors_un UNIQUE (last_name, name, father_name);

CREATE table if not exists book_authors
(
    book_id   BIGINT,
    author_id BIGINT
);

ALTER TABLE book_authors
    ADD FOREIGN KEY (book_id) REFERENCES books (id);
ALTER TABLE book_authors
    ADD FOREIGN KEY (author_id) REFERENCES authors (id);

CREATE TABLE if not exists genres
(
    id   BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    name VARCHAR(255) NOT NULL UNIQUE
);

CREATE table if not exists book_genres
(
    book_id  BIGINt,
    genre_id BIGINT
);

ALTER TABLE book_genres
    ADD FOREIGN KEY (book_id) REFERENCES books (id);
ALTER TABLE book_genres
    ADD FOREIGN KEY (genre_id) REFERENCES genres (id);