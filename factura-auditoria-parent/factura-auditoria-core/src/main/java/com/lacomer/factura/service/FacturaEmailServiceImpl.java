package com.lacomer.factura.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lacomer.factura.smt.dao.FacturaLoginDao;
import com.lacomer.factura.smt.entity.UsuarioEntity;
import com.lacomer.factura.utils.EmailSenderUtils;

@Component
public class FacturaEmailServiceImpl implements FacturaEmailService{

	@Autowired
	private EmailSenderUtils email; 
	
	@Autowired
	private FacturaLoginDao loginDao;
	
	@Override
	public String reenviaEmail(String usuario, String correo) {
		
		UsuarioEntity usuarioEntity = loginDao.validaExisteUsuario(usuario, correo);
		
		email.enviarCorreo(correo, usuarioEntity.getPassword());
		
		return "Finaliza";
	}

}
