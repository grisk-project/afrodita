package online.grisk.afrodita.dto;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UserDTO {
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    private String username;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    private String email;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    private String pass;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    private String trypass;

    @Basic(optional = false)
    @NotNull
    private EnterpriseDTO enterprise;

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

    public String getTrypass() {
        return trypass;
    }

    public void setTrypass(String trypass) {
        this.trypass = trypass;
    }

    public EnterpriseDTO getEnterprise() {
        return enterprise;
    }

    public void setEnterprise(EnterpriseDTO enterprise) {
        this.enterprise = enterprise;
    }
}
