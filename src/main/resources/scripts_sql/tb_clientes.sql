-- operações com a tabela tb_cliente

USE `projeto-eng-software`;

INSERT INTO tb_clientes (cpf, email, name, password)
	VALUES
    ('12345678901', 'cliente1@email.com', 'Cliente 1', 'senha123'),
    ('12345678902', 'cliente2@email.com', 'Cliente 2', 'senha123');

SELECT * FROM tb_clientes;

SELECT name, email
FROM tb_clientes
WHERE id_cliente = 1;

UPDATE tb_clientes SET email = 'novocliente@email.com' WHERE id_cliente = 1;

UPDATE tb_clientes
SET
	cpf = '',
    email = '',
    name = '',
    password = ''
WHERE id_cliente = 1;

DELETE FROM tb_clientes WHERE id_cliente = 2;

-- Obter Todos os Veículos de um Cliente pelo CPF

SELECT v.id_veiculo, v.ano, v.modelo, v.placa
FROM tb_veiculos v
INNER JOIN tb_clientes c ON v.cliente_id = c.id_cliente
WHERE c.cpf = '12345678901';

-- Obter o ID e a Descrição de Todas as Ocorrências de um Cliente pelo CPF

SELECT o.ocorrencia_id, o.description
FROM tb_ocorrencias o
INNER JOIN tb_clientes c ON o.cliente_id = c.id_cliente
WHERE c.cpf = '12345678901';