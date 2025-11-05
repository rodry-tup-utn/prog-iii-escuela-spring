package org.rodry.escuela.dto.estudiante;

import org.rodry.escuela.dto.curso.CursoDTO;

import java.util.Set;

public record EstudianteDTO (
     Long id,
     String nombre,
     String matricula){
}
