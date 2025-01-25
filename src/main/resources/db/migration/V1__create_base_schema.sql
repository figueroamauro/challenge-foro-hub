CREATE schema IF NOT EXISTS foro_hub;

CREATE TABLE users (
    id int AUTO_INCREMENT NOT NULL,
    username varchar(100) NOT NULL,
    password varchar(100) NOT NULL,
    email varchar(100) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE topics (
    id int AUTO_INCREMENT NOT NULL,
    title varchar(100) NOT NULL,
    message varchar(3000) NOT NULL,
    status varchar(100) NOT NULL,
    creation_date timestamp NOT NULL,
    last_update_date timestamp NOT NULL,
    user_id integer NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (user_id) REFERENCES users(id)
);

CREATE TABLE comments (
    id int AUTO_INCREMENT NOT NULL,
    message varchar(3000) NOT NULL,
    status varchar(100) NOT NULL,
    topic_id integer NOT NULL,
    user_id integer NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (topic_id) REFERENCES topics(id) ON DELETE CASCADE,
    FOREIGN KEY (user_id) REFERENCES users(id)
);