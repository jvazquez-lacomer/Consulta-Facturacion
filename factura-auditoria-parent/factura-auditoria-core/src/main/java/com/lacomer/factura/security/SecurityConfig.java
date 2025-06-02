package com.lacomer.factura.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;

@EnableWebSecurity
@Configuration
public class SecurityConfig {

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
	    http
	        .cors() // Habilita CORS
	        .and()
	        .csrf().disable() // Deshabilita CSRF
	        .sessionManagement()
	            .sessionCreationPolicy(SessionCreationPolicy.STATELESS) // Deshabilita el manejo de sesiones
	        .and()
	        .addFilterAfter(new AuthorizationFilter(), UsernamePasswordAuthenticationFilter.class) // Agrega el filtro de autorización
	        .authorizeRequests()
	        .antMatchers(HttpMethod.POST, "/lacomer/login").permitAll() // Permite solicitudes POST al endpoint de login
	        .anyRequest().authenticated(); // Requiere autenticación para otras solicitudes

	    return http.build();
	}

	@Bean
	public CorsConfigurationSource corsConfigurationSource() {
	    CorsConfiguration configuration = new CorsConfiguration();
	    configuration.setAllowedOrigins(Arrays.asList("http://localhost:4200")); // Permite solicitudes desde Angular
	    configuration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS")); // Métodos permitidos
	    configuration.setAllowedHeaders(Arrays.asList("Content-Type", "Authorization")); // Encabezados permitidos
	    configuration.setAllowCredentials(true); // Permite el uso de cookies o credenciales

	    UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
	    source.registerCorsConfiguration("/**", configuration); // Aplica la configuración a todas las rutas
	    return source;
	}
}