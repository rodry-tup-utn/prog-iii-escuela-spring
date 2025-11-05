package org.rodry.escuela.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@SuperBuilder
public class Curso extends Base{
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

    public void agregarEstudiante(Estudiante estudiante) {
        if (this.estudiantes.contains(estudiante)) {
            return;
        }
        this.estudiantes.add(estudiante);
        estudiante.agregarCurso(this);
    }

    public void removerEstudiante(Estudiante estudiante) {
        if (this.estudiantes.remove(estudiante)) {
            estudiante.removerCurso(this);
        }
    }
}
