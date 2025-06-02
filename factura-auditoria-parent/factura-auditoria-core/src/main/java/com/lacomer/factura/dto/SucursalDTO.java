package com.lacomer.factura.dto;

public class SucursalDTO {
    private Integer idSucursal;
    private String sucursal;

    public SucursalDTO(Integer idSucursal, String sucursal) {
        this.idSucursal = idSucursal;
        this.sucursal = sucursal;
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

	/**
	 * @return the sucursal
	 */
	public String getSucursal() {
		return sucursal;
	}

	/**
	 * @param sucursal the sucursal to set
	 */
	public void setSucursal(String sucursal) {
		this.sucursal = sucursal;
	}

    // getters y setters
}
