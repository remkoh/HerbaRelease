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
@Table(name = "usersetting")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usersetting.findAll", query = "SELECT u FROM Usersetting u"),
    @NamedQuery(name = "Usersetting.findById", query = "SELECT u FROM Usersetting u WHERE u.id = :id"),
    @NamedQuery(name = "Usersetting.findByIsadmin", query = "SELECT u FROM Usersetting u WHERE u.isadmin = :isadmin"),
    @NamedQuery(name = "Usersetting.findByIslocked", query = "SELECT u FROM Usersetting u WHERE u.islocked = :islocked"),
    @NamedQuery(name = "Usersetting.findByIsmailverified", query = "SELECT u FROM Usersetting u WHERE u.ismailverified = :ismailverified"),
    @NamedQuery(name = "Usersetting.findByIsmember", query = "SELECT u FROM Usersetting u WHERE u.ismember = :ismember")})
public class Usersetting implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Long id;
    @Column(name = "ISADMIN")
    private Boolean isadmin;
    @Column(name = "ISLOCKED")
    private Boolean islocked;
    @Column(name = "ISMAILVERIFIED")
    private Boolean ismailverified;
    @Column(name = "ISMEMBER")
    private Boolean ismember;
    @OneToMany(mappedBy = "usersettingidId")
    private Collection<User> userCollection;

    public Usersetting() {
    }

    public Usersetting(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getIsadmin() {
        return isadmin;
    }

    public void setIsadmin(Boolean isadmin) {
        this.isadmin = isadmin;
    }

    public Boolean getIslocked() {
        return islocked;
    }

    public void setIslocked(Boolean islocked) {
        this.islocked = islocked;
    }

    public Boolean getIsmailverified() {
        return ismailverified;
    }

    public void setIsmailverified(Boolean ismailverified) {
        this.ismailverified = ismailverified;
    }

    public Boolean getIsmember() {
        return ismember;
    }

    public void setIsmember(Boolean ismember) {
        this.ismember = ismember;
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
        if (!(object instanceof Usersetting)) {
            return false;
        }
        Usersetting other = (Usersetting) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "BO.Usersetting[ id=" + id + " ]";
    }
    
}
