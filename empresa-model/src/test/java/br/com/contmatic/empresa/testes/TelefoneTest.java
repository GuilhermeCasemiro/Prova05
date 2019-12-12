package br.com.contmatic.empresa.testes;

import static org.apache.commons.lang3.RandomStringUtils.random;
import static org.apache.commons.lang3.StringUtils.EMPTY;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.Test;

import br.com.contmatic.empresa.model.Telefone;
import br.com.contmatic.empresa.model.groups.Find;

/**
 * The Class TelefoneTest.
 */
public class TelefoneTest {

    /** The validator. */
    private Validator validator;

    /** The factory. */
    private ValidatorFactory factory = Validation.buildDefaultValidatorFactory();

    /** The telefone. */
    private Telefone telefone = Telefone.FIXO;

    /**
     * Nao deve aceitar descricao nula.
     */
    @Test
    public void nao_deve_aceitar_descricao_nula() {
        telefone.setDescricao(null);
        assertFalse(isValid(telefone, "A descrição não pode ser nula ou vazia.", Find.class));
    }

    /**
     * Nao deve aceitar descricao vazia.
     */
    @Test
    public void nao_deve_aceitar_descricao_vazia() {
        telefone.setDescricao(EMPTY);
        assertFalse(isValid(telefone, "A descrição não pode ser nula ou vazia.", Find.class));
    }

    /**
     * Deve aceitar descricao valida.
     */
    @Test
    public void deve_aceitar_descricao_valida() {
        telefone.setDescricao("Celular pessoal.");
        assertTrue(isValid(telefone, telefone.getDescricao(), Find.class));
    }

    /**
     * Nao deve aceitar descricao com a primeira letra minuscula.
     */
    @Test
    public void nao_deve_aceitar_descricao_com_a_primeira_letra_minuscula() {
        telefone.setDescricao("celular empresarial.");
        assertFalse(isValid(telefone, "A descrição não pode conter acentos, caracteres especiais e números.", Find.class));
    }

    /**
     * Nao deve aceitar descricao com numeros.
     */
    @Test
    public void nao_deve_aceitar_descricao_com_numeros() {
        telefone.setDescricao(random(10, true, true));
        assertFalse(isValid(telefone, "A descrição não pode conter acentos, caracteres especiais e números.", Find.class));
    }

    /**
     * Nao deve aceitar descricao com caracteres especiais.
     */
    @Test
    public void nao_deve_aceitar_descricao_com_caracteres_especiais() {
        telefone.setDescricao("celular empresarial: (11)9####-####.");
        assertFalse(isValid(telefone, "A descrição não pode conter acentos, caracteres especiais e números.", Find.class));
    }

    /**
     * Nao deve aceitar descricao com mais de 30 caracteres.
     */
    @Test
    public void nao_deve_aceitar_descricao_com_mais_de_30_caracteres() {
        telefone.setDescricao(random(35, true, false));
        assertFalse(isValid(telefone, "A descrição não pode ter menos de 15 e mais de 30 caracteres.", Find.class));
    }

    /**
     * Nao deve aceitar descricao com menos de 15 caracteres.
     */
    @Test
    public void nao_deve_aceitar_descricao_com_menos_de_15_caracteres() {
        telefone.setDescricao(random(35, true, false));
        assertFalse(isValid(telefone, "A descrição não pode ter menos de 15 e mais de 30 caracteres.", Find.class));
    }

    /**
     * Deve aceitar descricao entre 15 e 30 caracteres valido.
     */
    @Test
    public void deve_aceitar_descricao_entre_15_e_30_caracteres_valido() {
        telefone.setDescricao(random(20, true, false));
        assertTrue(isValid(telefone, telefone.getDescricao(), Find.class));
    }

    /**
     * Nao deve aceitar tamanho telefone fixo com mais de 9 numeros.
     */
    @Test
    public void nao_deve_aceitar_tamanho_telefone_fixo_com_mais_de_9_numeros() {
        telefone.setTamanho(10);
        assertFalse(isValid(telefone, "O tamanho do telefone não pode ser maior que 9.", Find.class));
    }

    /**
     * Nao deve aceitar tamanho telefone fixo com menos de 8 numeros.
     */
    @Test
    public void nao_deve_aceitar_tamanho_telefone_fixo_com_menos_de_8_numeros() {
        telefone.setTamanho(7);
        assertFalse(isValid(telefone, "O tamanho do telefone não pode ser menor que 8.", Find.class));
    }

    /**
     * Deve aceitar tamanho com 9 numeros.
     */
    @Test
    public void deve_aceitar_tamanho_com_9_numeros() {
        telefone.setTamanho(9);
        assertTrue(isValid(telefone, String.valueOf(telefone.getTamanho()), Find.class));
    }

    /**
     * Deve aceitar tamanho com 8 numeros.
     */
    @Test
    public void deve_aceitar_tamanho_com_8_numeros() {
        telefone.setTamanho(8);
        assertTrue(isValid(telefone, String.valueOf(telefone.getTamanho()), Find.class));
    }

    /**
     * Checks if is valid.
     *
     * @param telefone the telefone
     * @param mensagem the mensagem
     * @return true, if is valid
     */
    public boolean isValid(Telefone telefone, String mensagem, Class<?>... grupos) {
        validator = factory.getValidator();
        boolean valido = true;
        Set<ConstraintViolation<Telefone>> restricoes = validator.validate(telefone, grupos);
        for(ConstraintViolation<Telefone> constraintViolation : restricoes)
            if (constraintViolation.getMessage().equalsIgnoreCase(mensagem))
                valido = false;

        return valido;
    }
}
