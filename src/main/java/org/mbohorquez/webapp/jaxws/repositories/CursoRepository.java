package org.mbohorquez.webapp.jaxws.repositories;

import org.mbohorquez.webapp.jaxws.models.entity.Curso;

import java.util.List;

public interface CursoRepository {
    List<Curso> listar();
    Curso porId(Long id);
    Curso guardar(Curso curso);
    void eliminar(Long id);
}
