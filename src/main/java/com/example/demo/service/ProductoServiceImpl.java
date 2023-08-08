package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.IProductoRepo;
import com.example.demo.repository.modelo.Producto;
import com.example.demo.repository.modelo.ProductoConsulta;
import com.example.demo.repository.modelo.ProductoEscogido;

import jakarta.transaction.Transactional;
import jakarta.transaction.Transactional.TxType;

@Service
public class ProductoServiceImpl implements IProductoService{
	@Autowired
	private IProductoRepo iProductoRepo;

	@Override
	@Transactional(value = TxType.REQUIRED)
	public void ingresarProducto(Producto producto) {
		Producto prod = new Producto();
		boolean vacio = false;
		try {
			prod = this.iProductoRepo.buscarPorCodigoBarras(producto.getCodigoBarra());
		} catch (Exception e) {
			vacio = true;
		}
		if (vacio) {
			this.iProductoRepo.insertar(producto);
		} else {
			prod.setStock(prod.getStock() + producto.getStock());
			this.iProductoRepo.actualizar(prod);
		}
	}

	@Override
	@Transactional(value = TxType.REQUIRED)
	public ProductoConsulta buscarPorCodigo(String codigo) {
		Producto p = this.iProductoRepo.buscarPorCodigo(codigo);

		ProductoConsulta pcon = new ProductoConsulta();
		pcon.setCodigoBarra(p.getCodigoBarra());
		pcon.setNombre(p.getNombre());
		pcon.setStock(p.getStock());

		return pcon;
	}

}
