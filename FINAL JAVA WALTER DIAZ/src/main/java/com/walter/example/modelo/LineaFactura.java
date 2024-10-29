package com.walter.example.modelo;

import lombok.Data;

@Data
public class LineaFactura {
    private Long productoId;
    private Integer cantidad;
    private Double precioUnitario;

}
