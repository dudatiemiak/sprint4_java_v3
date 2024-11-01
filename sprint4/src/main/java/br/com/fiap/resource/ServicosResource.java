package br.com.fiap.resource;

import br.com.fiap.bo.ServicosBO;
import br.com.fiap.to.ServicosTO;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.sql.SQLException;
import java.util.ArrayList;

@Path("/servicos")
public class ServicosResource {
    private ServicosBO servicosBO = new ServicosBO();
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAll() {
        ArrayList<ServicosTO> resultado = servicosBO.findAll();
        Response.ResponseBuilder response = null;

        if (resultado != null) {
            response = Response.ok(); // 200 (ok)
        } else {
            response = Response.status(404); // 404 (NOT FOUND)
        }
        response.entity(resultado);
        return  response.build();
    }

    @GET
    @Path("/{id_servicos}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findByCodigo(@PathParam("id_servicos") Long id_servicos) {
        ServicosTO resultado = servicosBO.findByCodigo(id_servicos);

        Response.ResponseBuilder response = null;

        if (resultado != null) {
            response = Response.ok(); //200 ok
        } else {
            response = Response.status(404); //404 NOT FOUND
        }
        response.entity(resultado);
        return response.build();
    }


    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response save(@Valid ServicosTO servico) {
        ServicosTO resultado = servicosBO.save(servico);

        Response.ResponseBuilder response = null;

        if  (resultado != null) {
            response = Response.created(null); //201 - CREATED
        } else {
            response = Response.status(400); // 400 - BAD REQUEST
        }
        response.entity(resultado);
        return  response.build();
    }

    //método que vai responder ao verbo delete
    //só o delete vai ser diferente pq ele retorna verdadeiro ou falso
    @DELETE
    @Path("/{id_servicos}")
    public Response delete(@PathParam("id_servicos") Long id_servicos){
        Response.ResponseBuilder response = null;
        if(servicosBO.delete(id_servicos)){
            response = Response.status(204); //204 é o NO CONTENT - porque depois que eu apaguei não tem mais conteúdo, ou seja, deu certo.
        }else{
            response = Response.status(404); //404 NOT FOUND
        }
        return response.build();
    }

    @PUT
    @Path("/{id_servicos}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response update(@Valid ServicosTO servico, @PathParam("id_servicos") Long id_servicos) throws SQLException {
        servico.setId_servicos(id_servicos);
        ServicosTO resultado = servicosBO.update(servico);
        Response.ResponseBuilder response = null;
        if (resultado != null){
            response = Response.created(null); //201 CREATED
        }else {
            response = Response.status(400); //400 BAD REQUEST
        }
        response.entity(resultado);
        return response.build();
    }
}
