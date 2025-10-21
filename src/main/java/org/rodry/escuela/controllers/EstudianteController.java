package org.rodry.escuela.controllers;

import org.rodry.escuela.dto.CreateEstudianteDTO;
import org.rodry.escuela.dto.CursoDTO;
import org.rodry.escuela.dto.CursoSimpleDTO;
import org.rodry.escuela.dto.EstudianteDTO;
import org.rodry.escuela.service.EstudianteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/estudiantes")
public class EstudianteController {
    @Autowired
    private EstudianteService estudianteService;

    @GetMapping
    public List<EstudianteDTO> getAllEstudiantes(){
        return estudianteService.getAllEstudiantes();
    }

    @PostMapping
    public EstudianteDTO createEstudiante(@RequestBody CreateEstudianteDTO estudianteDTO){
        return estudianteService.createEstudiante(estudianteDTO);
    }

    @GetMapping("/{id}/cursos")
    public Set<CursoSimpleDTO> getCursos(@PathVariable Long id){
        return estudianteService.getAllCursos(id);
    }
}
