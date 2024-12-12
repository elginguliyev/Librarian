insert into authority_list
    (authority, student, librarian)
values ('ROLE_ADD_BOOK', 0, 1),
       ('ROLE_GET_BOOK', 1, 1),
       ('ROLE_DELETE_BOOK', 0, 1),
       ('ROLE_UPDATE_BOOK', 0, 1),
       ('ROLE_FIND_BOOK', 1, 0),
       ('ROLE_UPDATE_STUDENT', 1, 0),
       ('ROLE_DELETE_STUDENT', 1, 0),
       ('ROLE_GET_STUDENT', 1, 1),
       ('ROLE_CREAT_LIBRARY', 0, 1),
       ('ROLE_GET_LIBRARY', 1, 1),
       ('ROLE_DELETE_LIBRARY', 0, 1),
       ('ROLE_UPDATE_LIBRARY', 0, 1),
       ('ROLE_CREAT_LIBRARY', 0, 1),
       ('ROLE_GET_LIBRARIAN', 1, 1),
       ('ROLE_DELETE_LIBRARIAN', 0, 1),
       ('ROLE_UPDATE_LIBRARIAN', 0, 1);


INSERT INTO librarian (name, surname, username, address, phone, email, password)
VALUES ('Elgin', 'Guliyev', 'elgin', 'Baki', '1236', 'elgin@gmail.com', '{noop}elgin1');

insert into users
(username,password,enabled)
values
    ('elgin','{noop}elgin1',1);
--     ('satici2','{noop}1234',1),
--     ('alici1','{noop}1234',1),
--     ('alici2','{noop}1234',1);

insert into authorities
(username,authority)
select 'elgin',authority
from authority_list where librarian=1;