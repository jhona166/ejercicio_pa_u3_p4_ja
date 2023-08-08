package com.example.demo.service;

import java.util.List;

import com.example.demo.repository.modelo.ProductoEscogido;


public interface IFacturaService  {
	public void realizarFactura(List<ProductoEscogido> productos, String cedulaCliente);
}
