package br.com.contmatic.empresa.model;

import java.util.Set;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import br.com.caelum.stella.bean.validation.CNPJ;
import br.com.contmatic.empresa.model.groups.Create;
import br.com.contmatic.empresa.model.groups.Delete;
import br.com.contmatic.empresa.model.groups.Find;
import br.com.contmatic.empresa.model.groups.Update;

/**
 * The Class Empresa.
 */
public class Empresa {

    /** The cnpj. */
    @NotBlank(message = "CNPJ obrigatório.", groups = { Create.class, Delete.class, Find.class, Update.class })
    @CNPJ(message = "O CNPJ deve ser válido.", groups = { Create.class, Delete.class, Find.class, Update.class })
    @Size(min = 14, max = 14, message = "CNPJ deve conter exatamente 14 caracteres.", groups = { Create.class, Delete.class, Find.class, Update.class })
    private String cnpj;

    /** The razao social. */
    @NotBlank(message = "Razão Social é obrigatório.", groups = { Create.class, Delete.class, Find.class, Update.class })
    @Size(min = 10, max = 30, message = "Razão social deve ter no minino 10 caracteres e no maixmo 30 caracteres.", groups = { Create.class, Delete.class, Find.class, Update.class })
    @Pattern(regexp = "/[^a-zA-Z 0-9]+/", message = "Razão Social inválida.", groups = { Create.class, Delete.class, Find.class, Update.class })
    private String razaoSocial;

    /** The nome fantasia. */
    @NotBlank(message = "Nome fantasia é obrigatório.", groups = { Delete.class, Find.class, Update.class })
    @Size(min = 10, max = 30, message = "Nome fantasia deve ter no minimo 10 caracteres e no maixmo 30 caracteres.", groups = { Delete.class, Find.class, Update.class })
    @Pattern(regexp = "/[^a-zA-Z 0-9]+/", message = "Nome Fantasia inválido.", groups = { Delete.class, Find.class, Update.class })
    private String nomeFantasia;

    @Size(min = 1, max = 1000, message = "A empresa deve conter pelo menos 1 funcionário e no maximo 1000.")
    @Valid
    private Set<Funcionario> funcionarios;

    @Size(min = 1, max = 100, message = "A empresa deve conter pelo menos 1 contato e no maximo 100.")
    @Valid
    private Set<Contato> contatos;

    @Size(min = 1, max = 100, message = "A empresa deve conter pelo menos 1 endereço e no maximo 100.")
    @Valid
    private Set<Endereco> enderecos;

    @Valid
    private Cidade cidade;

    @Valid
    private Estado estado;

    /**
     * Instantiates a new Empresa.
     */
    public Empresa() {
        super();
    }

    /**
     * Instantiates a new Empresa.
     *
     * @param cnpj the cnpj
     * @param razaoSocial the razao social
     * @param nomeFantasia the nome fantasia
     */
    public Empresa(String cnpj) {
        super();
        this.cnpj = cnpj;

    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    public Set<Funcionario> getFuncionarios() {
        return funcionarios;
    }

    public void setFuncionarios(Set<Funcionario> funcionarios) {
        this.funcionarios = funcionarios;
    }

    public Set<Contato> getContatos() {
        return contatos;
    }

    public void setContatos(Set<Contato> contatos) {
        this.contatos = contatos;
    }

    public Set<Endereco> getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(Set<Endereco> enderecos) {
        this.enderecos = enderecos;
    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(cnpj).toHashCode();
    }

    /*
     * (non-Javadoc)
     * 
     * @see br.com.contmatic.models.Pessoa#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Empresa)) {
            return false;
        }
        Empresa empresa = (Empresa) obj;
        return new EqualsBuilder().append(cnpj, empresa.cnpj).isEquals();
    }

    /*
     * (non-Javadoc)
     * 
     * @see br.com.contmatic.models.Pessoa#toString()
     */
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
    }

}
