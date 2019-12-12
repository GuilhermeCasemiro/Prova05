package br.com.contmatic.empresa.model;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import br.com.contmatic.empresa.model.groups.Delete;
import br.com.contmatic.empresa.model.groups.Find;
import br.com.contmatic.empresa.model.groups.Update;

public class Cidade {

    @NotBlank(message = "Nome não pode ser nulo ou estar vazio.", groups = {Delete.class, Find.class, Update.class})
    @Size(min = 5, max = 25, message = "Nome não pode conter menos de 5 caracteres e mais de 25.", groups = { Delete.class, Find.class, Update.class})
    @Pattern(regexp = "[^_\\W\\d][záéíóúàèìòùâêîôûãõ]*", message = "Nome não pode ter números ou caracteres especiais.", groups = {Delete.class, Find.class, Update.class})
    private String nomeCidade;

    @Min(value = 1, message = "O código da cidade não pode ser menor que 1.", groups = {Delete.class, Find.class, Update.class})
    @Max(value = 100, message = "O código da cidade não pode ser maior que 100.", groups = {Delete.class, Find.class, Update.class})
    private int codigoCidade;

    public Cidade() {
        super();
    }

    public Cidade(String nomeCidade, int codigoCidade) {
        super();
        this.nomeCidade = nomeCidade;
        this.codigoCidade = codigoCidade;

    }

    public String getNomeCidade() {
        return this.nomeCidade;
    }

    public void setNomeCidade(String nome) {
        this.nomeCidade = nome;
    }

    public int getCodigoCidade() {
        return this.codigoCidade;
    }

    public void setCodigoCidade(int codigoCidade) {
        this.codigoCidade = codigoCidade;
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(codigoCidade).toHashCode();
    }

    @Override
    public boolean equals(Object obj) {

        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Cidade)) {
            return false;
        }

        Cidade cidade = (Cidade) obj;
        return new EqualsBuilder().append(codigoCidade, cidade.codigoCidade).isEquals();
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
    }
}
