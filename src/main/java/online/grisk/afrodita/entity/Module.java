/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package online.grisk.afrodita.entity;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 * @author pablo
 */
@Entity
@Table(name = "grisk_module", catalog = "grisk", schema = "public")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "Module.findAll", query = "SELECT m FROM Module m")
        , @NamedQuery(name = "Module.findByIdModule", query = "SELECT m FROM Module m WHERE m.idModule = :idModule")
        , @NamedQuery(name = "Module.findByDisplay", query = "SELECT m FROM Module m WHERE m.display = :display")
        , @NamedQuery(name = "Module.findByIcon", query = "SELECT m FROM Module m WHERE m.icon = :icon")
        , @NamedQuery(name = "Module.findByUri", query = "SELECT m FROM Module m WHERE m.uri = :uri")
        , @NamedQuery(name = "Module.findByDisplayOrder", query = "SELECT m FROM Module m WHERE m.displayOrder = :displayOrder")})
public class Module implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_module", nullable = false)
    private Short idModule;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "display", nullable = false, length = 2147483647)
    private String display;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "icon", nullable = false, length = 2147483647)
    private String icon;
    @Basic(optional = false)
    @NotNull
    @Column(name = "display_order", nullable = false)
    private short displayOrder;
    @JoinTable(name = "role_has_module", joinColumns = {
            @JoinColumn(name = "module", referencedColumnName = "id_module", nullable = false)}, inverseJoinColumns = {
            @JoinColumn(name = "role", referencedColumnName = "id_role", nullable = false)})
    @ManyToMany(fetch = FetchType.EAGER)
    private Collection<Role> roleCollection;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "module")
    @LazyCollection(LazyCollectionOption.FALSE)
    private Collection<Endpoint> endpointCollection;

    public Module() {
    }

    public Module(Short idModule) {
        this.idModule = idModule;
    }

    public Module(Short idModule, String display, String icon, short displayOrder) {
        this.idModule = idModule;
        this.display = display;
        this.icon = icon;
        this.displayOrder = displayOrder;
    }

    public Short getIdModule() {
        return idModule;
    }

    public void setIdModule(Short idModule) {
        this.idModule = idModule;
    }

    public String getDisplay() {
        return display;
    }

    public void setDisplay(String display) {
        this.display = display;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public short getDisplayOrder() {
        return displayOrder;
    }

    public void setDisplayOrder(short displayOrder) {
        this.displayOrder = displayOrder;
    }

    @XmlTransient
    public Collection<Role> getRoleCollection() {
        return roleCollection;
    }

    public void setRoleCollection(Collection<Role> roleCollection) {
        this.roleCollection = roleCollection;
    }

    public Collection<Endpoint> getEndpointCollection() {
        return endpointCollection;
    }

    public void setEndpointCollection(Collection<Endpoint> endpointCollection) {
        this.endpointCollection = endpointCollection;
    }

    @Override
    public String toString() {
        return "Module{" +
                "idModule=" + idModule +
                ", display='" + display + '\'' +
                ", icon='" + icon + '\'' +
                ", displayOrder=" + displayOrder +
                ", roleCollection=" + roleCollection.toString() +
                ", endpointCollection=" + endpointCollection.toString() +
                ", uri='" + uri + '\'' +
                '}';
    }

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "uri", nullable = false, length = 2147483647)
    private String uri;

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

}
