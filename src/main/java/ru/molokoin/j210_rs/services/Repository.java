package ru.molokoin.j210_rs.services;

import java.util.Collection;
import java.util.List;

import jakarta.ejb.Singleton;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import ru.molokoin.j210_rs.entities.AddressEntity;
import ru.molokoin.j210_rs.entities.ClientEntity;

@Singleton
public class Repository implements RepositoryFace{
    @PersistenceContext (unitName="Repository")
    private EntityManager em;

    @Override
    public <T> List<T> findAll(Class<T> clazz) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<T> cq = cb.createQuery(clazz);
        //Metamodel m = em.getMetamodel();
        Root<T> obj = cq.from(clazz);
        return em.createQuery(cq.select(obj)).getResultList();
    }

    @Override
    public <T> T findById(Class<T> clazz, Integer id) {
        return em.find(clazz, id);
    }

    @Override
    public <T> void delete(Class<T> clazz, Integer id) {
        T entity = em.find(clazz, id);
        em.remove(entity);
    }

    @Override
    public <T> void save(T entity) {
        em.persist(entity);
    }

    @Override
    public <T> void update(T entity) {
        em.merge(entity);
        em.flush();
    }

    @Override
    public List<ClientEntity> getClients() {
        return em.createNamedQuery("Clients.findAll", ClientEntity.class).getResultList();
    }

    

    @Override
    public List<ClientEntity> getClients(String filterName, String filterType) {
        if (filterName == null){filterName = "";}
        if (filterType == null){filterType = "";}
        String sql = "SELECT id, name, client_type, added FROM Clients WHERE name LIKE '%" + filterName+ "%' AND client_type LIKE '%" + filterType+ "%'";
        Query query = em.createNativeQuery(sql, ClientEntity.class);
        List<ClientEntity> clients = query.getResultList();
        return clients;
    }
    
    @Override
    public ClientEntity getClientById(Integer id){
        return em.find(ClientEntity.class, id);
    }

    @Override
    public ClientEntity createClient(ClientEntity client) {
        String sql = "SELECT * FROM Clients WHERE name='" + client.getName() + "' AND client_type='" + client.getClient_type() + "'";
        List<ClientEntity> list = em.createNativeQuery(sql, ClientEntity.class).getResultList();
        if(list.size()>0) client = list.get(0);
        em.merge(client);
        em.flush();
        return client;
    }

    @Override
    public ClientEntity updateClient(ClientEntity client) {
        em.merge(client);
        em.flush();
        return client;
    }

    /**
     * Проверить наличие адресов у Клиента,
     * при наличии, удалить адреса, затем удалить клиента
     */
    @Override
    public void removeClient(Integer id) {
        ClientEntity client = getClientById(id);
        Collection <AddressEntity> addresses =  client.getAddresses();
        if (addresses.size() > 0){
            for (AddressEntity address : addresses) {
                em.remove(address);
            }
        }
        em.remove(getClientById(id));
        em.flush();
    }

    @Override
    public AddressEntity createAddress(AddressEntity address) {
        String sql = "SELECT * FROM Addresses WHERE ip='"   + address.getIp() 
                                                            + "' AND mac='" + address.getMac() 
                                                            + "' AND model='" + address.getModel()
                                                            + "' AND address='" + address.getAddress()
                                                            + "' AND client_id='" + address.getClient().getId()
                                                            //+ "' AND client_id='" + address.getClient_id()
                                                            + "'";
        List<AddressEntity> list = em.createNativeQuery(sql, AddressEntity.class).getResultList();
        if(list.size()>0) address = list.get(0);
        em.merge(address);
        em.flush();
        return address;
    }
    @Override
    public AddressEntity updateAddress(AddressEntity address) {
        em.merge(address);
        em.flush();
        return address;
    }

    @Override
    public void removeAddress(Integer id) {
        em.remove(getAddressById(id));
        em.flush();
    }

    @Override
    public AddressEntity getAddressById(Integer id){
        return em.find(AddressEntity.class, id);
    }

    @Override
    public List<AddressEntity> getAddresses() {
        return em.createNamedQuery("Addresses.findAll", AddressEntity.class).getResultList();
    }
    /**
     * Метод возвращает перечень адресов, найденных в таблице Addresses
     * по id Клиента.
     * - метод оказался бесполезным, так как Сущности Клиентов содержат списки сущностей, привязанных к ним адресов.
     */
    @Override
    public List<AddressEntity> getAddressesByClientID(Integer client_id){
        String sql = "SELECT * FROM Addresses WHERE client_id=" + client_id;
        List<AddressEntity> list = em.createNativeQuery(sql, AddressEntity.class).getResultList();
        return list;
    }
}
