```sql
CREATE DATABASE IF NOT EXISTS controle_estoque;
USE controle_estoque;

-- =========================
-- TABELA CATEGORIA
-- =========================
CREATE TABLE `categoria` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(45) NOT NULL,
  `tamanho` ENUM('PEQUENO', 'MEDIO', 'GRANDE') DEFAULT NULL,
  `embalagem` ENUM('SACO', 'CAIXA', 'GARRAFA', 'PACOTE', 'LATA') DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- =========================
-- TABELA PRODUTO
-- =========================
CREATE TABLE `produto` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(100) DEFAULT NULL,
  `preco` decimal(10,2) DEFAULT NULL,
  `unidade` ENUM('UN', 'KG', 'G', 'L', 'ML') DEFAULT NULL,
  `quantidade` int DEFAULT NULL,
  `qtd_min` int DEFAULT NULL,
  `qtd_max` int DEFAULT NULL,
  `categoria_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `categoria_id` (`categoria_id`),
  CONSTRAINT `produto_ibfk_1`
    FOREIGN KEY (`categoria_id`)
    REFERENCES `categoria` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- =========================
-- TABELA MOVIMENTACAO
-- =========================
CREATE TABLE `movimentacao` (
  `id` int NOT NULL AUTO_INCREMENT,
  `produto_id` int DEFAULT NULL,
  `data_mov` date DEFAULT NULL,
  `quantidade` int DEFAULT NULL,
  `tipo` ENUM('ENTRADA', 'SAIDA') DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `produto_id` (`produto_id`),
  CONSTRAINT `movimentacao_ibfk_1`
    FOREIGN KEY (`produto_id`)
    REFERENCES `produto` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- =========================
-- TABELA REAJUSTE
-- =========================
CREATE TABLE `reajuste` (
  `id`            INT NOT NULL AUTO_INCREMENT,
  `data_reajuste` DATE NOT NULL,
  `valor`         DECIMAL(10,2) NOT NULL,
  `tipo`          ENUM('AUMENTO', 'DESCONTO') NOT NULL,
  `categoria_id`  INT DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `categoria_id` (`categoria_id`),
  CONSTRAINT `reajuste_ibfk_1`
    FOREIGN KEY (`categoria_id`)
    REFERENCES `categoria` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
```

