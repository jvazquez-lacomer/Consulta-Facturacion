package com.lacomer.factura.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class UserActualizaPwdRequestDTO {
	
	@NotBlank(message = "El campo 'usuario' no puede estar vacío")
	private String usuario;
	@NotBlank(message = "El campo 'email' no puede estar vacío")
	private String email;
	@NotNull(message = "El campo 'modificaPwd' no puede ser nulo")
	private Integer modificaPwd;
	@NotBlank(message = "El campo 'nuevoPwd' no puede estar vacío")
	private String nuevoPwd;
	
	/**
	 * @return the usuario
	 */
	public String getUsuario() {
		return usuario;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @return the modificaPwd
	 */
	public Integer getModificaPwd() {
		return modificaPwd;
	}
	
	/**
	 * @param usuario the usuario to set
	 */
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @param modificaPwd the modificaPwd to set
	 */
	public void setModificaPwd(Integer modificaPwd) {
		this.modificaPwd = modificaPwd;
	}
	/**
	 * @return the nuevoPwd
	 */
	public String getNuevoPwd() {
		return nuevoPwd;
	}
	/**
	 * @param nuevoPwd the nuevoPwd to set
	 */
	public void setNuevoPwd(String nuevoPwd) {
		this.nuevoPwd = nuevoPwd;
	}
		
		
}
