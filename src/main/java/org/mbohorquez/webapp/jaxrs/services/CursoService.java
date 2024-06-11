package org.mbohorquez.webapp.jaxrs.services;

import jakarta.ejb.Local;
import org.mbohorquez.webapp.jaxrs.models.entities.Curso;

import java.util.List;
import java.util.Optional;

@Local
public interface CursoService {
    List<Curso> listar();

    Optional<Curso> porId(Long id);

    Curso guardar(Curso curso);

    void eliminar(Long id);
}
