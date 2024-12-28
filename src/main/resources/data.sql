insert into authority_list
    (authority, student, librarian)
values ('ROLE_ADD_BOOK', 0, 1),
       ('ROLE_GET_BOOK', 1, 1),
       ('ROLE_DELETE_BOOK', 0, 1),
       ('ROLE_UPDATE_BOOK', 0, 1),
       ('ROLE_FIND_BOOK', 1, 1),
       ('ROLE_UPDATE_STUDENT', 1, 1),
       ('ROLE_DELETE_STUDENT', 1, 1),
       ('ROLE_GET_STUDENT', 1, 1),
       ('ROLE_CREAT_STUDENT', 0, 1),
       ('ROLE_FIND_STUDENT', 1, 1),
       ('ROLE_CREAT_LIBRARY', 0, 1),
       ('ROLE_GET_LIBRARY', 1, 1),
       ('ROLE_DELETE_LIBRARY', 0, 1),
       ('ROLE_UPDATE_LIBRARY', 0, 1),
       ('ROLE_CREAT_LIBRARY', 0, 1),
       ('ROLE_GET_LIBRARIAN', 1, 1),
       ('ROLE_DELETE_LIBRARIAN', 0, 1),
       ('ROLE_UPDATE_LIBRARIAN', 0, 1),
       ('ROLE_GET_BOOKS', 1, 1);


INSERT INTO librarian (name, surname, username, address, phone, email)
VALUES ('Elgin', 'Guliyev', 'elgin', 'Baki', '1236', 'elgin@gmail.com');

INSERT INTO student (name, surname, username, address, phone, email, library_id)
VALUES ('test1', 'test1', 'test1', 'Baki', '1237', 'test1@gmail.com',  1),
       ('test2', 'test2', 'test2', 'Baki', '1238', 'test2@gmail.com', 1);

INSERT INTO library (name, address, phone_number, email, established_date, librarian_id)
VALUES ('Central Library', '123 Main St', '+1234567890', 'central.library@example.com', '2000-01-01', 1);



INSERT INTO book (name, description, author, page_count, language, publish_date, register_date, library_id,
                  librarian_id)
VALUES ('The Great Gatsby', 'A classic novel set in the 1920s, exploring themes of wealth and excess.',
        'F. Scott Fitzgerald', 180,  'English', '1925-04-10', '2024-12-18 10:00:00', 1, 1),
       ('1984', 'A dystopian social science fiction novel and cautionary tale about the future.', 'George Orwell', 328,
         'English', '1949-06-08', '2024-12-18 10:10:00', 1, 1),
       ('To Kill a Mockingbird', 'A novel about racial injustice in the Deep South.', 'Harper Lee', 281,
        'English', '1960-07-11', '2024-12-18 10:20:00', 1, 1),
       ('Pride and Prejudice', 'A romantic novel of manners that depicts the British landed gentry.', 'Jane Austen',
        279,  'English', '1813-01-28', '2024-12-18 10:30:00', 1, 1);

insert into users
    (username, password, enabled)
values ('elgin', '$2a$12$ddKpitVCPkm10eLVHn/0P.fKZtDZUQYcV3d6G77JLeitMgWxgIjfu', 1),
       ('test1', '{noop}test1', 1),
       ('test2', '{noop}test2', 1);
--     ('alici2','{noop}1234',1);

insert into authorities
    (username, authority)
select 'elgin', authority
from authority_list
where librarian = 1;

insert into authorities
    (username, authority)
select 'test1', authority
from authority_list
where student = 1;


insert into authorities
    (username, authority)
select 'test2', authority
from authority_list
where student = 1;