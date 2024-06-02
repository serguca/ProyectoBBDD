package com.proyectoDBAPP.proyectoDBAPP.Repositories;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.proyectoDBAPP.proyectoDBAPP.Models.Seguidor;

public interface SeguidoresRepository extends JpaRepository<Seguidor, Integer> {
    @Query(value = "SELECT * FROM seguidores", nativeQuery = true)
    public List<Seguidor> encontrarTodos();
}