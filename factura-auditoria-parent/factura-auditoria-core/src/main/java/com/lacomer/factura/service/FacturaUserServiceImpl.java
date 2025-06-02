package com.lacomer.factura.service;


import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import com.lacomer.factura.dto.UserActualizaPwdRequestDTO;
import com.lacomer.factura.dto.UserAltaOrBajaRequestDTO;
import com.lacomer.factura.dto.UserBusquedaRequestDTO;
import com.lacomer.factura.dto.UserRequestDTO;
import com.lacomer.factura.dto.UserResponseDTO;
import com.lacomer.factura.exception.BusinessException;
import com.lacomer.factura.exception.NoContentException;
import com.lacomer.factura.smt.dao.FacturaLoginDao;
import com.lacomer.factura.smt.entity.UsuarioEntity;
import com.lacomer.factura.utils.EmailSenderUtils;
import com.lacomer.factura.utils.FacturaUtils;

@Component
public class FacturaUserServiceImpl implements FacturaUserService {
	
	@Autowired
	private FacturaLoginDao loginDao;
	
	@Autowired
	private FacturaUtils facturaUtils;
	@Autowired
	private  EmailSenderUtils emailUtils;

	@Override
	public UserResponseDTO crearUsuario(UserRequestDTO usuario) {

		UserResponseDTO usuarioResponse = new UserResponseDTO();
		UsuarioEntity entityUser = new UsuarioEntity();

		UsuarioEntity valida = loginDao.validaExisteUsuario(usuario.getLogin(), usuario.getEmail());

		if (valida == null) {
			entityUser.setLogin(usuario.getLogin());
			entityUser.setNombreUsuario(usuario.getNombreUsuario());
			entityUser.setCorreo(usuario.getEmail());
			entityUser.setTipoUsuario(usuario.getTipoUsuario());
			entityUser.setPassword(facturaUtils.generarContrasenaTemporal());
			entityUser.setEstatus(1);
			entityUser.setFechaCreacion(new Date());
			entityUser.setModificaPass(0);
			entityUser.setUsuarioAlta(usuario.getUsuarioAlta());
			entityUser.setIdSucursal(usuario.getIdSucursal());

			loginDao.save(entityUser);
			
			emailUtils.enviarCorreo(usuario.getEmail(), entityUser.getPassword());
			usuarioResponse.setMensaje("Usuario registrado correctamente");
		}
		else {
			throw new BusinessException("El usuario o correo ya existe, favor de verificar."); 
		}

		return usuarioResponse;
	}
	
	@Override
	public UserResponseDTO altaOrBajaUsuario(UserAltaOrBajaRequestDTO usuario) {
		UserResponseDTO usuarioResponse = new UserResponseDTO();
		
		UsuarioEntity usuarioEntity = loginDao.validaExisteUsuario(usuario.getLogin(), usuario.getEmail());
		
		usuarioEntity.setEstatus(usuario.getEstatus());
		
		if(usuario.getEstatus() == 0) {
			usuarioEntity.setFechaBaja(new Date());
			usuarioEntity.setUsuarioBaja(usuario.getUsuarioModifica());
		}else if(usuario.getEstatus() == 1) {
			usuarioEntity.setFechaModificacion(new Date());
			usuarioEntity.setUsuarioModifica(usuario.getUsuarioModifica());
		}
		
		loginDao.save(usuarioEntity);
		
		if(usuario.getEstatus() == 0) {
			usuarioResponse.setMensaje("El usuario " + usuario.getLogin() + " fue dado de baja.");
		}else if(usuario.getEstatus() == 1) {
			usuarioResponse.setMensaje("El usuario " + usuario.getLogin() + " fue activado.");
		}
		
		return usuarioResponse;
	}
	
	@Override
	public Page<UsuarioEntity> consultaUsuarios(UserBusquedaRequestDTO usuario, Pageable pageable) {
		
	    Page<UsuarioEntity> usuarios = loginDao.buscarUsuarios(usuario.getNombreUsuario(), usuario.getLogin(), usuario.getRol(), usuario.getEstatus(), pageable);

	    if (usuarios.hasContent()) {
	        return usuarios;
	    } else {
	        throw new NoContentException("No existen usuarios con los parámetros indicados");
	    }
	}

	@Override
	public String actualizaPWD(UserActualizaPwdRequestDTO usuario) {
		UsuarioEntity usuarioEntity = loginDao.validaExisteUsuario(usuario.getUsuario(), usuario.getEmail());
		
		if(usuarioEntity != null) {
			usuarioEntity.setModificaPass(1);
			usuarioEntity.setPassword(usuario.getNuevoPwd());
		}
		
		loginDao.save(usuarioEntity);
		
		return "Finaliza";
	}

}
