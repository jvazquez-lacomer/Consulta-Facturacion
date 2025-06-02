package com.lacomer.factura.dto;
import javax.validation.constraints.NotBlank;

public class LoginRequestDTO {
	
	@NotBlank(message = "El campo 'user' no puede estar vacío")
	private String user;
	@NotBlank(message = "El campo 'pass' no puede estar vacío")
	private String pass;

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}


}
