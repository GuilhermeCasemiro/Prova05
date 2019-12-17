package br.com.contmatic.empresa.model;

import java.math.BigDecimal;
import java.util.Set;

import javax.validation.Valid;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.hibernate.validator.constraints.br.CPF;
import org.joda.time.DateTime;

import br.com.contmatic.empresa.model.groups.Delete;
import br.com.contmatic.empresa.model.groups.Find;
import br.com.contmatic.empresa.model.groups.Update;

/**
 * The Class Funcionario.
 */
public class Funcionario {

    /** The nome. */
    @NotBlank(message = "Nome é obrigatório", groups = { Delete.class, Find.class, Update.class })
    @Pattern(regexp = "[^_\\W\\d][záéíóúàèìòùâêîôûãõ]*", message = "Nome não pode ter números ou caracteres especiais.", groups = { Delete.class, Find.class, Update.class })
    @Size(min = 3, max = 30, message = "Nome não pode ter menos de 3 ou mais de 30 caracteres.", groups = { Delete.class, Find.class, Update.class })
    private String nome;

    /** The email. */
    @Email(message = "Deve inserir um e-mail válido.", groups = { Delete.class, Find.class, Update.class })
    @NotEmpty(message = "E-mail é obrigatório.", groups = { Delete.class, Find.class, Update.class })
    private String email;

    /** The cpf. */
    @NotBlank(message = "CPF obrigatório.", groups = { Delete.class, Find.class, Update.class })
    @CPF(message = "CPF inserido deve ser válido.", groups = { Delete.class, Find.class, Update.class })
    @Size(min = 11, max = 11, message = "CPF deve conter exatamente 11 caracteres.", groups = { Delete.class, Find.class, Update.class })
    private String cpf;

    /** The data nascimento. */
    @NotNull(message = "Data de nascimento não pode ser nula.", groups = { Delete.class, Find.class, Update.class })
    private DateTime dataNascimento;

    /** The sexo. */
    @NotBlank(message = "Sexo obrigatório.", groups = { Delete.class, Find.class, Update.class })
    @Size(min = 8, max = 9, message = "Sexo deve ter no mínimo 8 caracteres e no máximo 9.", groups = { Delete.class, Find.class, Update.class })
    @Pattern(regexp = "[A-Z]\\B\\w\\D*", message = "Não pode conter acentos, caracteres especiais e números no sexo.", groups = { Delete.class, Find.class, Update.class })
    private String sexo;

    /** The endereco. */
    @Valid
    @NotNull(message = "Não pode conter lista de enderecos nula.", groups = { Delete.class, Update.class, Find.class })
    private Set<Endereco> endereco;

    /** The contatos. */
    @Valid
    @NotNull(message = "Não pode conter lista de contatos nula.", groups = { Delete.class, Update.class, Find.class })
    private Set<Contato> contatos;

    /** The salario. */
    @NotNull(message = "Salário é obrigatório.", groups = { Find.class })
    @DecimalMin(value = "1000", message = "O salário não pode ser menor que a base de R$: 1000.", groups = { Find.class })
    @DecimalMax(value = "8500", message = "O salário não pode ser maior que R$: 8500.", groups = { Find.class })
    private BigDecimal salario;

    /** The comissao. */
    @DecimalMin(value = "0", message = "A comissão não pode ser menor que R$: 0.", groups = { Find.class })
    @DecimalMax(value = "500", message = "A comissão não pode ser maior que R$: 500.", groups = { Find.class })
    private BigDecimal comissao;

    /** The departamento. */
    @NotBlank(message = "Ter um departamento é obrigatório.", groups = { Find.class })
    @Size(min = 5, max = 30, message = "O departamento não pode conter menos de 5 e mais de 30 caracteres.", groups = { Find.class })
    @Pattern(regexp = "([A-Z]\\B)([a-zA-Z])+$", message = "A primeira letra deve ser maiuscula e não pode conter acentuação e caracteres especiais.", groups = { Find.class })
    private String departamento;

    /**
     * Instantiates a new funcionario.
     */
    public Funcionario() {
        super();
    }

    public Funcionario(String nome, String email, String cpf, DateTime dataNascimento, String sexo, Set<Endereco> endereco) {
        super();
        this.nome = nome;
        this.email = email;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.sexo = sexo;
        this.endereco = endereco;
    }

    /**
     * Gets the nome.
     *
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * Sets the nome.
     *
     * @param nome the new nome
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Gets the email.
     *
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the email.
     *
     * @param email the new email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Gets the cpf.
     *
     * @return the cpf
     */
    public String getCpf() {
        return cpf;
    }

    /**
     * Sets the cpf.
     *
     * @param cpf the new cpf
     */
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    /**
     * Gets the data nascimento.
     *
     * @return the data nascimento
     */
    public DateTime getDataNascimento() {
        return dataNascimento;
    }

    /**
     * Sets the data nascimento.
     *
     * @param dataNascimento the new data nascimento
     */
    public void setDataNascimento(DateTime dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    /**
     * Gets the sexo.
     *
     * @return the sexo
     */
    public String getSexo() {
        return sexo;
    }

    /**
     * Sets the sexo.
     *
     * @param sexo the new sexo
     */
    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    /**
     * Gets the endereco.
     *
     * @return the endereco
     */
    public Set<Endereco> getEndereco() {
        return endereco;
    }

    /**
     * Sets the endereco.
     *
     * @param endereco the new endereco
     */
    public void setEndereco(Set<Endereco> endereco) {
        this.endereco = endereco;
    }

    /**
     * Gets the contatos.
     *
     * @return the contatos
     */
    public Set<Contato> getContatos() {
        return contatos;
    }

    /**
     * Sets the contatos.
     *
     * @param contatos the new contatos
     */
    public void setContatos(Set<Contato> contatos) {
        this.contatos = contatos;
    }

    /**
     * Gets the salario.
     *
     * @return the salario
     */

    public BigDecimal getSalario() {
        return salario;
    }

    /**
     * Sets the salario.
     *
     * @param salario the new salario
     */
    public void setSalario(BigDecimal salario) {
        this.salario = salario;
    }

    /**
     * Gets the comissao.
     *
     * @return the comissao
     */
    public BigDecimal getComissao() {
        return comissao;
    }

    /**
     * Sets the comissao.
     *
     * @param comissao the new comissao
     */
    public void setComissao(BigDecimal comissao) {
        this.comissao = comissao;
    }

    /**
     * Gets the departamento.
     *
     * @return the departamento
     */
    public String getDepartamento() {
        return departamento;
    }

    /**
     * Sets the departamento.
     *
     * @param departamento the new departamento
     */
    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {

        return new HashCodeBuilder().append(cpf).toHashCode();
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
        if (!(obj instanceof Funcionario)) {
            return false;
        }
        Funcionario funcionario = (Funcionario) obj;
        return new EqualsBuilder().append(cpf, funcionario.cpf).isEquals();
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
