insert into "grade" (id, value, subject_id, student_id)
values ('ab65a228-311f-42a4-8e79-31c98860c68b', 12,
        (select id from subject where name = 'Biology'),
        (select id from student where surname = 'Lachenkov'));
insert into "grade" (id, value, subject_id, student_id)
values ('ac12d5ea-2dbe-449d-abe9-3b806a37b8b7', 9,
        (select id from subject where name = 'Biology'),
        (select id from student where surname = 'Savchenko'));
insert into "grade" (id, value, subject_id, student_id)
values ('4d8d1cae-8940-431d-816f-003eb5f79944', 7,
        (select id from subject where name = 'Biology'),
        (select id from student where surname = 'Bondarenko'));
insert into "grade" (id, value, subject_id, student_id)
values ('6fc7975d-0ad6-4741-bc06-25ca66e12069', 5,
        (select id from subject where name = 'Biology'),
        (select id from student where surname = 'Dmitrenko'));
insert into "grade" (id, value, subject_id, student_id)
values ('88c95d9f-a241-4016-907e-7b8366afc53c', 9,
        (select id from subject where name = 'Biology'),
        (select id from student where surname = 'Screbtsov'));
insert into "grade" (id, value, subject_id, student_id)
values ('0da811aa-16f1-453a-b8ee-e8437f1d86ea', 10,
        (select id from subject where name = 'Biology'),
        (select id from student where surname = 'Stepanenko'));

insert into "grade" (id, value, subject_id, student_id)
values ('edc8b285-63ca-42f8-9e0f-92ff3f94ebb0', 4,
        (select id from subject where name = 'Mathematics'),
        (select id from student where surname = 'Lachenkov'));
insert into "grade" (id, value, subject_id, student_id)
values ('26e5f450-02f0-431f-ba68-c33e2651b95f', 5,
        (select id from subject where name = 'Mathematics'),
        (select id from student where surname = 'Savchenko'));
insert into "grade" (id, value, subject_id, student_id)
values ('f6e10fdd-9f7d-422f-bee0-0a72fcc9459a', 6,
        (select id from subject where name = 'Mathematics'),
        (select id from student where surname = 'Bondarenko'));
insert into "grade" (id, value, subject_id, student_id)
values ('ac1422c2-0f1d-4f6d-b03d-f497d64b2e79', 5,
        (select id from subject where name = 'Mathematics'),
        (select id from student where surname = 'Dmitrenko'));
insert into "grade" (id, value, subject_id, student_id)
values ('bf02ad65-ef11-4a63-b3d1-370ce386ae4f', 7,
        (select id from subject where name = 'Mathematics'),
        (select id from student where surname = 'Screbtsov'));
insert into "grade" (id, value, subject_id, student_id)
values ('e5daa2e3-f419-40df-b4e7-2a8bba4f8149', 10,
        (select id from subject where name = 'Mathematics'),
        (select id from student where surname = 'Stepanenko'));

insert into "grade" (id, value, subject_id, student_id)
values ('e5d2e080-2d88-4796-bdfa-537da412547f', 10,
        (select id from subject where name = 'English'),
        (select id from student where surname = 'Lachenkov'));
insert into "grade" (id, value, subject_id, student_id)
values ('37a13a35-bd7e-402e-a2fb-126ee4c6919a', 10,
        (select id from subject where name = 'English'),
        (select id from student where surname = 'Savchenko'));
insert into "grade" (id, value, subject_id, student_id)
values ('1fd725c9-7554-42e7-bfe3-4e37cdc24fa6', 11,
        (select id from subject where name = 'English'),
        (select id from student where surname = 'Bondarenko'));
insert into "grade" (id, value, subject_id, student_id)
values ('e5b6b34a-3c10-4daf-8f74-9517300c400f', 12,
        (select id from subject where name = 'English'),
        (select id from student where surname = 'Dmitrenko'));
insert into "grade" (id, value, subject_id, student_id)
values ('3c5b3a1c-fd9b-4001-b6a1-8253575ac3c5', 8,
        (select id from subject where name = 'English'),
        (select id from student where surname = 'Screbtsov'));
insert into "grade" (id, value, subject_id, student_id)
values ('e3b8a511-50bf-423a-8e8c-234f7337985e', 9,
        (select id from subject where name = 'English'),
        (select id from student where surname = 'Stepanenko'))
