package br.com.contmatic.empresa.model;

import static org.apache.commons.lang3.builder.ToStringBuilder.reflectionToString;
import static org.apache.commons.lang3.builder.ToStringStyle.JSON_STYLE;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import br.com.contmatic.empresa.model.groups.Delete;
import br.com.contmatic.empresa.model.groups.Find;
import br.com.contmatic.empresa.model.groups.Update;

public class Estado {
    @NotBlank(message = "Estado não pode ser nulo ou estar vazio.", groups = { Delete.class, Find.class, Update.class })
    @Size(min = 5, max = 30, message = "Estado não pode conter menos de 5 caracteres e mais de 30.", groups = { Delete.class, Find.class, Update.class })
    @Pattern(regexp = "[^_\\W\\d][záéíóúàèìòùâêîôûãõ]*", message = "Estado não pode ter números ou caracteres especiais.", groups = { Delete.class, Find.class, Update.class })
    private String nomeEstado;

    @Min(value = 1, message = "O código do estado não pode ser menor que 1.", groups = { Delete.class, Find.class, Update.class })
    @Max(value = 100, message = "O código do estado não pode ser maior que 100.", groups = { Delete.class, Find.class, Update.class })
    int codigoEstado;

    public Estado() {
        super();
    }

    public Estado(String nomeEstado, int codigoEstado) {
        super();
        this.nomeEstado = nomeEstado;
        this.codigoEstado = codigoEstado;
    }

    public String getNomeEstado() {
        return this.nomeEstado;
    }

    public void setNomeEstado(String nome) {
        this.nomeEstado = nome;
    }

    public int getCodigoEstado() {
        return this.codigoEstado;
    }

    public void setCodigoEstado(int codigoEstado) {
        this.codigoEstado = codigoEstado;
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(codigoEstado).toHashCode();
    }

    @Override
    public boolean equals(Object obj) {

        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Estado)) {
            return false;
        }
        Estado estado = (Estado) obj;
        return new EqualsBuilder().append(codigoEstado, estado.codigoEstado).isEquals();
    }

    @Override
    public String toString() {
        return reflectionToString(this, JSON_STYLE);
    }

}
