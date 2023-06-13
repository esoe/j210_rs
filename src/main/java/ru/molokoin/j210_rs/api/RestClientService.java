package ru.molokoin.j210_rs.api;

import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import ru.molokoin.j210_rs.entities.Client;
import ru.molokoin.j210_rs.services.RepositoryFace;

import java.util.List;

@Stateless
@Path("clients")
public class RestClientService {

    @EJB
    private RepositoryFace repository;

    @GET
    @Produces(MediaType.APPLICATION_XML)
    public List<Client> getAll(){
        return repository.findAll(Client.class);
    }
    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_XML)
    public Client getClient(@PathParam("id") Integer id){
        return repository.findById(Client.class, id);
    }
    
}
