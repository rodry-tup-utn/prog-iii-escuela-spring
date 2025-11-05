package org.rodry.escuela.dto.curso;

import org.rodry.escuela.dto.estudiante.EstudianteDTO;
import org.rodry.escuela.dto.profesor.ProfesorDTO;

import java.util.List;

public record CursoDTO (
    Long id,
    String nombre,
    ProfesorDTO profesor,
    List<EstudianteDTO> estudiantes){
}
