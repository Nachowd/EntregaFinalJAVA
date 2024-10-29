package com.walter.example.entidades;
import jakarta.persistence.*;
import lombok.Data;


@Data
@Entity
@Table(name = "productos")

public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    private String name;
    private double price;
    private int cantidad;

}
