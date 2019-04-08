INSERT INTO role VALUES (1,'ADMIN');
insert into user (active, email, last_name, name, password, user_id) values (1, 'test@gmail.com', 'LAST NAME', 'FIRST NAME', '$2a$10$ysrYmof0EkEKmN/Ncf4L.uO0JU5uPNoOwHRP/LyDvM3oAU/DXjcNC', 1);
INSERT INTO user_role VALUES (1,1);
insert into user (active, email, last_name, name, password, user_id) values (1, 'test2@gmail.com', 'LAST NAME', 'FIRST NAME', '$2a$10$ysrYmof0EkEKmN/Ncf4L.uO0JU5uPNoOwHRP/LyDvM3oAU/DXjcNC', 2);
INSERT INTO user_role VALUES (2,1);
