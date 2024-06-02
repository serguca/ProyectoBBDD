package com.proyectoDBAPP.proyectoDBAPP.Models;
import java.util.ArrayList;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
@Table(name = "users")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_usuario;
    private String nombre;
    private String contrasenia;
    private String correo;
    private String telefono;
    private String imagen;

    private ArrayList<Publicacion> publicaciones;
    private ArrayList<Usuario> seguidores;

    
    public int getId_usuario() {
        return id_usuario;
    }
    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
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

    @Override
    public String toString() {
        return "Usuario{" +
                "id_usuario=" + id_usuario +
                ", nombre='" + nombre + '\'' +
                ", contrasenia='" + contrasenia + '\'' +
                ", correo='" + correo + '\'' +
                ", telefono='" + telefono + '\'' +
                ", imagen='" + imagen + '\'' +
                ", publicaciones=" + publicaciones +
                ", seguidores=" + seguidores +
                '}';
    }
}
