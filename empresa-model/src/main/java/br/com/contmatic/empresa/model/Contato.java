package br.com.contmatic.empresa.model;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * The Class Contato.
 */
public final class Contato {

    /** The telefone. */
    @Valid
    @NotNull(message = "Telefone não pode ser nulo.")
    Telefone telefone;

    /** The ddd. */
    @Valid
    @NotNull(message = "DDD não pode ser nulo.")
    DDD ddd;

    /**
     * Instantiates a new contato.
     */
    public Contato() {
        super();
    }

    /**
     * Instantiates a new contato.
     *
     * @param telefone the telefone
     * @param ddd the ddd
     */
    public Contato(Telefone telefone, DDD ddd) {
        super();
        this.telefone = telefone;
        this.ddd = ddd;
    }

    /**
     * Gets the telefone.
     *
     * @return the telefone
     */
    public Telefone getTelefone() {
        return telefone;
    }

    /**
     * Sets the telefone.
     *
     * @param telefone the new telefone
     */
    public void setTelefone(Telefone telefone) {
        this.telefone = telefone;
    }

    /**
     * Gets the ddd.
     *
     * @return the ddd
     */
    public DDD getDdd() {
        return ddd;
    }

    /**
     * Sets the ddd.
     *
     * @param ddd the new ddd
     */
    public void setDdd(DDD ddd) {
        this.ddd = ddd;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(telefone).append(ddd).toHashCode();
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (obj.getClass() != getClass()) {
            return false;
        }
        Contato contato = (Contato) obj;
        return new EqualsBuilder().append(telefone, contato.telefone).append(ddd, contato.ddd).isEquals();
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
    }

}
