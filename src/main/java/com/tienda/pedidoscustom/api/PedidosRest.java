package com.tienda.pedidoscustom.api;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.tienda.pedidoscustom.dominio.Pedido.model.Pedido;
import com.tienda.pedidoscustom.dominio.Pedido.model.StatusPedido;
import com.tienda.pedidoscustom.dominio.Pedido.repository.PedidoRepository;
import com.tienda.pedidoscustom.dominio.Usuario.model.Usuario;
import com.tienda.pedidoscustom.dominio.Usuario.repository.UsuarioRepository;

@RestController
@RequestMapping("api/pedidos")
public class PedidosRest {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping("esperando")
    public List<Pedido> getPedidosEsperandoOfertas() {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();

        Optional<Usuario> usuarioOptional = usuarioRepository.findByUsername(username);

        if (usuarioOptional.isPresent()) {
            Usuario usuario = usuarioOptional.get();
            return pedidoRepository.findByStatusAndUsuarioNot(StatusPedido.ESPERANDO, usuario);
        } else {
            return Collections.emptyList();
        }
    }

}
