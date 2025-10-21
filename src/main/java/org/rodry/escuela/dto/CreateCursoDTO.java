package org.rodry.escuela.dto;

import lombok.Data;

@Data
public class CreateCursoDTO {
    private String nombre;
    private Long idProfesor;
}
