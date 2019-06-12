package online.grisk.afrodita.entity;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author pablo
 */
@Entity
@Table(name = "grisk_user", catalog = "grisk", schema = "public", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"username"})})
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "User.findAll", query = "SELECT u FROM User u")
        , @NamedQuery(name = "User.findByIdUser", query = "SELECT u FROM User u WHERE u.idUser = :idUser")
        , @NamedQuery(name = "User.findByUsername", query = "SELECT u FROM User u WHERE u.username = :username")
        , @NamedQuery(name = "User.findByPass", query = "SELECT u FROM User u WHERE u.pass = :pass")
        , @NamedQuery(name = "User.findByEnabled", query = "SELECT g FROM User g WHERE g.enabled = :enabled")
        , @NamedQuery(name = "User.findByNonLocked", query = "SELECT g FROM User g WHERE g.nonLocked = :nonLocked")
        , @NamedQuery(name = "User.findByAttempt", query = "SELECT g FROM User g WHERE g.attempt = :attempt")
        , @NamedQuery(name = "User.findByCreateAt", query = "SELECT u FROM User u WHERE u.createAt = :createAt")
        , @NamedQuery(name = "User.findByUpdateAt", query = "SELECT u FROM User u WHERE u.updateAt = :updateAt")})
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_user", nullable = false)
    private Long idUser;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "username", nullable = false, length = 2147483647)
    private String username;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "email", nullable = false, length = 2147483647)
    private String email;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "pass", nullable = false, length = 2147483647)
    private String pass;

    @Basic(optional = false)
    @NotNull
    @Column(name = "enabled")
    private boolean enabled;

    @Basic(optional = false)
    @NotNull
    @Column(name = "non_locked")
    private boolean nonLocked;

    @Basic(optional = false)
    @NotNull
    @Column(name = "attempt", nullable = false)
    private int attempt;

    @Column(name = "create_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createAt;

    @Basic(optional = false)
    @NotNull
    @Column(name = "update_at", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateAt;

    @JoinColumn(name = "enterprise", referencedColumnName = "id_enterprise", nullable = false)
    @ManyToOne(optional = false)
    private Enterprise enterprise;

    @JoinColumn(name = "role", referencedColumnName = "id_role", nullable = false)
    @ManyToOne(optional = false)
    private Role role;

    public User() {
    }

    public User(Long idUser) {
        this.idUser = idUser;
    }

    public User(@NotNull @Size(min = 1, max = 2147483647) String username, @NotNull @Size(min = 1, max = 2147483647) String email, @NotNull @Size(min = 1, max = 2147483647) String pass, @NotNull boolean enabled, @NotNull boolean nonLocked, @NotNull int attempt, Date createAt, @NotNull Date updateAt, Enterprise enterprise, Role role) {
        this.username = username;
        this.email = email;
        this.pass = pass;
        this.enabled = enabled;
        this.nonLocked = nonLocked;
        this.attempt = attempt;
        this.createAt = createAt;
        this.updateAt = updateAt;
        this.enterprise = enterprise;
        this.role = role;
    }

    public User(Long idUser, String username, String email, String pass, Date updateAt, boolean enabled, boolean nonLocked, int attempt) {
        this.idUser = idUser;
        this.username = username;
        this.email = email;
        this.pass = pass;
        this.updateAt = updateAt;
        this.enabled = enabled;
        this.nonLocked = nonLocked;
        this.attempt = attempt;
    }

    public Long getIdUser() {
        return idUser;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public boolean getNonLocked() {
        return nonLocked;
    }

    public void setNonLocked(boolean nonLocked) {
        this.nonLocked = nonLocked;
    }

    public int getAttempt() {
        return attempt;
    }

    public void setAttempt(int attempt) {
        this.attempt = attempt;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public Date getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Date updateAt) {
        this.updateAt = updateAt;
    }

    public Enterprise getEnterprise() {
        return enterprise;
    }

    public void setEnterprise(Enterprise enterprise) {
        this.enterprise = enterprise;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
