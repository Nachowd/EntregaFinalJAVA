package com.walter.example.modelo;
import lombok.Data;

import java.util.List;

@Data

public class RequerimientoFactura {

    private Cliente cliente;
    private List<LineaFactura> lineas;

}
