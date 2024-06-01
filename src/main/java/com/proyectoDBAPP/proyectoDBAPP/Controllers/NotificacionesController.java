package com.proyectoDBAPP.proyectoDBAPP.Controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proyectoDBAPP.proyectoDBAPP.Models.Notificacion;
import com.proyectoDBAPP.proyectoDBAPP.Repositories.NotificacionesRepository;

@RestController
@RequestMapping("/notificaciones")
public class NotificacionesController {

    @Autowired
    private NotificacionesRepository notificacionesRepository;
    
    @GetMapping("/prueba")
    public String prueba() {
        return "PRUEBA";
    }

    @GetMapping
    public List<Notificacion> getAllNotificaciones() {
        return notificacionesRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Notificacion> getNotificacionById(@PathVariable int id) {
        Optional<Notificacion> notificacion = notificacionesRepository.findById(id);
        return notificacion.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Notificacion createNotificacion(@RequestBody Notificacion notificacion) {
        return notificacionesRepository.save(notificacion);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Notificacion> modificarNotificacion(@PathVariable int id, @RequestBody Notificacion notificacion) {
        Optional<Notificacion> optionalNotificacion = notificacionesRepository.findById(id);
        if (optionalNotificacion.isPresent()) {
            Notificacion notificacionModificada = optionalNotificacion.get();
            notificacionModificada.setTipo_notificacion(notificacion.getTipo_notificacion());
            notificacionModificada.setFecha_notificacion(notificacion.getFecha_notificacion());

            Notificacion updatedNotificacion = notificacionesRepository.save(notificacionModificada);
            return ResponseEntity.ok(updatedNotificacion);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteNotificacion(@PathVariable int id) {
        Optional<Notificacion> optionalNotificacion = notificacionesRepository.findById(id);
        if (optionalNotificacion.isPresent()) {
            notificacionesRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
