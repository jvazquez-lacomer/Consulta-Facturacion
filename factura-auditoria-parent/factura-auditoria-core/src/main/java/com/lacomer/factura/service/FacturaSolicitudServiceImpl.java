package com.lacomer.factura.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import com.lacomer.factura.dto.FacturasAprobacionRequestDTO;
import com.lacomer.factura.dto.FacturasAprobacionResponseDTO;
import com.lacomer.factura.dto.SolicitudFacturaAprOrRechRequestDTO;
import com.lacomer.factura.dto.SolicitudFacturaRequestDTO;
import com.lacomer.factura.dto.SolicitudFacturasUsuarioRequestDTO;
import com.lacomer.factura.exception.NoContentException;
import com.lacomer.factura.smt.dao.SolicitudFacturasEntityDao;
import com.lacomer.factura.smt.dao.SolicitudFacturasJpaDao;
import com.lacomer.factura.smt.entity.SolicitudFacturasEntity;

@Component
public class FacturaSolicitudServiceImpl implements FacturaSolicitudService {

	@Autowired
	private SolicitudFacturasJpaDao repository;
	
	@Autowired
    private SolicitudFacturasEntityDao solicitudFacturaDao;

	@Override
	public Page<FacturasAprobacionResponseDTO> consultarSolicitudesAprobar(FacturasAprobacionRequestDTO request,
			Pageable pageable) {

		Page<FacturasAprobacionResponseDTO> solicitudes = repository.consultarSolicitudesAprobar(request.getFolio(),
				request.getDescripcionUsuario(), request.getFecha(), pageable);

		if (solicitudes.hasContent()) {
			return solicitudes;
		} else {
			throw new NoContentException("No existen solciitudes con los parámetros indicados");
		}
	}

	@Override
	public Page<SolicitudFacturasEntity> consultarSolicitudesUsuario(SolicitudFacturasUsuarioRequestDTO request,
			Pageable pageable) {

		Page<SolicitudFacturasEntity> solicitudes = repository.consultarSolicitudesUsuario(request.getUsuario(),
				request.getFolio(), request.getFecha(), request.getRazonSocial(), pageable);

		if (solicitudes.hasContent()) {
			return solicitudes;
		} else {
			throw new NoContentException("No existen solciitudes con los parámetros indicados");
		}
	}
	
	@Override
	public String actualizaEstadoSolicitud(SolicitudFacturaAprOrRechRequestDTO request) {
		repository.actualizarEstatusSolicitud(request.getFolio(), request.getEstatus(), request.getUsuario());
		
		 if (request.getEstatus() == 2) {
			 return "El folio " + request.getFolio() + " fue Aprobado.";
		 }else if (request.getEstatus() == 3) {
			 return "El folio " + request.getFolio() + " fue Rechazado.";
		 }
		 
		 return null;
	}
		
	@Override
    public String crearSolicitudFactura(SolicitudFacturaRequestDTO request) {
		
		// 1. Crear el folio de solicitud
	    String folioSolicitud = solicitudFacturaDao.crearFolioSolicitud(request);

	    // 2. Insertar detalles por cada código de barras
	    for (Long codigoBarras : request.getCodigosBarras()) {
	        solicitudFacturaDao.insertarSolicitudFacturasDet(request, folioSolicitud, codigoBarras);
	        // Puedes manejar el mensaje si lo necesitas
	    }

	    // 3. Actualizar el estatus de la solicitud
	    solicitudFacturaDao.actualizaEstatusSolicitud(folioSolicitud, 1,  request.getUsuario());

	    return folioSolicitud;
	    
	}

}
