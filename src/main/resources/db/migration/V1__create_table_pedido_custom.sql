CREATE TABLE pedidos_custom (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    descripcion VARCHAR(255),
    fecha_entrega DATE,
    nombre VARCHAR(255),
    precio DECIMAL(38,2),
    url_imagen VARCHAR(255),
    url_producto VARCHAR(255)
)
