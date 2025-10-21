package org.rodry.escuela.controllers;

import org.rodry.escuela.dto.CreateProfesorDTO;
import org.rodry.escuela.dto.ProfesorDTO;
import org.rodry.escuela.entities.Profesor;
import org.rodry.escuela.repository.ProfesorRepository;
import org.rodry.escuela.service.ProfesorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/profesores")
public class ProfesorController {

    @Autowired
    private ProfesorService profesorService;

    @GetMapping
    public List<ProfesorDTO> getAllProfesores(){
        return profesorService.getAllProfesores();
    }

    @PostMapping
    public ProfesorDTO createProfesor(@RequestBody CreateProfesorDTO profesorDTO){
        return  profesorService.createProfesor(profesorDTO);
    }
}
