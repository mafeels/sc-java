insert into usuario(codigo_usuario,username,data_nascimento,senha,e_mail)
	values ("112233","WillMasa","2001/04/09","meme1","will.masa");
select*
from usuario;
insert into flashcard(codigo_flashcard, codigo_usuario, nome_flashcard, frente_flashcard, verso_flashcard, autor_flashcard, categoria_flashcard, data_criacao, preco_flashcard)
	values ("666","112233","Biologia","mitocondria","respiração","WillMasa","biologia","2017-07-31","200");
select*
from flashcard;
insert into edita(data_edicao,codigo_flashcard,codigo_usuario)
	values ("2017-07-31","666","112233");
select*
from edita;
insert into compra(data_compra,codigo_flashcard,codigo_usuario)
	values ("2017-07-31","666","112233");
select*
from compra;

