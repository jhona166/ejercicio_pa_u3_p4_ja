package com.example.demo.service;

import com.example.demo.repository.modelo.Producto;
import com.example.demo.repository.modelo.ProductoConsulta;

public interface IProductoService {
	public void ingresarProducto(Producto producto);
	public ProductoConsulta buscarPorCodigo(String codigo);


}
