create database usuarios;

use usuarios;

create table usuarios(idUsu int auto_increment not null, usuario varchar(30) not null, contraseña varchar(20) not null, primary key(idUsu));

insert into usuarios (usuario, contraseña) values('sealcase@gmail.com', '123456');