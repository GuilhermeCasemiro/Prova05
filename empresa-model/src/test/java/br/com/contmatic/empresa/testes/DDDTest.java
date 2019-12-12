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

import br.com.contmatic.empresa.model.DDD;
import br.com.contmatic.empresa.model.groups.Delete;
import br.com.contmatic.empresa.model.groups.Find;
import br.com.contmatic.empresa.model.groups.Update;

/**
 * The Class DDDTest.
 */
public class DDDTest {

    /** The validator. */
    private Validator validator;

    /** The factory. */
    private ValidatorFactory factory = Validation.buildDefaultValidatorFactory();

    /** The ddd. */
    private DDD ddd = DDD.SAO_PAULO;

    /**
     * Nao deve aceitar uf nulo.
     */
    @Test
    public void nao_deve_aceitar_uf_nulo() {
        ddd.setUf(null);
        assertFalse(isValid(ddd, "UF é obrigatório.", Delete.class, Update.class, Find.class));
    }

    /**
     * Nao deve aceitar uf vazio.
     */
    @Test
    public void nao_deve_aceitar_uf_vazio() {
        ddd.setUf(EMPTY);
        assertFalse(isValid(ddd, "UF é obrigatório.", Delete.class, Update.class, Find.class));
    }

    /**
     * Nao deve aceitar uf com mais de 2 caracteres.
     */
    @Test
    public void nao_deve_aceitar_uf_com_mais_de_2_caracteres() {
        ddd.setUf(random(3, true, false));
        assertFalse(isValid(ddd, "UF não pode ter menos ou mais de 2 caracteres.", Delete.class, Update.class, Find.class));
    }

    /**
     * Nao deve aceitar uf com menos de 2 caracteres.
     */
    @Test
    public void nao_deve_aceitar_uf_com_menos_de_2_caracteres() {
        ddd.setUf(random(1, true, false));
        assertFalse(isValid(ddd, "UF não pode ter menos ou mais de 2 caracteres.", Delete.class, Update.class, Find.class));
    }

    /**
     * Deve aceitar uf valido com 2 caracteres.
     */
    @Test
    public void deve_aceitar_uf_valido_com_2_caracteres() {
        ddd.setUf(random(2, true, false));
        assertTrue(isValid(ddd, ddd.getUf(), Delete.class, Update.class, Find.class));
    }

    /**
     * Nao deve aceitar uf com numeros.
     */
    @Test
    public void nao_deve_aceitar_uf_com_numeros() {
        ddd.setUf("5P");
        assertFalse(isValid(ddd, "UF não pode conter letras minúsculas, números e caracteres especiais.", Delete.class, Update.class, Find.class));
    }

    /**
     * Nao deve aceitar uf com letras minusculas.
     */
    @Test
    public void nao_deve_aceitar_uf_com_letras_minusculas() {
        ddd.setUf("sp");
        assertFalse(isValid(ddd, "UF não pode conter letras minúsculas, números e caracteres especiais.", Delete.class, Update.class, Find.class));
    }

    /**
     * Nao deve aceitar uf com caracteres especiais.
     */
    @Test
    public void nao_deve_aceitar_uf_com_caracteres_especiais() {
        ddd.setUf("P!");
        assertFalse(isValid(ddd, "UF não pode conter letras minúsculas, números e caracteres especiais.", Delete.class, Update.class, Find.class));
    }

    /**
     * Deve aceitar um uf valido.
     */
    @Test
    public void deve_aceitar_um_uf_valido() {
        ddd.setUf("SP");
        assertTrue(isValid(ddd, ddd.getUf(), Delete.class, Update.class, Find.class));
    }

    /**
     * Nao deve aceitar ddd nulo.
     */
    @Test
    public void nao_deve_aceitar_ddd_nulo() {
        ddd.setDdd(null);
        assertFalse(isValid(ddd, "DDD é obrigatório.", Delete.class, Update.class, Find.class));
    }

    /**
     * Nao deve aceitar ddd vazio.
     */
    @Test
    public void nao_deve_aceitar_ddd_vazio() {
        ddd.setDdd(EMPTY);
        assertFalse(isValid(ddd, "DDD é obrigatório.", Delete.class, Update.class, Find.class));
    }

    /**
     * Nao deve aceitar ddd com mais de 2 caracteres.
     */
    @Test
    public void nao_deve_aceitar_ddd_com_mais_de_2_caracteres() {
        ddd.setDdd(random(3, true, false));
        assertFalse(isValid(ddd, "DDD não pode ter menos ou mais de 2 caracteres.", Delete.class, Update.class, Find.class));
    }

    /**
     * Nao deve aceitar ddd com menos de 2 caracteres.
     */
    @Test
    public void nao_deve_aceitar_ddd_com_menos_de_2_caracteres() {
        ddd.setDdd(random(1, true, false));
        assertFalse(isValid(ddd, "DDD não pode ter menos ou mais de 2 caracteres.", Delete.class, Update.class, Find.class));
    }

    /**
     * Deve aceitar um ddd valido.
     */
    @Test
    public void deve_aceitar_um_ddd_valido() {
        ddd.setDdd("11");
        assertTrue(isValid(ddd, "11", Delete.class, Update.class, Find.class));
    }

    /**
     * Nao deve aceitar ddd com letras.
     */
    @Test
    public void nao_deve_aceitar_ddd_com_letras() {
        ddd.setDdd("SS");
        assertFalse(isValid(ddd, "DDD não pode conter letras e caracteres especiais.", Delete.class, Update.class, Find.class));
    }

    /**
     * Nao deve aceitar ddd com caracteres especiais.
     */
    @Test
    public void nao_deve_aceitar_ddd_com_caracteres_especiais() {
        ddd.setDdd("$1");
        assertFalse(isValid(ddd, "DDD não pode conter letras e caracteres especiais.", Delete.class, Update.class, Find.class));
    }

    /**
     * Checks if is valid.
     *
     * @param ddd the ddd
     * @param mensagem the mensagem
     * @return true, if is valid
     */
    public boolean isValid(DDD ddd, String mensagem, Class<?>... grupos) {
        validator = factory.getValidator();
        boolean valido = true;
        Set<ConstraintViolation<DDD>> restricoes = validator.validate(ddd, grupos);
        for(ConstraintViolation<DDD> constraintViolation : restricoes)
            if (constraintViolation.getMessage().equalsIgnoreCase(mensagem))
                valido = false;

        return valido;
    }

}
