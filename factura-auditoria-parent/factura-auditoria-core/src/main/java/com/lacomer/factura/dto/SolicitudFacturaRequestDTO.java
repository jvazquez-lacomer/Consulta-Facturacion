package com.lacomer.factura.dto;

import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class SolicitudFacturaRequestDTO {
	@NotBlank(message = "El RFC es obligatorio.")
    private String rfc;
    @NotNull(message = "El idProveedor es obligatorio.")
    private Long idProveedor;
    private Integer seccion;
    private Integer cantidadPiezas;
    @NotNull(message = "La lista de códigos de barras es obligatoria.")
    private List<Long> codigosBarras;
    private String motivo;
    private String uuid;
    private String usuario;
    private Integer sucursal;
    
	/**
	 * @return the rfc
	 */
	public String getRfc() {
		return rfc;
	}
	/**
	 * @param rfc the rfc to set
	 */
	public void setRfc(String rfc) {
		this.rfc = rfc;
	}

	/**
	 * @return the seccion
	 */
	public Integer getSeccion() {
		return seccion;
	}
	/**
	 * @param seccion the seccion to set
	 */
	public void setSeccion(Integer seccion) {
		this.seccion = seccion;
	}
	/**
	 * @return the cantidadPiezas
	 */
	public Integer getCantidadPiezas() {
		return cantidadPiezas;
	}
	/**
	 * @param cantidadPiezas the cantidadPiezas to set
	 */
	public void setCantidadPiezas(Integer cantidadPiezas) {
		this.cantidadPiezas = cantidadPiezas;
	}
	/**
	 * @return the codigosBarras
	 */
	public List<Long> getCodigosBarras() {
		return codigosBarras;
	}
	/**
	 * @param codigosBarras the codigosBarras to set
	 */
	public void setCodigosBarras(List<Long> codigosBarras) {
		this.codigosBarras = codigosBarras;
	}
	/**
	 * @return the motivo
	 */
	public String getMotivo() {
		return motivo;
	}
	/**
	 * @param motivo the motivo to set
	 */
	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}
	/**
	 * @return the uuid
	 */
	public String getUuid() {
		return uuid;
	}
	/**
	 * @param uuid the uuid to set
	 */
	public void setUuid(String uuid) {
		this.uuid = uuid;
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
	 * @return the usuario
	 */
	public String getUsuario() {
		return usuario;
	}
	/**
	 * @param usuario the usuario to set
	 */
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	/**
	 * @return the sucursal
	 */
	public Integer getSucursal() {
		return sucursal;
	}
	/**
	 * @param sucursal the sucursal to set
	 */
	public void setSucursal(Integer sucursal) {
		this.sucursal = sucursal;
	}
    
}
