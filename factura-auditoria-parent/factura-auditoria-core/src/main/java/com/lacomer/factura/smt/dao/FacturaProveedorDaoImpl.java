package com.lacomer.factura.smt.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

@Repository
public class FacturaProveedorDaoImpl implements FacturaProveedorDao{
	
	
	@PersistenceContext(unitName = "primary")
    private EntityManager entityManager;

	@Override
	public List<Object[]> buscarProveedor(Long idProveedor, String proDes) {
	    String sql = "SELECT ID_PROVEEDOR, PRO_DES FROM smt.proveedor WHERE 1=1"
	               + (idProveedor != null ? " AND ID_PROVEEDOR = :idProveedor" : "")
	               + (proDes != null && !proDes.isEmpty() ? " AND UPPER(PRO_DES) LIKE '%' || UPPER(:proDes) || '%'" : "");

	    Query query = entityManager.createNativeQuery(sql);

	    if (idProveedor != null) {
	        query.setParameter("idProveedor", idProveedor);
	    }
	    if (proDes != null && !proDes.isEmpty()) {
	        query.setParameter("proDes", proDes);
	    }

	    return query.getResultList();
	}
}
