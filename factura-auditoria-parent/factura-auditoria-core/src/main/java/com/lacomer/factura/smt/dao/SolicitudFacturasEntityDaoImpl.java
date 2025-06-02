package com.lacomer.factura.smt.dao;
import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;

import org.springframework.stereotype.Repository;

import com.lacomer.factura.dto.SolicitudFacturaRequestDTO;

@Repository
public class SolicitudFacturasEntityDaoImpl implements SolicitudFacturasEntityDao {

	@PersistenceContext(unitName = "primary")
    private EntityManager entityManager;

    @Override
    public String crearFolioSolicitud(SolicitudFacturaRequestDTO reques) {
        StoredProcedureQuery query = entityManager.createStoredProcedureQuery("SP_INSERTA_SOLICITUD_FACTURAS");

        query.registerStoredProcedureParameter("p_rfc", String.class, ParameterMode.IN);
        query.registerStoredProcedureParameter("p_id_proveedor", Long.class, ParameterMode.IN);
        query.registerStoredProcedureParameter("p_usuario_solicita", String.class, ParameterMode.IN);
        query.registerStoredProcedureParameter("p_motivo", String.class, ParameterMode.IN);

        query.registerStoredProcedureParameter("p_id_solicitud", Long.class, ParameterMode.OUT);
        query.registerStoredProcedureParameter("p_folio_solicitud", String.class, ParameterMode.OUT);

        query.setParameter("p_rfc", reques.getRfc());
        query.setParameter("p_id_proveedor", reques.getIdProveedor());
        query.setParameter("p_usuario_solicita", reques.getUsuario());
        query.setParameter("p_motivo", reques.getMotivo());

        query.execute();

        return (String) query.getOutputParameterValue("p_folio_solicitud");
    }
    
    @Override
    public void actualizaEstatusSolicitud(String folioSolicitud, int tipoAccion, String usuario) {
        StoredProcedureQuery query = entityManager.createStoredProcedureQuery("SP_ACTUALIZA_ESTATUS_SOLICITUD");

        query.registerStoredProcedureParameter("p_folio_solicitud", String.class, ParameterMode.IN);
        query.registerStoredProcedureParameter("p_tipo_accion", Integer.class, ParameterMode.IN);
        query.registerStoredProcedureParameter("p_usuario", String.class, ParameterMode.IN);

        query.setParameter("p_folio_solicitud", folioSolicitud);
        query.setParameter("p_tipo_accion", tipoAccion);
        query.setParameter("p_usuario", usuario);

        query.execute();
    }
    
    @Override
    public String insertarSolicitudFacturasDet(SolicitudFacturaRequestDTO request, String folioSolicitud, Long codigoBarras) {
        StoredProcedureQuery query = entityManager.createStoredProcedureQuery("INSERT_SOLICITUD_FACTURAS_DET");

        query.registerStoredProcedureParameter("p_folio_solicitud", String.class, ParameterMode.IN);
        query.registerStoredProcedureParameter("p_codigo_barras", Long.class, ParameterMode.IN);
        query.registerStoredProcedureParameter("p_sucursal", Integer.class, ParameterMode.IN);
        query.registerStoredProcedureParameter("p_rfc", String.class, ParameterMode.IN);
        query.registerStoredProcedureParameter("p_id_proveedor", Long.class, ParameterMode.IN);
        query.registerStoredProcedureParameter("p_mensaje_out", String.class, ParameterMode.OUT);

        query.setParameter("p_folio_solicitud", folioSolicitud);
        query.setParameter("p_codigo_barras", codigoBarras);
        query.setParameter("p_sucursal", request.getSucursal());
        query.setParameter("p_rfc", request.getRfc());
        query.setParameter("p_id_proveedor", request.getIdProveedor());

        query.execute();

        return (String) query.getOutputParameterValue("p_mensaje_out");
    }

}