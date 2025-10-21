package org.rodry.escuela.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EstudianteDTO {
    private Long id;
    private String nombre;
    private String matricula;
}
