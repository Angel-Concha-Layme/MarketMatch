package com.tienda.pedidoscustom.dominio.Oferta.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tienda.pedidoscustom.dominio.Oferta.model.Oferta;

public interface OfertaRepository extends JpaRepository<Oferta, Long>{
}