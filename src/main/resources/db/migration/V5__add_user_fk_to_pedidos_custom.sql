
ALTER TABLE pedidos_custom ADD COLUMN usuario_username VARCHAR(50);

ALTER TABLE pedidos_custom
ADD CONSTRAINT fk_pedidos_custom_users
FOREIGN KEY (usuario_username) REFERENCES users(username);
