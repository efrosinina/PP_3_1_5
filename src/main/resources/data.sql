INSERT INTO roles (name) VALUES ('ROLE_USER'), ('ROLE_ADMIN');
insert into users (username, lastname, age, email, password) values ('admin', 'admin', 35, 'admin@mail.ru', '$2a$12$vvtRbztshZra1204sv3iouHqDvwq.HljFuOUJ4Sngawm4e1oRM7QW');
INSERT INTO users_roles (user_id, role_id) VALUES (1, 2);