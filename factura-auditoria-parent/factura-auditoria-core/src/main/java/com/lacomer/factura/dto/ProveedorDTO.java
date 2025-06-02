package com.lacomer.factura.dto;

public class ProveedorDTO {
	
	private Long idProveedor;
	private String proDes;

	public ProveedorDTO(Long idProveedor, String proDes) {
        this.idProveedor = idProveedor;
        this.proDes = proDes;
    }

	/**
	 * @return the idProveedor
	 */
	public Long getIdProveedor() {
		return idProveedor;
	}

	/**
	 * @param idProveedor the idProveedor to set
	 */
	public void setIdProveedor(Long idProveedor) {
		this.idProveedor = idProveedor;
	}

	/**
	 * @return the proDes
	 */
	public String getProDes() {
		return proDes;
	}

	/**
	 * @param proDes the proDes to set
	 */
	public void setProDes(String proDes) {
		this.proDes = proDes;
	}

	
	
	
	
	
	
}
