package org.mbohorquez.webapp.jaxws.services;

import jakarta.ejb.Local;
import org.mbohorquez.webapp.jaxws.models.entity.Curso;

import java.util.List;
import java.util.Optional;

@Local
public interface CursoService {
    List<Curso> listar();

    Optional<Curso> porId(Long id);

    Curso guardar(Curso curso);

    void eliminar(Long id);
}
