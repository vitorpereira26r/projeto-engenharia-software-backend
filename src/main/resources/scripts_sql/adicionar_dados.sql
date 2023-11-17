-- povoar o banco de dados

USE `projeto-eng-software`;

INSERT INTO tb_funcionarios (cpf, email, name, password, is_admin)
VALUES
('98765432101', 'joao.silva@email.com', 'Joao Silva', 'admin123', true),
('98765432102', 'maira.rezende@email.com', 'Maira Rezende', 'password', false),
('98765432103', 'carlos.rodrigues@email.com', 'Carlos Rodrigues', 'senha123', false),
('98765432104', 'ana.santos@email.com', 'Ana Santos', 'admin456', true),
('98765432105', 'rafael.gomes@email.com', 'Rafael Gomes', '123senha', false),
('98765432106', 'lucia.martins@email.com', 'Lucia Martins', 'senha789', false),
('98765432107', 'pedro.silveira@email.com', 'Pedro Silveira', 'admin789', true),
('98765432108', 'marina.almeida@email.com', 'Marina Almeida', 'senha321', false),
('98765432109', 'leonardo.ferreira@email.com', 'Leonardo Ferreira', 'admin987', true),
('98765432110', 'clara.lopes@email.com', 'Clara Lopes', 'senha654', false),
('98765432111', 'ricardo.oliveira@email.com', 'Ricardo Oliveira', 'admin555', true),
('98765432112', 'juliana.rocha@email.com', 'Juliana Rocha', 'senha444', false),
('98765432113', 'marcos.souza@email.com', 'Marcos Souza', 'admin333', true),
('98765432114', 'alice.campos@email.com', 'Alice Campos', 'senha222', false),
('98765432115', 'felipe.costa@email.com', 'Felipe Costa', 'admin111', true),
('98765432116', 'isabela.nunes@email.com', 'Isabela Nunes', 'senha999', false),
('98765432117', 'renato.mendes@email.com', 'Renato Mendes', 'admin000', true),
('98765432118', 'vanessa.pereira@email.com', 'Vanessa Pereira', 'senha888', false),
('98765432119', 'thiago.silva@email.com', 'Thiago Silva', 'admin777', true),
('98765432120', 'sandra.ferreira@email.com', 'Sandra Ferreira', 'senha666', false),
('98765432121', 'roberto.santana@email.com', 'Roberto Santana', 'admin999', true),
('98765432122', 'carolina.freitas@email.com', 'Carolina Freitas', 'senha444', false);
    
INSERT INTO tb_clientes (cpf, email, name, password)
VALUES
('12345678900', 'maria.figueredo@email.com', 'Maria Figueiredo', 'senha123'),
('12345678901', 'vinicius.junior@email.com', 'Vinicius Junior', 'senha123'),
('12345678902', 'julia.motta@email.com', 'Julia Motta', 'senha123'),
('12345678903', 'ana.silva@email.com', 'Ana Silva', 'senha456'),
('12345678904', 'felipe.almeida@email.com', 'Felipe Almeida', 'senha789'),
('12345678905', 'raquel.pereira@email.com', 'Raquel Pereira', 'senha987'),
('12345678906', 'rodrigo.martins@email.com', 'Rodrigo Martins', 'senha654'),
('12345678907', 'carla.nunes@email.com', 'Carla Nunes', 'senha321'),
('12345678908', 'gabriel.oliveira@email.com', 'Gabriel Oliveira', 'senha000'),
('12345678909', 'luciana.souza@email.com', 'Luciana Souza', 'senha111'),
('12345678910', 'bruno.campos@email.com', 'Bruno Campos', 'senha222'),
('12345678911', 'patricia.ferreira@email.com', 'Patricia Ferreira', 'senha333'),
('12345678912', 'thiago.santos@email.com', 'Thiago Santos', 'senha444'),
('12345678913', 'vanessa.mendes@email.com', 'Vanessa Mendes', 'senha555'),
('12345678914', 'pedro.camargo@email.com', 'Pedro Camargo', 'senha666'),
('12345678915', 'camila.pereira@email.com', 'Camila Pereira', 'senha777'),
('12345678916', 'roberto.souza@email.com', 'Roberto Souza', 'senha888'),
('12345678917', 'larissa.novaes@email.com', 'Larissa Novaes', 'senha999'),
('12345678918', 'marcos.martins@email.com', 'Marcos Martins', 'senha111'),
('12345678919', 'isabela.alves@email.com', 'Isabela Alves', 'senha222'),
('12345678920', 'alexandre.ferreira@email.com', 'Alexandre Ferreira', 'senha333'),
('12345678921', 'sabrina.santos@email.com', 'Sabrina Santos', 'senha444'),
('12345678922', 'andre.fernandes@email.com', 'Andre Fernandes', 'senha555');

INSERT INTO tb_veiculos (ano, modelo, placa, cliente_id)
VALUES
(2022, 'Chevrolet Onix', 'ABC1235', 1),
(2022, 'Fiat Argo', 'ABC1236', 1),
(2022, 'Hyundai HB20', 'ABC1237', 1),
(2022, 'Volkswagen Gol', 'ABC1238', 2),
(2022, 'Fiat Mobi', 'ABC1239', 2),
(2022, 'Kia Picanto', 'ABC1240', 3),
(2022, 'Renault Kwid', 'ABC1241', 3),
(2022, 'Toyota Corolla', 'ABC1242', 3),
(2022, 'Honda Civic', 'ABC1243', 3),
(2015, 'Fiat Uno', 'ABC1244', 4),
(2010, 'Fiat Palio', 'ABC1245', 4),
(2021, 'Chevrolet Cruze', 'ABC1246', 4),
(2020, 'Volkswagen Jetta', 'ABC1247', 5),
(2019, 'Nissan Sentra', 'ABC1248', 6),
(2018, 'Hyundai Elantra', 'ABC1249', 6),
(2017, 'Ford Focus', 'ABC1250', 7),
(2016, 'Citroën C4 Cactus', 'ABC1251', 7),
(2015, 'Peugeot 208', 'ABC1252', 8),
(2022, 'Volkswagen T-Cross', 'ABC1253', 9),
(2021, 'Honda HR-V', 'ABC1254', 10),
(2020, 'Nissan Kicks', 'ABC1255', 10),
(2019, 'Hyundai Creta', 'ABC1256', 11),
(2018, 'Toyota Corolla Cross', 'ABC1257', 11),
(2017, 'Jeep Compass', 'ABC1258', 11),
(2016, 'Chevrolet Tracker', 'ABC1259', 11),
(2015, 'Ford EcoSport', 'ABC1260', 11),
(2022, 'Volkswagen Nivus', 'ABC1261', 11),
(2021, 'Peugeot 2008', 'ABC1262', 12),
(2020, 'Citroën C4 Cactus SUV', 'ABC1263', 13),
(2019, 'Renault Captur', 'ABC1264', 13),
(2018, 'Jeep Renegade', 'ABC1265', 14),
(2017, 'Fiat Toro', 'ABC1266', 15),
(2016, 'Toyota Hilux', 'ABC1267', 15),
(2015, 'Chevrolet S10', 'ABC1268', 16),
(2021, 'Ford Fiesta', 'ABC1270', 17),
(2020, 'Chevrolet Malibu', 'ABC1271', 18),
(2019, 'Volkswagen Passat', 'ABC1272', 19),
(2018, 'Honda Fit', 'ABC1273', 19),
(2017, 'Toyota Prius', 'ABC1274', 19),
(2016, 'Hyundai Sonata', 'ABC1275', 19),
(2015, 'Nissan Altima', 'ABC1276', 20),
(2014, 'Mazda 6', 'ABC1277', 20),
(2013, 'Subaru Legacy', 'ABC1278', 20),
(2012, 'Kia Optima', 'ABC1279', 21),
(2011, 'Audi A3', 'ABC1280', 21),
(2010, 'BMW 5 Series', 'ABC1281', 22),
(2009, 'Mercedes-Benz E-Class', 'ABC1282', 23),
(2008, 'Lexus IS', 'ABC1283', 23),
(2007, 'Ford Fusion', 'ABC1284', 23);

INSERT INTO tb_ocorrencias (data, description, cliente_id, veiculo_id)
VALUES
('2023-11-17 13:05:57', 'Colisão leve na parte traseira do veículo durante o trânsito.', 4, 10),
('2023-11-17 13:05:57', 'Arranhão na lateral direita ao estacionar em uma vaga apertada.', 4, 10),
('2023-11-17 13:05:57', 'Vidro quebrado devido a vandalismo durante a noite.', 1, 1),
('2023-11-17 13:05:57', 'Problemas mecânicos após uma longa viagem.', 1, 2),
('2023-11-17 13:05:57', 'Roubo de pertences dentro do veículo estacionado.', 2, 5),
('2023-11-17 13:05:57', 'Acidente grave com danos significativos na parte frontal.', 8, 18),
('2023-11-17 13:05:57', 'Pane elétrica que causou a paralisação do veículo.', 10, 20),
('2023-11-17 13:05:57', 'Batida lateral ao atravessar um cruzamento.', 10, 21),
('2023-11-17 13:05:57', 'Incidente durante uma tempestade que resultou em danos diversos.', 11, 22),
('2023-11-17 13:05:57', 'Colisão com um animal na pista durante a noite.', 11, 23),
('2023-11-17 13:05:57', 'Avaria na suspensão após passar por um buraco na estrada.', 6, 15),
('2023-11-17 13:05:57', 'Arranhão na pintura causado por um incidente de estacionamento.', 7, 17),
('2023-11-17 13:05:57', 'Problema no sistema de freios durante uma descida íngreme.', 12, 32),
('2023-11-17 13:05:57', 'Perda total do veículo devido a um acidente de alta velocidade.', 13, 33),
('2023-11-17 13:05:57', 'Roubo do veículo em um estacionamento público.', 14, 35),
('2023-11-17 13:05:57', 'Pane elétrica que causou a paralisação do veículo.', 14, 36),
('2023-11-17 13:05:57', 'Batida lateral ao trocar de faixa na rodovia.', 15, 39),
('2023-11-17 13:05:57', 'Colisão traseira durante uma parada no semáforo.', 19, 43),
('2023-11-17 13:05:57', 'Incêndio no veículo devido a um problema no sistema elétrico.', 20, 47),
('2023-11-17 13:05:57', 'Acidente leve ao colidir com um poste na rua.', 17, 41);
