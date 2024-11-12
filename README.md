# LabHub

## Descrição
O **LabHUb** é um sistema que facilita o gerenciamento e monitoramento do hardware disponível em hospitais, tendo um controle eficiente do inventário e uso dos recursos.

## Funcionalidades
- Cadastro de equipamentos
- Controle de disponibilidade e status dos equipamentos
- Notificações de manutenção ou vencimento de garantias
- Lotes dos equipamentos

## Tecnologias
- Linguagem de programação: Java
- Banco de Dados: MySQL


## Diagrama Logico
![image](https://github.com/user-attachments/assets/f1c09e38-e8f2-42ad-85c0-2571cac8172d)

## Diagrama Conceitual
![image](https://github.com/user-attachments/assets/c3f20a95-a024-4956-a69c-683bf2147fbe)


```
-- Criação do banco de dados
CREATE DATABASE LabHub;

-- Selecionar o banco de dados
USE LabHub;

-- Criação da tabela equipamento
CREATE TABLE equipamento (
    id_equipamento INT AUTO_INCREMENT PRIMARY KEY,
    modelo VARCHAR(100) NOT NULL,
    fabricante VARCHAR(50) NOT NULL,
    numeroSerie VARCHAR(50) NOT NULL UNIQUE,
    statusEquipamento TEXT,
    garantia VARCHAR(50) NOT NULL
);

-- Inserir dados na tabela equipamento
INSERT INTO equipamento (modelo, fabricante, numeroSerie, statusEquipamento, garantia) VALUES
('Modelo A1', 'Fabricante X', 'SN123456', 'Disponível', '12 meses'),
('Modelo B2', 'Fabricante Y', 'SN654321', 'Em uso', '24 meses'),
('Modelo C3', 'Fabricante Z', 'SN789012', 'Em manutenção', '6 meses'),
('Modelo D4', 'Fabricante X', 'SN345678', 'Disponível', '12 meses'),
('Modelo E5', 'Fabricante Y', 'SN987654', 'Em uso', '36 meses');

-- Criação da tabela usuario
CREATE TABLE usuario (
    id_usuario INT AUTO_INCREMENT PRIMARY KEY,
    nomeUsuario VARCHAR(50) NOT NULL,
    emailUsuario VARCHAR(50) NOT NULL UNIQUE,
    cargo VARCHAR(90) NOT NULL,
    id_equipamento INT, 
    FOREIGN KEY (id_equipamento) REFERENCES equipamento(id_equipamento)
);

-- Inserir dados na tabela usuario
INSERT INTO usuario (nomeUsuario, emailUsuario, cargo, id_equipamento) VALUES
('Carlos Silva', 'carlos.silva@example.com', 'Analista de TI', 1),
('Maria Oliveira', 'maria.oliveira@example.com', 'Gerente de Projetos', 2),
('João Santos', 'joao.santos@example.com', 'Desenvolvedor', 3),
('Ana Costa', 'ana.costa@example.com', 'Analista de Sistemas', 4),
('Luiz Ferreira', 'luiz.ferreira@example.com', 'Coordenador', 5);

-- Criação da tabela tecnico
CREATE TABLE tecnico (
    id_tecnico INT AUTO_INCREMENT PRIMARY KEY,
    nomeTecnico VARCHAR(50) NOT NULL,
    cargoTecnico VARCHAR(50) NOT NULL,
    id_equipamento INT,
    FOREIGN KEY (id_equipamento) REFERENCES equipamento(id_equipamento)
);

-- Inserir dados na tabela tecnico
INSERT INTO tecnico (nomeTecnico, cargoTecnico, id_equipamento) VALUES
('Roberto Lima', 'Técnico de Manutenção', 1),
('Fernanda Souza', 'Técnica em Informática', 2),
('Lucas Almeida', 'Técnico de Redes', 3),
('Patrícia Silva', 'Técnica em Eletrônica', 4),
('Eduardo Costa', 'Técnico de Suporte', 5);

-- Criação da tabela manutencao
CREATE TABLE manutencao (
    id_manutencao INT AUTO_INCREMENT PRIMARY KEY,
    dataManutencao DATE, 
    tipoManutencao TEXT NOT NULL,
    id_equipamento INT,
    FOREIGN KEY (id_equipamento) REFERENCES equipamento(id_equipamento),
    id_tecnico INT,
    FOREIGN KEY (id_tecnico) REFERENCES tecnico(id_tecnico)
);

-- Inserir dados na tabela manutencao
INSERT INTO manutencao (dataManutencao, tipoManutencao, id_equipamento, id_tecnico) VALUES
('2024-01-15', 'Manutenção Preventiva', 1, 1),
('2024-02-20', 'Manutenção Corretiva', 2, 2),
('2024-03-10', 'Reparo de Equipamento', 3, 3),
('2024-04-05', 'Troca de Peças', 4, 4),
('2024-05-12', 'Verificação Geral', 5, 5);

-- Criação da tabela pecas
CREATE TABLE pecas (
    id_pecas INT AUTO_INCREMENT PRIMARY KEY,
    nomePecas VARCHAR(50) NOT NULL,
    quantidadePecas VARCHAR(60) NOT NULL,
    tipoPecas VARCHAR(80) NOT NULL,
    id_manutencao INT,
    FOREIGN KEY (id_manutencao) REFERENCES manutencao(id_manutencao)
);

-- Inserir dados na tabela pecas
INSERT INTO pecas (nomePecas, quantidadePecas, tipoPecas, id_manutencao) VALUES
('Fonte 500W', '10', 'Fonte', 1),
('HD 1TB', '5', 'Armazenamento', 2),
('Placa Mãe', '3', 'Placa', 3),
('Memória RAM 8GB', '15', 'Memória', 4),
('Monitor LED 24"', '2', 'Periférico', 5);

-- Criação da tabela laboratorio
CREATE TABLE laboratorio (
    id_laboratorio INT AUTO_INCREMENT PRIMARY KEY,
    numeroDaSala VARCHAR(10) NOT NULL,
    id_equipamento INT,
    FOREIGN KEY (id_equipamento) REFERENCES equipamento(id_equipamento)
);

-- Inserir dados na tabela laboratorio
INSERT INTO laboratorio (numeroDaSala, id_equipamento) VALUES
('Sala 101', 1),
('Sala 102', 2),
('Sala 103', 3),
('Sala 104', 4),
('Sala 105', 5);

create table hLogin(
id_login int auto_increment primary key,
login varchar(30) not null unique,
senha varchar(30) not null
);

insert into hlogin(login, senha) values
('admin', 'admin');


SELECT * FROM usuario;
SELECT * FROM equipamento;
SELECT * FROM manutencao;
SELECT * FROM pecas;	
SELECT * FROM tecnico;
SELECT * FROM laboratorio;

-- Consultar equipamentos e seus usuários
SELECT
    u.id_usuario,
    u.nomeUsuario AS Nome_Usuario,
    u.emailUsuario AS Email,
    u.cargo AS Cargo,
    e.id_equipamento,
    e.modelo AS Modelo,
    e.fabricante AS Fabricante,
    e.numeroSerie AS N°_serie,
    e.statusEquipamento AS Status_,
    e.garantia AS Garantia
FROM
    usuario u
JOIN
    equipamento e ON u.id_equipamento = e.id_equipamento;

-- Consultar o modelo do equipamento que está na sala
	SELECT
	l.id_laboratorio,
	l.numeroDaSala AS N_Sala,
	e.modelo AS Modelo,
	e.numeroSerie AS N°_Serie,
	e.statusEquipamento AS Status_Equipamento
	FROM
	laboratorio l
	JOIN
	equipamento e ON l.id_equipamento = e.id_equipamento;

-- Consultar o pc que vai receber a manutencao e o tecnico q ira realizala
SELECT
    m.id_manutencao,
    t.nomeTecnico AS Nome_Tecnico,
    m.dataManutencao AS Data_Da_Manutencao,
    m.tipoManutencao AS Tipo_De_Manutencao,
    e.modelo AS Modelo
FROM
    manutencao m
JOIN
    tecnico t ON m.id_tecnico = t.id_tecnico
JOIN
    equipamento e ON m.id_equipamento = e.id_equipamento;

-- Consulta pecas e manutencao
SELECT
    p.id_pecas,
    m.tipoManutencao,
    p.nomePecas AS Nome_da_Peça,
    p.quantidadePecas,
    p.tipoPecas
FROM
    pecas p
JOIN
    manutencao m ON p.id_manutencao = m.id_manutencao;




