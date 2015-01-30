/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BO;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Temp
 */
@Entity
@Table(name = "customerdata")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Customerdata.findAll", query = "SELECT c FROM Customerdata c"),
    @NamedQuery(name = "Customerdata.findById", query = "SELECT c FROM Customerdata c WHERE c.id = :id"),
    @NamedQuery(name = "Customerdata.findByBmi", query = "SELECT c FROM Customerdata c WHERE c.bmi = :bmi"),
    @NamedQuery(name = "Customerdata.findByBonemass", query = "SELECT c FROM Customerdata c WHERE c.bonemass = :bonemass"),
    @NamedQuery(name = "Customerdata.findByCkalrest", query = "SELECT c FROM Customerdata c WHERE c.ckalrest = :ckalrest"),
    @NamedQuery(name = "Customerdata.findByFattymass", query = "SELECT c FROM Customerdata c WHERE c.fattymass = :fattymass"),
    @NamedQuery(name = "Customerdata.findByMetabolicage", query = "SELECT c FROM Customerdata c WHERE c.metabolicage = :metabolicage"),
    @NamedQuery(name = "Customerdata.findByMusclemass", query = "SELECT c FROM Customerdata c WHERE c.musclemass = :musclemass"),
    @NamedQuery(name = "Customerdata.findByVisceralfat", query = "SELECT c FROM Customerdata c WHERE c.visceralfat = :visceralfat"),
    @NamedQuery(name = "Customerdata.findByWaterpercentage", query = "SELECT c FROM Customerdata c WHERE c.waterpercentage = :waterpercentage"),
    @NamedQuery(name = "Customerdata.findByWeighingdate", query = "SELECT c FROM Customerdata c WHERE c.weighingdate = :weighingdate"),
    @NamedQuery(name = "Customerdata.findByWeight", query = "SELECT c FROM Customerdata c WHERE c.weight = :weight")})
public class Customerdata implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Long id;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "BMI")
    private Float bmi;
    @Column(name = "BONEMASS")
    private Float bonemass;
    @Column(name = "CKALREST")
    private Integer ckalrest;
    @Column(name = "FATTYMASS")
    private Float fattymass;
    @Column(name = "METABOLICAGE")
    private Integer metabolicage;
    @Column(name = "MUSCLEMASS")
    private Float musclemass;
    @Column(name = "VISCERALFAT")
    private Float visceralfat;
    @Column(name = "WATERPERCENTAGE")
    private Float waterpercentage;
    @Column(name = "WEIGHINGDATE")
    @Temporal(TemporalType.DATE)
    private Date weighingdate;
    @Column(name = "WEIGHT")
    private Float weight;
    @OneToMany(mappedBy = "customerdataidId")
    private Collection<Customer> customerCollection;

    public Customerdata() {
    }

    public Customerdata(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Float getBmi() {
        return bmi;
    }

    public void setBmi(Float bmi) {
        this.bmi = bmi;
    }

    public Float getBonemass() {
        return bonemass;
    }

    public void setBonemass(Float bonemass) {
        this.bonemass = bonemass;
    }

    public Integer getCkalrest() {
        return ckalrest;
    }

    public void setCkalrest(Integer ckalrest) {
        this.ckalrest = ckalrest;
    }

    public Float getFattymass() {
        return fattymass;
    }

    public void setFattymass(Float fattymass) {
        this.fattymass = fattymass;
    }

    public Integer getMetabolicage() {
        return metabolicage;
    }

    public void setMetabolicage(Integer metabolicage) {
        this.metabolicage = metabolicage;
    }

    public Float getMusclemass() {
        return musclemass;
    }

    public void setMusclemass(Float musclemass) {
        this.musclemass = musclemass;
    }

    public Float getVisceralfat() {
        return visceralfat;
    }

    public void setVisceralfat(Float visceralfat) {
        this.visceralfat = visceralfat;
    }

    public Float getWaterpercentage() {
        return waterpercentage;
    }

    public void setWaterpercentage(Float waterpercentage) {
        this.waterpercentage = waterpercentage;
    }

    public Date getWeighingdate() {
        return weighingdate;
    }

    public void setWeighingdate(Date weighingdate) {
        this.weighingdate = weighingdate;
    }

    public Float getWeight() {
        return weight;
    }

    public void setWeight(Float weight) {
        this.weight = weight;
    }

    @XmlTransient
    public Collection<Customer> getCustomerCollection() {
        return customerCollection;
    }

    public void setCustomerCollection(Collection<Customer> customerCollection) {
        this.customerCollection = customerCollection;
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
        if (!(object instanceof Customerdata)) {
            return false;
        }
        Customerdata other = (Customerdata) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "BO.Customerdata[ id=" + id + " ]";
    }
    
}
