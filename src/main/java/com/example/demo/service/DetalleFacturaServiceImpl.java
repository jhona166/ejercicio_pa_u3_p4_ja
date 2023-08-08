package com.example.demo.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.IFacturaRepo;
import com.example.demo.repository.modelo.Detalle_Factura;
import com.example.demo.repository.modelo.FacturaReporte;

import jakarta.transaction.Transactional;
import jakarta.transaction.Transactional.TxType;

@Service
public class DetalleFacturaServiceImpl implements IDetalleFacturaService{
	@Autowired
	private IFacturaRepo iFacturaRepo;

	@Override
	@Transactional(value = TxType.REQUIRED)
	public List<FacturaReporte> buscaPorFecha(LocalDateTime fechaVenta, String categoria, Integer cantidad) {
		List<FacturaReporte> detalles = this.iFacturaRepo.buscaPorFechaCantidad(fechaVenta, cantidad);
		List<FacturaReporte> reporteVentas = new ArrayList<>();
		for (Detalle_Factura d : detalles) {
			if(d.getProducto().getCategoria().equals(categoria)) {
				FacturaReporte factura = new FacturaReporte();
				factura.setCodigoBarras(d.getProducto().getCodigoBarra());
				factura.setNombre(d.getProducto().getNombre());
				factura.setCantidad(d.getCantidad());
				factura.setPrecioUnitario(d.getPrecioUnitario());
				factura.setSubtotal(d.getSubtotal());
				reporteVentas.add(factura);
			}
		}

		return reporteVentas;
	}
}
