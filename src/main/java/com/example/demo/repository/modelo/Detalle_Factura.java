package com.example.demo.repository.modelo;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name="detalle_factura")
@NamedQuery(name = "DetalleFactura.buscarPorFechaCantidad", query = "SELECT d FROM Detalle_Factura d.fecha=:datoFecha")
public class Detalle_Factura {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_detalle")
	@SequenceGenerator(name = "seq_detalle", sequenceName = "seq_detalle", allocationSize = 1)
	@Column(name = "detalle_id")
	private Integer id;
	
	@Column(name = "defa_cantidad")
	private Integer cantidad;

	@Column(name = "defa_precio_unitario")
	private BigDecimal precioUnitario;

	@Column(name = "defa_subtotal")
	private BigDecimal subtotal;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "defa_id_producto")
	private Producto producto;

	@ManyToOne
	@JoinColumn(name = "defa_id_venta")
	private Factura factura;

	@Override
	public String toString() {
		return "Detalle_Factura [id=" + id + ", cantidad=" + cantidad + ", precioUnitario=" + precioUnitario
				+ ", subtotal=" + subtotal + "]";
	}

	
	// SET Y GET
	public Integer getId() {
		return id;
	}

	

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public BigDecimal getPrecioUnitario() {
		return precioUnitario;
	}

	public void setPrecioUnitario(BigDecimal precioUnitario) {
		this.precioUnitario = precioUnitario;
	}

	public BigDecimal getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(BigDecimal subtotal) {
		this.subtotal = subtotal;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}


	public Factura getFactura() {
		return factura;
	}


	public void setFactura(Factura factura) {
		this.factura = factura;
	}

	
	
	
	
	
}
