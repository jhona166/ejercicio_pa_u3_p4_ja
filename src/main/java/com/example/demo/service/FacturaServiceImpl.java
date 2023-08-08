package com.example.demo.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.IFacturaRepo;
import com.example.demo.repository.IProductoRepo;
import com.example.demo.repository.modelo.Detalle_Factura;
import com.example.demo.repository.modelo.Factura;
import com.example.demo.repository.modelo.Producto;
import com.example.demo.repository.modelo.ProductoEscogido;

import jakarta.transaction.Transactional;
import jakarta.transaction.Transactional.TxType;

@Service 
public class FacturaServiceImpl implements IFacturaService{
	@Autowired
	private IFacturaRepo iFacturaRepo;

	@Autowired
	private IProductoRepo iProductoRepo;

	@Override
	@Transactional(value = TxType.REQUIRED)
	public void realizarFactura(List<ProductoEscogido> productos, String cedulaCliente) {

		Factura fact = new Factura();
		fact.setCedulaCliente(cedulaCliente);
		fact.setFecha(LocalDateTime.now());

		BigDecimal montoPago = new BigDecimal(0);
		List<Detalle_Factura> detalles = new ArrayList<Detalle_Factura>();

		for (ProductoEscogido productoSolicitado : productos) {
			Producto producto = this.iProductoRepo.buscarPorCodigoBarras(productoSolicitado.getCodigoBarras());
			if (producto.getStock() == 0) {
				throw new RuntimeException();
			}

			if (producto.getStock() <= productoSolicitado.getCantidad()) {
				productoSolicitado.setCantidad(producto.getStock());
			}
			Detalle_Factura detalle = new Detalle_Factura();
			detalle.setProducto(producto);
			detalle.setCantidad(productoSolicitado.getCantidad());
			detalle.setPrecioUnitario(producto.getPrecio());
			detalle.setSubtotal(producto.getPrecio().multiply(new BigDecimal(productoSolicitado.getCantidad())));
			detalle.setFactura(fact);
			detalles.add(detalle);

			montoPago = montoPago.add(detalle.getSubtotal());
			Integer totalFinal=producto.getStock() - productoSolicitado.getCantidad();
			producto.setStock(totalFinal);
			this.iProductoRepo.actualizar(producto);
		}

		fact.setDetalles(detalles);
		fact.setTotalVenta(montoPago);

		this.iFacturaRepo.insertar(fact);
		
	}
}
