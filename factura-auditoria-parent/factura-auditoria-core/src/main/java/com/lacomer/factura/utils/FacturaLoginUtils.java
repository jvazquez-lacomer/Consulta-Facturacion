package com.lacomer.factura.utils;

/**
 * Interfaz para la generación de tokens JWT en la aplicación de Factura.
 * 
 * <p>Esta interfaz define el contrato para generar tokens JWT que incluyen el nombre de usuario
 * y otras reclamaciones adicionales. </p>
 * 
 * @author [jvazquez]
 * @version 1.0.0
 * @since 2025-02-19
 */
public interface FacturaLoginUtils {
    
	/**
	 * Genera un token JWT para el nombre de usuario dado.
	 *
	 * Este método crea un token JWT que incluye el nombre de usuario y otras reclamaciones adicionales.
	 * El token se firma utilizando el algoritmo HS512 y una clave secreta.
	 *
	 * @param username el nombre de usuario para el cual se genera el token
	 * @return un token JWT como una cadena de texto con un prefijo personalizado
	 */
	public String getJWTToken(String username);
}

