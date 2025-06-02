package com.lacomer.factura.smt.entity;

import java.util.Date;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.StoredProcedureParameter;
import javax.persistence.ParameterMode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@NamedStoredProcedureQuery(
	    name = "SP_ACTUALIZA_ESTATUS_SOLICITUD",
	    procedureName = "SP_ACTUALIZA_ESTATUS_SOLICITUD",
	    parameters = {
	        @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_folio_solicitud", type = String.class),
	        @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_tipo_accion", type = Integer.class),
	        @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_usuario", type = String.class)
	    }
)
@Entity
@Table(name = "SOLICITUD_FACTURAS")
public class SolicitudFacturasEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_SOLICITUD", nullable = false)
	private Long idSolicitud;

	@Column(name = "FOLIO_SOLICITUD")
	private String folioSolicitud;

	@Column(name = "RFC")
	private String rfc;

	@Column(name = "RAZON_SOCIAL")
	private String razonSocial;

	@Column(name = "UUID")
	private String uuid;

	@Column(name = "FECHA_CREACION")
	private Date fechaCreacion;

	@Column(name = "USUARIO_SOLICITA")
	private Long usuarioSolicita;

	@Column(name = "FECHA_AUTORIZACION")
	private Date fechaAutorizacion;

	@Column(name = "FECHA_RECHAZO")
	private Date fechaRechazo;

	@Column(name = "USUARIO_AUTORIZA")
	private Long usuarioAutoriza;

	@Column(name = "USUARIO_RECHAZA")
	private Long usuarioRechaza;

	@Column(name = "ESTATUS")
	private Integer estatus;

	// Getters y Setters
	public Long getIdSolicitud() {
		return idSolicitud;
	}

	public void setIdSolicitud(Long idSolicitud) {
		this.idSolicitud = idSolicitud;
	}

	public String getFolioSolicitud() {
		return folioSolicitud;
	}

	public void setFolioSolicitud(String folioSolicitud) {
		this.folioSolicitud = folioSolicitud;
	}

	public String getRfc() {
		return rfc;
	}

	public void setRfc(String rfc) {
		this.rfc = rfc;
	}

	public String getRazonSocial() {
		return razonSocial;
	}

	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public Long getUsuarioSolicita() {
		return usuarioSolicita;
	}

	public void setUsuarioSolicita(Long usuarioSolicita) {
		this.usuarioSolicita = usuarioSolicita;
	}

	public Date getFechaAutorizacion() {
		return fechaAutorizacion;
	}

	public void setFechaAutorizacion(Date fechaAutorizacion) {
		this.fechaAutorizacion = fechaAutorizacion;
	}

	public Date getFechaRechazo() {
		return fechaRechazo;
	}

	public void setFechaRechazo(Date fechaRechazo) {
		this.fechaRechazo = fechaRechazo;
	}

	public Long getUsuarioAutoriza() {
		return usuarioAutoriza;
	}

	public void setUsuarioAutoriza(Long usuarioAutoriza) {
		this.usuarioAutoriza = usuarioAutoriza;
	}

	public Long getUsuarioRechaza() {
		return usuarioRechaza;
	}

	public void setUsuarioRechaza(Long usuarioRechaza) {
		this.usuarioRechaza = usuarioRechaza;
	}

	public Integer getEstatus() {
		return estatus;
	}

	public void setEstatus(Integer estatus) {
		this.estatus = estatus;
	}
}
