package com.lacomer.factura.smt.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public interface FacturaProveedorDao    {
	
	
	public List<Object[]> buscarProveedor(Long idProveedor, String proDes);
}
