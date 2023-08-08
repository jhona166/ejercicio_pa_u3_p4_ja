package com.example.demo.repository.modelo;

public class ProductoEscogido {
	private String codigoBarras;

	private Integer cantidad;

	public void ProductoEscogido() {
		
	}
	
	@Override
	public String toString() {
		return "ProductoEscogido [codigoBarras=" + codigoBarras + ", cantidad=" + cantidad + "]";
	}

	// SET Y GET
	public String getCodigoBarras() {
		return codigoBarras;
	}

	public void setCodigoBarras(String codigoBarras) {
		this.codigoBarras = codigoBarras;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

}
