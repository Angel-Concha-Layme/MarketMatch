package com.tienda.pedidoscustom.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.tienda.pedidoscustom.dominio.Pedido.dto.PedidoFumulario;
import com.tienda.pedidoscustom.dominio.Pedido.model.Pedido;
import com.tienda.pedidoscustom.dominio.Pedido.repository.PedidoRepository;
import com.tienda.pedidoscustom.dominio.Usuario.model.Usuario;
import com.tienda.pedidoscustom.dominio.Usuario.repository.UsuarioRepository;

@Controller
@RequestMapping("/pedido")
public class PedidoController {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private UsuarioRepository UsuarioRepository;

    @GetMapping("/formulario")
    public String nuevoPedidoFormulario() {
        return "pedido/formulario";
    }

    @PostMapping("/nuevo")
    public String nuevoPedido(PedidoFumulario pedidoFumulario) {

        String username = SecurityContextHolder.getContext().getAuthentication().getName();

        Usuario usuario = UsuarioRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("No se encontro el usuario"));

        Pedido pedido = new Pedido(pedidoFumulario);
        pedido.setUsuario(usuario);

        pedidoRepository.save(pedido);

        return "redirect:/home";
    }
}
