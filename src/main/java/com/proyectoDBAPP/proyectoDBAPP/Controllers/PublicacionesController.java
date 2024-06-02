package com.proyectoDBAPP.proyectoDBAPP.Controllers;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proyectoDBAPP.proyectoDBAPP.Models.Publicacion;
import com.proyectoDBAPP.proyectoDBAPP.Repositories.PublicacionesRepository;




@RestController
@RequestMapping("/publicaciones")
public class PublicacionesController {
    @Autowired
    private PublicacionesRepository publicacionRepository;

    @GetMapping
    public List<Publicacion> getAllPublicaciones(){
        return publicacionRepository.findAll();
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Publicacion> getPublicacionById(@PathVariable Integer id){
        Optional<Publicacion> publicacion = publicacionRepository.findById(id);
        return publicacion.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Publicacion> crearPublicacion(@RequestBody Publicacion publicacion){
        Publicacion newPublicacion = publicacionRepository.save(publicacion);
        return ResponseEntity.status(HttpStatus.CREATED).body(newPublicacion);
        }

        @PutMapping("/{id}")
        public ResponseEntity<Publicacion> modificarPublicacion(@PathVariable int id, @RequestBody Publicacion publicacion){
        Optional<Publicacion> optionalPublicacion = publicacionRepository.findById(id);
        if (optionalPublicacion.isPresent()) {
            Publicacion publicacionActualizada = optionalPublicacion.get();
            
            publicacionActualizada.setTipo_Publicacion(publicacion.getTipo_Publicacion());
            publicacionActualizada.setFecha_Publicacion(publicacion.getFecha_Publicacion());
            publicacionActualizada.setInteraccion(publicacion.getInteraccion());

            Publicacion updatedPublicacion = publicacionRepository.save(publicacionActualizada);
            return ResponseEntity.ok(updatedPublicacion);
        } else {
            return ResponseEntity.notFound().build();
        }
        }
    
    @DeleteMapping("/eliminar/{id}")
    public void deletePublicacion(@PathVariable int id){
        Optional<Publicacion> optionalPublicacion = publicacionRepository.findById(id);
        if(optionalPublicacion.isPresent()){
            publicacionRepository.delete(optionalPublicacion.get());
        } else {
            throw new IllegalArgumentException("La publicacion con el id: " + id + " no existe");
        }
    }
    }



