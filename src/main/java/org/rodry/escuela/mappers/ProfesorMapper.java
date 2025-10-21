package org.rodry.escuela.mappers;

import org.rodry.escuela.dto.CreateProfesorDTO;
import org.rodry.escuela.dto.ProfesorDTO;
import org.rodry.escuela.entities.Profesor;
import org.springframework.stereotype.Component;

@Component
public class ProfesorMapper {
    public ProfesorDTO toDto(Profesor profesor) {

        if (profesor == null) {
            return null;
        }
        ProfesorDTO profesorDTO = new ProfesorDTO();
        profesorDTO.setId(profesor.getId());
        profesorDTO.setNombre(profesor.getNombre());
        profesorDTO.setEmail(profesor.getEmail());
        return profesorDTO;
    }

    public Profesor toEntity(CreateProfesorDTO createProfesorDTO) {
        if (createProfesorDTO == null) {
            return null;
        }
        Profesor profesor = new Profesor();
        profesor.setNombre(createProfesorDTO.getNombre());
        profesor.setEmail(createProfesorDTO.getEmail());

        return profesor;
    }
}
