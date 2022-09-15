insert into teacher (id, age, name, surname, subject_id)
VALUES ('277774de-6fe5-44bf-8e0d-2342d2b79549', 33, 'Gennadiy', 'Kitchenko',
        (select id from Subject where name = 'Mathematics'));
insert into teacher (id, age, name, surname, subject_id)
VALUES ('86dae00b-fafe-4bb2-8943-d17c82d3b8c1', 24, 'Zoya', 'Kuidina',
        (select id from Subject where name = 'Biology'));
insert into teacher (id, age, name, surname, subject_id)
VALUES ('a2514e67-ceaa-4084-9d70-ef407498f3bf', 48, 'Ruslana', 'Peresada',
        (select id from subject where name = 'English'))