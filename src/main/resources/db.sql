begin transaction;

drop schema if exists cap cascade;

create schema cap;

create table cap.todo (
	id int8 generated always as identity not null,
	task varchar(255) NOT null,
	completed boolean not null
);

alter table cap.todo alter column completed set default false;

commit;

rollback;