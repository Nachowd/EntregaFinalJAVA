package com.walter.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.walter.example.entidades.Producto;

public interface ProductoRepositorio extends JpaRepository<Producto,Long>{ }

