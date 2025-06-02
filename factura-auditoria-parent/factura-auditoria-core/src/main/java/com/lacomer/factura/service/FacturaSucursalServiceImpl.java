package com.lacomer.factura.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lacomer.factura.dto.SucursalDTO;
import com.lacomer.factura.smt.dao.FacturaSucursalDao;

@Service
public class FacturaSucursalServiceImpl implements FacturaSucursalService {

	 @Autowired
	    private FacturaSucursalDao sucursalRepository;

	    @Override
	    public List<SucursalDTO> obtenerSucursales() {
	        return sucursalRepository.obtenerSucursales();
	    }

}