SELECT flashcard.codigo_usuario, usuario.codigo_usuario
FROM flashcard INNER JOIN usuario ON flashcard.codigo_usuario = usuario.codigo_usuario
ORDER BY flashcard.codigo_usuario; 