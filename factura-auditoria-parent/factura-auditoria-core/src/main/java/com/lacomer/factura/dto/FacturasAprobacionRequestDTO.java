package com.lacomer.factura.dto;

public class FacturasAprobacionRequestDTO {
   
	private String folio;
	private String descripcionUsuario;
	private String fecha;
	
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
	 * @return the descripcionUsuario
	 */
	public String getDescripcionUsuario() {
		return descripcionUsuario;
	}
	/**
	 * @param descripcionUsuario the descripcionUsuario to set
	 */
	public void setDescripcionUsuario(String descripcionUsuario) {
		this.descripcionUsuario = descripcionUsuario;
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
	

}