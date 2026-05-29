# Sistema de Controle de Estoque

Projeto desenvolvido com o objetivo de criar um sistema de controle de estoque para uma empresa fictícia, aplicando conceitos de Programação Orientada a Objetos (POO).

---

# Descrição do Projeto

Toda empresa de comércio possui um estoque, no qual armazena os seus produtos. O controle eficiente do estoque permite que a empresa tenha um planejamento melhor de suas compras, pois possibilita saber exatamente a quantidade disponível de cada produto.

O sistema tem como objetivo registrar e controlar os produtos armazenados, suas quantidades, preços e movimentações de entrada e saída, garantindo que o estoque esteja sempre atualizado.

Os produtos são classificados em categorias, como por exemplo:

- Limpeza  
- Enlatados  
- Vegetais  
- Óleos  
- Outros  

O sistema também permite reajustar os preços de todos os produtos em um determinado percentual.

Sempre que ocorre uma movimentação de estoque, o saldo atual do produto é atualizado automaticamente:

- Entrada → adiciona quantidade  
- Saída → subtrai quantidade  

O sistema também emite avisos importantes:

- Quando a quantidade estiver abaixo da quantidade mínima  
- Quando a quantidade ultrapassar a quantidade máxima  

Não é necessário cadastrar previamente clientes ou fornecedores.

---

# Objetivo do Sistema

Desenvolver um sistema capaz de:

- Controlar o estoque de produtos
- Registrar movimentações de entrada e saída
- Manter o saldo atualizado automaticamente
- Emitir alertas de quantidade mínima e máxima
- Gerar relatórios de controle do estoque
- Facilitar o planejamento de compras

---

## Requisitos Funcionais

### RF01
O sistema deve permitir o cadastro de produtos.

### RF02
O sistema deve permitir alterar produtos cadastrados.

### RF03
O sistema deve permitir excluir produtos.

### RF04
O sistema deve permitir consultar produtos.

### RF05
O sistema deve permitir cadastrar categorias.

### RF06
O sistema deve permitir registrar movimentações de entrada.

### RF07
O sistema deve permitir registrar movimentações de saída.

### RF08
O sistema deve atualizar automaticamente o saldo do estoque.

### RF09
O sistema deve emitir alertas de estoque mínimo e máximo.

### RF10
O sistema deve gerar relatórios do estoque.

---

## Requisitos Não Funcionais

### RNF01
O sistema deve ser desenvolvido em Java.

### RNF02
O sistema deve utilizar Programação Orientada a Objetos.

### RNF03
O sistema deve utilizar banco de dados MySQL.

### RNF04
O sistema deve seguir arquitetura MVC.

### RNF05
O sistema deve funcionar no NetBeans.

### RNF06
O sistema deve possuir interface intuitiva.

### RNF07
O sistema deve permitir fácil manutenção do código.

### RNF08
O sistema deve utilizar Git e GitHub para versionamento.

### RNF09
O sistema deve possuir organização modular em pacotes.

### RNF10
O sistema deve executar corretamente com JDK 25.

# Relatórios do Sistema


## Lista de Preços

Relação de todos os produtos em ordem alfabética contendo:

- Nome do produto
- Preço unitário
- Unidade de medida
- Categoria

---

## Balanço Físico e Financeiro

Relação de todos os produtos contendo:

- Quantidade disponível
- Valor unitário
- Valor total por produto
- Valor total geral do estoque

---

## Produtos Abaixo da Quantidade Mínima

Relatório contendo:

- Nome do produto
- Quantidade mínima
- Quantidade em estoque

---

## Quantidade de Produtos por Categoria

Relatório contendo:

- Nome da categoria
- Quantidade de produtos distintos

---

## Produto com Maior Movimentação

Relatório contendo:

- Produto com maior número de entradas
- Produto com maior número de saídas

---

# Estrutura das Entidades

## Produto

- Nome
- Preço unitário
- Unidade
- Quantidade em estoque
- Quantidade mínima em estoque
- Quantidade máxima em estoque
- Categoria

---

## Categoria

- Nome
- Tamanho (Pequeno, Médio ou Grande)
- Embalagem (Lata, Vidro ou Plástico)

---

## Movimentação

- Nome do produto
- Data da movimentação
- Quantidade movimentada
- Tipo da movimentação (Entrada ou Saída)

---

# Tecnologias Utilizadas

- Java ( JDK 25.0 )
- Apache NetBeans IDE 29
- Programação Orientada a Objetos (POO)
- Git
- GitHub

---

# Integrantes do Grupo

- Kauã Sousa Paulo, RA: 10726111167, github: okauasp ( e commits com a autoria de Kauã )
- Bruno da Silva Antunes, RA: 1072610215, github: dev-brunoantunes
- Luigi  Tadeu Tricarico, RA:10726112026, github: LuigiTadeuTricarico ( e commits com a autoria de Usuario )
  

---

# Observação

Este projeto está sendo desenvolvido ao longo do semestre, podendo receber atualizações e correções conforme as orientações do professor.

---

# Observação banco

1. Execute o arquivo banco/controle_estoque.sql no MySQL Workbench

2. Verifique usuário e senha na classe util.Conexao

3. Execute o projeto Maven no NetBeans
