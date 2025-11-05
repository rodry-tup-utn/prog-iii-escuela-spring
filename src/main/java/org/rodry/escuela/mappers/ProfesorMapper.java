package org.rodry.escuela.mappers;

import org.rodry.escuela.dto.profesor.CreateProfesorDTO;
import org.rodry.escuela.dto.profesor.ProfesorDTO;
import org.rodry.escuela.entities.Profesor;
import org.springframework.stereotype.Component;

@Component
public class ProfesorMapper {
    public ProfesorDTO toDto(Profesor profesor) {

        return new ProfesorDTO(
                profesor.getId(),
                profesor.getNombre(),
                profesor.getEmail()
        );
    }

    public Profesor toEntity(CreateProfesorDTO createProfesorDTO) {

        return Profesor.builder()
                .nombre(createProfesorDTO.nombre())
                .email(createProfesorDTO.email())
                .activo(true)
                .build();
    }
}
