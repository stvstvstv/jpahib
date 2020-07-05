-- noinspection SqlNoDataSourceInspectionForFile

INSERT INTO course(id, name, created_date, last_update) values(10001, 'jpa in 50 steps', sysdate(), sysdate())
INSERT INTO course(id, name, created_date, last_update) values(10002, 'GIGI', sysdate(), sysdate())
INSERT INTO course(id, name, created_date, last_update) values(10003, 'BIBI', sysdate(), sysdate())
INSERT INTO course(id, name, created_date, last_update) values(10004, 'sake', sysdate(), sysdate())

insert into passport(id, number) values(40001,'A123')
insert into passport(id, number) values(40002,'b344')
insert into passport(id, number) values(40003,'c54545')

insert into student(id, name, passport_id) values(20001,'Ranga', 40001)
insert into student(id, name, passport_id) values(20002,'Adam', 40002)
insert into student(id, name, passport_id) values(20003,'Jane', 40003)

insert into review(id, description, rating, course_id, student_id) values(50002,'jmek','**', 10001, 20001)
insert into review(id, description, rating, course_id, student_id) values(50001,'da bravo','***', 10001, 20002)
insert into review(id, description, rating, course_id, student_id) values(50003,'plm','**', 10003, 20001)

insert into student_course(student_id, course_id) values (20001, 10001)
insert into student_course(student_id, course_id) values (20002, 10001)
insert into student_course(student_id, course_id) values (20003, 10001)
insert into student_course(student_id, course_id) values (20001, 10003)