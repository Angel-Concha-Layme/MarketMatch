ALTER TABLE ofertas ADD COLUMN usuario_username VARCHAR(50);
ALTER TABLE ofertas ADD CONSTRAINT fk_ofertas_users FOREIGN KEY (usuario_username) REFERENCES users(username);
