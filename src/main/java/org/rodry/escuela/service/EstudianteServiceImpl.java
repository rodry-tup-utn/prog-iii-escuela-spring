package org.rodry.escuela.service;

import org.rodry.escuela.dto.curso.CursoDTO;
import org.rodry.escuela.dto.estudiante.CreateEstudianteDTO;
import org.rodry.escuela.dto.estudiante.EstudianteDTO;
import org.rodry.escuela.entities.Curso;
import org.rodry.escuela.entities.Estudiante;
import org.rodry.escuela.mappers.CursoMapper;
import org.rodry.escuela.mappers.EstudianteMapper;
import org.rodry.escuela.repository.CursoRepository;
import org.rodry.escuela.repository.EstudianteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class EstudianteServiceImpl implements EstudianteService {
    @Autowired
    private EstudianteMapper estudianteMapper;
    @Autowired
    private EstudianteRepository estudianteRepository;
    @Autowired
    private CursoRepository cursoRepository;
    @Autowired
    private CursoMapper cursoMapper;

    @Override
    public List<EstudianteDTO> findAll(){
        List<Estudiante> estudiantes = estudianteRepository.findAllByActivoTrue();

        return estudiantes.stream()
                .map(estudianteMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public EstudianteDTO createEstudiante(CreateEstudianteDTO dto){
        Estudiante estudiante = estudianteMapper.toEstudiante(dto);

        Estudiante savedEstudiante = estudianteRepository.save(estudiante);

        return estudianteMapper.toDto(savedEstudiante);
    }

    @Override
    public Set<CursoDTO> getAllCursos(Long estudianteId){
        Estudiante estudiante = estudianteRepository.findById(estudianteId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Estudiante no encontrado"));
            Set<Curso> cursos = estudiante.getCursos();
            return cursos.stream()
                    .map(cursoMapper::toDto)
                    .collect(Collectors.toSet());

    }
}
