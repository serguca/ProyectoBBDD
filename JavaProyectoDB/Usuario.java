package JavaProyectoDB;
import java.util.ArrayList;

public class Usuario{
    
    //Constructor
    public Usuario(int id_usuario, String nombre, String contrasena, String correo, String telefono, String imagen,
            ArrayList<Publicacion> publicaciones, ArrayList<Seguidores> seguidores) {
        this.id_usuario = id_usuario;
        this.nombre = nombre;
        this.contrasena = contrasena;
        this.correo = correo;
        this.telefono = telefono;
        this.imagen = imagen;
        this.publicaciones = publicaciones;
        this.seguidores = seguidores;
    }
    //Variables y arrayList 
    private int id_usuario;
    private String nombre;
    private String contrasena;
    private String correo;
    private String telefono;
    private String imagen;

    private ArrayList<Publicacion> publicaciones;
    private ArrayList<Seguidores> seguidores;
    //Getters y Setters
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
    public String getContrasena() {
        return contrasena;
    }
    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
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
    public ArrayList<Seguidores> getSeguidores() {
        return seguidores;
    }
    public void setSeguidores(ArrayList<Seguidores> seguidores) {
        this.seguidores = seguidores;
    }

}