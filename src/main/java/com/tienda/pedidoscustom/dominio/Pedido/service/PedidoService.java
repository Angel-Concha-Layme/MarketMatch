package com.tienda.pedidoscustom.dominio.Pedido.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tienda.pedidoscustom.dominio.Pedido.dto.DetallesModelo;
import com.tienda.pedidoscustom.dominio.Pedido.model.Pedido;
import com.tienda.pedidoscustom.dominio.Pedido.model.StatusPedido;
import com.tienda.pedidoscustom.dominio.Pedido.repository.PedidoRepository;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    public List<DetallesModelo> obtenerPedidos() {
        List<Pedido> pedidos = pedidoRepository.findAll();

        return pedidos.stream().map(this::convertirPedidoDetallesDTO).filter(p -> p != null)
                .collect(Collectors.toList());

    }

    private DetallesModelo convertirPedidoDetallesDTO(Pedido pedido) {

        if (pedido.getNombre() == null || pedido.getDescripcion() == null || pedido.getUrlImagen() == null
                || pedido.getUrlProducto() == null || pedido.getPrecio() == BigDecimal.ZERO
                || pedido.getFechaEntrega() == null) {

            return null;
        }

        DetallesModelo detallesModelo = new DetallesModelo(pedido.getNombre(), pedido.getDescripcion(),
                pedido.getUrlImagen(), pedido.getUrlProducto(), pedido.getPrecio().toString(),
                pedido.getFechaEntrega().toString());
        return detallesModelo;

    }

    public List<DetallesModelo> obtenerPedidosPorStatus(StatusPedido status) {
        List<Pedido> pedidos = pedidoRepository.findByStatus(status);

        return pedidos.stream().map(this::convertirPedidoDetallesDTO).filter(p -> p != null)
                .collect(Collectors.toList());
    }

    public List<DetallesModelo> obtenerPedidosPorUsuario(String username) {
        List<Pedido> pedidos = pedidoRepository.findByUsuarioUsername(username);

        return pedidos.stream().map(this::convertirPedidoDetallesDTO).filter(p -> p != null)
                .collect(Collectors.toList());
    }

    public List<DetallesModelo> obtenerPedidosPorUsuarioYEstado(String name, StatusPedido estado) {
        List<Pedido> pedidos = pedidoRepository.findByUsuarioUsernameAndStatus(name, estado);

        return pedidos.stream().map(this::convertirPedidoDetallesDTO).filter(p -> p != null)
                .collect(Collectors.toList());
    }

    public List<DetallesModelo> findAll() {
        List<Pedido> pedidos = pedidoRepository.findAll();

        return pedidos.stream().map(this::convertirPedidoDetallesDTO).filter(p -> p != null)
                .collect(Collectors.toList());
    }

    public List<DetallesModelo> findByStatus(StatusPedido entregado) {
        List<Pedido> pedidos = pedidoRepository.findByStatus(entregado);

        return pedidos.stream().map(this::convertirPedidoDetallesDTO).filter(p -> p != null)
                .collect(Collectors.toList());
    }

}
