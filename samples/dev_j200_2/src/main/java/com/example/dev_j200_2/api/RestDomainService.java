package com.example.dev_j200_2.api;

import com.example.dev_j200_2.entities.DomainEntity;
import com.example.dev_j200_2.repo.AppRepositoryI;
import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@Stateless
@Path("domain")
public class RestDomainService {

    @EJB
    private AppRepositoryI repository;

    //localhost:8080/sameApp/api/domain/1
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<DomainEntity> getAll(){
        return repository.findAll(DomainEntity.class);
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public DomainEntity getDomain(@PathParam("id") Long id){
        return repository.findById(DomainEntity.class, id);
    }

    @DELETE
    @Path("{id}")
    public void delete(@PathParam("id") Long id){
        repository.delete(DomainEntity.class, id);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void create(DomainEntity domain){
        repository.save(domain);
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void update(DomainEntity domain){
        System.out.println(domain);
        repository.update(domain);
    }
}
