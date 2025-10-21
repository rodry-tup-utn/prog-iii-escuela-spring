package org.rodry.escuela.service;

import org.rodry.escuela.dto.CreateProfesorDTO;
import org.rodry.escuela.dto.ProfesorDTO;
import org.rodry.escuela.entities.Profesor;
import org.rodry.escuela.mappers.ProfesorMapper;
import org.rodry.escuela.repository.ProfesorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProfesorService {
    @Autowired
    private ProfesorRepository profesorRepository;
    @Autowired
    private ProfesorMapper profesorMapper;

    public List<ProfesorDTO> getAllProfesores(){
        List<Profesor> profesores = profesorRepository.findAll();

        return profesores.stream()
                .map(profesorMapper::toDto)
                .collect(Collectors.toList());
    }

    public ProfesorDTO createProfesor(CreateProfesorDTO dto) {

        Profesor profesor = profesorMapper.toEntity(dto);

        Profesor savedProfesor = profesorRepository.save(profesor);

        return profesorMapper.toDto(savedProfesor);
    }
}
