CREATE TABLE `Tema` (
	`id` bigint NOT NULL AUTO_INCREMENT,
	`Front-End` varchar(255) NOT NULL,
	`Back-End` varchar(255) NOT NULL,
	`Full Stack` varchar(255) NOT NULL,
	`Banco de Dados` varchar(255) NOT NULL,
	`Básico` varchar(255) NOT NULL,
    primary key (id),
    tema_id bigint,
    foreign key (tema_id) references postagem(id)
);












