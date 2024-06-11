package org.mbohorquez.webapp.jaxws.controllers;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.mbohorquez.webapp.jaxws.models.entity.Curso;
import org.mbohorquez.webapp.jaxws.services.CursoService;

import java.util.List;

@RequestScoped
@Path("/cursos")
//@Produces(MediaType.APPLICATION_XML)
@Produces(MediaType.APPLICATION_JSON)
public class CursoRestController {

    @Inject
    CursoService service;

    @GET
    public List<Curso> listar() {
        return service.listar();
    }

    @GET
    @Path("/{id}")
    public Response porId(@PathParam("id") Long id) {
        return service.porId(id)
                .map(existingCurso -> Response.ok(existingCurso).build())
                .orElse(Response.status(Response.Status.NOT_FOUND).build());
    }

    @POST
//    @Consumes(MediaType.APPLICATION_XML)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response crear(Curso curso) {
        try {
            service.guardar(curso);
            return Response.ok(curso).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.serverError().build();
        }
    }

    @PUT
    @Path("/{id}")
//    @Consumes(MediaType.APPLICATION_XML)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response editar(@PathParam("id") Long id, Curso curso) {
        return service.porId(id)
                .map(existingCurso -> {
                    try {
                        existingCurso.setNombre(curso.getNombre());
                        existingCurso.setDescripcion(curso.getDescripcion());
                        existingCurso.setDuracion(curso.getDuracion());
                        existingCurso.setInstructor(curso.getInstructor());
                        service.guardar(existingCurso);
                        return Response.ok(existingCurso).build();
                    } catch (Exception e) {
                        e.printStackTrace();
                        return Response.serverError().build();
                    }
                })
                .orElse(Response.status(Response.Status.NOT_FOUND).build());
    }

    @DELETE
    @Path("/{id}")
    public Response eliminar(@PathParam("id") Long id) {
        return service.porId(id)
                .map(existingCurso -> {
                    try {
                        service.eliminar(existingCurso.getId());
                        return Response.noContent().build();
                    } catch (Exception e) {
                        e.printStackTrace();
                        return Response.serverError().build();
                    }
                })
                .orElse(Response.status(Response.Status.NOT_FOUND).build());
    }

}
