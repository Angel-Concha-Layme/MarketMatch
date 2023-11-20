CREATE TABLE ofertas (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    fecha_entrega DATE, 
    precio DECIMAL(38,2),
    comentario VARCHAR(255),
    pedido_id BIGINT,
    FOREIGN KEY (pedido_id) REFERENCES pedidos_custom(id)
);
