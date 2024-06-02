package com.proyectoDBAPP.proyectoDBAPP.Repositories;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.proyectoDBAPP.proyectoDBAPP.Models.Seguidor;

public interface SeguidoresRepository extends JpaRepository<Seguidor, Integer> {
    @Query("INSERT INTO seguidores (seguidor_id, seguido_id) VALUES (seguidor_id_value, seguido_id_value);")
    public void insertSeguidor(@Param("seguidor_id_value") int seguidor_id_value, @Param("seguido_id_value") int seguido_id_value);
}