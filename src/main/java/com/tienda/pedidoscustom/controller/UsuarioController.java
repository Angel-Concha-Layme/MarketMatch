package com.tienda.pedidoscustom.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tienda.pedidoscustom.dominio.Pedido.dto.DetallesModelo;
import com.tienda.pedidoscustom.dominio.Pedido.model.StatusPedido;
import com.tienda.pedidoscustom.dominio.Pedido.service.PedidoService;
import org.springframework.ui.Model;

@Controller
@RequestMapping("usuario")
public class UsuarioController {
    @Autowired
    PedidoService pedidoService;

    @GetMapping("pedido")
    public String home(Model model, Principal principal) {
        List<DetallesModelo> pedidoDTO = pedidoService.obtenerPedidosPorUsuario(principal.getName());
        model.addAttribute("pedidos", pedidoDTO);
        return "usuario/home";
    }

    @GetMapping("pedido/filtrar")
    public String filtrarPorStatus(@RequestParam(name = "status") String status, Model model, Principal principal) {
        try {
            StatusPedido estado = StatusPedido.valueOf(status.toUpperCase());

            List<DetallesModelo> pedidoDTO = pedidoService.obtenerPedidosPorUsuarioYEstado(principal.getName(), estado);
            model.addAttribute("pedidos", pedidoDTO);
        } catch (IllegalArgumentException e) {
            model.addAttribute("error", "Estado no válido");
            return "usuario/home";
        }
        return "usuario/home";
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public String onError() {
        return "redirect:/usuario/home";
    }
}
