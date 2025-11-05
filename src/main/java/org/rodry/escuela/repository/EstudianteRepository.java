package org.rodry.escuela.repository;

import org.rodry.escuela.entities.Estudiante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EstudianteRepository extends JpaRepository<Estudiante,Long> {
    List<Estudiante> findAllByActivoTrue();

}
