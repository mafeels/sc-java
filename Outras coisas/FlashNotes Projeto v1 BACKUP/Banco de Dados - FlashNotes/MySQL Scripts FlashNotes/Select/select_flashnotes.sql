select*
from compra;

select distinct * from flashcard order by nome_flashcard asc;
select * from flashcard order by autor_flashcard asc;
select * from flashcard order by categoria_flashcard asc;  /* todos esses serão uma pesquisa genérica, onde o usuário pode digitar as partes que estão pretas*/
select * from flashcard order by data_criacao asc;
select * from flashcard order by preco_flashcard asc;

select count(preco_flashcard) as maior_preco from flashcard;
select min(preco_flashcard) from flashcard; 
select max(preco_flashcard) from flashcard;
select sum(preco_flashcard) as sumatoria from flashcard;
select avg(preco_flashcard) from flashcard;

select * from flashcard where categoria_flashcard like 'Biologia%';/*exemplo*/


SELECT flashcard.codigo_usuario, usuario.codigo_usuario
FROM flashcard INNER JOIN usuario ON flashcard.codigo_usuario = usuario.codigo_usuario
ORDER BY flashcard.codigo_usuario; 

select frente_flashcard, verso_flashcard
from flashcard;

update flashcard
set frente_flashcard = "cromossomo e cromatina", verso_flashcard = "cromatina = cimento, cromossomo = concreto"
where codigo_flashcard = 666;

