package com.lacomer.factura.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lacomer.factura.dto.ArticuloDTO;
import com.lacomer.factura.exception.NoContentException;
import com.lacomer.factura.smt.dao.FacturaArticuloDao;

@Component
public class FacturaArticuloServiceImpl implements FacturaArticuloService{

	@Autowired
	private FacturaArticuloDao repository;
	
	
	@Override
	public List<ArticuloDTO> buscarArticulo(Long codigoBarras, String articuloDescripcion ) {
        List<ArticuloDTO> articulos = repository.buscarArticulo(codigoBarras, articuloDescripcion)
            .stream()
            .map(arr -> new ArticuloDTO(
                (Long.valueOf(arr[0].toString())),
                (String) arr[1]
            ))
            .collect(Collectors.toList());

        if (articulos.isEmpty()) {
            throw new NoContentException("No existe el articulo solciitado " + "codigo_barras: " + codigoBarras + " Descripcion: " +  articuloDescripcion );
        }

        return articulos;
    }

}
