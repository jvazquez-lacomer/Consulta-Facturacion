package com.lacomer.factura.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);
	
	// Manejo de excepciones genéricas
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Map<String, Object>> handleGenericException(Exception ex, WebRequest request) {
    	logger.error("Error interno del servidor (Exception): ", ex);
        return errorResponse(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage() , "Error interno del servidor", request);
    }

    // Manejo de excepciones específicas (ejemplo: NullPointerException)
    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<Map<String, Object>> handleNullPointerException(NullPointerException ex, WebRequest request) {
    	logger.error("Dato nulo encontrado (NullPointerException):", ex);
        return errorResponse(HttpStatus.INTERNAL_SERVER_ERROR,ex.getMessage() , "Dato nulo encontrado", request);
    }

    // Manejo de excepciones de base de datos
    @ExceptionHandler(DataAccessException.class)
    public ResponseEntity<Map<String, Object>> handleDatabaseException(DataAccessException ex, WebRequest request) {
    	logger.error("Error en la base de datos (DataAccessException)", ex);
        return errorResponse(HttpStatus.INTERNAL_SERVER_ERROR, ex.getRootCause() != null ? ex.getRootCause().getMessage() : ex.getMessage() ,"Error en la base de datos", request);
    }

    // Manejo de excepciones de negocio
    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<Map<String, Object>> handleBusinessException(BusinessException ex, WebRequest request) {
    	logger.error("Error de negocio (BusinessException)", ex);
        return errorResponse(HttpStatus.UNPROCESSABLE_ENTITY, ex.getMessage(),"Error de negocio: " + ex.getMessage() , request);
    }
    
 // Manejo de excepciones de validación
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, Object>> handleValidationException(MethodArgumentNotValidException ex) {
        Map<String, Object> body = new HashMap<>();
        logger.error("Los datos proporcionados no son válidos. (MethodArgumentNotValidException)", ex);
        body.put("timestamp", LocalDateTime.now());
        body.put("status", HttpStatus.BAD_REQUEST.value());
        body.put("error", "Error de validación");

        // Extraer los errores de los campos
        StringBuilder fieldErrors = new StringBuilder();
        for (FieldError error : ex.getBindingResult().getFieldErrors()) {
            fieldErrors.append(error.getDefaultMessage() + "\n");
        }
        body.put("message", "Los datos proporcionados no son válidos.");
        body.put("fieldErrors", fieldErrors);

        return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
    }
    
    @ExceptionHandler(HttpClientErrorException.BadRequest.class)
    public ResponseEntity<Map<String, Object>> handleBadRequestException(HttpClientErrorException.BadRequest ex, WebRequest request) {
    	logger.error("Error de negocio (HttpClientErrorException)", ex);
        return errorResponse(HttpStatus.BAD_REQUEST, ex.getMessage() , "Solicitud inválida", request);
    }

    // Manejo de UnauthorizedException (401)
    @ExceptionHandler(HttpClientErrorException.Unauthorized.class)
    public ResponseEntity<Map<String, Object>> handleUnauthorizedException(HttpClientErrorException.Unauthorized ex, WebRequest request) {
    	logger.error("No autorizado (HttpClientErrorException)", ex);
        return errorResponse(HttpStatus.UNAUTHORIZED,ex.getMessage() , "No autorizado", request);
    }

    // Manejo de NotFoundException (404)
    @ExceptionHandler(HttpClientErrorException.NotFound.class)
    public ResponseEntity<Map<String, Object>> handleNotFoundException(HttpClientErrorException.NotFound ex, WebRequest request) {
    	logger.error("Recurso no encontrado (HttpClientErrorException)", ex);
        return errorResponse(HttpStatus.NOT_FOUND,ex.getMessage() , "Recurso no encontrado", request);
    }

    @ExceptionHandler(NoContentException.class)
    public ResponseEntity<Map<String, Object>> handleNoContentException(NoContentException ex,WebRequest request) {
    	logger.error("No se encontro inFormacion ", ex);
        return errorResponse(HttpStatus.NO_CONTENT,ex.getMessage() , "Recurso no encontrado", request);
    }
    
    // Método para construir una respuesta uniforme
    private ResponseEntity<Map<String, Object>> errorResponse(HttpStatus status, String error, String message, WebRequest request) {
        Map<String, Object> body = new HashMap<>();
        body.put("timestamp", LocalDateTime.now());
        body.put("status", status.value());
        body.put("error", error);
        body.put("message", message);
        body.put("path", request.getDescription(false).replace("uri=", ""));
        return new ResponseEntity<>(body, status);
    }
	
}