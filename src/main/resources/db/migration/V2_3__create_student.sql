insert into "student" (id, age, name, surname, startdate, group_id)
values ('8bc3bd6b-8a9c-4e3f-867e-0b63752b6703', '16', 'Petro', 'Lachenkov', '2022-09-14',
        (select id from groupstudents where name = 'TRRT-16-1'));
insert into "student" (id, age, name, surname, startdate, group_id)
values ('9cffeed0-a6ef-41ce-aaf3-bdb2c9c4ff39', '17', 'Igor', 'Savchenko', '2022-09-13',
        (select id from groupstudents where name = 'TRRT-16-1'));
insert into "student" (id, age, name, surname, startdate, group_id)
values ('b0e103ab-3d92-4584-92fb-70b469fc19dc', '18', 'Vitaliy', 'Bondarenko', '2022-09-11',
        (select id from groupstudents where name = 'RTICS-20-2'));
insert into "student" (id, age, name, surname, startdate, group_id)
values ('39a84ae2-2ca9-4749-bb83-9e1533947059', '20', 'Vadim', 'Dmitrenko', '2022-09-19',
        (select id from groupstudents where name = 'RTICS-20-2'));
insert into "student" (id, age, name, surname, startdate, group_id)
values ('a9cfb8e6-8778-4018-89c7-6907bfbce2d2', '19', 'Ruslan', 'Screbtsov', '2022-09-15',
        (select id from groupstudents where name = 'RTICS-20-2'));
insert into "student" (id, age, name, surname, startdate, group_id)
values ('a2a75023-5308-4712-91d5-c886b11979c4', '22', 'Oleh', 'Stepanenko', '2022-09-14',
        (select id from groupstudents WHERE name = 'RTICS-20-1'))