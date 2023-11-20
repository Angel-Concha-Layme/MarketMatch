package com.tienda.pedidoscustom.api;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tienda.pedidoscustom.api.dto.RequestNuevaOferta;
import com.tienda.pedidoscustom.dominio.Oferta.model.Oferta;
import com.tienda.pedidoscustom.dominio.Oferta.repository.OfertaRepository;
import com.tienda.pedidoscustom.dominio.Pedido.model.Pedido;
import com.tienda.pedidoscustom.dominio.Pedido.repository.PedidoRepository;
import com.tienda.pedidoscustom.dominio.Usuario.model.Usuario;
import com.tienda.pedidoscustom.dominio.Usuario.repository.UsuarioRepository;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("api/ofertas")
@AllArgsConstructor
public class OfertasRest {
    private final UsuarioRepository usuarioRepository;
    private final PedidoRepository pedidoRepository;
    private final OfertaRepository ofertaRepository;

    @PostMapping  
    private Oferta creaOferta(@RequestBody RequestNuevaOferta requestNuevaOferta){
        String usernameLogueado = SecurityContextHolder.getContext().getAuthentication().getName();

        Usuario usuario = usuarioRepository.findByUsername(usernameLogueado).orElseThrow(() -> new UsernameNotFoundException(" No se encontro el usuario " + usernameLogueado));
        
        Pedido pedido = pedidoRepository.findById(requestNuevaOferta.id()).orElseThrow(() -> new RuntimeException("No se encontro el pedido " + requestNuevaOferta.id()));

        Oferta nuevaOferta =  Oferta.builder()
            .fechaEntrega(requestNuevaOferta.fechaEntrega())
            .precio(requestNuevaOferta.precio())
            .comentario(requestNuevaOferta.comentario())
            .pedido(pedido)
            .usuario(usuario)
            .build();

        ofertaRepository.save(nuevaOferta);

        return nuevaOferta;
    }
    
}
