package com.lacomer.factura.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class SolicitudFacturaAprOrRechRequestDTO {
   
	@NotNull(message = "El campo 'usuario' no puede estar vacío")
    private Long usuario;  
	@NotNull(message = "El campo 'estatus' no puede estar vacío")
	private Integer estatus;
	@NotBlank(message = "El campo 'folio' no puede estar vacío")
	private String folio;
	
	public String getFolio() {
		return folio;
	}
	public void setFolio(String folio) {
		this.folio = folio;
	}
	public Long getUsuario() {
		return usuario;
	}
	public void setUsuario(Long usuario) {
		this.usuario = usuario;
	}
	public Integer getEstatus() {
		return estatus;
	}
	public void setEstatus(Integer estatus) {
		this.estatus = estatus;
	}
    
	
   
    
}