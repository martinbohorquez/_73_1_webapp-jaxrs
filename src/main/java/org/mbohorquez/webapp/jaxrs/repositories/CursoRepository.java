package org.mbohorquez.webapp.jaxrs.repositories;

import org.mbohorquez.webapp.jaxrs.models.entities.Curso;

import java.util.List;

public interface CursoRepository {
    List<Curso> listar();
    Curso porId(Long id);
    Curso guardar(Curso curso);
    void eliminar(Long id);
}
