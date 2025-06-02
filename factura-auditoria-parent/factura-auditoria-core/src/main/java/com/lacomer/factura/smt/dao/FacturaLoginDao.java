package com.lacomer.factura.smt.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.lacomer.factura.smt.entity.UsuarioEntity;

@Repository
public interface FacturaLoginDao extends CrudRepository<UsuarioEntity, Long> {

	@Query("SELECT u FROM UsuarioEntity u WHERE u.login = :usuario AND u.password = :psw")
	public UsuarioEntity consultaUsuario(@Param("usuario") String usuario, @Param("psw") String psw);

	@Query("SELECT u FROM UsuarioEntity u WHERE u.login = :usuario or u.correo = :correo ")
	public UsuarioEntity validaExisteUsuario(@Param("usuario") String usuario, @Param("correo") String correo);

	@Query("SELECT u FROM UsuarioEntity u WHERE "
			+ "(:nombreUsuario IS NULL OR u.nombreUsuario LIKE %:nombreUsuario%) AND "
			+ "(:login IS NULL OR u.login = :login) AND " + "(:rol IS NULL OR u.tipoUsuario = :rol) AND "
			+ "(:estatus IS NULL OR u.estatus = :estatus)")
	public Page<UsuarioEntity> buscarUsuarios(@Param("nombreUsuario") String nombreUsuario,
			@Param("login") String login, @Param("rol") Integer rol, @Param("estatus") Integer estatus,
			Pageable pageable);

}
