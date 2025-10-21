package org.rodry.escuela.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Estudiante {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String matricula;


    @ManyToMany(mappedBy = "estudiantes")
    @JsonIgnore
    @Builder.Default
    private Set<Curso> cursos = new HashSet<>();

}
