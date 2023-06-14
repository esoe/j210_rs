package ru.molokoin.j210_rs.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlTransient;
import ru.molokoin.j210_rs.transport.AddressModel;
import ru.molokoin.j210_rs.transport.ClientModel;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;

@Entity
@XmlRootElement(name = "client")
@Table(name = "Clients", schema = "j200", catalog = "")
@NamedQueries({
    @NamedQuery(name = "Clients.findAll",
                query = "SELECT c FROM ClientEntity c")
})
public class ClientEntity implements Serializable{
    private static final long serialVersionUID = 1L;

    @Id //уникальный идентификатор строки
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false) //не может быть null
    @Column(name = "id")
    private Integer id;
    @Column(name = "name", length = 100)
    private String name;
    @Column(name = "client_type", length = 100)
    private String client_type;
    @Column(name = "added", length = 100)
    private String added;
    @OneToMany(mappedBy = "client", fetch = FetchType.EAGER)
    private Collection<AddressEntity> addresses = new ArrayList<>();

    public ClientEntity(){}
    public ClientEntity(String name, String client_type, String added){
        setName(name);
        setClient_type(client_type);
        setAdded(added);
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public Integer getId() {
        return id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public void setClient_type(String client_type) {
        this.client_type = client_type;
    }
    public String getClient_type() {
        return client_type;
    }
    public void setAdded(String added) {
        this.added = added;
    }
    public String getAdded() {
        return added;
    }
    //@XmlTransient
    public Collection<AddressEntity> getAddresses() {
        return addresses;
    }
    public void setAddresses(Collection<AddressEntity> addresses) {
        this.addresses = addresses;
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
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
        ClientEntity other = (ClientEntity) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }
    @Override
    public String toString() {
        return "Client [id=" + id + ", name=" + name + ", client_type=" + client_type + ", added=" + added
                + ", addresses=" + addresses
                + "]";
    }
    public ClientModel toModel() {
        ClientModel cm = new ClientModel();
        cm.setId(id);
        cm.setName(name);
        cm.setAdded(added);
        cm.setClient_type(client_type);
        Collection<AddressModel> cam = new ArrayList<>();
        for (AddressEntity ae : addresses) {
            cam.add(ae.toModel());
        }
        cm.setAddresses(cam);
        return cm;
    }
    

}
