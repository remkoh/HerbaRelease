/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BO;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Temp
 */
@Entity
@Table(name = "domicile")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Domicile.findAll", query = "SELECT d FROM Domicile d"),
    @NamedQuery(name = "Domicile.findById", query = "SELECT d FROM Domicile d WHERE d.id = :id"),
    @NamedQuery(name = "Domicile.findByCity", query = "SELECT d FROM Domicile d WHERE d.city = :city"),
    @NamedQuery(name = "Domicile.findByCountry", query = "SELECT d FROM Domicile d WHERE d.country = :country"),
    @NamedQuery(name = "Domicile.findByPostalcode", query = "SELECT d FROM Domicile d WHERE d.postalcode = :postalcode")})
public class Domicile implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Long id;
    @Column(name = "CITY")
    private String city;
    @Column(name = "COUNTRY")
    private String country;
    @Column(name = "POSTALCODE")
    private String postalcode;
    @OneToMany(mappedBy = "woonplaatsidId")
    private Collection<Address> addressCollection;

    public Domicile() {
    }

    public Domicile(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPostalcode() {
        return postalcode;
    }

    public void setPostalcode(String postalcode) {
        this.postalcode = postalcode;
    }

    @XmlTransient
    public Collection<Address> getAddressCollection() {
        return addressCollection;
    }

    public void setAddressCollection(Collection<Address> addressCollection) {
        this.addressCollection = addressCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Domicile)) {
            return false;
        }
        Domicile other = (Domicile) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "BO.Domicile[ id=" + id + " ]";
    }
    
}
