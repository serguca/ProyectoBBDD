-- Crear tabla de usuarios
CREATE TABLE users (
  id INT AUTO_INCREMENT PRIMARY KEY,
  username VARCHAR(50) NOT NULL UNIQUE,
  email VARCHAR(120) NOT NULL UNIQUE,
  password VARCHAR(100) NOT NULL,
  created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Crear tabla de seguidores
CREATE TABLE followers (
  id INT AUTO_INCREMENT PRIMARY KEY,
  follower_id INT NOT NULL,
  followed_id INT NOT NULL,
  created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  FOREIGN KEY (follower_id) REFERENCES users(id),
  FOREIGN KEY (followed_id) REFERENCES users(id)
);

-- Crear tabla de publicaciones
CREATE TABLE posts (
  id INT AUTO_INCREMENT PRIMARY KEY,
  user_id INT NOT NULL,
  content TEXT NOT NULL,
  created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  FOREIGN KEY (user_id) REFERENCES users(id)
);

-- Crear tabla de notificaciones
CREATE TABLE notifications (
  id INT AUTO_INCREMENT PRIMARY KEY,
  user_id INT NOT NULL,
  message TEXT NOT NULL,
  created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  FOREIGN KEY (user_id) REFERENCES users(id)
);

-- Insertar usuarios de ejemplo
INSERT INTO users (username, email, password)
VALUES
  ('usuario1', 'usuario1@example.com', 'password1'),
  ('usuario2', 'usuario2@example.com', 'password2'),
  ('usuario3', 'usuario3@example.com', 'password3'),
  ('usuario4', 'usuario4@example.com', 'password4');

-- Insertar seguidores de ejemplo
INSERT INTO followers (follower_id, followed_id)
VALUES
  (1, 2),
  (1, 3),
  (2, 1),
  (2, 3),
  (3, 1),
  (3, 2),
  (3, 4),
  (4, 3);

-- Insertar publicaciones de ejemplo
INSERT INTO posts (user_id, content)
VALUES
  (1, 'Hola, soy usuario1'),
  (1, 'Estoy de buen humor hoy'),
  (2, 'Hola, soy usuario2'),
  (2, 'Estoy estudiando para un examen'),
  (3, 'Hola, soy usuario3'),
  (3, 'Estoy disfrutando de un fin de semana relajado'),
  (4, 'Hola, soy usuario4'),
  (4, 'Estoy planeando un viaje');

-- Insertar notificaciones de ejemplo
INSERT INTO notifications (user_id, message)
VALUES
  (1, 'Tienes un nuevo seguidor'),
  (2, 'Tienes un nuevo mensaje'),
  (3, 'Tienes un nuevo post'),
  (4, 'Tienes un nuevo comentario');