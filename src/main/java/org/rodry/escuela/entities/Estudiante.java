package org.rodry.escuela.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.HashSet;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@SuperBuilder
public class Estudiante extends Base {

    private String nombre;
    private String matricula;

    @ManyToMany(mappedBy = "estudiantes")
    @JsonIgnore
    @Builder.Default
    private Set<Curso> cursos = new HashSet<>();

    public void agregarCurso(Curso curso) {
        if (this.cursos.contains(curso)) {
            return;
        }
        this.cursos.add(curso);
        curso.agregarEstudiante(this);
    }

    public void removerCurso(Curso curso) {
        if (this.cursos.remove(curso)) {
            curso.removerEstudiante(this);
        }
    }
}
