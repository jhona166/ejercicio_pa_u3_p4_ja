package com.example.demo.repository.modelo;

import java.time.LocalDateTime;

public class FacturaReporte {
	private LocalDateTime fecha;
	private String categoria;
	private String cantidad;
	public FacturaReporte(LocalDateTime fecha, String categoria, String cantidad) {
		super();
		this.fecha = fecha;
		this.categoria = categoria;
		this.cantidad = cantidad;
	}
	public void FacturaReporte() {
		
	}
	
	public LocalDateTime getFecha() {
		return fecha;
	}
	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public String getCantidad() {
		return cantidad;
	}
	public void setCantidad(String cantidad) {
		this.cantidad = cantidad;
	}
	
	
	
	
	
	
}
