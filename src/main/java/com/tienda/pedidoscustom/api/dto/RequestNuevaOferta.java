package com.tienda.pedidoscustom.api.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public record RequestNuevaOferta(Long id, BigDecimal precio, LocalDate fechaEntrega, String comentario){}
