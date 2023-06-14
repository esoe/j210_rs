package ru.molokoin.j210_rs.services;

import java.util.List;

import jakarta.ejb.Local;
import ru.molokoin.j210_rs.entities.AddressEntity;
import ru.molokoin.j210_rs.entities.ClientEntity;

@Local
public interface RepositoryFace {
    <T> List<T> findAll(Class<T> clazz);
    <T> T findById(Class<T> clazz, Integer id);
    <T> void delete(Class<T> clazz, Integer id);
    <T> void save(T entity);
    <T> void update(T entity);

    List<ClientEntity> getClients();
    List<ClientEntity> getClients(String filterName, String filterType);
    ClientEntity getClientById(Integer id);
    ClientEntity createClient(ClientEntity client);
    ClientEntity updateClient(ClientEntity client);
    void removeClient(Integer id);
    AddressEntity createAddress(AddressEntity address);
    AddressEntity updateAddress(AddressEntity address);
    void removeAddress(Integer id);
    AddressEntity getAddressById(Integer id);
    List<AddressEntity> getAddresses();
    List<AddressEntity> getAddressesByClientID(Integer client_id);
}
