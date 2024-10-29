package com.walter.example.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.walter.example.excepciones.StockInsuficiente;
import com.walter.example.entidades.Factura;
import com.walter.example.entidades.Producto;
import com.walter.example.modelo.RequerimientoFactura;
import com.walter.example.service.FacturaServicio;
import com.walter.example.service.ServicioProducto;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class ControladorProducto {

    @Autowired
    private ServicioProducto servicioProducto;

    @Autowired
    private FacturaServicio facturaServicio;

    @PostMapping ("/facturas")
    public ResponseEntity<Factura> crearFactura (@RequestBody RequerimientoFactura requerimientoFactura) {
        Factura factura = new Factura();
        factura = facturaServicio.crearNuevaFactura(factura, requerimientoFactura);
        return ResponseEntity.status(HttpStatus.CREATED).body(factura);
    }

    // Obtener todos los productos
    @GetMapping("/productos")
    public ResponseEntity<List<Producto>> getAllProducts() {
        return ResponseEntity.ok(servicioProducto.findAll());
    }

    // Obtener un producto por ID
    @GetMapping("/productos/{id}")
    public ResponseEntity<Producto> getProductById(@PathVariable Long id) {
        return servicioProducto.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @ExceptionHandler(StockInsuficiente.class)
    public ResponseEntity<String> handleInsufficientStockException(StockInsuficiente
                                                                           ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());

    }
}
