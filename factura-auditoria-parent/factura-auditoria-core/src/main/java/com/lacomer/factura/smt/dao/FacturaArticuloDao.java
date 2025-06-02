package com.lacomer.factura.smt.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public interface FacturaArticuloDao    {
	
	public List<Object[]> buscarArticulo(Long codigoBarras, String descripcionArticulo);
}
