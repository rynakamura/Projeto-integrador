CREATE TABLE `Postagens` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`titulo` varchar(255) NOT NULL,
	`descricao` varchar(1000) NOT NULL,
	`data_postagem` varchar(8) NOT NULL,
	`link_video` varchar(255) NOT NULL,
	`tema_id` INT NOT NULL,
	`usuario_id` INT NOT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `Tema` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`materia` varchar(255) NOT NULL,
	`ano_conteudo` varchar(255) NOT NULL,
	`descricao` varchar(1000) NOT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `Usuário` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`nome_completo` varchar(255) NOT NULL,
	`login` varchar(255) NOT NULL,
	`senha` varchar(20) NOT NULL,
	PRIMARY KEY (`id`)
);

ALTER TABLE `Postagens` ADD CONSTRAINT `Postagens_fk0` FOREIGN KEY (`tema_id`) REFERENCES `Tema`(`id`);

ALTER TABLE `Postagens` ADD CONSTRAINT `Postagens_fk1` FOREIGN KEY (`usuario_id`) REFERENCES `Usuário`(`id`);

