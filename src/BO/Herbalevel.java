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
@Table(name = "herbalevel")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Herbalevel.findAll", query = "SELECT h FROM Herbalevel h"),
    @NamedQuery(name = "Herbalevel.findById", query = "SELECT h FROM Herbalevel h WHERE h.id = :id"),
    @NamedQuery(name = "Herbalevel.findByDiscountamount", query = "SELECT h FROM Herbalevel h WHERE h.discountamount = :discountamount"),
    @NamedQuery(name = "Herbalevel.findByLevelname", query = "SELECT h FROM Herbalevel h WHERE h.levelname = :levelname")})
public class Herbalevel implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Long id;
    @Column(name = "DISCOUNTAMOUNT")
    private Integer discountamount;
    @Column(name = "LEVELNAME")
    private String levelname;
    @OneToMany(mappedBy = "herbalevelidId")
    private Collection<User> userCollection;

    public Herbalevel() {
    }

    public Herbalevel(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getDiscountamount() {
        return discountamount;
    }

    public void setDiscountamount(Integer discountamount) {
        this.discountamount = discountamount;
    }

    public String getLevelname() {
        return levelname;
    }

    public void setLevelname(String levelname) {
        this.levelname = levelname;
    }

    @XmlTransient
    public Collection<User> getUserCollection() {
        return userCollection;
    }

    public void setUserCollection(Collection<User> userCollection) {
        this.userCollection = userCollection;
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
        if (!(object instanceof Herbalevel)) {
            return false;
        }
        Herbalevel other = (Herbalevel) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "BO.Herbalevel[ id=" + id + " ]";
    }
    
}
