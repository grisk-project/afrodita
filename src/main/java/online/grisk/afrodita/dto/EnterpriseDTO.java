package online.grisk.afrodita.dto;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class EnterpriseDTO {
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    private String name;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    private String rut;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }
}
