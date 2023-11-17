-- operações com a tabela tb_ocorrencias

USE `projeto-eng-software`;

INSERT INTO tb_ocorrencias (data, description, cliente_id, veiculo_id)
	VALUES
    (TO_TIMESTAMP('2023-11-17T13:05:57Z', 'YYYY-MM-DDTHH24:MI:SSOF'), 'Descrição da ocorrência', 1, 1),
    (TO_TIMESTAMP('2023-11-17T13:05:57Z', 'YYYY-MM-DDTHH24:MI:SSOF'), 'Descrição da ocorrência', 1, 1);

SELECT * FROM tb_ocorrencias;

SELECT cliente_id, veiculo_id, description
FROM tb_ocorrencias
WHERE ocorrencia_id = 1;

UPDATE tb_ocorrencias SET description = '' WHERE ocorrencia_id = 1;

UPDATE tb_ocorrencias
SET
	description = '',
    cliente_id = 1,
    veiculo_id = 1
WHERE ocorrencia_id = 1;

DELETE FROM tb_ocorrencias WHERE ocorrencia_id = 1;

-- INNER JOIN para obter informações detalhadas sobre o cliente e veículo associados a cada ocorrência

SELECT o.ocorrencia_id, o.data, o.description,
       c.name AS cliente_name, v.modelo AS veiculo_modelo
FROM tb_ocorrencias o
INNER JOIN tb_clientes c ON o.cliente_id = c.id_cliente
INNER JOIN tb_veiculos v ON o.veiculo_id = v.id_veiculo;

-- JOIN para Obter Informações do Cliente de uma Ocorrência

SELECT o.ocorrencia_id, o.data, o.description,
       c.name AS cliente_name, c.cpf AS cliente_cpf, c.email AS cliente_email
FROM tb_ocorrencias o
INNER JOIN tb_clientes c ON o.cliente_id = c.id_cliente
WHERE o.ocorrencia_id = 1;

-- JOIN para Obter Informações do Veículo de uma Ocorrência

SELECT o.ocorrencia_id, o.data, o.description,
       v.modelo AS veiculo_modelo, v.placa AS veiculo_placa, v.ano AS veiculo_ano
FROM tb_ocorrencias o
INNER JOIN tb_veiculos v ON o.veiculo_id = v.id_veiculo
WHERE o.ocorrencia_id = 1;