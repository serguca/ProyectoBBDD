INSERT INTO usuarios (nombre, apellido, correo, contrasenia, telefono, imagen) VALUES
('Juan', 'Pérez', 'juan.perez@example.com', 'password123', '1234567890', 'juan.png'),
('María', 'García', 'maria.garcia@example.com', 'password456', '0987654321', 'maria.png'),
('Carlos', 'Ramírez', 'carlos.ramirez@example.com', 'password789', '1122334455', 'carlos.png'),
('Ana', 'López', 'ana.lopez@example.com', 'password321', '5566778899', 'ana.png');

INSERT INTO seguidores (id_usuario, id_seguidor) VALUES
(5, 6),
(5, 7),
(5, 8);