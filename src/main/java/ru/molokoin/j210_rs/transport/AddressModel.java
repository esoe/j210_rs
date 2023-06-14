package ru.molokoin.j210_rs.transport;

import java.io.Serializable;

import jakarta.xml.bind.annotation.XmlRootElement;
/**
 * Класс-модель, для транспортировки данных между сервисом и клиентом
 */
import ru.molokoin.j210_rs.entities.AddressEntity;
@XmlRootElement(name = "address")
public class AddressModel implements Serializable{
    private Integer id;
    private String ip;
    private String mac;
    private String model;
    private String address;
    private Integer client_id;
    
    public AddressModel(){}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getMac() {
        return mac;
    }

    public void setMac(String mac) {
        this.mac = mac;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getClient_id() {
        return client_id;
    }

    public void setClient_id(Integer client_id) {
        this.client_id = client_id;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((ip == null) ? 0 : ip.hashCode());
        result = prime * result + ((mac == null) ? 0 : mac.hashCode());
        result = prime * result + ((model == null) ? 0 : model.hashCode());
        result = prime * result + ((address == null) ? 0 : address.hashCode());
        result = prime * result + ((client_id == null) ? 0 : client_id.hashCode());
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
        AddressModel other = (AddressModel) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (ip == null) {
            if (other.ip != null)
                return false;
        } else if (!ip.equals(other.ip))
            return false;
        if (mac == null) {
            if (other.mac != null)
                return false;
        } else if (!mac.equals(other.mac))
            return false;
        if (model == null) {
            if (other.model != null)
                return false;
        } else if (!model.equals(other.model))
            return false;
        if (address == null) {
            if (other.address != null)
                return false;
        } else if (!address.equals(other.address))
            return false;
        if (client_id == null) {
            if (other.client_id != null)
                return false;
        } else if (!client_id.equals(other.client_id))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "AddressModel [id=" + id + ", ip=" + ip + ", mac=" + mac + ", model=" + model + ", address=" + address
                + ", client_id=" + client_id + "]";
    }

    /**
     * Метод преобразует модель данных об адресе в сущность базы данных
     * - применим только в серверной части приложения
     * - надеюсь, данные о идентификаторе клиента подцепятся автоматически (наврятли конечно, модель то без магии работает)
     * - возможно стоит тут сделать запрос в репозиторий и по id-клиента притащить сущность клиента. 
     * @return
     */
    public AddressEntity toEntity(){
        AddressEntity ae = new AddressEntity();
        ae.setAddress(address);
        ae.setId(id);
        ae.setIp(ip);
        ae.setMac(mac);
        ae.setModel(model);
        return ae;
    }
    
    
    
}
