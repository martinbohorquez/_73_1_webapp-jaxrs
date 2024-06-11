package org.mbohorquez.webapp.jaxrs.services;


import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.jws.WebMethod;
import org.mbohorquez.webapp.jaxrs.models.entities.Curso;
import org.mbohorquez.webapp.jaxrs.repositories.CursoRepository;

import java.util.List;
import java.util.Optional;

@Stateless
public class CursoServiceImpl implements CursoService {
    @Inject
    private CursoRepository repository;

    @Override
    @WebMethod
    public List<Curso> listar() {
        return repository.listar();
    }

    @Override
    public Optional<Curso> porId(Long id) {
        return Optional.ofNullable(repository.porId(id));
    }

    @Override
    @WebMethod
    public Curso guardar(Curso curso) {
        return repository.guardar(curso);
    }

    @Override
    public void eliminar(Long id) {
        repository.eliminar(id);
    }
}
