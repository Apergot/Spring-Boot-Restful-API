/* Populate tabla clients */
INSERT INTO regions (id, name) VALUES (1, 'Asia');
INSERT INTO regions (id, name) VALUES (2, 'South America');
INSERT INTO regions (id, name) VALUES (3, 'Europe');
INSERT INTO regions (id, name) VALUES (4, 'Africa');
INSERT INTO regions (id, name) VALUES (5, 'Oceania');
INSERT INTO regions (id, name) VALUES (6, 'Antarctica');
INSERT INTO regions (id, name) VALUES (7, 'North America');
INSERT INTO regions (id, name) VALUES (8, 'Central America');
INSERT INTO clients (region_id,firstname, lastname, email, create_at) VALUES(3,'Alejandro', 'Perdomo', 'apergot95@gmail.com', '2020-01-01');
INSERT INTO clients (region_id,firstname, lastname, email, create_at) VALUES(7,'Mr. John', 'Doe', 'john.doe@gmail.com', '2020-01-02');
INSERT INTO clients (region_id,firstname, lastname, email, create_at) VALUES(3,'Linus', 'Torvalds', 'linus.torvalds@gmail.com', '2020-01-03');
INSERT INTO clients (region_id,firstname, lastname, email, create_at) VALUES(3, 'Rasmus', 'Lerdorf', 'rasmus.lerdorf@gmail.com', '2020-01-04');
INSERT INTO clients (region_id,firstname, lastname, email, create_at) VALUES(5,'Erich', 'Gamma', 'erich.gamma@gmail.com', '2020-02-01');
INSERT INTO clients (region_id,firstname, lastname, email, create_at) VALUES(6,'Richard', 'Helm', 'richard.helm@gmail.com', '2020-02-10');
INSERT INTO clients (region_id,firstname, lastname, email, create_at) VALUES(7, 'Ralph', 'Johnson', 'ralph.johnson@gmail.com', '2020-02-18');
INSERT INTO clients (region_id,firstname, lastname, email, create_at) VALUES(8, 'John', 'Vlissides', 'john.vlissides@gmail.com', '2020-02-28');
INSERT INTO clients (region_id,firstname, lastname, email, create_at) VALUES(1, 'Dr. James', 'Gosling', 'james.gosling@gmail.com', '2020-03-03');
INSERT INTO clients (region_id,firstname, lastname, email, create_at) VALUES(3, 'Magma', 'Lee', 'magma.lee@gmail.com', '2020-03-04');
INSERT INTO clients (region_id,firstname, lastname, email, create_at) VALUES(3,'Tornado', 'Roe', 'tornado.roe@gmail.com', '2020-03-05');
INSERT INTO clients (region_id,firstname, lastname, email, create_at) VALUES(3,'Jade', 'Doe', 'jane.doe@gmail.com', '2020-03-06');

INSERT INTO users (username, password, enabled, firstname, lastname, email) VALUES ('SilentStorm', '$2a$10$urpm4dBvTyPZrTwimQqGE.HeubQTE2XSTtiW1FE.JsqA5R4sKY3z.', 1, 'Alejandro', 'Perdomo', 'someone@mail.xd');
INSERT INTO users (username, password, enabled, firstname, lastname, email) VALUES ('admin', '$2a$10$urpm4dBvTyPZrTwimQqGE.HeubQTE2XSTtiW1FE.JsqA5R4sKY3z.', 1,'Alejandro', 'Perdomo', 'admin@mail.xd');

INSERT INTO roles (name) VALUES ('ROLE_USER');
INSERT INTO roles (name) VALUES ('ROLE_ADMIN');

INSERT INTO users_roles (user_id, roles_id) VALUES (1,1);
INSERT INTO users_roles (user_id, roles_id) VALUES (2,1);
INSERT INTO users_roles (user_id, roles_id) VALUES (2,2);
