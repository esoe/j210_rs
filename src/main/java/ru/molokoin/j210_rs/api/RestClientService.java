package ru.molokoin.j210_rs.api;

import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import ru.molokoin.j210_rs.entities.AddressEntity;
import ru.molokoin.j210_rs.entities.ClientEntity;
import ru.molokoin.j210_rs.services.RepositoryFace;
import ru.molokoin.j210_rs.transport.ClientModel;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Stateless
@Path("clients")
public class RestClientService {

    @EJB
    private RepositoryFace repository;

    // @GET
    // @Produces(MediaType.APPLICATION_XML)
    // public Collection<ClientModel> getAll(){
    //     Collection<ClientModel> ccm = new ArrayList<>();
    //     Collection<ClientEntity> cce = repository.findAll(ClientEntity.class);
    //     for (ClientEntity ce : cce) {
    //         ClientModel cm = ce.toModel();
    //         ccm.add(cm);
    //     }
    //     return ccm;
    // }

    /**
     * Получение сведений о всех Клиентах
     * @return
     */
    @GET
    @Produces(MediaType.APPLICATION_XML)
    public Collection<ClientEntity> getClients(){
        System.out.println("Передача данных обо всех клиентах ...");
        Collection<ClientEntity> cce = repository.findAll(ClientEntity.class);
        return cce;
    }

    /**
     * Получение сущности клиента по id
     * @param id
     * @return
     */
    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_XML)
    public ClientEntity getClient(@PathParam("id") Integer id){
        System.out.println("Передача данных о клиенте по id ...");
        return repository.findById(ClientEntity.class, id);
    }

    @DELETE
    @Path("{id}")
    public void delete(@PathParam("id") Integer id){
        System.out.println("Удаление данных клиента по id ...");
        repository.delete(ClientEntity.class, id);
    }

    @POST
    @Consumes(MediaType.APPLICATION_XML)
    public void create(ClientEntity client){
        System.out.println("Добавление данных нового клиента ...");
        repository.save(client);
    }

    @PUT
    @Consumes(MediaType.APPLICATION_XML)
    public void update(ClientEntity client){
        System.out.println("Обновление данных клиента ...");
        repository.update(client);
    }
    
}
