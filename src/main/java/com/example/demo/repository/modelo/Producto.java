package com.example.demo.repository.modelo;

import java.math.BigDecimal;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name="producto")
public class Producto {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_producto")
	@SequenceGenerator(name = "seq_producto", sequenceName = "seq_producto", allocationSize = 1)
	@Column(name = "prod_id")
	private Integer id;
	
	@Column(name = "prod_codigo_barras")
	private String codigoBarra;

	@Column(name = "prod_nombre")
	private String nombre;

	@Column(name = "prod_categoria")
	private String categoria;

	@Column(name = "prod_stock")
	private Integer stock;

	@Column(name = "prod_precio")
	private BigDecimal precio;

	@OneToMany(mappedBy = "producto", fetch = FetchType.LAZY)
	private List<Detalle_Factura> detalles;

	@Override
	public String toString() {
		return "Producto [id=" + id + ", codigoBarra=" + codigoBarra + ", nombre=" + nombre + ", categoria=" + categoria
				+ ", stock=" + stock + ", precio=" + precio + "]";
	}

	// SET Y GET
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCodigoBarra() {
		return codigoBarra;
	}

	public void setCodigoBarra(String codigoBarra) {
		this.codigoBarra = codigoBarra;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

	public BigDecimal getPrecio() {
		return precio;
	}

	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}

	public List<Detalle_Factura> getDetalles() {
		return detalles;
	}

	public void setDetalles(List<Detalle_Factura> detalles) {
		this.detalles = detalles;
	}



}
