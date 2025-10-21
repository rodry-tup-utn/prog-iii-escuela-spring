package org.rodry.escuela.mappers;

import org.rodry.escuela.dto.CreateEstudianteDTO;
import org.rodry.escuela.dto.EstudianteDTO;
import org.rodry.escuela.entities.Estudiante;
import org.springframework.stereotype.Component;

@Component
public class EstudianteMapper {
    public EstudianteDTO toEstudianteDto(Estudiante estudiante) {
        EstudianteDTO estudianteDTO = new EstudianteDTO();
        estudianteDTO.setId(estudiante.getId());
        estudianteDTO.setNombre(estudiante.getNombre());
        estudianteDTO.setMatricula(estudiante.getMatricula());

        return estudianteDTO;
    }

    public Estudiante toEstudiante(CreateEstudianteDTO estudianteDTO) {
        Estudiante estudiante = new Estudiante();
        estudiante.setNombre(estudianteDTO.getNombre());
        estudiante.setMatricula(estudianteDTO.getMatricula());

        return estudiante;
    }
}
