create database proyectoDB;
use proyectoDB;

create table if not exists usuarios(
	id_usuario int primary key auto_increment,
	nombre varchar(30),
	apellido varchar(30),
	correo varchar(30),
	contrasenia varchar(30),
	telefono varchar(30),
	imagen varchar(40)
);

create table if not exists seguidores(
	id_seguidor int primary key auto_increment,
	id_usuario int
);

create table if not exists notificaciones(
	id_notificacion int primary key auto_increment,
	id_usuario int, 
	tipo_notificacion VARCHAR(20),
	fecha_notificacion VARCHAR(20)
);

create table if not exists publicaciones(
	id_publicacion int primary key auto_increment,
	id_usuario int, 
	tipo_publicacion VARCHAR(20),
	fecha_publicacion VARCHAR(20),
	interaccion VARCHAR(20)
);

INSERT INTO usuarios (id_usuario, nombre, apellido, correo, contrasena, telefono, imagen)
VALUES 
  (DEFAULT, 'Juan', 'Pérez', 'juan.perez@example.com', 'pass123', '99999999','www.img.com'),
  (DEFAULT, 'María', 'González', 'maria.gonzalez@example.com', 'abc456', '7777777','www.img.com'),
  (DEFAULT, 'Carlos', 'Rodríguez', 'carlos.rodriguez@example.com', 'xyz789','888888888','www.img.com'),
  (DEFAULT, 'Ana', 'Sánchez', 'ana.sanchez@example.com', 'qwerty','8888888888','www.img.com'),
  (DEFAULT, 'Pedro', 'Gómez', 'pedro.gomez@example.com', 'password','55555555555','www.img.com');




