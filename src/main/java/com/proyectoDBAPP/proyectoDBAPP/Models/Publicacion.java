// Version: 1.0
package com.proyectoDBAPP.proyectoDBAPP.Models;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
@Table(name = "publicaciones")
public class Publicacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Column(nullable = false,length = 20)
    private String tipo_Publicacion;

    @Column(nullable = false,length = 20)
    private String fecha_Publicacion;

    @Column(nullable = false,length = 20)
    private String interaccion;

    public int getId() {
        return id;
    }

    public void setId(int id_publicacion) {
        this.id = id_publicacion;
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
