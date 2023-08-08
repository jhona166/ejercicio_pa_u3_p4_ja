package com.example.demo.service;

import java.time.LocalDateTime;
import java.util.List;

import com.example.demo.repository.modelo.Factura;
import com.example.demo.repository.modelo.FacturaReporte;

public interface IDetalleFacturaService {
	public List<FacturaReporte> buscaPorFecha(LocalDateTime fechaVenta, String categoria, Integer cantidad);
}
