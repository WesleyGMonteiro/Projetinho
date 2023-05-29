

CREATE DATABASE BDVENDAS;


CREATE USER 'USUARIOCHEFE'@'%' IDENTIFIED BY '123';
GRANT ALL ON *.* TO 'USUARIOCHEFE'@'%' WITH GRANT OPTION;


USE BDVENDAS;

/***** TABELA CLIENTES *****/
CREATE TABLE tb_clientes (
  id int auto_increment primary key,
  nome varchar(100) not null,
  sobrenome varchar(100) not null,
  sexo varchar(20) not null,
  nascimento date not null,
  rg varchar (30) not null,
  cpf varchar (20) not null,
  email varchar(200) not null,
  celular varchar(30) not null,
  celular2 varchar(30) not null,
  cep varchar(100) not null,
  endereco varchar (255) not null,
  numero int,
  complemento varchar (200),
  bairro varchar (100) not null,
  cidade varchar (100) not null,
  estado varchar (2) not null
);

/*****************/

/***** TABELA FORNECEDORES *****/
CREATE TABLE tb_fornecedores (
  id int auto_increment primary key,
  nome varchar(100),
  cnpj varchar (100),
  email varchar(200),
  telefone varchar(30),
  celular varchar(30),
  cep varchar(100),
  endereco varchar (255),
  numero int,
  complemento varchar (200),
  bairro varchar (100),
  cidade varchar (100),
  estado varchar (2)
);
/*****************/


/***** TABELA PRODUTOS *****/
CREATE TABLE tb_produtos (
  id int auto_increment primary key,
  descricao varchar(100),
  preco decimal (10,2),
  qtd_estoque int,
  for_id int,

  FOREIGN KEY (for_id) REFERENCES tb_fornecedores(id)
);
/*****************/

/***** TABELA VENDAS *****/
CREATE TABLE tb_vendas (
  id int auto_increment primary key,
  cliente_id int,
  data_venda datetime,
  total_venda decimal (10,2),
  observacoes text,

  FOREIGN KEY (cliente_id) REFERENCES tb_clientes(id)
);
/*****************/

/***** TABELA ITENS_VENDAS *****/
CREATE TABLE tb_itensvendas (
  id int auto_increment primary key,
  venda_id int,
  produto_id int,
  qtd int,
  subtotal decimal (10,2),

  FOREIGN KEY (venda_id) REFERENCES tb_vendas(id),
  FOREIGN KEY (produto_id) REFERENCES tb_produtos(id)
);
/*****************/


select * from tb_clientes where nome like 'a%';