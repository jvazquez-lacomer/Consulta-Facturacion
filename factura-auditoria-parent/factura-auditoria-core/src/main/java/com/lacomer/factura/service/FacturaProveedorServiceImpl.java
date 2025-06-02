package com.lacomer.factura.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lacomer.factura.dto.ProveedorDTO;
import com.lacomer.factura.exception.NoContentException;
import com.lacomer.factura.smt.dao.FacturaProveedorDao;

@Component
public class FacturaProveedorServiceImpl implements FacturaProveedorService{

	@Autowired
	private FacturaProveedorDao repository;
	
	
	@Override
	public List<ProveedorDTO> buscarProveedor(Long idProveedor, String proDescripcion) {
        List<ProveedorDTO> resultado = repository.buscarProveedor(idProveedor, proDescripcion)
            .stream()
            .map(arr -> new ProveedorDTO(
                (Long.valueOf(arr[0].toString())),
                (String) arr[1]
            ))
            .collect(Collectors.toList());

        if (resultado.isEmpty()) {
            throw new NoContentException("No existe el proveedor solciitado " + "ID_proveedor: " + idProveedor + " Descripcion: " +  proDescripcion );
        }

        return resultado;
    }

}
