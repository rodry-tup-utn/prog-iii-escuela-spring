package org.rodry.escuela.mappers;

import org.rodry.escuela.dto.curso.CursoDTO;
import org.rodry.escuela.dto.estudiante.CreateEstudianteDTO;
import org.rodry.escuela.dto.estudiante.EstudianteDTO;
import org.rodry.escuela.entities.Estudiante;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.stream.Collectors;

@Component
public class EstudianteMapper {
    @Autowired
    private CursoMapper cursoMapper;

    public EstudianteDTO toDto(Estudiante estudiante) {

        EstudianteDTO estudianteDTO = new EstudianteDTO(
                estudiante.getId(),
                estudiante.getNombre(),
                estudiante.getMatricula());

        return estudianteDTO;
    }

    public Estudiante toEstudiante(CreateEstudianteDTO estudianteDTO) {
        return Estudiante.builder()
                .nombre(estudianteDTO.nombre())
                .matricula(estudianteDTO.matricula())
                .activo(true)
                .build();
    }
}
