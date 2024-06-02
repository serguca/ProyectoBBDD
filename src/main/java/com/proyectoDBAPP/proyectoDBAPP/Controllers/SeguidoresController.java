package com.proyectoDBAPP.proyectoDBAPP.Controllers;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proyectoDBAPP.proyectoDBAPP.Models.Seguidor;
import com.proyectoDBAPP.proyectoDBAPP.Repositories.SeguidoresRepository;

@RestController
@RequestMapping("/seguidores")
public class SeguidoresController {
    @Autowired
    private SeguidoresRepository seguidoresRepository;
    
    @GetMapping
    public List<Seguidor> getAllSeguidores() {
        return seguidoresRepository.findAll();
    }
}
