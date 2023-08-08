package com.example.demo.repository;

import com.example.demo.repository.modelo.Producto;

public interface IProductoRepo {
	public void insertar(Producto producto);
	public void actualizar(Producto producto);
	public Producto buscarPorCodigoBarras(String codigo);
	public Producto buscarPorCodigo(String codigo);
	
	
}
