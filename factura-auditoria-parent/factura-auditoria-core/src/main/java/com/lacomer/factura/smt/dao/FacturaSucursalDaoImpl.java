package com.lacomer.factura.smt.dao;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.lacomer.factura.dto.SucursalDTO;

@Repository
public class FacturaSucursalDaoImpl implements FacturaSucursalDao{
	
	
	@PersistenceContext(unitName = "primary")
    private EntityManager entityManager;

	@Override
	public List<SucursalDTO> obtenerSucursales() {
		
		String sql = "SELECT ID_SUCURSAL, SUC_DES FROM SUCURSAL WHERE ID_CONCEPT_NEG IN (9,3,4,6) AND SUC_STATUS = 0 ORDER BY ID_SUCURSAL ASC";
        List<Object[]> results = entityManager.createNativeQuery(sql).getResultList();
        return results.stream()
                .map(row -> new SucursalDTO(
                        ((Number) row[0]).intValue(),
                        (String) row[1]
                ))
                .collect(Collectors.toList());
	}

}
