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
FOREIGN KEY (publicaciones) REFERENCES publicaciones(id_publicacion);
FOREIGN KEY (seguidores) REFERENCES seguidores(id_seguidor);



-- Insertar datos en la tabla usuarios
INSERT INTO usuarios (nombre, apellido, correo, contrasenia, telefono, imagen, publicaciones, seguidores) VALUES
('Juan', 'Pérez', 'juan.perez@example.com', 'password123', '1234567890', 'juan.png', '1,2', '2,3'),
('María', 'García', 'maria.garcia@example.com', 'password456', '0987654321', 'maria.png', '3,4', '1'),
('Carlos', 'Ramírez', 'carlos.ramirez@example.com', 'password789', '1122334455', 'carlos.png', '5', '1,3'),
('Ana', 'López', 'ana.lopez@example.com', 'password321', '5566778899', 'ana.png', '', '2,4');

-- Insertar datos en la tabla publicaciones
INSERT INTO publicaciones (id_usuario, tipo_publicacion, fecha_publicacion, interaccion) VALUES
(1, 'foto', '2024-05-01', 'like'),
(1, 'video', '2024-05-02', 'comentario'),
(2, 'estado', '2024-05-03', 'compartir'),
(2, 'foto', '2024-05-04', 'like'),
(3, 'video', '2024-05-05', 'comentario');

-- Insertar datos en la tabla seguidores
INSERT INTO seguidores (id_usuario, id_seguidor) VALUES
(1, 2),
(1, 3),
(2, 1),
(3, 1),
(3, 2),
(4, 1),
(4, 2);

-- Insertar datos en la tabla notificaciones
INSERT INTO notificaciones (id_usuario, tipo_notificacion, fecha_notificacion) VALUES
(1, 'comentario', '2024-05-01'),
(1, 'like', '2024-05-02'),
(2, 'compartir', '2024-05-03'),
(2, 'comentario', '2024-05-04'),
(3, 'like', '2024-05-05');
