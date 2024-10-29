package com.walter.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.walter.example.entidades.Producto;
import com.walter.example.repository.ProductoRepositorio;

import java.util.List;
import java.util.Optional;

@Service
public class ServicioProducto {
    @Autowired
    private ProductoRepositorio productoRepository;

    // Método para encontrar todos los productos.
    public List<Producto> findAll() {
        return productoRepository.findAll();
    }

    public Optional<Producto> findById(Long id) {
        return productoRepository.findById(id);
    }

    // Método para calcular el total de una lista de productos
    public Double calcularTotal(List<Producto> productos) {
        double total = 0;
        for (Producto producto : productos) {
            total += producto.getPrice() * producto.getCantidad();
        }
        return total;
    }
}

