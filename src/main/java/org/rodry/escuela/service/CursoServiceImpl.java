package org.rodry.escuela.service;

import org.rodry.escuela.dto.curso.CreateCursoDTO;
import org.rodry.escuela.dto.curso.CursoDTO;
import org.rodry.escuela.entities.Curso;
import org.rodry.escuela.entities.Estudiante;
import org.rodry.escuela.entities.Profesor;
import org.rodry.escuela.mappers.CursoMapper;
import org.rodry.escuela.repository.CursoRepository;
import org.rodry.escuela.repository.EstudianteRepository;
import org.rodry.escuela.repository.ProfesorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CursoServiceImpl implements CursoService {
    @Autowired
    private CursoRepository cursoRepository;
    @Autowired
    private CursoMapper cursoMapper;
    @Autowired
    private ProfesorRepository profesorRepository;
    @Autowired
    private EstudianteRepository estudianteRepository;

    @Override
    public  List<CursoDTO> findAll(){
        List<Curso> cursos = cursoRepository.findAllByActivoTrue();
        return cursos.stream()
                .map(cursoMapper::toDto)
                .collect(Collectors.toList());
    }
    @Override
    public CursoDTO findById(Long id){
        Curso curso = cursoRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "No se encontro curso con el id"));
        return cursoMapper.toDto(curso);
    }

    @Override
    public CursoDTO createCurso(CreateCursoDTO dto){
        Profesor profesor = profesorRepository.findById(dto.idProfesor())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND ,"No se encontro el profesor indicado"));

        Curso curso = Curso.builder()
                .nombre(dto.nombre())
                .profesor(profesor)
                .activo(true)
                .build();
        Curso savedCurso = cursoRepository.save(curso);
        return  cursoMapper.toDto(savedCurso);
    }
    @Override
    public CursoDTO agregarEstudiante(Long cursoId, Long estudianteId){

        Curso cursoEncontrado = cursoRepository.findById(cursoId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "No se encontro un curso con ID: " + cursoId));

        Estudiante estudianteEncontrado = estudianteRepository.findById(estudianteId)
                .orElseThrow(() -> new ResponseStatusException( HttpStatus.NOT_FOUND, "No se encontro estudiante con ID: " + estudianteId));

        cursoEncontrado.agregarEstudiante(estudianteEncontrado);
        Curso cursoGuardado =cursoRepository.save(cursoEncontrado);
        return cursoMapper.toDto(cursoGuardado);
    }
    @Override
    public CursoDTO eliminarEstudiante(Long cursoId, Long estudianteId){

        Curso cursoEncontrado = cursoRepository.findById(cursoId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "No se encontro un curso con ID: " + cursoId));

        Estudiante estudianteEncontrado = estudianteRepository.findById(estudianteId)
                .orElseThrow(() -> new ResponseStatusException( HttpStatus.NOT_FOUND, "No se encontro estudiante con ID: " + estudianteId));

        cursoEncontrado.removerEstudiante(estudianteEncontrado);

        Curso cursoGuardado = cursoRepository.save(cursoEncontrado);

        return cursoMapper.toDto(cursoGuardado);
    }

}
