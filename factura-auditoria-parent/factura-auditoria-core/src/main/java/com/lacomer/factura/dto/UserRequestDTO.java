package com.lacomer.factura.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class UserRequestDTO {
	
	@NotBlank(message = "El campo 'login' no puede estar vacío")
	private String login;
	@NotBlank(message = "El campo 'nombreUsuario' no puede estar vacío")
	private String nombreUsuario;
	@NotBlank(message = "El campo 'email' no puede estar vacío")
	private String email;
	@NotNull(message = "El campo 'tipoUsuario' no puede ser nulo")
	private Integer tipoUsuario;
	@NotBlank(message = "El campo 'usuarioAlta' no puede estar vacío")
	private String usuarioAlta;
	private Integer idSucursal;
	
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getNombreUsuario() {
		return nombreUsuario;
	}
	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Integer getTipoUsuario() {
		return tipoUsuario;
	}
	public void setTipoUsuario(Integer tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}
	/**
	 * @return the usuarioAlta
	 */
	public String getUsuarioAlta() {
		return usuarioAlta;
	}
	/**
	 * @param usuarioAlta the usuarioAlta to set
	 */
	public void setUsuarioAlta(String usuarioAlta) {
		this.usuarioAlta = usuarioAlta;
	}
	/**
	 * @return the idSucursal
	 */
	public Integer getIdSucursal() {
		return idSucursal;
	}
	/**
	 * @param idSucursal the idSucursal to set
	 */
	public void setIdSucursal(Integer idSucursal) {
		this.idSucursal = idSucursal;
	}
	
}
