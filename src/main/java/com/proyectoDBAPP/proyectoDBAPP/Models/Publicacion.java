// Version: 1.0
package com.proyectoDBAPP.proyectoDBAPP.Models;


import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
@Table(name = "posts")
public class Publicacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_publicacion;
    private int id_usuario;
    private String tipo_Publicacion;
    private String fecha_Publicacion;
    private String interaccion;

    public int getId_publicacion() {
        return id_publicacion;
    }

    public void setId_publicacion(int id_publicacion) {
        this.id_publicacion = id_publicacion;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getTipo_Publicacion() {
        return tipo_Publicacion;
    }

    public void setTipo_Publicacion(String tipo_Publicacion) {
        this.tipo_Publicacion = tipo_Publicacion;
    }

    public String getFecha_Publicacion() {
        return fecha_Publicacion;
    }

    public void setFecha_Publicacion(String fecha_Publicacion) {
        this.fecha_Publicacion = fecha_Publicacion;
    }

    public String getInteraccion() {
        return interaccion;
    }

    public void setInteraccion(String interaccion) {
        this.interaccion = interaccion;
    }
}
