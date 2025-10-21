package org.rodry.escuela.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    
    @ManyToOne
    @JoinColumn(name = "profesor_id", nullable = false)
    private Profesor profesor;

    @ManyToMany
    @JoinTable(name = "estudiante_curso",
            joinColumns = @JoinColumn(name = "curso_id"),
            inverseJoinColumns = @JoinColumn(name = "estudiante_id"))
    @Builder.Default
    private List<Estudiante> estudiantes = new ArrayList<>();
}
