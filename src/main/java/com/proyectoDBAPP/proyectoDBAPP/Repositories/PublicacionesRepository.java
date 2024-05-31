package com.proyectoDBAPP.proyectoDBAPP.Repositories;
import org.springframework.data.jpa.repository.JpaRepository;

import com.proyectoDBAPP.proyectoDBAPP.Models.Publicacion;


public interface PublicacionesRepository extends JpaRepository<Publicacion, Integer>{
}