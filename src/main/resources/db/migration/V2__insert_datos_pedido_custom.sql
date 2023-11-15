ALTER TABLE pedidos_custom
MODIFY url_imagen VARCHAR(2000),
MODIFY url_producto VARCHAR(2000);


INSERT INTO pedidos_custom (descripcion, fecha_entrega, nombre, precio, url_imagen, url_producto) VALUES
('Laptop ASUS ROG con potente procesador y tarjeta gráfica para gaming', '2023-11-15', 'Laptop ASUS ROG', 1200.00, 'https://d1zktoovjdma6n.cloudfront.net/media/catalog/product/cache/2868dafe2b4ec8474f3b444cfc8b532a/r/o/rog-strix-g15_g513rc-hn097w_1_1.png', 'https://pe.store.asus.com/rog/90nr08a5-m004j0-g513rc.html'),
('Consola de videojuegos PlayStation 5, última generación con control inalámbrico y gráficos en alta definición', '2023-12-10', 'PlayStation 5', 499.99, 'https://assetsio.reedpopcdn.com/ps5-pre-order-header.jpg?width=690&quality=75&format=jpg&dpr=2&auto=webp', 'https://www.playstation.com/es-pe/ps5/'),
('Smartphone iPhone 13, pantalla OLED, cámara de alta resolución y procesador ultrarrápido', '2023-11-20', 'iPhone 13', 999.99, 'https://www.apple.com/v/iphone-13/j/images/specs/finish_iphone13__cxzvxe2jkr8m_large.jpg', 'https://www.apple.com/la/iphone-13/specs/'),
('Auriculares inalámbricos Sony WH-1000XM4, cancelación de ruido y alta calidad de sonido', '2023-12-05', 'Sony WH-1000XM4', 349.99, 'https://pesonyb2c.vtexassets.com/arquivos/ids/209620-1600-auto?v=637323444689900000&width=1600&height=auto&aspect=true', 'https://store.sony.com.pe/wh-1000xm4/p'),
('Cafetera express DeLonghi, prepara cafés de calidad profesional en casa', '2023-11-28', 'Cafetera DeLonghi', 249.99, 'https://kitchencenter.pe/cdn/shop/products/50459_2_700x.jpg?v=1619766242', 'https://www.delonghi.com/es-es/productos/cafe/cafeteras-automaticas'),
('Tableta gráfica Wacom para diseño, superficie amplia y lápiz de alta precisión', '2023-12-15', 'Tableta Gráfica Wacom', 699.99, 'https://m.media-amazon.com/images/I/612WSFCWpmL._AC_SL1500_.jpg', 'https://www.tailoy.com.pe/tecnologia/art-technology.html?tailoyetl_999_marcav2=6409&gclid=CjwKCAjwnOipBhBQEiwACyGLujY_cLE_Hd-eDQ4RSDmaSkJtWxo6Kb8hnN7ntL1Nn30VT5kiyRYxWxoCqy4QAvD_BwE'),
('Cámara fotográfica profesional Canon EOS R5, resolución de 45 MP y grabación de video en 8K', '2023-11-30', 'Cámara Canon EOS R5', 3899.99, 'https://i1.adis.ws/i/canon/eos-r5_front_rf24-105mmf4lisusm_32c26ad194234d42b3cd9e582a21c99b?$prod-spec-hero-1by1$', 'https://www.canon.es/cameras/eos-r5/specifications/'),
('Nintendo Switch OLED Model with enhanced audio and visual features', '2023-11-08', 'Nintendo Switch OLED', 350.00, 'https://assets.nintendo.com/image/upload/f_auto/q_auto/dpr_1.0/c_scale,w_800/ncom/en_US/switch/videos/heg001-07060600/posters/oled-model', 'https://www.nintendo.com/switch/oled-model/');
