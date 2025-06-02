package com.lacomer.factura.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class UserAltaOrBajaRequestDTO {
	
	@NotBlank(message = "El campo 'login' no puede estar vacío")
	private String login;
	@NotBlank(message = "El campo 'email' no puede estar vacío")
	private String email;
	@NotBlank(message = "El campo 'usuarioModifica' no puede estar vacío")
	private String usuarioModifica;
	@NotNull(message = "El campo 'estatus' no puede estar nulo")
	private Integer estatus;
	
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
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return the usuarioModifica
	 */
	public String getUsuarioModifica() {
		return usuarioModifica;
	}
	/**
	 * @param usuarioModifica the usuarioModifica to set
	 */
	public void setUsuarioModifica(String usuarioModifica) {
		this.usuarioModifica = usuarioModifica;
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
