package com.lacomer.factura.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lacomer.factura.dto.LoginRequestDTO;
import com.lacomer.factura.dto.LoginResponseDTO;
import com.lacomer.factura.exception.NoContentException;
import com.lacomer.factura.smt.dao.FacturaLoginDao;
import com.lacomer.factura.smt.entity.UsuarioEntity;
import com.lacomer.factura.utils.FacturaLoginUtils;


@Component
public class FacturaLoginServiceImpl implements FacturaLoginService {
	
	@Autowired
	private FacturaLoginDao loginDao;

	@Autowired
	private FacturaLoginUtils facturaUtils;
	
	@Override
	public LoginResponseDTO consultaUsuario(LoginRequestDTO usuario) {
		
		LoginResponseDTO usuarioResponse = null;
		UsuarioEntity usuarioEntity = loginDao.consultaUsuario(usuario.getUser(), usuario.getPass());
		
		if(usuarioEntity != null) {
			usuarioResponse = new LoginResponseDTO();
			BeanUtils.copyProperties(usuarioEntity, usuarioResponse);
			usuarioResponse.setToken(facturaUtils.getJWTToken(usuario.getUser()));     
		}else {
			throw new NoContentException("El usuario o contraseña no es correcto. User: "  + usuario.getUser() );
		}
		
		return usuarioResponse;
	}
	
	
}
