# DB setup query
CREATE SCHEMA [IF NOT EXISTS] trippy;

CREATE TABLE trippy.user(
id SERIAL PRIMARY KEY,
username VARCHAR(20) NOT NULL,
email VARCHAR(30) NOT NULL,
phone VARCHAR NOT NULL,
city VARCHAR(20) NOT NULL,
registration_date DATE NOT NULL
);

CREATE TABLE trippy.business(
id SERIAL PRIMARY KEY,
name VARCHAR(30) NOT NULL,
"type" VARCHAR NOT NULL,
rating INT NOT NULL,
reviews_count INT NOT NULL,
email VARCHAR(30) NOT NULL,
phone VARCHAR NOT NULL,
city VARCHAR(20) NOT NULL
);

ALTER TABLE trippy.business
ALTER COLUMN reviews_count
SET DEFAULT 0;

ALTER TABLE trippy.business
ALTER COLUMN rating
SET DEFAULT 0;

CREATE TABLE trippy.review(
id SERIAL PRIMARY KEY,
user_id INT NOT NULL,
business_id INT NOT NULL,
rating INT NOT NULL,
feedback VARCHAR(100) NOT NULL,
stamp_created DATE NOT NULL,
FOREIGN KEY(user_id) REFERENCES trippy.user(id),
FOREIGN KEY(business_id) REFERENCES trippy.business(id));