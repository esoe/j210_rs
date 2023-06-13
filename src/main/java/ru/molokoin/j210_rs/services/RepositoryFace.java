package ru.molokoin.j210_rs.services;

import java.util.List;

import jakarta.ejb.Local;
import ru.molokoin.j210_rs.entities.Address;
import ru.molokoin.j210_rs.entities.Client;

@Local
public interface RepositoryFace {
    <T> List<T> findAll(Class<T> clazz);
    <T> T findById(Class<T> clazz, Integer id);
    <T> void delete(Class<T> clazz, Integer id);
    <T> void save(T entity);
    <T> void update(T entity);

    List<Client> getClients();
    List<Client> getClients(String filterName, String filterType);
    Client getClientById(Integer id);
    Client createClient(Client client);
    Client updateClient(Client client);
    void removeClient(Integer id);
    Address createAddress(Address address);
    Address updateAddress(Address address);
    void removeAddress(Integer id);
    Address getAddressById(Integer id);
    List<Address> getAddresses();
    List<Address> getAddressesByClientID(Integer client_id);
}
