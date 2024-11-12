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
create database LabHub;

use LabHub;

-- 1. Tabela `usuarios`
CREATE TABLE usuario (
    id_usuario INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    senha VARCHAR(100) NOT NULL,
    perfil ENUM('tecnico', 'administrador', 'professor', 'estagiario') NOT NULL
);

-- 2. Tabela `laboratorios`
CREATE TABLE laboratorios (
    id_laboratorio INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL
);

-- 3. Tabela `maquinas`
CREATE TABLE maquinas (
    id_maquina INT AUTO_INCREMENT PRIMARY KEY,
    id_laboratorio INT,
    nome VARCHAR(100) NOT NULL,
    processador VARCHAR(100),
    memoria_RAM VARCHAR(50),
    armazenamento VARCHAR(50),
    numero_serie VARCHAR(100) UNIQUE,
    data_aquisicao DATE,
    status ENUM('funcionando', 'em_manutencao', 'fora_de_uso') NOT NULL,
    FOREIGN KEY (id_laboratorio) REFERENCES laboratorios(id_laboratorio)
);

-- 4. Tabela `manutencoes`
CREATE TABLE manutencoes (
    id_manutencao INT AUTO_INCREMENT PRIMARY KEY,
    id_maquina INT,
    data_manutencao DATE NOT NULL,
    diagnostico TEXT,
    solucao TEXT,
    tecnico_responsavel VARCHAR(100),
    FOREIGN KEY (id_maquina) REFERENCES maquinas(id_maquina)
);

-- 5. Tabela `pecas`
CREATE TABLE pecas (
    id_peca INT AUTO_INCREMENT PRIMARY KEY,
    nome_peca VARCHAR(100) NOT NULL,
    quantidade_estoque INT DEFAULT 0,
    descricao TEXT,
    imagem BLOB
);

-- 6. Tabela `pecas_manutencao`
CREATE TABLE pecas_manutencao (
    id_peca_manutencao INT AUTO_INCREMENT PRIMARY KEY,
    id_manutencao INT,
    id_peca INT,
    quantidade_utilizada INT NOT NULL,
    FOREIGN KEY (id_manutencao) REFERENCES manutencoes(id_manutencao),
    FOREIGN KEY (id_peca) REFERENCES pecas(id_peca)
);

-- 7. Tabela `tecnico`
CREATE TABLE tecnicos (
    id_tecnico INT AUTO_INCREMENT PRIMARY KEY,     -- Identificador único do técnico
    nome VARCHAR(100) NOT NULL,                    -- Nome do técnico
    email VARCHAR(100) NOT NULL UNIQUE,            -- E-mail único do técnico
    id_laboratorio INT,                            -- Laboratório ao qual o técnico está alocado (caso haja)
    telefone VARCHAR(20),                          -- Telefone do técnico
    data_admissao DATE,                            -- Data de admissão do técnico
    FOREIGN KEY (id_laboratorio) REFERENCES laboratorios(id_laboratorio) -- Relaciona ao laboratório
);

-- 8. Tabela `login`
CREATE TABLE login (
    id_usuario INT AUTO_INCREMENT PRIMARY KEY,     -- Identificador único do usuário
    email VARCHAR(100) NOT NULL UNIQUE,            -- E-mail único do usuário (relacionado com a tabela tecnicos)
    senha VARCHAR(255) NOT NULL,                   -- Senha criptografada do usuário
    ultimo_login TIMESTAMP NULL,                   -- Data e hora do último login
    status ENUM('ativo', 'inativo') DEFAULT 'ativo', -- Status do usuário (ativo ou inativo)
    CONSTRAINT fk_email FOREIGN KEY (email) REFERENCES tecnicos(email) -- Relaciona com o e-mail da tabela 'tecnicos'
);

-- Inserindo dados na tabela `usuarios`
INSERT INTO usuario (nome, email, senha, perfil) VALUES
('Carlos Silva', 'carlos@lab.com', 'tec', 'tecnico'),
('Ana Oliveira', 'ana@lab.com', 'adm', 'administrador'),
('João Santos', 'joao@lab.com', 'prof', 'professor');

-- Inserindo dados na tabela `laboratorios`
INSERT INTO laboratorios (nome) VALUES
('LabinA'),
('LabinB'),
('LabinC'),
('LabinD');

-- Inserindo dados na tabela `maquinas`
INSERT INTO maquinas (id_laboratorio, nome, processador, memoria_RAM, armazenamento, numero_serie, data_aquisicao, status) VALUES
(1, 'Máquina A', 'Intel Core i5', '8GB', '500GB SSD', 'SN001', '2023-01-10', 'funcionando'),
(2, 'Máquina B', 'Intel Core i7', '16GB', '1TB HDD', 'SN002', '2022-11-20', 'em_manutencao'),
(3, 'Máquina C', 'AMD Ryzen 5', '8GB', '256GB SSD', 'SN003', '2023-05-15', 'fora_de_uso');

-- Inserindo dados na tabela `manutencoes`
INSERT INTO manutencoes (id_maquina, data_manutencao, diagnostico, solucao, tecnico_responsavel) VALUES
(1, '2024-01-15', 'Reparação do sistema', 'Reinstalação do SO', 'Carlos Silva'),
(2, '2024-02-20', 'Troca de fonte', 'Fonte substituída', 'Ana Oliveira'),
(3, '2024-03-05', 'Aquecimento excessivo', 'Limpeza interna', 'João Santos');

-- Inserindo dados na tabela `pecas`
INSERT INTO pecas (nome_peca, quantidade_estoque, descricao, imagem) VALUES
('Fonte de Alimentação 500W', 10, 'Fonte para desktops com 500W', NULL),
('Memória RAM 8GB', 20, 'DDR4 para notebooks e desktops', NULL),
('Disco SSD 256GB', 15, 'SSD SATA para alto desempenho', NULL);

-- Inserindo dados na tabela `pecas_manutencao`
INSERT INTO pecas_manutencao (id_manutencao, id_peca, quantidade_utilizada) VALUES
(1, 1, 1),
(2, 2, 2),
(3, 3, 1);

-- Inserindo dados na tabela `tecnico`
INSERT INTO tecnicos (nome, email, id_laboratorio, telefone, data_admissao) VALUES
('Carlos Silva', 'carlos@lab.com', 1, '1234-5678', '2024-01-10'),
('Ana Oliveira', 'ana@lab.com', 2, '2345-6789', '2023-07-15'),
('João Santos', 'joao@lab.com', 3, '3456-7890', '2023-12-01'),
('Maria Pereira', 'maria@lab.com', 1, '4567-8901', '2024-03-01');

-- Inserindo dados na tabela `login`
INSERT INTO login (email, senha, ultimo_login, status) VALUES
('carlos@lab.com', 'senha123', '2024-11-09 08:00:00', 'ativo'),
('ana@lab.com', 'senha456', '2024-11-08 09:30:00', 'ativo'),
('joao@lab.com', 'senha789', '2024-11-07 14:45:00', 'ativo'),
('maria@lab.com', 'senha101', NULL, 'ativo');

-- Consulta SQL: Relatórios e Detalhes do Sistema
SELECT 
    l.nome AS Laboratório,
    COUNT(m.id_maquina) AS quantidade_maquinas,
    SUM(CASE WHEN m.status = 'funcionando' THEN 1 ELSE 0 END) AS maquinas_funcionando,
    SUM(CASE WHEN m.status = 'em_manutencao' THEN 1 ELSE 0 END) AS maquinas_em_manutencao,
    SUM(CASE WHEN m.status = 'fora_de_uso' THEN 1 ELSE 0 END) AS maquinas_fora_de_uso
FROM laboratorios l
LEFT JOIN maquinas m ON l.id_laboratorio = m.id_laboratorio
GROUP BY l.id_laboratorio, l.nome
ORDER BY quantidade_maquinas DESC;	

-- Consulta Relatório de Uso de Peças nas Manutenções
SELECT 
    p.nome_peca,
    pm.quantidade_utilizada,
    ma.data_manutencao,
    m.numero_serie AS numero_serie_maquina,
    l.nome AS laboratorio
FROM pecas_manutencao pm
JOIN pecas p ON pm.id_peca = p.id_peca
JOIN manutencoes ma ON pm.id_manutencao = ma.id_manutencao
JOIN maquinas m ON ma.id_maquina = m.id_maquina
JOIN laboratorios l ON m.id_laboratorio = l.id_laboratorio
ORDER BY ma.data_manutencao DESC;

select*from laboratorio;
describe laboratorio;
ALTER TABLE laboratorios
ADD COLUMN quantidade_maquinas VARCHAR(255);














