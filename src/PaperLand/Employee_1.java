/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PaperLand;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

/**
 *
 * @author anjal
 */
@Entity
@Table(name = "employee", catalog = "inventory", schema = "")
@NamedQueries({
    @NamedQuery(name = "Employee_1.findAll", query = "SELECT e FROM Employee_1 e")
    , @NamedQuery(name = "Employee_1.findById", query = "SELECT e FROM Employee_1 e WHERE e.id = :id")
    , @NamedQuery(name = "Employee_1.findByFirstName", query = "SELECT e FROM Employee_1 e WHERE e.firstName = :firstName")
    , @NamedQuery(name = "Employee_1.findByMiddleName", query = "SELECT e FROM Employee_1 e WHERE e.middleName = :middleName")
    , @NamedQuery(name = "Employee_1.findByLastName", query = "SELECT e FROM Employee_1 e WHERE e.lastName = :lastName")
    , @NamedQuery(name = "Employee_1.findByBirthday", query = "SELECT e FROM Employee_1 e WHERE e.birthday = :birthday")
    , @NamedQuery(name = "Employee_1.findByGender", query = "SELECT e FROM Employee_1 e WHERE e.gender = :gender")
    , @NamedQuery(name = "Employee_1.findByStatus", query = "SELECT e FROM Employee_1 e WHERE e.status = :status")
    , @NamedQuery(name = "Employee_1.findByAddress", query = "SELECT e FROM Employee_1 e WHERE e.address = :address")
    , @NamedQuery(name = "Employee_1.findByEmail", query = "SELECT e FROM Employee_1 e WHERE e.email = :email")
    , @NamedQuery(name = "Employee_1.findByContact", query = "SELECT e FROM Employee_1 e WHERE e.contact = :contact")})
public class Employee_1 implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "Id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "First_Name")
    private String firstName;
    @Column(name = "Middle_Name")
    private String middleName;
    @Column(name = "Last_Name")
    private String lastName;
    @Basic(optional = false)
    @Column(name = "Birthday")
    @Temporal(TemporalType.TIME)
    private Date birthday;
    @Basic(optional = false)
    @Column(name = "Gender")
    private String gender;
    @Basic(optional = false)
    @Column(name = "Status")
    private String status;
    @Basic(optional = false)
    @Column(name = "Address")
    private String address;
    @Basic(optional = false)
    @Column(name = "Email")
    private String email;
    @Column(name = "Contact")
    private Integer contact;

    public Employee_1() {
    }

    public Employee_1(Integer id) {
        this.id = id;
    }

    public Employee_1(Integer id, String firstName, Date birthday, String gender, String status, String address, String email) {
        this.id = id;
        this.firstName = firstName;
        this.birthday = birthday;
        this.gender = gender;
        this.status = status;
        this.address = address;
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        Integer oldId = this.id;
        this.id = id;
        changeSupport.firePropertyChange("id", oldId, id);
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

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        Date oldBirthday = this.birthday;
        this.birthday = birthday;
        changeSupport.firePropertyChange("birthday", oldBirthday, birthday);
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        String oldGender = this.gender;
        this.gender = gender;
        changeSupport.firePropertyChange("gender", oldGender, gender);
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        String oldStatus = this.status;
        this.status = status;
        changeSupport.firePropertyChange("status", oldStatus, status);
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        String oldAddress = this.address;
        this.address = address;
        changeSupport.firePropertyChange("address", oldAddress, address);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        String oldEmail = this.email;
        this.email = email;
        changeSupport.firePropertyChange("email", oldEmail, email);
    }

    public Integer getContact() {
        return contact;
    }

    public void setContact(Integer contact) {
        Integer oldContact = this.contact;
        this.contact = contact;
        changeSupport.firePropertyChange("contact", oldContact, contact);
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
        if (!(object instanceof Employee_1)) {
            return false;
        }
        Employee_1 other = (Employee_1) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "PaperLand.Employee_1[ id=" + id + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
