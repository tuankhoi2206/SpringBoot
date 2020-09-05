CREATE TABLE IF NOT EXISTS USER(id integer not null,birth_date timestamp,name varchar(255),primary key(id))
insert into user values(1, sysdate(),'AB')
insert into user values(2, sysdate(),'Jill')
insert into user values(3, sysdate(),'Jam')
insert into user values(4, sysdate(),'WilliamVu')

insert into post values(1, 'My First Post',4)
insert into post values(2, 'My Second Post',4)