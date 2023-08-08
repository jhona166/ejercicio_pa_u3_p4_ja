package com.example.demo;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.repository.modelo.FacturaReporte;
import com.example.demo.repository.modelo.Producto;
import com.example.demo.repository.modelo.ProductoConsulta;
import com.example.demo.repository.modelo.ProductoEscogido;
import com.example.demo.service.IDetalleFacturaService;
import com.example.demo.service.IFacturaService;
import com.example.demo.service.IProductoService;

@SpringBootApplication
public class EjercicioPaU3P4JaApplication implements CommandLineRunner {
	
	private static Logger LOG = Logger.getLogger(EjercicioPaU3P4JaApplication.class);
	
	@Autowired
	private IProductoService iProductoService;

	@Autowired
	private IFacturaService iFacturaService;

	@Autowired
	private IDetalleFacturaService iDetalleFacturaService;

	public static void main(String[] args) {
		SpringApplication.run(EjercicioPaU3P4JaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
				
				//a
				//1
				Producto prod1 = new Producto();
				prod1.setNombre("Omeprazol");
				prod1.setCodigoBarra("001");
				prod1.setCategoria("Varios");
				prod1.setPrecio(new BigDecimal(2.00));
				prod1.setStock(12);
				this.iProductoService.ingresarProducto(prod1);
				//2
				Producto prod2 = new Producto();
				prod2.setNombre("Lemonflu");
				prod2.setCodigoBarra("002");
				prod2.setCategoria("Antigripales");
				prod2.setPrecio(new BigDecimal(1.60));
				prod2.setStock(16);
				this.iProductoService.ingresarProducto(prod2);

				//b
				ProductoEscogido prode1 = new ProductoEscogido();
				prode1.setCantidad(4);
				prod1.setCodigoBarra("001");

				ProductoEscogido prode2 = new ProductoEscogido();
				prode2.setCantidad(6);
				prod1.setCodigoBarra("002");
				
				List<ProductoEscogido> productos = new ArrayList<ProductoEscogido>();
				productos.add(prode1);
				productos.add(prode2);
				
				

				this.iFacturaService.realizarFactura(productos, "1727501510");

				ProductoConsulta pc = this.iProductoService.buscarPorCodigo("001");

				LOG.info("Producto Consulta Stock: " + pc);

				LocalDateTime fecha = LocalDateTime.now();

				List<FacturaReporte> reporteVentas = this.iDetalleFacturaService.buscaPorFecha(fecha, "Varios", 2);
				reporteVentas.forEach(v -> LOG.info("Venta: " + v));
	}

}
