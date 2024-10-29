package com.walter.example.entidades;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data

    public class DetalleFactura {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @ManyToOne
        @JoinColumn(name = "factura_id")
        private Factura factura;

        @ManyToOne
        @JoinColumn(name = "producto_id")
        private Producto producto;

        private int cantidad;
        private double precioUnitario;
}

