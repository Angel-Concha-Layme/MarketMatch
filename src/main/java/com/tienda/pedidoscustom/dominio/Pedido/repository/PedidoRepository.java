package com.tienda.pedidoscustom.dominio.Pedido.repository;

import java.util.List;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tienda.pedidoscustom.dominio.Pedido.model.Pedido;
import com.tienda.pedidoscustom.dominio.Pedido.model.StatusPedido;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {

    @Cacheable("pedidos")
    List<Pedido> findByStatus(StatusPedido status);

    @Cacheable("pedidos")
    List<Pedido> findByUsuarioUsername(String username);

    @Cacheable("pedidos")
    List<Pedido> findByUsuarioUsernameAndStatus(String name, StatusPedido estado);
}