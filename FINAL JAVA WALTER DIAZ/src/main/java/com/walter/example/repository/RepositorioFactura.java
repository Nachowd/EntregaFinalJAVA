package com.walter.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.walter.example.entidades.Factura;

public interface RepositorioFactura extends JpaRepository<Factura, Long> {
}