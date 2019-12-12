package br.com.contmatic.empresa.testes;

import static br.com.contmatic.empresa.model.easy.random.funcionario.ContatoRandom.gerarContato;
import static com.google.code.beanmatchers.BeanMatchers.hasValidBeanConstructor;
import static com.google.code.beanmatchers.BeanMatchers.hasValidBeanHashCode;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.jeasy.random.EasyRandom;
import org.junit.Test;

import br.com.contmatic.empresa.model.Contato;
import br.com.contmatic.empresa.model.DDD;
import br.com.contmatic.empresa.model.Telefone;
import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;

/**
 * The Class ContatoTest.
 */
public class ContatoTest {

    /** The validator. */
    private Validator validator;

    /** The factory. */
    private ValidatorFactory factory = Validation.buildDefaultValidatorFactory();

    private Contato contato = new EasyRandom().nextObject(Contato.class);

    private Contato contato2 = new EasyRandom().nextObject(Contato.class);

    /**
     * Nao deve aceitar telefone nulo.
     */
    @Test
    public void nao_deve_aceitar_telefone_nulo() {
        contato.setTelefone(null);
        assertFalse(isValid(contato, "Telefone não pode ser nulo."));
    }

    @Test
    public void deve_aceitar_um_telefone_celular_valido() {
        contato.setTelefone(Telefone.CELULAR);
        assertTrue(isValid(contato, Telefone.CELULAR.toString()));
    }

    @Test
    public void deve_aceitar_um_telefone_fixo_valido() {
        contato.setTelefone(Telefone.FIXO);
        assertTrue(isValid(contato, Telefone.FIXO.toString()));
    }

    /**
     * Nao deve conter ddd nulo.
     */
    @Test
    public void nao_deve_conter_ddd_nulo() {
        contato.setDdd(null);
        assertFalse(isValid(contato, "DDD não pode ser nulo."));
    }

    @Test
    public void deve_aceitar_um_ddd_valido() {
        contato.setDdd(DDD.SAO_PAULO);
        assertTrue(isValid(contato, DDD.SAO_PAULO.toString()));
    }

    /**
     * Deve respeitar o construtor.
     */
    @Test
    public void deve_respeitar_o_construtor() {
        assertThat(Contato.class, hasValidBeanConstructor());
    }

    /**
     * Deve respeitar o equals.
     */
    @Test
    public void deve_respeitar_o_equals() {
        EqualsVerifier.forClass(Contato.class).suppress(Warning.NONFINAL_FIELDS, Warning.STRICT_INHERITANCE).verify();
    }

    /**
     * Deve respeitar o hashcode.
     */
    @Test
    public void deve_respeitar_o_hashcode() {
        assertThat(Contato.class, hasValidBeanHashCode());
    }

    @Test
    public void deve_retornar_falso_se_os_contatos_forem_diferentes() {
        contato.setDdd(DDD.AMAPA);
        contato.setTelefone(Telefone.CELULAR);

        contato2.setDdd(DDD.BAHIA);
        contato2.setTelefone(Telefone.FIXO);
        assertFalse(contato.equals(contato2));
    }

    @Test
    public void deve_retornar_verdadeiro_se_os_contatos_forem_iguais() {
        contato.setDdd(DDD.AMAPA);
        contato.setTelefone(Telefone.CELULAR);

        contato2.setDdd(DDD.AMAPA);
        contato2.setTelefone(Telefone.CELULAR);
        assertTrue(contato.equals(contato2));
    }

    /**
     * Deve respeitar o to string.
     */
    @Test
    public void deve_respeitar_o_toString() {
        Contato contato = gerarContato();
        contato.setTelefone(Telefone.FIXO);
        assertTrue(contato.toString().contains("FIXO"));
    }

    public boolean isValid(Contato contato, String mensagem) {
        validator = factory.getValidator();
        boolean valido = true;
        Set<ConstraintViolation<Contato>> restricoes = validator.validate(contato);
        for(ConstraintViolation<Contato> constraintViolation : restricoes)
            if (constraintViolation.getMessage().equalsIgnoreCase(mensagem))
                valido = false;

        return valido;
    }

}
