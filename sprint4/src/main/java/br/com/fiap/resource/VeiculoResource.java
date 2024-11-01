package br.com.fiap.resource;

import br.com.fiap.bo.VeiculoBO;
import br.com.fiap.to.VeiculoTO;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.sql.SQLException;
import java.util.ArrayList;

@Path("/veiculo")
public class VeiculoResource {
    private VeiculoBO veiculoBO = new VeiculoBO();
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAll() {
        ArrayList<VeiculoTO> resultado = veiculoBO.findAll();
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
    @Path("/{id_veiculo}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findByCodigo(@PathParam("id_veiculo") Long id_veiculo) {
        VeiculoTO resultado = veiculoBO.findByCodigo(id_veiculo);

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
    public Response save(@Valid VeiculoTO veiculo) {
        VeiculoTO resultado = veiculoBO.save(veiculo);

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
    @Path("/{id_veiculo}")
    public Response delete(@PathParam("id_veiculo") Long id_veiculo){
        Response.ResponseBuilder response = null;
        if(veiculoBO.delete(id_veiculo)){
            response = Response.status(204); //204 é o NO CONTENT - porque depois que eu apaguei não tem mais conteúdo, ou seja, deu certo.
        }else{
            response = Response.status(404); //404 NOT FOUND
        }
        return response.build();
    }

    @PUT
    @Path("/{id_veiculo}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response update(@Valid VeiculoTO veiculo, @PathParam("id_veiculo") Long id_veiculo) throws SQLException {
        veiculo.setId_veiculo(id_veiculo);
        VeiculoTO resultado = veiculoBO.update(veiculo);
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
