package org.rodry.escuela.mappers;

import org.rodry.escuela.dto.curso.CursoDTO;
import org.rodry.escuela.dto.estudiante.EstudianteDTO;
import org.rodry.escuela.dto.profesor.ProfesorDTO;
import org.rodry.escuela.entities.Curso;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CursoMapper {
    @Autowired
    @Lazy
    private EstudianteMapper estudianteMapper;
    @Autowired
    private ProfesorMapper profesorMapper;

    public CursoDTO toDto(Curso curso) {

        ProfesorDTO profesorDto = profesorMapper.toDto(curso.getProfesor());

        List<EstudianteDTO> estudiantesDTO = curso.getEstudiantes()
                .stream()
                .map(estudianteMapper::toDto)
                .collect(Collectors.toList());

        return new CursoDTO(
                curso.getId(),
                curso.getNombre(),
                profesorDto,
                estudiantesDTO);
    }
}
