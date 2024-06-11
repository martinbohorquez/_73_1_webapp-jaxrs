package org.mbohorquez.webapp.jaxrs.repositories;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import org.mbohorquez.webapp.jaxrs.models.entities.Curso;

import java.util.List;

@RequestScoped
public class CursoRepositoryImpl implements CursoRepository {
    @Inject
    private EntityManager em;

    @Override
    public List<Curso> listar() {
        return em.createQuery("select c from Curso c", Curso.class).getResultList();
    }

    @Override
    public Curso porId(Long id) {
        return em.find(Curso.class, id);
    }

    @Override
    public Curso guardar(Curso curso) {
        if (curso.getId() != null && curso.getId() > 0) {
            em.merge(curso);
        } else {
            em.persist(curso);
        }
        return curso;
    }

    @Override
    public void eliminar(Long id) {
        Curso curso = porId(id);
        em.remove(curso);

    }
}
