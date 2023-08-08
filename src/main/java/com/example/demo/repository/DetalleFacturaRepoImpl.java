package com.example.demo.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.repository.modelo.Detalle_Factura;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import jakarta.transaction.Transactional.TxType;
@Repository
@Transactional
public class DetalleFacturaRepoImpl implements IDetalleFacturaRepo{
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	@Transactional(value = TxType.NOT_SUPPORTED)
	public List<Detalle_Factura> buscaPorFecha(LocalDateTime fechaVenta,String categoria, Integer cantidad) {
		TypedQuery<Detalle_Factura> myquery = this.entityManager.createNamedQuery("DetalleVenta.buscarPorFecha",
				Detalle_Factura.class);
		myquery.setParameter("fecha", fechaVenta);
		myquery.setParameter("categoria", categoria);
		myquery.setParameter("datoCantidad", cantidad);
		List<Detalle_Factura> detalles_factura = myquery.getResultList();
		for (Detalle_Factura d : detalles_factura) {
			d.getProducto().getNombre();
		}
		return detalles_factura;
	}

}
