package com.example.dev_j200_2.entities;

import jakarta.persistence.*;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlTransient;

import java.sql.Date;

@Entity
@XmlRootElement
@Table(name = "domain", schema = "test_db", catalog = "")
@NamedQueries({
        @NamedQuery(name = "Domain.All", query = "select d from DomainEntity d")
})
public class DomainEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @Basic
    @Column(name = "domain_name")
    private String domainName;
    @Basic
    @Column(name = "ip")
    private String ip;
    @Basic
    @Column(name = "date_reg")
    private Date dateReg;
    @Basic
    @Column(name = "country_reg")
    private String countryReg;
    @JoinColumn(name = "person")
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private PersonEntity person;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @XmlTransient
    public PersonEntity getPerson() {
        return person;
    }

    public void setPerson(PersonEntity person) {
        this.person = person;
    }

    public String getDomainName() {
        return domainName;
    }

    public void setDomainName(String domainName) {
        this.domainName = domainName;
    }


    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }


    public Date getDateReg() {
        return dateReg;
    }

    public void setDateReg(Date dateReg) {
        this.dateReg = dateReg;
    }


    public String getCountryReg() {
        return countryReg;
    }

    public void setCountryReg(String countryReg) {
        this.countryReg = countryReg;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DomainEntity that = (DomainEntity) o;

        if (id != that.id) return false;
        if (domainName != null ? !domainName.equals(that.domainName) : that.domainName != null) return false;
        if (ip != null ? !ip.equals(that.ip) : that.ip != null) return false;
        if (dateReg != null ? !dateReg.equals(that.dateReg) : that.dateReg != null) return false;
        if (countryReg != null ? !countryReg.equals(that.countryReg) : that.countryReg != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (domainName != null ? domainName.hashCode() : 0);
        result = 31 * result + (ip != null ? ip.hashCode() : 0);
        result = 31 * result + (dateReg != null ? dateReg.hashCode() : 0);
        result = 31 * result + (countryReg != null ? countryReg.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "DomainEntity{" +
                "id=" + id +
                ", domainName='" + domainName + '\'' +
                ", ip='" + ip + '\'' +
                ", dateReg=" + dateReg +
                ", countryReg='" + countryReg + '\'' +
                '}';
    }
}
