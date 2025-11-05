package org.rodry.escuela.service;

import org.rodry.escuela.dto.profesor.CreateProfesorDTO;
import org.rodry.escuela.dto.profesor.ProfesorDTO;

import java.util.List;

public interface ProfesorService {
    List<ProfesorDTO> getAllProfesores();
    ProfesorDTO createProfesor(CreateProfesorDTO profesorDTO);
}
