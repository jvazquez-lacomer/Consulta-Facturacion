package com.lacomer.factura.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class SolicitudFacturasUsuarioRequestDTO {
   
	@NotNull(message = "El campo 'usuario' no puede estar vacío")
    private Long usuario;  
    private String folio;
    private String fecha;
    private String razonSocial;
    
	/**
	 * @return the usuario
	 */
	public Long getUsuario() {
		return usuario;
	}
	/**
	 * @param usuario the usuario to set
	 */
	public void setUsuario(Long usuario) {
		this.usuario = usuario;
	}
	/**
	 * @return the folio
	 */
	public String getFolio() {
		return folio;
	}
	/**
	 * @param folio the folio to set
	 */
	public void setFolio(String folio) {
		this.folio = folio;
	}
	/**
	 * @return the fecha
	 */
	public String getFecha() {
		return fecha;
	}
	/**
	 * @param fecha the fecha to set
	 */
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	/**
	 * @return the razonSocial
	 */
	public String getRazonSocial() {
		return razonSocial;
	}
	/**
	 * @param razonSocial the razonSocial to set
	 */
	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}
    
    
}