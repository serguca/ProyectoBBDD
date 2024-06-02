package com.proyectoDBAPP.proyectoDBAPP.Models;
import java.util.ArrayList;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
@Table(name = "usuarios")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false,length = 50)
    private String nombre;

    @Column(nullable = false,length = 30)
    private String apellido;

    @Column(nullable = false,length = 30)
    private String correo;

    @Column(nullable = false,length = 30)
    private String contrasenia;

    @Column(nullable = false,length = 30)
    private String telefono;

    @Column(nullable = false,length = 40)
    private String imagen;

    public int getId_usuario() {
        return id;
    }
    public void setId_usuario(int id_usuario) {
        this.id = id_usuario;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getContrasenia() {
        return contrasenia;
    }
    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }
    public String getCorreo() {
        return correo;
    }
    public void setCorreo(String correo) {
        this.correo = correo;
    }
    public String getTelefono() {
        return telefono;
    }
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    public String getImagen() {
        return imagen;
    }
    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    /*
    public ArrayList<Publicacion> getPublicaciones() {
        return publicaciones;
    }
    
    public void setPublicaciones(ArrayList<Publicacion> publicaciones) {
        this.publicaciones = publicaciones;
    }
    public ArrayList<Usuario> getSeguidores() {
        return seguidores;
    }
    public void setSeguidores(ArrayList<Usuario> seguidores) {
        this.seguidores = seguidores;
    }


    public void seguirUsuario(Usuario usuario){
        this.seguidores.add(usuario);
    }

    public void dejarDeSeguirUsuario(Usuario usuario){
        this.seguidores.remove(usuario);
    }
     */

    @Override
    public String toString() {
        return "Usuario{" +
                "id_usuario=" + id +
                ", nombre='" + nombre + '\'' +
                ", contrasenia='" + contrasenia + '\'' +
                ", correo='" + correo + '\'' +
                ", telefono='" + telefono + '\'' +
                ", imagen='" + imagen + '\'' +
                '}';
    }
}
