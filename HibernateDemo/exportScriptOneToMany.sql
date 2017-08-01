drop table if exists CATEGORIA;
drop table if exists DIFICULDADE;
drop table if exists PALAVRA;
create table CATEGORIA (CATEGORIA_ID integer not null, CATEGORIA_DESCRICAO varchar(255), primary key (CATEGORIA_ID));
create table DIFICULDADE (DIFICULDADE_ID integer not null, DIFICULDADE_DESCRICAO varchar(255), primary key (DIFICULDADE_ID));
create table PALAVRA (PALAVRA_ID integer not null, PALAVRA_DESCRICAO varchar(255), DIFICULDADE_ID integer not null, primary key (PALAVRA_ID));
alter table PALAVRA add constraint FKcs5uh3pkr3592cli2tu6xx730 foreign key (DIFICULDADE_ID) references DIFICULDADE (DIFICULDADE_ID);
