package com.proyectoDBAPP.proyectoDBAPP.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
@Table(name = "notificaciones")
public class Notificacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    private int id_notificacion;
    private int id_usuario;
    private String tipo_notificacion;
    private String fecha_notificacion;
    
    public int getId_notificacion() {
        return id_notificacion;
    }
    public void setId_notificacion(int id_notificacion) {
        this.id_notificacion = id_notificacion;
    }
    public int getId_usuario() {
        return id_usuario;
    }
    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }
    public String getTipo_notificacion() {
        return tipo_notificacion;
    }
    public void setTipo_notificacion(String tipo_notificacion) {
        this.tipo_notificacion = tipo_notificacion;
    }
    public String getFecha_notificacion() {
        return fecha_notificacion;
    }
    public void setFecha_notificacion(String fecha_notificacion) {
        this.fecha_notificacion = fecha_notificacion;
    }
}
