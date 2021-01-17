DROP TABLE users;
CREATE TABLE IF NOT EXISTS users (
    id VARCHAR NOT NULL,
    name VARCHAR NOT NULL,
    mail_address VARCHAR NOT NULL DEFAULT '',
    primary key (id)
);
