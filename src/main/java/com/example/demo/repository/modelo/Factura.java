package com.example.demo.repository.modelo;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.CascadeType;
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
@Table(name="factura")
public class Factura {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_factura")
	@SequenceGenerator(name = "seq_factura", sequenceName = "seq_factura", allocationSize = 1)
	@Column(name = "fact_id")
	private Integer id;

	@Column(name = "fact_fecha")
	private LocalDateTime fecha;

	@Column(name = "fact_cedula_cliente")
	private String cedulaCliente;

	@Column(name = "fact_total")
	private BigDecimal totalVenta;


	@Override
	public String toString() {
		return "Factura [id=" + id + ", fecha=" + fecha + ", cedulaCliente=" + cedulaCliente + ", totalVenta="
				+ totalVenta + ", detalles=" + detalles + "]";
	}

	@OneToMany(mappedBy = "factura", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Detalle_Factura> detalles;

	
	//Set and Get
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}


	public LocalDateTime getFecha() {
		return fecha;
	}

	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}

	public String getCedulaCliente() {
		return cedulaCliente;
	}

	public void setCedulaCliente(String cedulaCliente) {
		this.cedulaCliente = cedulaCliente;
	}

	public BigDecimal getTotalVenta() {
		return totalVenta;
	}

	public void setTotalVenta(BigDecimal totalVenta) {
		this.totalVenta = totalVenta;
	}

	public List<Detalle_Factura> getDetalles() {
		return detalles;
	}

	public void setDetalles(List<Detalle_Factura> detalles) {
		this.detalles = detalles;
	}



}
