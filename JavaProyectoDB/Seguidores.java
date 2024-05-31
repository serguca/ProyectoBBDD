package JavaProyectoDB;
import java.util.ArrayList;


public class Seguidores extends Usuario{
    
    //Constructor extendido con clase usuario
    public Seguidores(int id_usuario, String nombre, String contrasena, String correo, String telefono, String imagen,
            ArrayList<Publicacion> publicaciones, ArrayList<Seguidores> seguidores, int id_seguidor, int id_usuario2) {
        super(id_usuario, nombre, contrasena, correo, telefono, imagen, publicaciones, seguidores);
        this.id_seguidor = id_seguidor;
        id_usuario = id_usuario2;
    }
    //Variables nuevas
    private int id_seguidor;
    private int id_usuario;
    //Getters y Setters
    public int getId_seguidor() {
        return id_seguidor;
    }
    public void setId_seguidor(int id_seguidor) {
        this.id_seguidor = id_seguidor;
    }
    public int getId_usuario() {
        return id_usuario;
    }
    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }
}
