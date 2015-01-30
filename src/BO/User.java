/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BO;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Temp
 */
@Entity
@Table(name = "user")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "User.findAll", query = "SELECT u FROM User u"),
    @NamedQuery(name = "User.findById", query = "SELECT u FROM User u WHERE u.id = :id"),
    @NamedQuery(name = "User.findByEmail", query = "SELECT u FROM User u WHERE u.email = :email"),
    @NamedQuery(name = "User.findByFirstname", query = "SELECT u FROM User u WHERE u.firstname = :firstname"),
    @NamedQuery(name = "User.findByHerbaccount", query = "SELECT u FROM User u WHERE u.herbaccount = :herbaccount"),
    @NamedQuery(name = "User.findByLastname", query = "SELECT u FROM User u WHERE u.lastname = :lastname"),
    @NamedQuery(name = "User.findByPassword", query = "SELECT u FROM User u WHERE u.password = :password")})
public class User implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Long id;
    @Column(name = "EMAIL")
    private String email;
    @Column(name = "FIRSTNAME")
    private String firstname;
    @Column(name = "HERBACCOUNT")
    private String herbaccount;
    @Column(name = "LASTNAME")
    private String lastname;
    @Column(name = "PASSWORD")
    private String password;
    @JoinColumn(name = "USERSETTINGID_ID", referencedColumnName = "ID")
    @ManyToOne
    private Usersetting usersettingidId;
    @JoinColumn(name = "ADDRESSID_ID", referencedColumnName = "ID")
    @ManyToOne
    private Address addressidId;
    @JoinColumn(name = "HERBALEVELID_ID", referencedColumnName = "ID")
    @ManyToOne
    private Herbalevel herbalevelidId;

    public User() {
    }

    public User(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getHerbaccount() {
        return herbaccount;
    }

    public void setHerbaccount(String herbaccount) {
        this.herbaccount = herbaccount;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Usersetting getUsersettingidId() {
        return usersettingidId;
    }

    public void setUsersettingidId(Usersetting usersettingidId) {
        this.usersettingidId = usersettingidId;
    }

    public Address getAddressidId() {
        return addressidId;
    }

    public void setAddressidId(Address addressidId) {
        this.addressidId = addressidId;
    }

    public Herbalevel getHerbalevelidId() {
        return herbalevelidId;
    }

    public void setHerbalevelidId(Herbalevel herbalevelidId) {
        this.herbalevelidId = herbalevelidId;
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
        if (!(object instanceof User)) {
            return false;
        }
        User other = (User) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "BO.User[ id=" + id + " ]";
    }
    
}
