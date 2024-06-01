package com.proyectoDBAPP.proyectoDBAPP.Controllers;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.proyectoDBAPP.proyectoDBAPP.Models.Usuario;
import com.proyectoDBAPP.proyectoDBAPP.Repositories.UsuarioRepository;

@RestController
@RequestMapping("/usuarios")
public class UsuariosController {
    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping
    public List<Usuario> getAllUsuarios(){
        return usuarioRepository.findAll();
    }

    @GetMapping("/{id}/seguidores")
    public List<Usuario> getSeguidores(@PathVariable int id) {
        Optional<Usuario> usuarioOptional = usuarioRepository.findById(id);
        Usuario usuario = usuarioOptional.orElseThrow(() -> new IllegalArgumentException("El usuario con el id: " + id + " no existe"));
        return usuario.getSeguidores();
    }


    @GetMapping("/{id}")    //Este id es el que recive el metodo
    public ResponseEntity<Usuario> getUsuarioById(@PathVariable int id){ // Queremos que sea igual a este id para que se pueda hacer la busqueda
      Optional <Usuario> usuario = usuarioRepository.findById(id);//@PathVariable INDICA QUE  EL ID DE ARRIBA ES EL MISMO QUE EL DE ABAJO Y ENTRA POR LA RUTA
        return usuario.map(ResponseEntity :: ok).orElseGet(() -> ResponseEntity.notFound().build()); //SI PUEDE DEVOLVER EL ID DEL USUARIO EL RESPONSE ENTITY ES OK SINO NOS DARÁ UN NOT FOUND
    }

    @PostMapping
    public Usuario createUsuario(@RequestBody Usuario usuario){
        return usuarioRepository.save(usuario);
    }

    @PutMapping("/{id}")
    public Usuario updateUsuario(int id, Usuario usuario){
        Optional<Usuario> usuarioOptional = usuarioRepository.findById(id);
        if(usuarioOptional.isPresent()){
            Usuario UsuarioModificado = usuarioOptional.get();
            UsuarioModificado.setNombre(usuario.getNombre());
            UsuarioModificado.setCorreo(usuario.getCorreo());
            UsuarioModificado.setContrasenia(usuario.getContrasenia());
            UsuarioModificado.setTelefono(usuario.getTelefono());
            UsuarioModificado.setImagen(usuario.getImagen());
            // Set other properties as needed
            return usuarioRepository.save(UsuarioModificado);
        } else {
            // Handle case when user with given id does not exist
            throw new IllegalArgumentException("El usuario con el id: " + id + " no existe");
        }
    }

    


    public void deleteUsuario(int id){
        Optional<Usuario> usuarioOptional = usuarioRepository.findById(id);
        if(usuarioOptional.isPresent()){
            usuarioRepository.delete(usuarioOptional.get());
        } else {
            throw new IllegalArgumentException("El usuario con el id: " + id + " no existe");
        }
    }
    

    @PutMapping("/{id}/seguir")
    public void seguirUsuario(@PathVariable int id, @RequestBody Usuario seguidor){
       Optional<Usuario> usuarioOptional = usuarioRepository.findById(id);
       Usuario usuario = usuarioOptional.get();
        usuario.seguirUsuario(seguidor);
    }

    @PutMapping("/{id}/dejarDeSeguir")
    public void dejarDeSeguirUsuario(@PathVariable int id, @RequestBody Usuario seguidor){
       Optional<Usuario> usuarioOptional = usuarioRepository.findById(id);
       Usuario usuario = usuarioOptional.get();
        usuario.dejarDeSeguirUsuario(seguidor);
    }



}
