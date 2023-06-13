package ru.molokoin.j210_rs.api;

import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import ru.molokoin.j210_rs.services.RepositoryFace;
import ru.molokoin.j210_rs.entities.Address;
import ru.molokoin.j210_rs.entities.Client;

import java.util.List;

@Stateless
@Path("addresses")
public class RestAddressService {

    @EJB
    private RepositoryFace repository;

    // @GET
    // @Produces(MediaType.APPLICATION_XML)
    // public List<Address> getAddresses(){
    //     return repository.getAddresses();
    // }

    @GET
    @Produces(MediaType.APPLICATION_XML)
    public List<Address> getAll(){
        return repository.findAll(Address.class);
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_XML)
    public Address getAddressById(@PathParam("id") Integer id){
        return repository.getAddressById(id);
    }

    @DELETE
    @Path("{id}")
    public void delete(@PathParam("id") Integer id){
        repository.delete(Address.class, id);
    }

    @POST
    @Consumes(MediaType.APPLICATION_XML)
    public void create(Address address){
        repository.save(address);
    }

    @PUT
    @Consumes(MediaType.APPLICATION_XML)
    public void update(Address address){
        repository.update(address);
    }
}
