package com.example.demo.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.IFacturaRepo;
import com.example.demo.repository.modelo.Detalle_Factura;
import com.example.demo.repository.modelo.FacturaReporte;

import jakarta.transaction.Transactional;
import jakarta.transaction.Transactional.TxType;

@Service
public class DetalleFacturaServiceImpl implements IDetalleFacturaService{
	@Autowired
	private IFacturaRepo iFacturaRepo;

	@Override
	@Transactional(value = TxType.REQUIRED)
	public List<FacturaReporte> buscaPorFecha(LocalDateTime fechaVenta, String categoria, Integer cantidad) {
	

		return null;
	}
}
