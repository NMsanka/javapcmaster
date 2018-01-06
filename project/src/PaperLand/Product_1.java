/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PaperLand;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author anjal
 */
@Entity
@Table(name = "product", catalog = "inventory", schema = "")
@NamedQueries({
    @NamedQuery(name = "Product_1.findAll", query = "SELECT p FROM Product_1 p")
    , @NamedQuery(name = "Product_1.findByPId", query = "SELECT p FROM Product_1 p WHERE p.pId = :pId")
    , @NamedQuery(name = "Product_1.findByPName", query = "SELECT p FROM Product_1 p WHERE p.pName = :pName")
    , @NamedQuery(name = "Product_1.findByQuantity", query = "SELECT p FROM Product_1 p WHERE p.quantity = :quantity")
    , @NamedQuery(name = "Product_1.findByPrice", query = "SELECT p FROM Product_1 p WHERE p.price = :price")})
public class Product_1 implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "P_Id")
    private Integer pId;
    @Basic(optional = false)
    @Column(name = "P_Name")
    private String pName;
    @Basic(optional = false)
    @Column(name = "Quantity")
    private String quantity;
    @Basic(optional = false)
    @Column(name = "Price")
    private long price;

    public Product_1() {
    }

    public Product_1(Integer pId) {
        this.pId = pId;
    }

    public Product_1(Integer pId, String pName, String quantity, long price) {
        this.pId = pId;
        this.pName = pName;
        this.quantity = quantity;
        this.price = price;
    }

    public Integer getPId() {
        return pId;
    }

    public void setPId(Integer pId) {
        Integer oldPId = this.pId;
        this.pId = pId;
        changeSupport.firePropertyChange("PId", oldPId, pId);
    }

    public String getPName() {
        return pName;
    }

    public void setPName(String pName) {
        String oldPName = this.pName;
        this.pName = pName;
        changeSupport.firePropertyChange("PName", oldPName, pName);
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        String oldQuantity = this.quantity;
        this.quantity = quantity;
        changeSupport.firePropertyChange("quantity", oldQuantity, quantity);
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        long oldPrice = this.price;
        this.price = price;
        changeSupport.firePropertyChange("price", oldPrice, price);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pId != null ? pId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Product_1)) {
            return false;
        }
        Product_1 other = (Product_1) object;
        if ((this.pId == null && other.pId != null) || (this.pId != null && !this.pId.equals(other.pId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "PaperLand.Product_1[ pId=" + pId + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
