package com.lacomer.factura.smt.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.lacomer.factura.dto.SucursalDTO;

@Repository
public interface FacturaSucursalDao {

	public List<SucursalDTO> obtenerSucursales();
	
}
