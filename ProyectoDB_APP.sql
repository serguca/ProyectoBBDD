CREATE DATABASE proyectoDB;
USE proyectoDB;

-- Crear tabla usuarios
CREATE TABLE IF NOT EXISTS usuarios (
  id_usuario INT PRIMARY KEY AUTO_INCREMENT,
  nombre VARCHAR(30),
  apellido VARCHAR(30),
  correo VARCHAR(30),
  contrasena VARCHAR(30),
  telefono VARCHAR(30),
  imagen VARCHAR(40)
);

-- Crear tabla publicaciones con clave foránea hacia usuarios
CREATE TABLE IF NOT EXISTS publicaciones (
  id_publicacion INT PRIMARY KEY AUTO_INCREMENT,
  id_usuario INT,
  tipo_publicacion VARCHAR(20),
  fecha_publicacion DATE,
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

-- Insertar datos en la tabla usuarios
INSERT INTO usuarios (id_usuario, nombre, apellido, correo, contrasena, telefono, imagen)
VALUES 
  (DEFAULT, 'Juan', 'Pérez', 'juan.perez@example.com', 'pass123', '99999999','www.img.com'),
  (DEFAULT, 'María', 'González', 'maria.gonzalez@example.com', 'abc456', '7777777','www.img.com'),
  (DEFAULT, 'Carlos', 'Rodríguez', 'carlos.rodriguez@example.com', 'xyz789','888888888','www.img.com'),
  (DEFAULT, 'Ana', 'Sánchez', 'ana.sanchez@example.com', 'qwerty','8888888888','www.img.com'),
  (DEFAULT, 'Pedro', 'Gómez', 'pedro.gomez@example.com', 'password','55555555555','www.img.com');

-- Insertar datos en la tabla publicaciones
INSERT INTO publicaciones (id_publicacion, id_usuario, tipo_publicacion, fecha_publicacion, interaccion)
VALUES
  (DEFAULT, 1, 'foto', '2024-05-20', 'like'),
  (DEFAULT, 2, 'video', '2024-05-19', 'comment'),
  (DEFAULT, 3, 'texto', '2024-05-18', 'share');

-- Insertar datos en la tabla seguidores
-- Juan sigue a María y Carlos
-- María sigue a Ana
INSERT INTO seguidores (id_usuario, id_seguidor)
VALUES
  (1, 2),
  (1, 3),
  (2, 4);