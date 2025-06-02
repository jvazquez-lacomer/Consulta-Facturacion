package com.lacomer.factura.dto;

public class UserBusquedaRequestDTO {
	
	private String nombreUsuario;
	private String login;
	private Integer rol;
	private Integer estatus;
	
	/**
	 * @return the nombreUsuario
	 */
	public String getNombreUsuario() {
		return nombreUsuario;
	}
	/**
	 * @param nombreUsuario the nombreUsuario to set
	 */
	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}
	/**
	 * @return the login
	 */
	public String getLogin() {
		return login;
	}
	/**
	 * @param login the login to set
	 */
	public void setLogin(String login) {
		this.login = login;
	}
	/**
	 * @return the rol
	 */
	public Integer getRol() {
		return rol;
	}
	/**
	 * @param rol the rol to set
	 */
	public void setRol(Integer rol) {
		this.rol = rol;
	}
	/**
	 * @return the estatus
	 */
	public Integer getEstatus() {
		return estatus;
	}
	/**
	 * @param estatus the estatus to set
	 */
	public void setEstatus(Integer estatus) {
		this.estatus = estatus;
	}
	
		

}
