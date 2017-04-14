--
-- Create some roles
--
INSERT INTO roles (name) VALUES ('USER');

--
-- Create some users
--
INSERT INTO users (username, password, enabled)
VALUES ('zeros', '$2a$10$/80K8IjgoYwnWC/RPjOZ0eA.3/.EZnPevbgZG5JnkAYuucN23sKOC', 1);
INSERT INTO users (username, password, enabled)
VALUES ('hercule', '$2a$10$/80K8IjgoYwnWC/RPjOZ0eA.3/.EZnPevbgZG5JnkAYuucN23sKOC', 1);

--
-- Assign role to user
--
INSERT INTO users_roles (user_id, role_id) VALUES (1, 1);
INSERT INTO users_roles (user_id, role_id) VALUES (2, 1);

--
-- Create some posts
--
INSERT INTO posts (content) VALUES ('Savez vous qu''il est possible de créer des sites web à l''aide de Spring ?!');
INSERT INTO posts (content) VALUES ('Le canapé n''est plus confortable...');
--
-- Create some comments
--
INSERT INTO comments (author_id, post_id, content) VALUES (1, 1, 'Superbe article !');
INSERT INTO comments (author_id, post_id, content) VALUES (2, 1, 'Je ne savais pas ça possible...');

--
-- Create some likes
--
INSERT INTO likes (author_id, post_id) VALUES (1, 1);
INSERT INTO likes (author_id, post_id) VALUES (2, 2);