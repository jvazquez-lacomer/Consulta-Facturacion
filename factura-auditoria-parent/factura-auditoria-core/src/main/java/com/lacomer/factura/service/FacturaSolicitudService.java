package com.lacomer.factura.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.lacomer.factura.dto.FacturasAprobacionRequestDTO;
import com.lacomer.factura.dto.FacturasAprobacionResponseDTO;
import com.lacomer.factura.dto.SolicitudFacturaAprOrRechRequestDTO;
import com.lacomer.factura.dto.SolicitudFacturaRequestDTO;
import com.lacomer.factura.dto.SolicitudFacturasUsuarioRequestDTO;
import com.lacomer.factura.smt.entity.SolicitudFacturasEntity;

public interface FacturaSolicitudService {

	public Page<FacturasAprobacionResponseDTO> consultarSolicitudesAprobar(FacturasAprobacionRequestDTO request,Pageable pageable);
	
	public Page<SolicitudFacturasEntity> consultarSolicitudesUsuario(SolicitudFacturasUsuarioRequestDTO request,Pageable pageable);
	
	public String actualizaEstadoSolicitud(SolicitudFacturaAprOrRechRequestDTO request);
	
	public String crearSolicitudFactura(SolicitudFacturaRequestDTO request);

}
