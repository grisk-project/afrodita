/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package online.grisk.afrodita.entity;

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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author pablo
 */
@Entity
@Table(name = "grisk_endpoint")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Endpoint.findAll", query = "SELECT e FROM Endpoint e")
    , @NamedQuery(name = "Endpoint.findByIdEndpoint", query = "SELECT e FROM Endpoint e WHERE e.idEndpoint = :idEndpoint")
    , @NamedQuery(name = "Endpoint.findByUri", query = "SELECT e FROM Endpoint e WHERE e.uri = :uri")})
public class Endpoint implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_endpoint")
    private Short idEndpoint;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "uri")
    private String uri;
    
    @JoinColumn(name = "module", referencedColumnName = "id_module")
    @ManyToOne(optional = false)
    private Module module;

    public Endpoint() {
    }

    public Endpoint(Short idEndpoint) {
        this.idEndpoint = idEndpoint;
    }

    public Endpoint(Short idEndpoint, String uri) {
        this.idEndpoint = idEndpoint;
        this.uri = uri;
    }

    public Short getIdEndpoint() {
        return idEndpoint;
    }

    public void setIdEndpoint(Short idEndpoint) {
        this.idEndpoint = idEndpoint;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public Module getModule() {
        return module;
    }

    public void setModule(Module module) {
        this.module = module;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEndpoint != null ? idEndpoint.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Endpoint)) {
            return false;
        }
        Endpoint other = (Endpoint) object;
        if ((this.idEndpoint == null && other.idEndpoint != null) || (this.idEndpoint != null && !this.idEndpoint.equals(other.idEndpoint))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Endpoint[ idEndpoint=" + idEndpoint + " ]";
    }
    
}
