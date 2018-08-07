create database flashnotes;
show databases;
use flashnotes;
show tables;
create table usuario (
	codigo_usuario int not null,
    username varchar(20) not null,
    data_nascimento date not null,
    senha varchar(12) not null,
    e_mail varchar(50) not null,
    primary key(codigo_usuario)) engine=innodb;

create table flashcard (
	codigo_flashcard int not null,
    codigo_usuario int not null,
    nome_flashcard varchar(30) not null,
    frente_flashcard mediumtext not null,
    verso_flashcard mediumtext not null,
    autor_flashcard varchar(20) not null,
    categoria_flashcard varchar(25) not null,
    data_criacao datetime not null,
    preco_flashcard int not null,
    primary key (codigo_flashcard),
    constraint fk_codigo_usuario foreign key(codigo_usuario)
    references usuario (codigo_usuario)) engine=innodb;
    

create table edita (
	data_edicao datetime,
    codigo_flashcard int not null,
    codigo_usuario int not null,
    constraint fk_codigo_flashcard_edita foreign key(codigo_flashcard)
    references flashcard (codigo_flashcard),
    constraint fk_codigo_usuario_edita foreign key(codigo_usuario)
    references flashcard (codigo_usuario)) engine=innodb;
    

create table compra (
	data_compra datetime,
    codigo_flashcard int not null,
    codigo_usuario int not null,
    constraint fk_codigo_flashcard_compra foreign key(codigo_flashcard)
    references flashcard (codigo_flashcard),
    constraint fk_codigo_usuario_compra foreign key(codigo_usuario)
    references flashcard (codigo_usuario)) engine=innodb;

	
    

    
	
	