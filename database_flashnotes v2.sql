create database flashnotes;
show databases;
use flashnotes;
show tables;
create table usuario (
    codigo_usuario bigint not null auto_increment,
    username varchar(20) not null,
    data_nascimento varchar(10) null,
    senha varchar(12) not null,
    e_mail varchar(50) not null,
    primeiro_nome varchar(20) null,
    ultimo_nome varchar(20) null,
    imagem_perfil LONGBLOB null,
    primary key(codigo_usuario)) engine=innodb;

create table flashcard (
    codigo_flashcard bigint not null auto_increment,
    codigo_usuario bigint not null,
    nome_flashcard varchar(30) not null,
    frente_flashcard mediumtext not null,
    verso_flashcard mediumtext not null,
    autor_flashcard varchar(20) not null,
    categoria_flashcard varchar(25) not null,
    data_criacao varchar(10) not null,
    imagem_flashcard LONGBLOB null,
    primary key (codigo_flashcard),
    constraint fk_codigo_usuario foreign key(codigo_usuario)
    references usuario (codigo_usuario)
    on delete restrict
    on update restrict
    ) engine=innodb;
    

create table edita (
    data_edicao datetime,
    codigo_flashcard bigint not null,
    codigo_usuario bigint not null,
    constraint fk_codigo_flashcard_edita foreign key(codigo_flashcard)
    references flashcard (codigo_flashcard),
    constraint fk_codigo_usuario_edita foreign key(codigo_usuario)
    references flashcard (codigo_usuario)) engine=innodb;

select *
from usuario;
select *
from flashcard;


insert into usuario(username,data_nascimento,senha,e_mail,primeiro_nome,ultimo_nome)
	values ("WillMasa2","2001/04/08","meme1","will.masa","William","Yoshida");

insert into flashcard(codigo_usuario, nome_flashcard, frente_flashcard, verso_flashcard, autor_flashcard, categoria_flashcard, data_criacao)
	values (1,"Biologia","mitocondria","respiração","WillMasa","biologia","2017-07-31");
