DROP DATABASE `padrinho_do_bem_db`;

CREATE DATABASE `padrinho_do_bem_db`;
USE `padrinho_do_bem_db`;

CREATE TABLE IF NOT EXISTS `usuario`(
	id INT PRIMARY KEY AUTO_INCREMENT,
	type BOOL default false NOT NULL,
	email VARCHAR(200) NOT NULL,
	cpf VARCHAR(20) NOT NULL,
	nome VARCHAR(200) NOT NULL,
	senha VARCHAR(200) NOT NULL,
	UNIQUE(cpf)
);

INSERT INTO `usuario` (`type`, `email`, `cpf`, `nome`, `senha`) VALUES
	( TRUE, "admin@padrinho.bem", "000.000.000-00", "Admin", "Admin");
  
INSERT INTO `usuario` (`type`, `email`, `cpf`, `nome`, `senha`) VALUES
	( false, "test@padrinho.bem", "123.456.789-00", "Pedro Jesus", "Admin");
 
DELETE FROM usuario WHERE id = 2;
 
INSERT INTO `usuario` (`type`, `email`, `cpf`, `nome`, `senha`) VALUES
	( false, "test@padrinho.bem", "123.456.789-00", "Pedro Jesus", "Admin");
  
INSERT INTO `usuario` (`type`, `email`, `cpf`, `nome`, `senha`) VALUES
	( false, "test@padrinho.bem", "123.456.789-01", "Pedro Jesus do santis", "Admin");
  
 


CREATE TABLE IF NOT EXISTS `crianca`(
	id INT PRIMARY KEY AUTO_INCREMENT,
	nome VARCHAR(200) NOT NULL,
  idade INT NOT NULL,
  historia VARCHAR(2000) NOT NULL,
  local VARCHAR(50) NOT NULL
);

INSERT INTO crianca (nome,idade,historia, `local`) VALUES
	("11",12,"...","Sao Paulo - SP"),
	("2",12,"...","Sao Paulo - SP");

create table if not exists `necessidade` (
	id INT auto_increment primary key,
    tipo enum('educacao', 'lazer', 'vestuario', 'alimentacao') NOT NULL,
    crianca_id INT NOT NULL,
    foreign key fk_crianca (crianca_id)
		references crianca(id)
        on delete cascade, 
  	UNIQUE(tipo, crianca_id)
);

INSERT INTO necessidade (tipo, crianca_id) VALUES 
	("educacao", 1),
  ("educacao", 2),
  ("vestuario", 1);

create table if not exists `apadrinhamento` (
	id INT auto_increment primary key,
  	data_inicio date not NULL,
    tempo_meses INT NOT NULL, 
    crianca_id INT not null,
    usuario_id INT not null,
    necessidade_id INT not null,
    foreign key fk_apadrinhamento_crianca (crianca_id)
		references crianca(id)
        on delete cascade,
	foreign key fk_apadrinhamento_user (usuario_id)
		references usuario(id)
        on delete cascade,
	foreign key fk_apadrinhamento_necessidade (necessidade_id)
		references necessidade(id)
        on delete cascade,
    UNIQUE(crianca_id,usuario_id,necessidade_id)
);

insert into `apadrinhamento` (`crianca_id`, `data_inicio`, `necessidade_id`, `tempo_meses`, `usuario_id`) 
	values 
  	(1, '2023-01-13', 1, 2, 3),
    (1, '2023-01-13', 2, 3, 3),
    (1, '2023-01-17', 3, 4, 3),
    (2, '2023-03-13', 2, 6, 4);


describe apadrinhamento;









