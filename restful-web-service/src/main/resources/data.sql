create table user(id integer not null,birth_date timestamp,name varchar(255),primary key(id))

insert into user values(1, sysdate(),'AB')
insert into user values(2, sysdate(),'Jill')
insert into user values(3, sysdate(),'Jam')