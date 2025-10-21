package org.rodry.escuela.service;

import org.rodry.escuela.dto.CreateCursoDTO;
import org.rodry.escuela.dto.CursoDTO;
import org.rodry.escuela.dto.EstudianteDTO;
import org.rodry.escuela.entities.Curso;
import org.rodry.escuela.entities.Estudiante;
import org.rodry.escuela.entities.Profesor;
import org.rodry.escuela.mappers.CursoMapper;
import org.rodry.escuela.repository.CursoRepository;
import org.rodry.escuela.repository.EstudianteRepository;
import org.rodry.escuela.repository.ProfesorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CursoService {
    @Autowired
    private CursoRepository cursoRepository;
    @Autowired
    private CursoMapper cursoMapper;
    @Autowired
    private ProfesorRepository profesorRepository;
    @Autowired
    private EstudianteRepository estudianteRepository;

    public  List<CursoDTO> findAll(){
        List<Curso> cursos = cursoRepository.findAll();

        return cursos.stream()
                .map(cursoMapper::toDto)
                .collect(Collectors.toList());
    }

    public CursoDTO createCurso(CreateCursoDTO dto){
        Profesor profesor = profesorRepository.findById(dto.getIdProfesor())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND ,"No se encontro el profesor indicado"));
        Curso curso = Curso.builder()
                .nombre(dto.getNombre())
                .profesor(profesor)
                .build();
        Curso savedCurso = cursoRepository.save(curso);
        return  cursoMapper.toDto(savedCurso);
    }
    public CursoDTO agregarEstudiante(Long cursoId, Long estudianteId){

        Curso cursoEncontrado = cursoRepository.findById(cursoId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "No se encontro un curso con ID: " + cursoId));

        Estudiante estudianteEncontrado = estudianteRepository.findById(estudianteId)
                .orElseThrow(() -> new ResponseStatusException( HttpStatus.NOT_FOUND, "No se encontro estudiante con ID: " + estudianteId));

        cursoEncontrado.getEstudiantes().add(estudianteEncontrado);
        cursoRepository.save(cursoEncontrado);
        return cursoMapper.toDto(cursoEncontrado);

    }

}
