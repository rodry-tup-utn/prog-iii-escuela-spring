package org.rodry.escuela.mappers;

import org.rodry.escuela.dto.CursoDTO;
import org.rodry.escuela.dto.CursoSimpleDTO;
import org.rodry.escuela.dto.EstudianteDTO;
import org.rodry.escuela.dto.ProfesorDTO;
import org.rodry.escuela.entities.Curso;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CursoMapper {
    @Autowired
    private EstudianteMapper estudianteMapper;
    @Autowired
    private ProfesorMapper profesorMapper;

    public CursoDTO toDto(Curso curso) {
        if (curso == null) {
            return null;
        }

        ProfesorDTO profesorDto = profesorMapper.toDto(curso.getProfesor());

        List<EstudianteDTO> estudiantesDTO = curso.getEstudiantes()
                .stream()
                .map(estudianteMapper::toEstudianteDto)
                .collect(Collectors.toList());

        CursoDTO cursoDto = new CursoDTO();
        cursoDto.setId(curso.getId());
        cursoDto.setNombre(curso.getNombre());
        cursoDto.setProfesor(profesorDto);
        cursoDto.setEstudiantes(estudiantesDTO);

        return cursoDto;
    }
    public CursoSimpleDTO toSimpleDto(Curso curso) {

        if (curso == null) {
            return null;
        }
        CursoSimpleDTO cursoDto = new CursoSimpleDTO();
        cursoDto.setId(curso.getId());
        cursoDto.setNombre(curso.getNombre());
        cursoDto.setProfesor(profesorMapper.toDto(curso.getProfesor()));
        return cursoDto;
    }

}
