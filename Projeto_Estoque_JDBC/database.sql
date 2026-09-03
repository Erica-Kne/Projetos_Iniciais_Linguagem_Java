USE estoque;
CREATE TABLE produto (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    descricao VARCHAR(255),
    preco DECIMAL(10, 2) NOT NULL,
    quantidade INT NOT NULL
);

INSERT INTO produto (nome, descricao, preco, quantidade) VALUES ("Blusa Preta", "Blusa 100% algodão", 69.90, 6);
INSERT INTO produto (nome, descricao, preco, quantidade) VALUES ("Calça Wide Leg Azul", "Calça Wide Leg em jeans", 179.90, 10);
INSERT INTO produto (nome, descricao, preco, quantidade) VALUES ("Suéter Marrom", "Suéter Marrom em trico", 119.90, 5);
INSERT INTO produto (nome, descricao, preco, quantidade) VALUES ("Saia Xadrez", "Saia Xadrez em tule", 119.90, 8);
