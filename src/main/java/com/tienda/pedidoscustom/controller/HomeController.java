package com.tienda.pedidoscustom.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tienda.pedidoscustom.dominio.Pedido.dto.DetallesModelo;
import com.tienda.pedidoscustom.dominio.Pedido.model.StatusPedido;
import com.tienda.pedidoscustom.dominio.Pedido.service.PedidoService;

@Controller
@RequestMapping("/home")
public class HomeController {

    @Autowired
    private PedidoService pedidoService;

    @GetMapping
    public String home(Model model, Principal principal) {
        List<DetallesModelo> pedidoDTO = pedidoService.findByStatus(StatusPedido.ENTREGADO);
        model.addAttribute("pedidos", pedidoDTO);
        return "home";
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public String onError() {
        return "redirect:/home";
    }
}
