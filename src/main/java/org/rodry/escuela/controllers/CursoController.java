package org.rodry.escuela.controllers;

import org.rodry.escuela.dto.curso.CreateCursoDTO;
import org.rodry.escuela.dto.curso.CursoDTO;
import org.rodry.escuela.service.CursoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cursos")
public class CursoController {
    @Autowired
    private CursoServiceImpl cursoService;

    @GetMapping
    public List<CursoDTO> getAllCursos(){
        return cursoService.findAll();
    }

    @PostMapping
    public CursoDTO createCurso(@RequestBody CreateCursoDTO cursoDTO){
        return  cursoService.createCurso(cursoDTO);
    }

    @PutMapping("/{cursoId}/asignar/{estudianteId}")
    public CursoDTO agregarEstudiante(@PathVariable Long cursoId, @PathVariable Long estudianteId){
        return cursoService.agregarEstudiante(cursoId, estudianteId);
    }
    @DeleteMapping("/{cursoId}/quitar/{estudianteId}")
    public CursoDTO quitarEstudiante(@PathVariable Long cursoId, @PathVariable Long estudianteId) {
        return cursoService.eliminarEstudiante(cursoId, estudianteId);
    }
}

