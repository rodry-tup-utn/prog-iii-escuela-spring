package org.rodry.escuela.service;

import org.rodry.escuela.dto.curso.CreateCursoDTO;
import org.rodry.escuela.dto.curso.CursoDTO;
import org.rodry.escuela.dto.estudiante.EstudianteDTO;

import java.util.List;
import java.util.Optional;

public interface CursoService {
    List<CursoDTO> findAll();
    CursoDTO findById(Long id);
    CursoDTO createCurso(CreateCursoDTO createCursoDTO);
    CursoDTO agregarEstudiante(Long cursoId, Long estudianteId);
    CursoDTO eliminarEstudiante(Long cursoId, Long estudianteId);
}
