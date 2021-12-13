create table event
(
    id          bigint       not null
        primary key,
    creator     bigint       null,
    date        datetime(6)  null,
    description varchar(255) null,
    picture     varchar(255) null,
    place       varchar(255) null,
    title       varchar(255) null,
    type        varchar(255) null
);

create table event_attendees
(
    event_id  bigint not null,
    attendees bigint null,
    foreign key (event_id) references event (id)
);

create table hibernate_sequence
(
    next_val bigint null
);

create table course
(
    id          bigint       not null
        primary key,
    creator_id  bigint       null,
    description varchar(255) null,
    link        varchar(255) null,
    picture     varchar(255) null,
    title       varchar(255) null
);

create table notification
(
    id      bigint       not null
        primary key,
    is_read bit          null,
    message varchar(255) null,
    user_id bigint       null
);

create table user
(
    id       bigint       not null
        primary key,
    email    varchar(255) null,
    is_admin bit          null,
    name     varchar(255) null,
    password varchar(255) null,
    role     varchar(255) null
);

create table user_event_id
(
    user_id  bigint not null,
    event_id bigint null,
        foreign key (user_id) references user (id)
);


create table auth_session
(
    id       bigint       not null
        primary key,
    user_id  bigint not null,
    token VARCHAR(255) null,
    foreign key (user_id) references user (id)
);

create table role
(
    id   bigint       not null
        primary key,
    name varchar(255) null
);

create table user_roles
(
    user_id  bigint not null,
    roles_id bigint not null,
    primary key (user_id, roles_id),
    foreign key (roles_id) references role (id)
);

INSERT INTO finalProject.event (id, creator, date, description, picture, place, title, type) VALUES (1, 1, '2021-11-20 18:01:44', 'But we can’t do it without you. Whether you donate to children for the holidays, either by giving a financial gift, organizing your own fundraiser, or participating in an event, your generosity means the world in the life of a child.', 'https://images.pexels.com/photos/1686463/pexels-photo-1686463.jpeg?auto=compress&cs=tinysrgb&dpr=3&h=750&w=1260', 'Africa', 'ONG Help needed', 'ONG');
INSERT INTO finalProject.event (id, creator, date, description, picture, place, title, type) VALUES (2, 2, '2021-12-20 18:01:47', 'Help us to reforest, we will plant trees with your help.', 'https://images.pexels.com/photos/1072824/pexels-photo-1072824.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260', 'UK', 'PLANT_TREES', 'PLANT_TREES');
INSERT INTO finalProject.event (id, creator, date, description, picture, place, title, type) VALUES (3, 2, '2022-05-20 18:01:50', 'We need your help to plant up to 1000 trees on Europe.', 'https://compote.slate.com/images/c465d192-5e36-4533-90fc-e198da3f061a.jpeg?width=780&height=520&rect=1560x1040&offset=0x0', 'EU', 'PLANT_TREES', 'PLANT_TREES');
INSERT INTO finalProject.event (id, creator, date, description, picture, place, title, type) VALUES (4, 1, '2022-02-20 18:01:55', 'The HelpAge Global Network is a unique worldwide alliance standing up for the rights of older people. It is a truly international movement for change. We share one major goal: creating a fairer world for older people so they can live safe, healthy ', 'https://images.pexels.com/photos/2883380/pexels-photo-2883380.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260', 'AFRICA', 'ONG', 'ONG');
INSERT INTO finalProject.event (id, creator, date, description, picture, place, title, type) VALUES (6, 6, '2021-11-23 14:15:42', 'Africa kids need you! Help us to create a good life for them!', 'https://images.unsplash.com/photo-1615150338956-542fc878f7e4?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=2330&q=80', 'Africa', 'ONG', 'ONG');
INSERT INTO finalProject.event (id, creator, date, description, picture, place, title, type) VALUES (7, 1, '2021-11-26 14:15:49', 'We are a group to clean plastic on beaches in Murcia. Join us!', 'https://cdn.shopify.com/s/files/1/0518/7135/0963/articles/0caec3eaa7cd3c17e14ad5e5fc51f2d4_1000x.jpg?v=1613130725', 'Murcia', 'CLEAN', 'CLEAN');
INSERT INTO finalProject.event (id, creator, date, description, picture, place, title, type) VALUES (8, 1, '2022-07-29 22:49:08', 'Help us to feed people with problems', 'https://images.pexels.com/photos/6994926/pexels-photo-6994926.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260', 'Madrid', 'Feed-Homeless', 'OTHER');
INSERT INTO finalProject.event (id, creator, date, description, picture, place, title, type) VALUES (9, 2, '2022-06-29 22:49:14', 'Help our Grampa!', 'https://www.ayudafamiliar.es/blog/wp-content/uploads/2019/11/como-cuidar-persona-mayor.jpg', 'Asturias', 'Help is needed', 'OTHER');
INSERT INTO finalProject.event (id, creator, date, description, picture, place, title, type) VALUES (10, 3, '2022-01-29 22:49:19', 'This animals need help!', 'https://images.pexels.com/photos/1904105/pexels-photo-1904105.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260', 'Spain', 'Animals need help!', 'Other');
INSERT INTO finalProject.event (id, creator, date, description, picture, place, title, type) VALUES (11, 4, '2022-03-01 22:49:25', 'Ayuda en catastrofes', 'https://images.pexels.com/photos/36785/soldier-military-uniform-american.jpg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260', 'Uganda', 'Help others ', 'Other');
INSERT INTO finalProject.event (id, creator, date, description, picture, place, title, type) VALUES (13, 6, '2022-04-29 22:49:37', 'Volunteers to vacuun children around the world', 'https://images.pexels.com/photos/3997722/pexels-photo-3997722.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260', 'World', 'Help children to get them vaccination', 'other');
INSERT INTO finalProject.event (id, creator, date, description, picture, place, title, type) VALUES (14, 7, '2021-12-29 22:49:33', 'remove plastic.', 'https://images.pexels.com/photos/7656743/pexels-photo-7656743.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260', 'world', 'Remove Plastic', 'other');
INSERT INTO finalProject.event (id, creator, date, description, picture, place, title, type) VALUES (28, 1, '1907-07-13 00:00:00', 'Help kids in Madrid', 'https://www.todaysparent.com/wp-content/uploads/2018/09/ways-to-help-kids-with-autism-have-great-playdates-1280x960.jpg', 'Madrid', 'Help kids!', 'ONG');
INSERT INTO finalProject.event (id, creator, date, description, picture, place, title, type) VALUES (40, 1, '1907-07-13 00:00:00', 'Have a trip and help turtles to get to the sea! The turtles are in danger to desapear from our oceans. Helping them to get to the sea, you are increasing their change to survive and avoid their extincion. Join us now!', 'https://images.unsplash.com/photo-1617835963886-d504ab3cca44?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=2340&q=80', 'Indonesia', 'Help turtles to get save to the sea!', 'Help animals');
INSERT INTO finalProject.event (id, creator, date, description, picture, place, title, type) VALUES (41, 2, '1907-07-13 00:00:00', 'Marine animals are in danger to desapear. Help with the stranded to go back to the ocean. ', 'https://images.unsplash.com/photo-1607153333879-c174d265f1d2?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=2342&q=80', 'Indonesia', 'Help dolphins and other mamals', 'Help animals');
INSERT INTO finalProject.event (id, creator, date, description, picture, place, title, type) VALUES (54, 2, '1907-07-13 00:00:00', 'Help kids in Madridkjjkjk', 'https://www.todaysparent.com/wp-content/uploads/2018/09/ways-to-help-kids-with-autism-have-great-playdates-1280x960.jpg', 'Madrid', 'Help kids!oiopo', 'ONG');
INSERT INTO finalProject.event (id, creator, date, description, picture, place, title, type) VALUES (55, 1, '2021-12-11 10:48:24', 'Embark on an unforgettable volunteer trip and experience South Africa’s authentic lifestyle whilst making a real difference to the vervet monkey population. On this amazing adventure.', 'https://images.unsplash.com/photo-1522107992019-d841a73de1f4?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=2340&q=80', 'Africa', 'Big 5 African Wildlife & Conservation', 'ONG');
INSERT INTO finalProject.event (id, creator, date, description, picture, place, title, type) VALUES (56, 3, '2021-12-13 10:48:28', null, 'https://cdn.pixabay.com/photo/2015/08/21/11/43/chimpanzee-898756_1280.jpg', 'Africa', 'Monkey Rehabilitation', 'ONG');
INSERT INTO finalProject.event (id, creator, date, description, picture, place, title, type) VALUES (57, 2, '2021-12-13 10:48:32', 'Elephant Conservation & Helping Local Farmers', 'https://cdn.pixabay.com/photo/2021/10/16/08/41/animal-6714423_1280.jpg', 'Africa', 'Elephant Conservation & Helping Local Farmers', 'ONG');
INSERT INTO finalProject.event (id, creator, date, description, picture, place, title, type) VALUES (58, 3, '2021-12-15 10:48:35', 'Scuba Diving and Marine Conservation', 'https://cdn.pixabay.com/photo/2019/12/22/15/07/fish-4712750_1280.jpg', 'Indonesia', 'Scuba Diving and Marine Conservation', 'Animals help');
INSERT INTO finalProject.event (id, creator, date, description, picture, place, title, type) VALUES (59, 4, '2021-12-14 10:48:40', 'Embark on an unforgettable volunteer trip and experience the Nepalese lifestyle whilst making a real difference to the greater community. On this amazing adventure.', 'https://cdn.pixabay.com/photo/2013/02/12/14/58/nepal-80755_1280.jpg', 'Nepal', 'Humanitarian Nepal', 'Help kids');
INSERT INTO finalProject.event (id, creator, date, description, picture, place, title, type) VALUES (61, 6, '2021-12-14 10:48:48', 'Volunteer to help the children in one of Tanzania’s most renowned communities, the Maasai. With their iconic brightly coloured wraps and their distinctive dances, interacting with the Maasai is as every bit as memorable as any landscape or big five encounter. Helping within the day care centre will see you busy assisting the teachers and playing with the children - where you will be sure to brighten up their lives.', 'https://cdn.pixabay.com/photo/2013/04/10/18/07/tanga-102575_1280.jpg', 'Africa', 'Tanzania Childcare Volunteers', 'ONG');
INSERT INTO finalProject.event (id, creator, date, description, picture, place, title, type) VALUES (62, 1, '2021-12-13 10:48:53', 'Volunteer to teach in Thailand and help assist in one of several government run under-resourced schools located in the poorer suburbs of Bangkok. You and other volunteers will play a vital role in creating exciting and engaging lessons to ensure all of the children learn something new and also lend a helping hand where needed.', 'https://cdn.pixabay.com/photo/2016/10/30/05/45/learning-1782430_1280.jpg', 'Africa', 'Volunteer to teach Thailad.', 'Animals');
INSERT INTO finalProject.event (id, creator, date, description, picture, place, title, type) VALUES (63, 2, '2021-12-16 10:49:00', 'Get hands on with this award winning marine conservation programme in the beautiful Plettenberg Bay. Located along the heart of the Garden Route and offering some amazing coastal scenery you will get to observe some amazing marine wildlife such as Bottlenose Dolphins, Great White Sharks.', 'https://cdn.pixabay.com/photo/2017/02/09/15/10/sea-2052650_1280.jpg', 'Africa', 'South Africa Marine Conservation', 'ONG');
INSERT INTO finalProject.event (id, creator, date, description, picture, place, title, type) VALUES (64, 1, '1907-07-13 00:00:00', 'Help kids in Madrid', 'https://www.todaysparent.com/wp-content/uploads/2018/09/ways-to-help-kids-with-autism-have-great-playdates-1280x960.jpg', 'Madrid', 'Help kids!', 'ONG');
INSERT INTO finalProject.event (id, creator, date, description, picture, place, title, type) VALUES (68, 5, '1907-07-13 00:00:00', 'Help kids in Madrid', 'https://www.todaysparent.com/wp-content/uploads/2018/09/ways-to-help-kids-with-autism-have-great-playdates-1280x960.jpg', 'Madrid', 'Help kids!', 'ONG');
INSERT INTO finalProject.event (id, creator, date, description, picture, place, title, type) VALUES (71, 5, '1907-07-13 00:00:00', 'Help kids in Madrid', 'https://www.todaysparent.com/wp-content/uploads/2018/09/ways-to-help-kids-with-autism-have-great-playdates-1280x960.jpg', 'Madrid', 'Help kids!', 'ONG');


insert into finalProject.course (id, creator_id, description, link, picture, title)
values  (1, 1, 'Create your own beauty products', 'https://www.youtube.com/embed/B0otvi4FD-g', 'https://images.pexels.com/photos/7262469/pexels-photo-7262469.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260', 'Create your own beauty products and avoid plastic'),
        (2, 1, 'recycle at home', 'https://www.youtube.com/embed/GlM_JHy9lUA', 'https://images.pexels.com/photos/7262360/pexels-photo-7262360.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260', 'How to recycle at home.'),
        (3, 2, 'Best ideas to avoid plastic.', 'https://www.youtube.com/embed/OagTXWfaXEo', 'https://images.pexels.com/photos/4033158/pexels-photo-4033158.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500', 'Best ideas to avoid consume plastic.'),
        (4, 3, 'Want to Eat Sustainably? ', 'https://www.youtube.com/embed/pzCLgB18w2Q', 'https://images.pexels.com/photos/219794/pexels-photo-219794.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260', 'Want to Eat Sustainably?');


insert into finalProject.user (id, email, is_admin, name, password, role)
values  (1, 'test@gmail.com', false, 'test', '$2a$10$5PiTmvKVwJFh65p6P8BWDutBdm5NN2jEQrXHGemvzQ59Cekj80TDC', ''),
        (2, 'test2@gmail.com', false, 'Lucas', '$2a$10$5PiTmvKVwJFh65p6P8BWDutBdm5NN2jEQrXHGemvzQ59Cekj80TDC', 'user'),
        (3, 'test3@gmail.com', false, 'Maria', '$2a$10$5PiTmvKVwJFh65p6P8BWDutBdm5NN2jEQrXHGemvzQ59Cekj80TDC', 'user'),
        (4, 'test4@gmail.com', false, 'Julia', '$2a$10$5PiTmvKVwJFh65p6P8BWDutBdm5NN2jEQrXHGemvzQ59Cekj80TDC', 'user'),
        (5, 'test5@gmail.com', false, 'Sofia', '$2a$10$5PiTmvKVwJFh65p6P8BWDutBdm5NN2jEQrXHGemvzQ59Cekj80TDC', 'user'),
        (6, 'test6@gmail.com', false, 'Marcos', '$2a$10$5PiTmvKVwJFh65p6P8BWDutBdm5NN2jEQrXHGemvzQ59Cekj80TDC', 'user'),
        (7, 'test7@gmail.com', false, 'Miguel', '$2a$10$5PiTmvKVwJFh65p6P8BWDutBdm5NN2jEQrXHGemvzQ59Cekj80TDC', 'user'),
        (8, 'test8@gmail.com', false, 'Juan', '$2a$10$5PiTmvKVwJFh65p6P8BWDutBdm5NN2jEQrXHGemvzQ59Cekj80TDC', 'user'),
        (35, 'irene@gmail.com', false, 'irene', '$2a$10$5PiTmvKVwJFh65p6P8BWDutBdm5NN2jEQrXHGemvzQ59Cekj80TDC', ''),
        (93, 'irene@test.com', false, 'irene', '$2a$10$l9FSlOGvk.1FpCoBm.0Q/entRlqWjJxF.X5nxhQsnzKukg9s6ciOC', 'User');

insert into finalProject.event_attendees (event_id, attendees)
values  (9, 2),
        (54, 2),
        (10, 2),
        (56, 3),
        (55, 1),
        (55, 3),
        (1, 3),
        (3, 3),
        (11, 2),
        (11, 3),
        (11, 4),
        (63, 4),
        (14, 2),
        (14, 5),
        (62, 3),
        (62, 4),
        (62, 5),
        (61, 4),
        (61, 5),
        (4, 1),
        (4, 2),
        (4, 3),
        (59, 4),
        (2, 1),
        (2, 2);

insert into finalProject.user_event_id (user_id, event_id)
values  (1, 1),
        (1, 2);



