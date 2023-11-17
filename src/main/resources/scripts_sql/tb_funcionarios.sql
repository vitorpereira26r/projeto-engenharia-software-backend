-- operações com a tabela tb_funcionarios

USE `projeto-eng-software`;

INSERT INTO tb_funcionarios (cpf, email, name, password, is_admin)
	VALUES
    ('98765432101', 'admin1@email.com', 'Admin', 'admin123', true),
    ('98765432102', 'funcionario2@email.com', 'Funcionario', 'password', false);
    
SELECT * FROM tb_funcionarios;

SELECT name, email
FROM tb_funcionarios
WHERE id_funcionario = 1;

UPDATE tb_funcionarios SET email = 'novocliente@email.com' WHERE id_cliente = 1;

UPDATE tb_funcionarios
SET
	cpf = '',
    email = '',
    name = '',
    password = '',
    is_admin = false
WHERE id_funcionario = 1;

DELETE FROM tb_funcionarios WHERE id_funcionario = 1;
