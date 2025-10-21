package org.rodry.escuela.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.rodry.escuela.entities.Profesor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CursoDTO {
    private Long id;
    private String nombre;
    private ProfesorDTO profesor;
    private List<EstudianteDTO> estudiantes;
}
