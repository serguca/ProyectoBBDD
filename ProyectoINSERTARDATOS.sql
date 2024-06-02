USE proyectoDB;

-- Insertar datos en la tabla usuarios
INSERT INTO usuarios (nombre, apellido, correo, contrasenia, telefono, imagen)
VALUES 
  ('Juan', 'Perez', 'juan@example.com', 'contrasenia1', '123456789', 'imagen1.jpg'),
  ('Maria', 'Gomez', 'maria@example.com', 'contrasenia2', '987654321', 'imagen2.jpg'),
  ('Pedro', 'Martinez', 'pedro@example.com', 'contrasenia3', '456123789', 'imagen3.jpg'),
  ('Laura', 'Lopez', 'laura@example.com', 'contrasenia4', '789456123', 'imagen4.jpg');

-- Insertar datos en la tabla publicaciones
INSERT INTO publicaciones (usuario_id, tipo_publicacion, fecha_publicacion, interaccion)
VALUES 
  (1, 'foto', '2024-06-01', 'like'),
  (2, 'video', '2024-05-30', 'comment'),
  (3, 'texto', '2024-05-28', 'share'),
  (4, 'foto', '2024-05-26', 'like');

-- Insertar datos en la tabla seguidores
INSERT INTO seguidores (seguidor_id, seguido_id)
VALUES 
  (1, 2),
  (2, 3),
  (3, 4),
  (4, 1);

-- Insertar datos en la tabla notificaciones
INSERT INTO notificaciones (usuario_id, fecha_notificacion)
VALUES 
  (1, '2024-06-02'),
  (2, '2024-06-01'),
  (3, '2024-05-31'),
  (4, '2024-05-30');
