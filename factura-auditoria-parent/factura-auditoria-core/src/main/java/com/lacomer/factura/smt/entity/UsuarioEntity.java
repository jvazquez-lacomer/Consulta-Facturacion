package com.lacomer.factura.smt.entity;
import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "USUARIO_FACTURACION")
public class UsuarioEntity {

	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "usuario_seq")
    @SequenceGenerator(name = "usuario_seq", sequenceName = "SEQ_USUARIO_FACTURACION", allocationSize = 1)
    @Column(name = "ID_USUARIO", nullable = false)
    private Long idUsuario;
	
    @Column(name = "LOGIN", length = 12, nullable = false)
    private String login;

    @Column(name = "NOMBRE_USUARIO", length = 100, nullable = false)
    private String nombreUsuario;

    @Column(name = "TIPO_USUARIO", nullable = false)
    private int tipoUsuario;

    @Column(name = "PASSWORD", length = 20, nullable = false)
    private String password;

    @Column(name = "ESTATUS", nullable = false)
    private int estatus;

    @Column(name = "FECHA_CREACION")
    @Temporal(TemporalType.DATE)
    private Date fechaCreacion;

    @Column(name = "FECHA_MODIFICACION")
    @Temporal(TemporalType.DATE)
    private Date fechaModificacion;

    @Column(name = "FECHA_BAJA")
    @Temporal(TemporalType.DATE)
    private Date fechaBaja;

    @Column(name = "USUARIO_ALTA", length = 12)
    private String usuarioAlta;

    @Column(name = "USUARIO_BAJA", length = 12)
    private String usuarioBaja;

    @Column(name = "USUARIO_MODIFICA", length = 12)
    private String usuarioModifica;

    @Column(name = "FECHA_ULTIMA_SESION")
    @Temporal(TemporalType.DATE)
    private Date fechaUltimaSesion;

    @Column(name = "CORREO", length = 50)
    private String correo;
    
    @Column(name = "MODIFICA_PASS", length = 1)
    private Integer modificaPass;

    @Column(name = "ID_SUCURSAL", length = 3)
    private Integer idSucursal;

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
	 * @return the tipoUsuario
	 */
	public int getTipoUsuario() {
		return tipoUsuario;
	}

	/**
	 * @param tipoUsuario the tipoUsuario to set
	 */
	public void setTipoUsuario(int tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the estatus
	 */
	public int getEstatus() {
		return estatus;
	}

	/**
	 * @param estatus the estatus to set
	 */
	public void setEstatus(int estatus) {
		this.estatus = estatus;
	}

	/**
	 * @return the fechaCreacion
	 */
	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	/**
	 * @param fechaCreacion the fechaCreacion to set
	 */
	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	/**
	 * @return the fechaModificacion
	 */
	public Date getFechaModificacion() {
		return fechaModificacion;
	}

	/**
	 * @param fechaModificacion the fechaModificacion to set
	 */
	public void setFechaModificacion(Date fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}

	/**
	 * @return the fechaBaja
	 */
	public Date getFechaBaja() {
		return fechaBaja;
	}

	/**
	 * @param fechaBaja the fechaBaja to set
	 */
	public void setFechaBaja(Date fechaBaja) {
		this.fechaBaja = fechaBaja;
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
	 * @return the usuarioBaja
	 */
	public String getUsuarioBaja() {
		return usuarioBaja;
	}

	/**
	 * @param usuarioBaja the usuarioBaja to set
	 */
	public void setUsuarioBaja(String usuarioBaja) {
		this.usuarioBaja = usuarioBaja;
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
	 * @return the fechaUltimaSesion
	 */
	public Date getFechaUltimaSesion() {
		return fechaUltimaSesion;
	}

	/**
	 * @param fechaUltimaSesion the fechaUltimaSesion to set
	 */
	public void setFechaUltimaSesion(Date fechaUltimaSesion) {
		this.fechaUltimaSesion = fechaUltimaSesion;
	}

	/**
	 * @return the correo
	 */
	public String getCorreo() {
		return correo;
	}

	/**
	 * @param correo the correo to set
	 */
	public void setCorreo(String correo) {
		this.correo = correo;
	}

	/**
	 * @return the modificaPass
	 */
	public Integer getModificaPass() {
		return modificaPass;
	}

	/**
	 * @param modificaPass the modificaPass to set
	 */
	public void setModificaPass(Integer modificaPass) {
		this.modificaPass = modificaPass;
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
	 * @return the idUsuario
	 */
	public Long getIdUsuario() {
		return idUsuario;
	}

	/**
	 * @param idUsuario the idUsuario to set
	 */
	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}
    
}