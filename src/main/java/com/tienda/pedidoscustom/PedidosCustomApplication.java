package com.tienda.pedidoscustom;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class PedidosCustomApplication {

	public static void main(String[] args) {
		SpringApplication.run(PedidosCustomApplication.class, args);
	}

}
