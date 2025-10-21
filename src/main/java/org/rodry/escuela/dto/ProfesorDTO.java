package org.rodry.escuela.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProfesorDTO {
    private Long id;
    private String nombre;
    private String email;
}
