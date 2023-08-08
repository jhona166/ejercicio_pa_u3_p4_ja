package com.example.demo.repository;

import java.time.LocalDateTime;
import java.util.List;

import com.example.demo.repository.modelo.Detalle_Factura;

public interface IDetalleFacturaRepo {
	public List<Detalle_Factura> buscaPorFecha(LocalDateTime fechaVenta,String categoria, Integer cantidad);


}
