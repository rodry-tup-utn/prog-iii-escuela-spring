package org.rodry.escuela.dto;

import lombok.Data;

@Data
public class CursoSimpleDTO {
    private Long id;
    private String nombre;
    private ProfesorDTO profesor;
}
