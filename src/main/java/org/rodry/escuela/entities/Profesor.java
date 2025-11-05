package org.rodry.escuela.entities;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@SuperBuilder
public class Profesor extends Base {
    private String nombre;
    private String email;
}
