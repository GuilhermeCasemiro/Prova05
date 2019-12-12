package br.com.contmatic.empresa.model;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import br.com.contmatic.empresa.model.groups.Delete;
import br.com.contmatic.empresa.model.groups.Find;
import br.com.contmatic.empresa.model.groups.Update;

/**
 * The Enum Telefone.
 */
public enum Telefone {

                      /** The celular. */
                      CELULAR("Celular", 9),
                      /** The fixo. */
                      FIXO("Fixo", 8);

    /** The descricao. */
    @NotBlank(message = "A descrição não pode ser nula ou vazia.", groups = { Delete.class, Update.class, Find.class })
    @Size(min = 15, max = 30, message = "A descrição não pode ter menos de 15 e mais de 30 caracteres.", groups = { Delete.class, Update.class, Find.class })
    @Pattern(regexp = "[A-Z]\\BB\\w\\D", message = "A descrição não pode conter acentos, caracteres especiais e números.", groups = { Delete.class, Update.class, Find.class })
    private String descricao;

    /** The tamanho. */
    @Min(value = 8, message = "O tamanho do telefone não pode ser menor que 8.", groups = { Delete.class, Update.class, Find.class })
    @Max(value = 9, message = "O tamanho do telefone não pode ser maior que 9.", groups = { Delete.class, Update.class, Find.class })
    private int tamanho;

    /**
     * Instantiates a new telefone.
     *
     * @param descricao the descricao
     * @param tamanho the tamanho
     */
    private Telefone(String descricao, int tamanho) {
        this.descricao = descricao;
        this.tamanho = tamanho;
    }

    /**
     * Gets the descricao.
     *
     * @return the descricao
     */
    public String getDescricao() {
        return this.descricao;
    }

    /**
     * Gets the tamanho.
     *
     * @return the tamanho
     */
    public int getTamanho() {
        return this.tamanho;
    }

    /**
     * Sets the descricao.
     *
     * @param descricao the new descricao
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    /**
     * Sets the tamanho.
     *
     * @param tamanho the new tamanho
     */
    public void setTamanho(int tamanho) {
        this.tamanho = tamanho;
    }

}
