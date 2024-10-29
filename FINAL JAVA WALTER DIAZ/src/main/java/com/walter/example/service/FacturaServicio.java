package com.walter.example.service;

import com.walter.example.entidades.DetalleFactura;
import com.walter.example.entidades.Factura;
import com.walter.example.entidades.Producto;
import com.walter.example.excepciones.StockInsuficiente;
import com.walter.example.excepciones.NoEncontrado;
import com.walter.example.modelo.RequerimientoFactura;
import com.walter.example.modelo.LineaFactura;
import com.walter.example.repository.RepositorioFactura;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;



@Service



public class FacturaServicio{

    @Autowired
    private ServicioProducto servicioProducto;

    @Autowired
    private RepositorioFactura facturaRepository;

    private static final Logger log = LoggerFactory.getLogger(FacturaServicio.class);

    public Factura crearNuevaFactura(Factura factura, RequerimientoFactura requerimientoFactura) {

        double total = 0;



        List<DetalleFactura> detallesFactura = new ArrayList<>();

        for (LineaFactura linea : requerimientoFactura.getLineas()) {

            Producto producto = servicioProducto.findById(linea.getProductoId()).orElseThrow(() -> new NoEncontrado("Producto no encontrado"));

            if (producto.getCantidad() < linea.getCantidad()) {

                throw new StockInsuficiente("Stock insuficiente para el producto " + producto.getId());

            }

            DetalleFactura detalle = new DetalleFactura();

            detalle.setProducto(producto);

            detalle.setCantidad(linea.getCantidad());

            detalle.setPrecioUnitario(linea.getPrecioUnitario());

            detalle.setFactura(factura);

            detallesFactura.add(detalle);

            total += linea.getCantidad() * linea.getPrecioUnitario();

        }



        factura.setDetallesFactura(detallesFactura);

        factura.setTotal(total);

        factura.setFecha(new Date());

        return facturaRepository.save(factura);

    }

}

