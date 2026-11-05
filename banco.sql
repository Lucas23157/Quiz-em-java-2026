DROP TABLE IF EXISTS partida;
DROP TABLE IF EXISTS questao;
DROP TABLE IF EXISTS jogador;

CREATE TABLE jogador (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    apelido VARCHAR(50) NOT NULL UNIQUE
);

CREATE TABLE partida (
    id SERIAL PRIMARY KEY,
    id_jogador INT NOT NULL,
    pontuacao_obtida INT NOT NULL CHECK (pontuacao_obtida >= 0),
    data_partida TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT fk_partida_jogador FOREIGN KEY (id_jogador) 
        REFERENCES jogador (id) ON DELETE CASCADE
);

CREATE TABLE questao (
    id SERIAL PRIMARY KEY,
    tipo VARCHAR(10) NOT NULL, 
    enunciado VARCHAR(255) NOT NULL,
    pontos_base INT NOT NULL CHECK (pontos_base > 0),
    alternativa_a VARCHAR(100),
    alternativa_b VARCHAR(100),
    alternativa_c VARCHAR(100),
    gabarito_me CHAR(1),
    nivel_dificuldade INT,
    gabarito_vf BOOLEAN
);

INSERT INTO jogador (nome, apelido) VALUES 
('Bruno Salvador', 'BrunoSD'),
('Paulo Lucas', 'PauloL');

INSERT INTO partida (id_jogador, pontuacao_obtida) VALUES 
(1, 150),
(2, 140);

INSERT INTO questao (tipo, enunciado, pontos_base, alternativa_a, alternativa_b, alternativa_c, gabarito_me, nivel_dificuldade, gabarito_vf) VALUES
('ME', 'Qual palavra-chave define herança de classe em Java?', 10, 'implements', 'extends', 'inherits', 'B', 2, NULL),
('VF', 'Uma classe abstrata pode ser instanciada diretamente com new.', 15, NULL, NULL, NULL, NULL, NULL, FALSE);
