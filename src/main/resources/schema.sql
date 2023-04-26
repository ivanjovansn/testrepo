CREATE TABLE IF NOT EXISTS Event (
    id SERIAL PRIMARY KEY,
    name varchar(255) NOT NULL,
    description text,
    status VARCHAR(20) NOT NULL,
    held_on TIMESTAMP NOT NULL
);