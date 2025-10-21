package org.rodry.escuela.controllers;

import org.rodry.escuela.dto.CreateCursoDTO;
import org.rodry.escuela.dto.CursoDTO;
import org.rodry.escuela.entities.Curso;
import org.rodry.escuela.service.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cursos")
public class CursoController {
    @Autowired
    private CursoService cursoService;

    @GetMapping
    public List<CursoDTO> getAllCursos(){
        return cursoService.findAll();
    }

    @PostMapping
    public CursoDTO createCurso(@RequestBody CreateCursoDTO cursoDTO){
        return  cursoService.createCurso(cursoDTO);
    }

    @PostMapping("/{cursoId}/asignar/{estudianteId}")
    public CursoDTO agregarEstudiante(@PathVariable Long cursoId, @PathVariable Long estudianteId){
        return cursoService.agregarEstudiante(cursoId, estudianteId);
    }
}

