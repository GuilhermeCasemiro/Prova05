package br.com.contmatic.empresa.testes;

import static br.com.contmatic.empresa.model.easy.random.estado.EstadoRandom.gerarEstado;
import static com.google.code.beanmatchers.BeanMatchers.hasValidBeanConstructor;
import static com.google.code.beanmatchers.BeanMatchers.hasValidBeanHashCodeFor;
import static com.google.code.beanmatchers.BeanMatchers.hasValidGettersAndSetters;
import static org.apache.commons.lang3.RandomStringUtils.random;
import static org.apache.commons.lang3.StringUtils.EMPTY;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.Test;

import br.com.contmatic.empresa.model.Estado;
import br.com.contmatic.empresa.model.groups.Find;
import br.com.contmatic.empresa.model.groups.Update;
import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;

public class EstadoTest {

    /** The validator. */
    private Validator validator;

    /** The factory. */
    private ValidatorFactory factory = Validation.buildDefaultValidatorFactory();

    private Estado estado = gerarEstado();

    @Test
    public void nao_deve_aceitar_nome_nulo() {
        estado.setNomeEstado(null);
        assertFalse(isValid(estado, "Estado não pode ser nulo ou estar vazio.", Update.class, Find.class));
    }

    /**
     * Nao deve aceitar nome vazio.
     */
    @Test
    public void nao_deve_aceitar_nome_vazio() {
        estado.setNomeEstado(EMPTY);
        assertFalse(isValid(estado, "Estado não pode ser nulo ou estar vazio.", Update.class, Find.class));
    }

    /**
     * Deve aceitar uma cidade valida.
     */
    @Test
    public void deve_aceitar_uma_estado_valido() {
        estado.setNomeEstado("São Paulo");
        assertTrue(isValid(estado, estado.getNomeEstado(), Update.class, Find.class));
    }

    /**
     * Nao deve aceitar nome com numeros.
     */
    @Test
    public void nao_deve_aceitar_nome_com_numeros() {
        estado.setNomeEstado("R0raima");
        assertFalse(isValid(estado, "Estado não pode ter números ou caracteres especiais.", Update.class, Find.class));
    }

    /**
     * Nao deve aceitar nome com caracteres especiais.
     */
    @Test
    public void nao_deve_aceitar_nome_com_caracteres_especiais() {
        estado.setNomeEstado("$Rio de Janeir#");
        assertFalse(isValid(estado, "Estado não pode ter números ou caracteres especiais.", Update.class, Find.class));
    }

    /**
     * Nao deve aceitar nome com mais de 25 caracteres.
     */
    @Test
    public void nao_deve_aceitar_nome_com_mais_de_25_caracteres() {
        estado.setNomeEstado(random(35, true, false));
        assertFalse(isValid(estado, "Estado não pode conter menos de 5 caracteres e mais de 30.", Update.class, Find.class));
    }

    /**
     * Nao deve aceitar nome com menos de 5 caracteres.
     */
    @Test
    public void nao_deve_aceitar_nome_com_menos_de_5_caracteres() {
        estado.setNomeEstado(random(3, true, false));
        assertFalse(isValid(estado, "Estado não pode conter menos de 5 caracteres e mais de 30.", Update.class, Find.class));
    }

    /**
     * Deve aceitar nome entre 5 e 25 caracteres.
     */
    @Test
    public void deve_aceitar_nome_entre_5_e_25_caracteres() {
        estado.setNomeEstado(random(20, true, false));
        assertTrue(isValid(estado, estado.getNomeEstado(), Update.class, Find.class));
    }

    @Test
    public void nao_deve_codigo_acima_de_100() {
        estado.setCodigoEstado(105);
        assertFalse(isValid(estado, "O código do estado não pode ser maior que 100.", Update.class, Find.class));
    }

    /**
     * Nao deve codigo abaixo de 1.
     */
    @Test
    public void nao_deve_codigo_abaixo_de_1() {
        estado.setCodigoEstado(0);
        assertFalse(isValid(estado, "O código do estado não pode ser menor que 1.", Update.class, Find.class));
    }

    @Test
    public void deve_aceitar_um_codigo_valido() {
        estado.setCodigoEstado(31);
        assertTrue(isValid(estado, String.valueOf(estado.getCodigoEstado()), Update.class, Find.class));
    }

    @Test
    public void deve_conter_um_construtor() {
        assertThat(Estado.class, hasValidBeanConstructor());
    }

    @Test
    public void deve_conter_os_gets_e_sets() {
        assertThat(Estado.class, hasValidGettersAndSetters());
    }

    /**
     * Deve respeitar o hash code.
     */
    @Test
    public void deve_respeitar_o_hash_code() {
        assertThat(Estado.class, hasValidBeanHashCodeFor("codigoEstado"));
    }

    /**
     * Deve respeitar o equals.
     */
    @Test
    public void deve_respeitar_o_equals() {
        EqualsVerifier.forClass(Estado.class).suppress(Warning.STRICT_INHERITANCE, Warning.NONFINAL_FIELDS).withOnlyTheseFields("codigoEstado").verify();
    }

    /**
     * Deve respeitar o to string.
     */
    @Test
    public void deve_respeitar_o_to_string() {
        estado.setCodigoEstado(25);
        assertTrue(estado.toString().contains("25"));
    }

    public boolean isValid(Estado estado, String mensagem, Class<?>... grupos) {
        validator = factory.getValidator();
        boolean valido = true;
        Set<ConstraintViolation<Estado>> restricoes = validator.validate(estado, grupos);
        for(ConstraintViolation<Estado> constraintViolation : restricoes)
            if (constraintViolation.getMessage().equalsIgnoreCase(mensagem))
                valido = false;

        return valido;
    }
}
