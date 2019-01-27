CREATE KEYSPACE IF NOT EXISTS bankdb WITH replication = {'class': 'SimpleStrategy', 'replication_factor' : 3};

USE bankdb;

CREATE TABLE IF NOT EXISTS users (
    name varchar,
    id varchar,
    amount float,
    PRIMARY KEY (id));

INSERT INTO users (name, id, amount) VALUES('Julia',  'd3bbb532-0548-4fd1-856c-01a9701b0749', 5000.0);
INSERT INTO users (name, id, amount) VALUES('Naomi',  'ded6809d-1840-4194-88cc-37c6d342e13e', 10000.0);
