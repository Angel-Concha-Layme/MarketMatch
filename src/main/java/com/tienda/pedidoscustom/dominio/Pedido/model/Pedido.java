package com.tienda.pedidoscustom.dominio.Pedido.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.tienda.pedidoscustom.dominio.Pedido.dto.PedidoFumulario;
import com.tienda.pedidoscustom.dominio.Usuario.model.Usuario;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "pedidos_custom")
@Entity(name = "Pedidos_custom")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "nombre")
    private String nombre;
    @Column(name = "precio")
    private BigDecimal precio;
    @Column(name = "fecha_entrega")
    private LocalDate fechaEntrega;
    @Column(name = "url_producto")
    private String urlProducto;
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "url_imagen")
    private String urlImagen;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private StatusPedido status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_username")
    private Usuario usuario;

    public Pedido(PedidoFumulario pedidoFumulario) {
        this.nombre = pedidoFumulario.nombre();
        this.urlProducto = pedidoFumulario.urlProducto();
        this.urlImagen = pedidoFumulario.urlImagen();
        this.descripcion = pedidoFumulario.descripcion();
        this.precio = new BigDecimal("0");
        this.fechaEntrega = null;
        this.status = StatusPedido.ESPERANDO;
    }
}
