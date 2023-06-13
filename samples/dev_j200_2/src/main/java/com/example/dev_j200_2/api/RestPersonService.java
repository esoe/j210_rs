package com.example.dev_j200_2.api;

import com.example.dev_j200_2.entities.PersonEntity;
import com.example.dev_j200_2.repo.AppRepositoryI;
import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@Stateless
@Path("person")
public class RestPersonService {

    @EJB
    private AppRepositoryI repository;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<PersonEntity> getAll(){
        return repository.findAll(PersonEntity.class);
    }
}
