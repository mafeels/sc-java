select*
from compra;

select * from flashcard order by nome_flashcard asc;
select * from flashcard order by autor_flashcard asc;
select * from flashcard order by categoria_flashcard asc;
select * from flashcard order by data_criacao asc;
select * from flashcard order by preco_flashcard asc;

select * from flashcard where categoria_flashcard like 'Biologia%';/*exemplo*/


/*
select frente_flashcard, verso_flashcard
from flashcard

update flashcard
set frente_flashcard = "cromossomo e cromatina", verso_flashcard = "cromatina = cimento, cromossomo = concreto"
where codigo_flashcard = 666
*/
