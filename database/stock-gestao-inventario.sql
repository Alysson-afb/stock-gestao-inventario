CREATE DATABASE stockDB;
USE stockDB;

CREATE TABLE espaco (
	pk_cod_espaco INT(3) PRIMARY KEY,
    nome VARCHAR(50) NOT NULL,
    descricao VARCHAR(50) NOT NULL,
    numero INT(4)
);

CREATE TABLE bem (
	pk_cod_bem INT(4) PRIMARY KEY,
    categoria VARCHAR(50) NOT NULL,
    nome VARCHAR(50) NOT NULL,
    descricao VARCHAR(50) NOT NULL,
    valor DECIMAL(10,2) NOT NULL,
    data_aquisicao DATE NOT NULL,
    estado_conservacao INT(2) NOT NULL,
    fk_cod_espaco INT(4)
);

ALTER TABLE bem
ADD CONSTRAINT fk_bem_espaco
FOREIGN KEY (fk_cod_espaco) REFERENCES espaco(pk_cod_espaco)

ON DELETE CASCADE
ON UPDATE CASCADE;

-- Inserindo 15 Salas de Aula (Espaços)
INSERT INTO espaco (pk_cod_espaco, nome, descricao, numero) VALUES
(101, 'Sala de Aula A1', 'Bloco 1', 101),
(102, 'Sala de Aula B2', 'Bloco 2', 102),
(103, 'Sala de Aula C3', 'Bloco 3', 103),
(104, 'Sala de Aula D4', 'Bloco 4', 104),
(105, 'Sala de Aula E5', 'Bloco 5', 105),
(106, 'Sala de Aula F6', 'Bloco 6', 106),
(107, 'Sala de Aula G7', 'Bloco 7', 107),
(108, 'Sala de Aula H8', 'Bloco 8', 108),
(109, 'Sala de Aula I9', 'Bloco 9', 109),
(110, 'Sala de Aula J10', 'Bloco 10', 110);

-- Sala de Aula 101
INSERT INTO bem (pk_cod_bem, categoria, nome, descricao, valor, data_aquisicao, estado_conservacao, fk_cod_espaco) VALUES
(1, 'Eletrônico', 'Monitor Dell 24"', 'Monitor LED Full HD', 850.00, '2023-01-15', 1, 101),
(2, 'Eletrônico', 'Computador Desktop', 'CPU Intel i5, 8GB RAM', 2500.00, '2023-01-15', 1, 101),
(3, 'Mobiliário', 'Mesa de Escritório', 'Mesa de madeira, 120x60cm', 350.00, '2023-01-15', 1, 101),
(4, 'Mobiliário', 'Cadeira Ergonômica', 'Cadeira com ajuste de altura e encosto', 480.00, '2023-01-15', 1, 101),
(5, 'Mobiliário', 'Mesa Redonda', 'Mesa de reuniões, diâmetro 120cm', 700.00, '2023-03-15', 2, 101),
(6, 'Eletrônico', 'Projetor Epson', 'Projetor multimídia', 1200.00, '2022-03-20', 1, 101),
(7, 'Eletrônico', 'Teclado USB', 'Teclado padrão ABNT2', 80.00, '2023-01-15', 1, 101),
(8, 'Eletrônico', 'Mouse Óptico', 'Mouse USB padrão', 45.00, '2023-01-15', 2, 101),
(9, 'Mobiliário', 'Poltrona de Espera', 'Poltrona estofada', 250.00, '2023-02-20', 1, 101),
(10, 'Eletrônico', 'Telefone IP', 'Telefone VoIP', 300.00, '2023-06-01', 2, 101);

-- Sala de Aula 102
INSERT INTO bem (pk_cod_bem, categoria, nome, descricao, valor, data_aquisicao, estado_conservacao, fk_cod_espaco) VALUES
(11, 'Mobiliário', 'Estante para Livros', 'Estante de madeira, 5 prateleiras', 400.00, '2022-08-01', 2, 102),
(12, 'Eletrônico', 'Computador All-in-One', 'Computador com tela integrada', 3200.00, '2023-03-05', 1, 102),
(13, 'Eletrônico', 'Servidor Dell', 'Servidor de dados', 8000.00, '2021-11-01', 2, 102),
(14, 'Eletrônico', 'Monitor Samsung 27"', 'Monitor LED QHD', 1200.00, '2023-03-10', 1, 102),
(15, 'Mobiliário', 'Carrinho de Limpeza', 'Carrinho para materiais de limpeza', 120.00, '2022-10-10', 1, 102),
(16, 'Eletrônico', 'Tela Interativa', 'Quadro branco digital', 7500.00, '2023-04-10', 1, 102),
(17, 'Eletrônico', 'Webcam Logitech', 'Webcam Full HD', 150.00, '2023-05-01', 1, 102),
(18, 'Mobiliário', 'Cadeira Fixa', 'Cadeira de plástico, sem braço', 90.00, '2023-01-15', 2, 102),
(19, 'Eletrônico', 'Scanner de Documentos', 'Scanner de alta velocidade', 700.00, '2022-11-20', 1, 102),
(20, 'Mobiliário', 'Sofá de Espera', 'Sofá de 3 lugares', 1200.00, '2023-04-20', 1, 102);

-- Sala de Aula 103
INSERT INTO bem (pk_cod_bem, categoria, nome, descricao, valor, data_aquisicao, estado_conservacao, fk_cod_espaco) VALUES
(21, 'Mobiliário', 'Banqueta Alta', 'Banqueta para balcão', 120.00, '2023-03-01', 2, 103),
(22, 'Eletrônico', 'Smart TV 50"', 'TV com acesso à internet', 2800.00, '2023-07-20', 1, 103),
(23, 'Mobiliário', 'Gaveteiro com Rodas', 'Gaveteiro com 3 gavetas', 200.00, '2022-09-15', 2, 103),
(24, 'Eletrônico', 'Nobreak', 'Fonte de alimentação ininterrupta', 600.00, '2023-02-25', 1, 103),
(25, 'Mobiliário', 'Aparador', 'Móvel de apoio em madeira', 450.00, '2023-05-12', 1, 103),
(26, 'Eletrônico', 'Caixa de Som Bluetooth', 'Caixa de som portátil', 250.00, '2023-10-05', 1, 103),
(27, 'Mobiliário', 'Prateleira de Parede', 'Prateleira suspensa', 80.00, '2023-01-30', 2, 103),
(28, 'Eletrônico', 'Tablet Samsung', 'Tablet com tela de 10 polegadas', 1500.00, '2023-06-18', 1, 103),
(29, 'Mobiliário', 'Puff Quadrado', 'Puff estofado', 100.00, '2023-04-05', 2, 103),
(30, 'Eletrônico', 'Leitor de Código de Barras', 'Leitor USB', 180.00, '2022-12-10', 1, 103);

-- Sala de Aula 104
INSERT INTO bem (pk_cod_bem, categoria, nome, descricao, valor, data_aquisicao, estado_conservacao, fk_cod_espaco) VALUES
(31, 'Eletrônico', 'Monitor Ultrawide', 'Monitor de 34 polegadas', 2500.00, '2023-11-01', 1, 104),
(32, 'Mobiliário', 'Cadeira Gamer', 'Cadeira ergonômica para jogos', 1200.00, '2023-10-15', 1, 104),
(33, 'Eletrônico', 'Impressora 3D', 'Impressora de prototipagem rápida', 3500.00, '2023-09-20', 1, 104),
(34, 'Mobiliário', 'Mesa de Desenho', 'Mesa inclinável para desenho técnico', 800.00, '2022-07-10', 2, 104),
(35, 'Eletrônico', 'Dock Station', 'Estação de acoplamento para notebooks', 400.00, '2023-05-25', 1, 104),
(36, 'Mobiliário', 'Armário com Portas de Vidro', 'Armário para exposição', 900.00, '2023-04-18', 2, 104),
(37, 'Eletrônico', 'Microfone de Lapela', 'Microfone sem fio', 150.00, '2023-08-30', 1, 104),
(38, 'Mobiliário', 'Bancada de Trabalho', 'Bancada robusta para laboratório', 1100.00, '2022-06-05', 2, 104),
(39, 'Eletrônico', 'HD Externo', 'Disco rígido de 2TB', 300.00, '2023-03-12', 1, 104),
(40, 'Mobiliário', 'Cesto de Lixo Seletivo', 'Conjunto de cestos para reciclagem', 180.00, '2023-02-15', 1, 104);

-- Sala de Aula 105
INSERT INTO bem (pk_cod_bem, categoria, nome, descricao, valor, data_aquisicao, estado_conservacao, fk_cod_espaco) VALUES
(41, 'Eletrônico', 'Monitor Curvo', 'Monitor de 27 polegadas', 1800.00, '2023-12-05', 1, 105),
(42, 'Mobiliário', 'Mesa de Reunião Oval', 'Mesa para 8 pessoas', 1500.00, '2023-11-10', 1, 105),
(43, 'Eletrônico', 'Projetor 4K', 'Projetor de alta resolução', 4000.00, '2023-10-25', 1, 105),
(44, 'Mobiliário', 'Cadeira Diretor', 'Cadeira de couro com encosto alto', 950.00, '2023-09-18', 1, 105),
(45, 'Eletrônico', 'Sistema de Som Ambiente', 'Conjunto de alto-falantes de teto', 1200.00, '2023-08-28', 1, 105),
(46, 'Mobiliário', 'Balcão de Atendimento', 'Balcão em L', 1300.00, '2023-07-15', 2, 105),
(47, 'Eletrônico', 'Câmera de Segurança', 'Câmera IP com visão noturna', 350.00, '2023-06-22', 1, 105),
(48, 'Mobiliário', 'Estante de Aço', 'Estante com prateleiras reforçadas', 550.00, '2022-05-18', 2, 105),
(49, 'Eletrônico', 'Relógio de Ponto Eletrônico', 'Controle de acesso biométrico', 1800.00, '2023-04-28', 1, 105),
(50, 'Mobiliário', 'Mesa de Centro', 'Mesa de vidro para sala de espera', 280.00, '2023-03-20', 2, 105);

-- Sala de Aula 106
INSERT INTO bem (pk_cod_bem, categoria, nome, descricao, valor, data_aquisicao, estado_conservacao, fk_cod_espaco) VALUES
(51, 'Eletrônico', 'Monitor Dell 24"', 'Monitor LED Full HD', 850.00, '2023-01-15', 1, 106),
(52, 'Eletrônico', 'Computador Desktop', 'CPU Intel i5, 8GB RAM', 2500.00, '2023-01-15', 1, 106),
(53, 'Mobiliário', 'Mesa de Escritório', 'Mesa de madeira, 120x60cm', 350.00, '2023-01-15', 2, 106),
(54, 'Mobiliário', 'Cadeira Ergonômica', 'Cadeira com ajuste de altura e encosto', 480.00, '2023-01-15', 1, 106),
(55, 'Mobiliário', 'Mesa Redonda', 'Mesa de reuniões, diâmetro 120cm', 700.00, '2023-03-15', 1, 106),
(56, 'Eletrônico', 'Projetor Epson', 'Projetor multimídia', 1200.00, '2022-03-20', 2, 106),
(57, 'Eletrônico', 'Teclado USB', 'Teclado padrão ABNT2', 80.00, '2023-01-15', 1, 106),
(58, 'Eletrônico', 'Mouse Óptico', 'Mouse USB padrão', 45.00, '2023-01-15', 1, 106),
(59, 'Mobiliário', 'Poltrona de Espera', 'Poltrona estofada', 250.00, '2023-02-20', 2, 106),
(60, 'Eletrônico', 'Telefone IP', 'Telefone VoIP', 300.00, '2023-06-01', 1, 106);

-- Sala de Aula 107
INSERT INTO bem (pk_cod_bem, categoria, nome, descricao, valor, data_aquisicao, estado_conservacao, fk_cod_espaco) VALUES
(61, 'Mobiliário', 'Estante para Livros', 'Estante de madeira, 5 prateleiras', 400.00, '2022-08-01', 2, 107),
(62, 'Eletrônico', 'Computador All-in-One', 'Computador com tela integrada', 3200.00, '2023-03-05', 1, 107),
(63, 'Eletrônico', 'Servidor Dell', 'Servidor de dados', 8000.00, '2021-11-01', 2, 107),
(64, 'Eletrônico', 'Monitor Samsung 27"', 'Monitor LED QHD', 1200.00, '2023-03-10', 1, 107),
(65, 'Mobiliário', 'Carrinho de Limpeza', 'Carrinho para materiais de limpeza', 120.00, '2022-10-10', 1, 107),
(66, 'Eletrônico', 'Tela Interativa', 'Quadro branco digital', 7500.00, '2023-04-10', 1, 107),
(67, 'Eletrônico', 'Webcam Logitech', 'Webcam Full HD', 150.00, '2023-05-01', 1, 107),
(68, 'Mobiliário', 'Cadeira Fixa', 'Cadeira de plástico, sem braço', 90.00, '2023-01-15', 2, 107),
(69, 'Eletrônico', 'Scanner de Documentos', 'Scanner de alta velocidade', 700.00, '2022-11-20', 1, 107),
(70, 'Mobiliário', 'Sofá de Espera', 'Sofá de 3 lugares', 1200.00, '2023-04-20', 1, 107);

-- Sala de Aula 108
INSERT INTO bem (pk_cod_bem, categoria, nome, descricao, valor, data_aquisicao, estado_conservacao, fk_cod_espaco) VALUES
(71, 'Mobiliário', 'Banqueta Alta', 'Banqueta para balcão', 120.00, '2023-03-01', 2, 108),
(72, 'Eletrônico', 'Smart TV 50"', 'TV com acesso à internet', 2800.00, '2023-07-20', 1, 108),
(73, 'Mobiliário', 'Gaveteiro com Rodas', 'Gaveteiro com 3 gavetas', 200.00, '2022-09-15', 2, 108),
(74, 'Eletrônico', 'Nobreak', 'Fonte de alimentação ininterrupta', 600.00, '2023-02-25', 1, 108),
(75, 'Mobiliário', 'Aparador', 'Móvel de apoio em madeira', 450.00, '2023-05-12', 1, 108),
(76, 'Eletrônico', 'Caixa de Som Bluetooth', 'Caixa de som portátil', 250.00, '2023-10-05', 1, 108),
(77, 'Mobiliário', 'Prateleira de Parede', 'Prateleira suspensa', 80.00, '2023-01-30', 2, 108),
(78, 'Eletrônico', 'Tablet Samsung', 'Tablet com tela de 10 polegadas', 1500.00, '2023-06-18', 1, 108),
(79, 'Mobiliário', 'Puff Quadrado', 'Puff estofado', 100.00, '2023-04-05', 2, 108),
(80, 'Eletrônico', 'Leitor de Código de Barras', 'Leitor USB', 180.00, '2022-12-10', 1, 108);

-- Sala de Aula 109
INSERT INTO bem (pk_cod_bem, categoria, nome, descricao, valor, data_aquisicao, estado_conservacao, fk_cod_espaco) VALUES
(81, 'Eletrônico', 'Monitor Ultrawide', 'Monitor de 34 polegadas', 2500.00, '2023-11-01', 1, 109),
(82, 'Mobiliário', 'Cadeira Gamer', 'Cadeira ergonômica para jogos', 1200.00, '2023-10-15', 1, 109),
(83, 'Eletrônico', 'Impressora 3D', 'Impressora de prototipagem rápida', 3500.00, '2023-09-20', 1, 109),
(84, 'Mobiliário', 'Mesa de Desenho', 'Mesa inclinável para desenho técnico', 800.00, '2022-07-10', 2, 109),
(85, 'Eletrônico', 'Dock Station', 'Estação de acoplamento para notebooks', 400.00, '2023-05-25', 1, 109),
(86, 'Mobiliário', 'Armário com Portas de Vidro', 'Armário para exposição', 900.00, '2023-04-18', 2, 109),
(87, 'Eletrônico', 'Microfone de Lapela', 'Microfone sem fio', 150.00, '2023-08-30', 1, 109),
(888, 'Mobiliário', 'Bancada de Trabalho', 'Bancada robusta para laboratório', 1100.00, '2022-06-05', 2, 109),
(89, 'Eletrônico', 'HD Externo', 'Disco rígido de 2TB', 300.00, '2023-03-12', 1, 109),
(90, 'Mobiliário', 'Cesto de Lixo Seletivo', 'Conjunto de cestos para reciclagem', 180.00, '2023-02-15', 1, 109);

-- Sala de Aula 110
INSERT INTO bem (pk_cod_bem, categoria, nome, descricao, valor, data_aquisicao, estado_conservacao, fk_cod_espaco) VALUES
(100, 'Eletrônico', 'Monitor Curvo', 'Monitor de 27 polegadas', 1800.00, '2023-12-05', 1, 110),
(101, 'Mobiliário', 'Mesa de Reunião Oval', 'Mesa para 8 pessoas', 1500.00, '2023-11-10', 1, 110),
(102, 'Eletrônico', 'Projetor 4K', 'Projetor de alta resolução', 4000.00, '2023-10-25', 1, 110),
(103, 'Mobiliário', 'Cadeira Diretor', 'Cadeira de couro com encosto alto', 950.00, '2023-09-18', 1, 110),
(104, 'Eletrônico', 'Sistema de Som Ambiente', 'Conjunto de alto-falantes de teto', 1200.00, '2023-08-28', 1, 110),
(105, 'Mobiliário', 'Balcão de Atendimento', 'Balcão em L', 1300.00, '2023-07-15', 2, 110),
(106, 'Eletrônico', 'Câmera de Segurança', 'Câmera IP com visão noturna', 350.00, '2023-06-22', 1, 110),
(107, 'Mobiliário', 'Estante de Aço', 'Estante com prateleiras reforçadas', 550.00, '2022-05-18', 2, 110),
(108, 'Eletrônico', 'Relógio de Ponto Eletrônico', 'Controle de acesso biométrico', 1800.00, '2023-04-28', 1, 110),
(109, 'Mobiliário', 'Mesa de Centro', 'Mesa de vidro para sala de espera', 280.00, '2023-03-20', 2, 110),
(110, 'Eletrônico', 'Purificador de Ar', 'Aparelho para filtragem de ar', 450.00, '2023-02-18', 1, 110);

select bem.*,espaco.nome AS espaconome, espaco.descricao AS espacodescricao, espaco.numero from bem 
    join espaco on (espaco.pk_cod_espaco = bem.fk_cod_espaco)