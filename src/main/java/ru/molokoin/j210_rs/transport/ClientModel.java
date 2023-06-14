package ru.molokoin.j210_rs.transport;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlTransient;
import ru.molokoin.j210_rs.entities.AddressEntity;
/**
 * Класс-модель, для транспортировки данных между сервисом и клиентом
 */
import ru.molokoin.j210_rs.entities.ClientEntity;
@XmlRootElement(name = "client")
public class ClientModel implements Serializable{
    private Integer id;
    private String name;
    private String client_type;
    private String added;
    private Collection<AddressModel> addresses = new ArrayList<>();

    public ClientModel(){}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClient_type() {
        return client_type;
    }

    public void setClient_type(String client_type) {
        this.client_type = client_type;
    }

    public String getAdded() {
        return added;
    }

    public void setAdded(String added) {
        this.added = added;
    }

    //@XmlTransient
    public Collection<AddressModel> getAddresses() {
        return addresses;
    }

    public void setAddresses(Collection<AddressModel> addresses) {
        this.addresses = addresses;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((client_type == null) ? 0 : client_type.hashCode());
        result = prime * result + ((added == null) ? 0 : added.hashCode());
        result = prime * result + ((addresses == null) ? 0 : addresses.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        ClientModel other = (ClientModel) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (client_type == null) {
            if (other.client_type != null)
                return false;
        } else if (!client_type.equals(other.client_type))
            return false;
        if (added == null) {
            if (other.added != null)
                return false;
        } else if (!added.equals(other.added))
            return false;
        if (addresses == null) {
            if (other.addresses != null)
                return false;
        } else if (!addresses.equals(other.addresses))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "ClientModel [id=" + id + ", name=" + name + ", client_type=" + client_type + ", added=" + added
                + ", addresses=" + addresses + "]";
    }
    /**
     * Метод преобразования модели в сущность базы данных
     * - применяется только в серверной модели
     * @return
     */
    public ClientEntity toEntity(){
        ClientEntity ce = new ClientEntity();
        ce.setId(id);
        ce.setName(name);
        ce.setClient_type(client_type);
        ce.setAdded(added);
        /**
         * Преобразуем список моделей адресов в сущности
         */
        Collection <AddressEntity> aec = new ArrayList<>();
        for (AddressModel am : addresses) {
            AddressEntity ae = am.toEntity();
            ae.setClient(ce);
            aec.add(ae);
        }
        return ce;
    }
}
