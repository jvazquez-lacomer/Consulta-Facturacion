package com.lacomer.factura.dto;

public class ArticuloDTO {
	
	private Long codigobarras;
	private String descripcionArticulo;

	public ArticuloDTO(Long codigobarras, String descripcionArticulo) {
        this.codigobarras = codigobarras;
        this.descripcionArticulo = descripcionArticulo;
    }

	/**
	 * @return the codigobarras
	 */
	public Long getCodigobarras() {
		return codigobarras;
	}

	/**
	 * @param codigobarras the codigobarras to set
	 */
	public void setCodigobarras(Long codigobarras) {
		this.codigobarras = codigobarras;
	}

	/**
	 * @return the descripcionArticulo
	 */
	public String getDescripcionArticulo() {
		return descripcionArticulo;
	}

	/**
	 * @param descripcionArticulo the descripcionArticulo to set
	 */
	public void setDescripcionArticulo(String descripcionArticulo) {
		this.descripcionArticulo = descripcionArticulo;
	}

	
	
}
