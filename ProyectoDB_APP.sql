CREATE DATABASE proyectoDB;
USE proyectoDB;

-- Crear tabla usuarios sin la clave foránea problematica
CREATE TABLE IF NOT EXISTS usuarios (
  id_usuario INT PRIMARY KEY AUTO_INCREMENT,
  nombre VARCHAR(30),
  apellido VARCHAR(30),
  correo VARCHAR(30),
  contrasenia VARCHAR(30),
  telefono VARCHAR(30),
  imagen VARCHAR(40),
  publicaciones INT,
  seguidores INT
);

-- Crear tabla publicaciones con clave foránea hacia usuarios
CREATE TABLE IF NOT EXISTS publicaciones (
  id_publicacion INT PRIMARY KEY AUTO_INCREMENT,
  id_usuario INT,
  tipo_publicacion VARCHAR(20),
  fecha_publicacion VARCHAR(20),
  interaccion VARCHAR(20),
  FOREIGN KEY (id_usuario) REFERENCES usuarios(id_usuario)
);

-- Crear tabla seguidores
-- Usamos dos claves foráneas hacia la tabla usuarios para representar la relación muchos a muchos
CREATE TABLE IF NOT EXISTS seguidores (
  id_usuario INT,
  id_seguidor INT,
  PRIMARY KEY (id_usuario, id_seguidor),
  FOREIGN KEY (id_usuario) REFERENCES usuarios(id_usuario),
  FOREIGN KEY (id_seguidor) REFERENCES usuarios(id_usuario)
);

-- Crear tabla notificaciones con clave foránea hacia usuarios
CREATE TABLE IF NOT EXISTS notificaciones (
  id_notificacion INT PRIMARY KEY AUTO_INCREMENT,
  id_usuario INT,
  tipo_notificacion VARCHAR(20),
  fecha_notificacion DATE,
  FOREIGN KEY (id_usuario) REFERENCES usuarios(id_usuario)
);

-- Alterar tabla usuarios para añadir la clave foránea hacia publicaciones
ALTER TABLE usuarios
ADD CONSTRAINT fk_publicaciones_id
FOREIGN KEY (publicaciones) REFERENCES publicaciones(id_publicacion),
ADD CONSTRAINT fk_seguidores_id
FOREIGN KEY (seguidores) REFERENCES seguidores(id_seguidor)
