-- operações com a tabela tb_veiculos

USE `projeto-eng-software`;

INSERT INTO tb_veiculos (ano, modelo, placa, client_id)
	VALUES
    (2022, 'Modelo A', 'ABC1234', 1),
    (2022, 'Modelo A', 'ABC1234', 1);

SELECT * FROM tb_veiculos;

SELECT ano, placa
FROM tb_veiculos
WHERE id_veiculo = 1;

UPDATE tb_veiculos SET placa = 'XYZ5678' WHERE id_veiculo = 1;

UPDATE tb_veiculos
SET
	ano = 2020,
    modelo = '',
    placa = ''
WHERE id_veiculo = 1;

DELETE FROM tb_veiculos WHERE id_veiculo = 1;

-- JOIN para Obter Informações do Cliente Associado a um Veículo

SELECT v.id_veiculo, v.ano, v.modelo, v.placa, c.name AS cliente_name
FROM tb_veiculos v
INNER JOIN tb_clientes c ON v.cliente_id = c.id_cliente
WHERE v.id_veiculo = 1;

-- JOIN para Obter o ID e a Descrição de Todas as Ocorrências de um Veículo pela Placa

SELECT o.ocorrencia_id, o.description
FROM tb_ocorrencias o
INNER JOIN tb_veiculos v ON o.veiculo_id = v.id_veiculo
WHERE v.placa = 'ABC1235';