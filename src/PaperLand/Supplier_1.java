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
@Table(name = "supplier", catalog = "inventory", schema = "")
@NamedQueries({
    @NamedQuery(name = "Supplier_1.findAll", query = "SELECT s FROM Supplier_1 s")
    , @NamedQuery(name = "Supplier_1.findBySupplierId", query = "SELECT s FROM Supplier_1 s WHERE s.supplierId = :supplierId")
    , @NamedQuery(name = "Supplier_1.findByFirstName", query = "SELECT s FROM Supplier_1 s WHERE s.firstName = :firstName")
    , @NamedQuery(name = "Supplier_1.findByMiddleName", query = "SELECT s FROM Supplier_1 s WHERE s.middleName = :middleName")
    , @NamedQuery(name = "Supplier_1.findByLastName", query = "SELECT s FROM Supplier_1 s WHERE s.lastName = :lastName")
    , @NamedQuery(name = "Supplier_1.findByAddress", query = "SELECT s FROM Supplier_1 s WHERE s.address = :address")
    , @NamedQuery(name = "Supplier_1.findByContact", query = "SELECT s FROM Supplier_1 s WHERE s.contact = :contact")
    , @NamedQuery(name = "Supplier_1.findByEmail", query = "SELECT s FROM Supplier_1 s WHERE s.email = :email")})
public class Supplier_1 implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "Supplier_Id")
    private Integer supplierId;
    @Column(name = "First_Name")
    private String firstName;
    @Basic(optional = false)
    @Column(name = "Middle_Name")
    private String middleName;
    @Column(name = "Last_Name")
    private String lastName;
    @Basic(optional = false)
    @Column(name = "Address")
    private String address;
    @Basic(optional = false)
    @Column(name = "Contact")
    private int contact;
    @Basic(optional = false)
    @Column(name = "Email")
    private String email;

    public Supplier_1() {
    }

    public Supplier_1(Integer supplierId) {
        this.supplierId = supplierId;
    }

    public Supplier_1(Integer supplierId, String middleName, String address, int contact, String email) {
        this.supplierId = supplierId;
        this.middleName = middleName;
        this.address = address;
        this.contact = contact;
        this.email = email;
    }

    public Integer getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Integer supplierId) {
        Integer oldSupplierId = this.supplierId;
        this.supplierId = supplierId;
        changeSupport.firePropertyChange("supplierId", oldSupplierId, supplierId);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        String oldFirstName = this.firstName;
        this.firstName = firstName;
        changeSupport.firePropertyChange("firstName", oldFirstName, firstName);
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        String oldMiddleName = this.middleName;
        this.middleName = middleName;
        changeSupport.firePropertyChange("middleName", oldMiddleName, middleName);
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        String oldLastName = this.lastName;
        this.lastName = lastName;
        changeSupport.firePropertyChange("lastName", oldLastName, lastName);
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        String oldAddress = this.address;
        this.address = address;
        changeSupport.firePropertyChange("address", oldAddress, address);
    }

    public int getContact() {
        return contact;
    }

    public void setContact(int contact) {
        int oldContact = this.contact;
        this.contact = contact;
        changeSupport.firePropertyChange("contact", oldContact, contact);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        String oldEmail = this.email;
        this.email = email;
        changeSupport.firePropertyChange("email", oldEmail, email);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (supplierId != null ? supplierId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Supplier_1)) {
            return false;
        }
        Supplier_1 other = (Supplier_1) object;
        if ((this.supplierId == null && other.supplierId != null) || (this.supplierId != null && !this.supplierId.equals(other.supplierId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "PaperLand.Supplier_1[ supplierId=" + supplierId + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
