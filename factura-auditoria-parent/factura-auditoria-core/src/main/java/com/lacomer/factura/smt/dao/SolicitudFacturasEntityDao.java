package com.lacomer.factura.smt.dao;

import org.springframework.stereotype.Repository;

import com.lacomer.factura.dto.SolicitudFacturaRequestDTO;

@Repository
public interface SolicitudFacturasEntityDao    {
	
	public String crearFolioSolicitud(SolicitudFacturaRequestDTO reques);

	public void actualizaEstatusSolicitud(String folioSolicitud, int tipoAccion, String usuario);

	public String insertarSolicitudFacturasDet(SolicitudFacturaRequestDTO request, String folioSolicitud, 
			Long codigoBarras);
	
}
