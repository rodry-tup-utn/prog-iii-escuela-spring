package org.rodry.escuela.service;

import org.rodry.escuela.dto.curso.CursoDTO;
import org.rodry.escuela.dto.estudiante.CreateEstudianteDTO;
import org.rodry.escuela.dto.estudiante.EstudianteDTO;
import org.rodry.escuela.entities.Estudiante;

import java.util.List;
import java.util.Set;

public interface EstudianteService {
    List<EstudianteDTO> findAll();
    EstudianteDTO createEstudiante(CreateEstudianteDTO createEstudianteDTO);
    Set<CursoDTO> getAllCursos(Long estudianteId);
}
