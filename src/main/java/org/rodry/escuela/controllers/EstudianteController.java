package org.rodry.escuela.controllers;

import org.rodry.escuela.dto.curso.CursoDTO;
import org.rodry.escuela.dto.estudiante.CreateEstudianteDTO;
import org.rodry.escuela.dto.estudiante.EstudianteDTO;
import org.rodry.escuela.service.EstudianteServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/estudiantes")
public class EstudianteController {
    @Autowired
    private EstudianteServiceImpl estudianteService;

    @GetMapping
    public List<EstudianteDTO> getAllEstudiantes(){
        return estudianteService.findAll();
    }

    @PostMapping
    public EstudianteDTO createEstudiante(@RequestBody CreateEstudianteDTO estudianteDTO){
        return estudianteService.createEstudiante(estudianteDTO);
    }

    @GetMapping("/{id}/cursos")
    public Set<CursoDTO> getCursos(@PathVariable Long id){
        return estudianteService.getAllCursos(id);
    }
}
