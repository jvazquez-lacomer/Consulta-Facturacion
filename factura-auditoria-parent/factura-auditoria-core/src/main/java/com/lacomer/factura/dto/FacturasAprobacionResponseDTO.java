package com.lacomer.factura.dto;

import com.lacomer.factura.smt.entity.SolicitudFacturasEntity;

public class FacturasAprobacionResponseDTO {
    private SolicitudFacturasEntity solicitud;
    private String nombreUsuario;

    // Constructor
    public FacturasAprobacionResponseDTO(SolicitudFacturasEntity solicitud, String nombreUsuario) {
        this.solicitud = solicitud;
        this.nombreUsuario = nombreUsuario;
    }

    // Getters y Setters
    public SolicitudFacturasEntity getSolicitud() {
        return solicitud;
    }

    public void setSolicitud(SolicitudFacturasEntity solicitud) {
        this.solicitud = solicitud;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }
}