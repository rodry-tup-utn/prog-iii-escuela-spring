package org.rodry.escuela.controllers;

import org.rodry.escuela.dto.profesor.CreateProfesorDTO;
import org.rodry.escuela.dto.profesor.ProfesorDTO;
import org.rodry.escuela.service.ProfesorServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/profesores")
public class ProfesorController {

    @Autowired
    private ProfesorServiceImpl profesorService;

    @GetMapping
    public List<ProfesorDTO> getAllProfesores(){
        return profesorService.getAllProfesores();
    }

    @PostMapping
    public ProfesorDTO createProfesor(@RequestBody CreateProfesorDTO profesorDTO){
        return  profesorService.createProfesor(profesorDTO);
    }
}
