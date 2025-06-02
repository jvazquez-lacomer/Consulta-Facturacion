package com.lacomer.factura.smt.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

@Repository
public class FacturaArticuloDaoImpl implements FacturaArticuloDao{
	
	
	@PersistenceContext(unitName = "primary")
    private EntityManager entityManager;

	@Override
	public List<Object[]> buscarArticulo(Long codigoBarras, String descripcionArticulo) {
	    
	    String sql = "SELECT B.ID_EAN, A.ARTI_DES FROM ARTI A, ARTI_REL B WHERE 1=1"
	    		   + (" AND A.ID_ARTICULO = B.ID_ARTICULO ")
	               + (codigoBarras != null ? " AND B.ID_ARTICULO = :codigoBarras" : "")
	               + (descripcionArticulo != null && !descripcionArticulo.isEmpty() ? " AND UPPER(A.ARTI_DES) LIKE '%' || UPPER(:descripcionArticulo) || '%'" : "");

	    Query query = entityManager.createNativeQuery(sql);

	    if (codigoBarras != null) {
	        query.setParameter("codigoBarras", codigoBarras);
	    }
	    if (descripcionArticulo != null && !descripcionArticulo.isEmpty()) {
	        query.setParameter("descripcionArticulo", descripcionArticulo);
	    }

	    return query.getResultList();
	}
}
