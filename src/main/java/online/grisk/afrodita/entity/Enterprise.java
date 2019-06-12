/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package online.grisk.afrodita.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author pablo
 */
@Entity
@Table(name = "grisk_enterprise", catalog = "grisk", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Enterprise.findAll", query = "SELECT e FROM Enterprise e")
    , @NamedQuery(name = "Enterprise.findByIdEnterprise", query = "SELECT e FROM Enterprise e WHERE e.idEnterprise = :idEnterprise")
    , @NamedQuery(name = "Enterprise.findByName", query = "SELECT e FROM Enterprise e WHERE e.name = :name")})
public class Enterprise implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_enterprise", nullable = false)
    private Long idEnterprise;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "rut", nullable = false, length = 2147483647)
    private String rut;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "name", nullable = false, length = 2147483647)
    private String name;


    @OneToMany(cascade = CascadeType.ALL, mappedBy = "enterprise")
    private Collection<User> userCollection;

    public Enterprise() {
    }

    public Enterprise(Long idEnterprise) {
        this.idEnterprise = idEnterprise;
    }

    public Enterprise(Long idEnterprise, String rut, String name) {
        this.idEnterprise = idEnterprise;
        this.rut = rut;
        this.name = name;
    }      

    public Enterprise(@NotNull @Size(min = 1, max = 2147483647) String rut,
			@NotNull @Size(min = 1, max = 2147483647) String name) {
		super();
		this.rut = rut;
		this.name = name;
	}

	public Long getIdEnterprise() {
        return idEnterprise;
    }

    public void setIdEnterprise(Long idEnterprise) {
        this.idEnterprise = idEnterprise;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
        hash += (idEnterprise != null ? idEnterprise.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Enterprise)) {
            return false;
        }
        Enterprise other = (Enterprise) object;
        if ((this.idEnterprise == null && other.idEnterprise != null) || (this.idEnterprise != null && !this.idEnterprise.equals(other.idEnterprise))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Enterprise[ idEnterprise=" + idEnterprise + " ]";
    }
    
}
