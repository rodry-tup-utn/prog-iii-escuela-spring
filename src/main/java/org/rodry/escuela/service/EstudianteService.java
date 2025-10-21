package org.rodry.escuela.service;

import org.rodry.escuela.dto.CreateEstudianteDTO;
import org.rodry.escuela.dto.CursoDTO;
import org.rodry.escuela.dto.CursoSimpleDTO;
import org.rodry.escuela.dto.EstudianteDTO;
import org.rodry.escuela.entities.Curso;
import org.rodry.escuela.entities.Estudiante;
import org.rodry.escuela.mappers.CursoMapper;
import org.rodry.escuela.mappers.EstudianteMapper;
import org.rodry.escuela.mappers.ProfesorMapper;
import org.rodry.escuela.repository.CursoRepository;
import org.rodry.escuela.repository.EstudianteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class EstudianteService {
    @Autowired
    private EstudianteMapper estudianteMapper;
    @Autowired
    private EstudianteRepository estudianteRepository;
    @Autowired
    private CursoRepository cursoRepository;
    @Autowired
    private CursoMapper cursoMapper;

    public List<EstudianteDTO> getAllEstudiantes(){
        List<Estudiante> estudiantes = estudianteRepository.findAll();

        return estudiantes.stream()
                .map(estudianteMapper::toEstudianteDto)
                .collect(Collectors.toList());
    }

    public EstudianteDTO createEstudiante(CreateEstudianteDTO dto){
        Estudiante estudiante = estudianteMapper.toEstudiante(dto);

        Estudiante savedEstudiante = estudianteRepository.save(estudiante);

        return estudianteMapper.toEstudianteDto(savedEstudiante);
    }

    public Set<CursoSimpleDTO> getAllCursos(Long estudianteId){
        Estudiante estudiante = estudianteRepository.findById(estudianteId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Estudiante no encontrado"));
            Set<Curso> cursos = estudiante.getCursos();
            return cursos.stream()
                    .map(cursoMapper::toSimpleDto)
                    .collect(Collectors.toSet());

    }
}
