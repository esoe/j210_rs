package ru.molokoin.j210_rs.api;

import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import ru.molokoin.j210_rs.services.RepositoryFace;
import ru.molokoin.j210_rs.entities.AddressEntity;
import ru.molokoin.j210_rs.entities.ClientEntity;

import java.util.List;

@Stateless
@Path("addresses")
public class RestAddressService {

    @EJB
    private RepositoryFace repository;

    @GET
    @Produces(MediaType.APPLICATION_XML)
    public List<AddressEntity> getAll(){
        System.out.println("Передача всех адресов ...");
        return repository.findAll(AddressEntity.class);
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_XML)
    public AddressEntity getAddressById(@PathParam("id") Integer id){
        System.out.println("Передача адреса по id ...");
        return repository.getAddressById(id);
    }

    @DELETE
    @Path("{id}")
    public void delete(@PathParam("id") Integer id){
        System.out.println("Удаление адреса ...");
        repository.delete(AddressEntity.class, id);
    }

    @POST
    @Consumes(MediaType.APPLICATION_XML)
    public void create(AddressEntity address){
        System.out.println("Добавление адреса ...");
        repository.save(address);
    }

    @PUT
    @Consumes(MediaType.APPLICATION_XML)
    public void update(AddressEntity address){
        System.out.println("Обновление адреса ...");
        repository.update(address);
    }
}
