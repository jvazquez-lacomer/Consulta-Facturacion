package com.lacomer.factura.smt.dao;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.lacomer.factura.dto.FacturasAprobacionResponseDTO;
import com.lacomer.factura.smt.entity.SolicitudFacturasEntity;

@Repository
public interface SolicitudFacturasJpaDao extends CrudRepository<SolicitudFacturasEntity, Long> {

	
	@Query("SELECT new com.lacomer.factura.dto.FacturasAprobacionResponseDTO(s, u.nombreUsuario) "
	        + "FROM SolicitudFacturasEntity s JOIN UsuarioEntity u ON s.usuarioSolicita = u.login WHERE "
	        + "(:folio IS NULL OR s.folioSolicitud = :folio) AND "
	        + "(:descripcionUsuario IS NULL OR LOWER(u.nombreUsuario) LIKE LOWER(CONCAT('%', :descripcionUsuario, '%'))) AND "
	        + "(:fecha IS NULL OR TRUNC(s.fechaCreacion) = TO_DATE(:fecha, 'DD/MM/YYYY')) AND "
	        + "s.estatus = 1 "
	        + "ORDER BY s.fechaCreacion ASC, s.idSolicitud ASC")
	public Page<FacturasAprobacionResponseDTO> consultarSolicitudesAprobar(
	    @Param("folio") String folio,
	    @Param("descripcionUsuario") String descripcionUsuario,
	    @Param("fecha") String fecha,
	    Pageable pageable
	);
	
	@Query("SELECT s FROM SolicitudFacturasEntity s WHERE "
	        + "(:usuario IS NULL OR s.usuarioSolicita = :usuario) AND "
	        + "(:folio IS NULL OR s.folioSolicitud = :folio) AND "
	        + "(:fecha IS NULL OR TRUNC(s.fechaCreacion) = TO_DATE(:fecha, 'DD/MM/YYYY')) AND "
	        + "(:razonSocial IS NULL OR LOWER(s.razonSocial) LIKE LOWER('%'|| :razonSocial || '%'))"
	        + "ORDER BY s.fechaCreacion ASC, s.idSolicitud ASC")
	public Page<SolicitudFacturasEntity> consultarSolicitudesUsuario(
	        @Param("usuario") Long usuario,
	        @Param("folio") String folio,
	        @Param("razonSocial") String razonSocial,
	        @Param("fecha") String fecha,
	        Pageable pageable);
	
	 public Optional<SolicitudFacturasEntity> findByFolioSolicitud(String folioSolicitud);
	 
	 @Procedure(name = "SP_ACTUALIZA_ESTATUS_SOLICITUD")
	 public void actualizarEstatusSolicitud(
		        @Param("p_folio_solicitud") String folio,
		        @Param("p_tipo_accion") Integer tipoAccion,
		        @Param("p_usuario") Long usuario
		    );
}
