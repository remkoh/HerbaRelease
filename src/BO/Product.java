/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BO;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
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
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Temp
 */
@Entity
@Table(name = "product")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Product.findAll", query = "SELECT p FROM Product p"),
    @NamedQuery(name = "Product.findById", query = "SELECT p FROM Product p WHERE p.id = :id"),
    @NamedQuery(name = "Product.findByProductdescription", query = "SELECT p FROM Product p WHERE p.productdescription = :productdescription"),
    @NamedQuery(name = "Product.findByProductname", query = "SELECT p FROM Product p WHERE p.productname = :productname"),
    @NamedQuery(name = "Product.findByProductprice", query = "SELECT p FROM Product p WHERE p.productprice = :productprice"),
    @NamedQuery(name = "Product.findBySku", query = "SELECT p FROM Product p WHERE p.sku = :sku")})
public class Product implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Long id;
    @Column(name = "PRODUCTDESCRIPTION")
    private String productdescription;
    @Column(name = "PRODUCTNAME")
    private String productname;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "PRODUCTPRICE")
    private Double productprice;
    @Column(name = "SKU")
    private String sku;
    @JoinColumn(name = "PRODUCTLINEID_ID", referencedColumnName = "ID")
    @ManyToOne
    private Productline productlineidId;
    @JoinColumn(name = "PRODUCTCATEGORYID_ID", referencedColumnName = "ID")
    @ManyToOne
    private Productcategory productcategoryidId;

    public Product() {
    }

    public Product(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        Long oldId = this.id;
        this.id = id;
        changeSupport.firePropertyChange("id", oldId, id);
    }

    public String getProductdescription() {
        return productdescription;
    }

    public void setProductdescription(String productdescription) {
        String oldProductdescription = this.productdescription;
        this.productdescription = productdescription;
        changeSupport.firePropertyChange("productdescription", oldProductdescription, productdescription);
    }

    public String getProductname() {
        return productname;
    }

    public void setProductname(String productname) {
        String oldProductname = this.productname;
        this.productname = productname;
        changeSupport.firePropertyChange("productname", oldProductname, productname);
    }

    public Double getProductprice() {
        return productprice;
    }

    public void setProductprice(Double productprice) {
        Double oldProductprice = this.productprice;
        this.productprice = productprice;
        changeSupport.firePropertyChange("productprice", oldProductprice, productprice);
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        String oldSku = this.sku;
        this.sku = sku;
        changeSupport.firePropertyChange("sku", oldSku, sku);
    }

    public Productline getProductlineidId() {
        return productlineidId;
    }

    public void setProductlineidId(Productline productlineidId) {
        Productline oldProductlineidId = this.productlineidId;
        this.productlineidId = productlineidId;
        changeSupport.firePropertyChange("productlineidId", oldProductlineidId, productlineidId);
    }

    public Productcategory getProductcategoryidId() {
        return productcategoryidId;
    }

    public void setProductcategoryidId(Productcategory productcategoryidId) {
        Productcategory oldProductcategoryidId = this.productcategoryidId;
        this.productcategoryidId = productcategoryidId;
        changeSupport.firePropertyChange("productcategoryidId", oldProductcategoryidId, productcategoryidId);
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
        if (!(object instanceof Product)) {
            return false;
        }
        Product other = (Product) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "[" + this.productcategoryidId.getProductcategoryname() + "]" + " " + this.getProductname();
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
