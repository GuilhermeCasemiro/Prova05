package br.com.contmatic.empresa.testes;

import static br.com.contmatic.empresa.model.easy.random.endereco.EnderecoRandom.gerarEndereco;
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

import br.com.contmatic.empresa.model.Endereco;
import br.com.contmatic.empresa.model.Estado;
import br.com.contmatic.empresa.model.groups.Delete;
import br.com.contmatic.empresa.model.groups.Find;
import br.com.contmatic.empresa.model.groups.Update;
import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;

/**
 * The Class EnderecoTest.
 */
public class EnderecoTest {

    /** The validator. */
    private Validator validator;

    /** The factory. */
    private ValidatorFactory factory = Validation.buildDefaultValidatorFactory();

    /** The endereco. */
    Endereco endereco = gerarEndereco();

    Estado estado = new Estado();

    /* Testes para o bairro */

    /**
     * Nao deve aceitar bairro vazio.
     */
    @Test
    public void nao_deve_aceitar_bairro_nulo() {
        endereco.setBairro(null);
        assertFalse(isValid(endereco, "Bairro não pode ser nulo e nem estar vazio.", Delete.class, Update.class, Find.class));
    }

    /**
     * Nao deve aceitar bairro vazio.
     */
    @Test
    public void nao_deve_aceitar_bairro_vazio() {
        endereco.setBairro(EMPTY);
        assertFalse(isValid(endereco, "Bairro não pode ser nulo e nem estar vazio.", Delete.class, Update.class, Find.class));
    }

    /**
     * Deve aceitar um bairro valido.
     */
    @Test
    public void deve_aceitar_um_bairro_valido() {
        endereco.setBairro("Vila Mariana");
        assertTrue(isValid(endereco, "Vila Mariana", Delete.class, Update.class, Find.class));
    }

    /**
     * Nao deve aceitar um bairro invalido.
     */
    @Test
    public void nao_deve_aceitar_um_bairro_invalido() {
        endereco.setBairro("Vil@ Marian@");
        assertFalse(isValid(endereco, "Bairro não pode conter números e caracteres especiais.", Delete.class, Update.class, Find.class));
    }

    /**
     * Deve aceitar bairro com acentuacao.
     */
    @Test
    public void deve_aceitar_bairro_com_acentuacao() {
        endereco.setBairro("Tatuapé");
        assertTrue(isValid(endereco, endereco.getBairro(), Delete.class, Update.class, Find.class));
    }

    /**
     * Nao deve aceitar bairro com numero.
     */
    @Test
    public void nao_deve_aceitar_bairro_com_numero() {
        endereco.setBairro("T4tuap3");
        assertFalse(isValid(endereco, "Bairro não pode conter números e caracteres especiais.", Delete.class, Update.class, Find.class));
    }

    /**
     * Nao deve conter bairro com mais de 30 caracteres.
     */
    @Test
    public void nao_deve_conter_bairro_com_mais_de_30_caracteres() {
        endereco.setBairro(random(31));
        assertFalse(isValid(endereco, "Bairro não pode conter menos de 5 caracteres e mais 30 de caracteres.", Delete.class, Update.class, Find.class));
    }

    /**
     * Nao deve conter bairro com menos de 5 caracteres.
     */
    @Test
    public void nao_deve_conter_bairro_com_menos_de_5_caracteres() {
        endereco.setBairro(random(4));
        assertFalse(isValid(endereco, "Bairro não pode conter menos de 5 caracteres e mais 30 de caracteres.", Delete.class, Update.class, Find.class));
    }

    /**
     * Bairro deve conter entre 5 e 30 caracteres.
     */
    @Test
    public void bairro_deve_conter_entre_5_e_30_caracteres() {
        endereco.setBairro(random(15, true, true));
        assertTrue(isValid(endereco, endereco.getBairro(), Delete.class, Update.class, Find.class));
    }

    /* Testes do CEP */

    /**
     * Nao deve aceitar cep nulo.
     */
    @Test
    public void nao_deve_aceitar_cep_nulo() {
        endereco.setCep(null);
        assertFalse(isValid(endereco, "CEP não pode ser nulo e nem vazio.", Delete.class, Update.class, Find.class));
    }

    /**
     * Nao deve aceitar cep vazio.
     */
    @Test
    public void nao_deve_aceitar_cep_vazio() {
        endereco.setCep(EMPTY);
        assertFalse(isValid(endereco, "CEP não pode ser nulo e nem vazio.", Delete.class, Update.class, Find.class));
    }

    /**
     * Deve aceitar um cep valido.
     */
    @Test
    public void deve_aceitar_um_cep_valido() {
        endereco.setCep("70385530");
        assertTrue(isValid(endereco, endereco.getCep(), Delete.class, Update.class, Find.class));
    }

    /**
     * Nao deve aceitar um cep invalido.
     */
    @Test
    public void nao_deve_aceitar_um_cep_invalido() {
        endereco.setCep("70385-53A");
        assertFalse(isValid(endereco, "CEP inválido.", Delete.class, Update.class, Find.class));
    }

    /**
     * Na deve aceitar um cep com caracteres especiais.
     */
    @Test
    public void na_deve_aceitar_um_cep_com_caracteres_especiais() {
        endereco.setCep("7038&-53@");
        assertFalse(isValid(endereco, "CEP inválido.", Delete.class, Update.class, Find.class));
    }

    /**
     * Nao deve conter cep com mais de 9 caracteres.
     */
    @Test
    public void nao_deve_conter_cep_com_mais_de_9_caracteres() {
        endereco.setCep(random(10, false, true));
        assertFalse(isValid(endereco, "CEP não pode ter mais de 9 caracteres.", Delete.class, Update.class, Find.class));
    }

    /**
     * Nao deve conter cep com menos de 9 caracteres.
     */
    @Test
    public void nao_deve_conter_cep_com_menos_de_9_caracteres() {
        endereco.setCep(random(8, false, true));
        assertFalse(isValid(endereco, "CEP não pode ter mais de 9 caracteres.", Delete.class, Update.class, Find.class));
    }

    /**
     * Deve aceitar cep com 9 caracteres.
     */
    @Test
    public void deve_aceitar_cep_com_9_caracteres() {
        endereco.setBairro(random(9));
        assertTrue(isValid(endereco, endereco.getCep(), Delete.class, Update.class, Find.class));
    }
    /*-------------------------------------------------------------------------*/

    /**
     * Pode aceitar complemento nulo.
     */
    /* Test do Complemento */
    @Test
    public void pode_aceitar_complemento_nulo() {
        endereco.setComplemento(null);
        assertTrue(isValid(endereco, null, Delete.class, Update.class, Find.class));
    }

    /**
     * Pode aceitar complemento vazio.
     */
    @Test
    public void pode_aceitar_complemento_vazio() {

        endereco.setComplemento(EMPTY);
        assertTrue(isValid(endereco, EMPTY, Delete.class, Update.class, Find.class));
    }

    /**
     * Deve aceitar um complemento valido.
     */
    @Test
    public void deve_aceitar_um_complemento_valido() {
        endereco.setComplemento("Apartamento 41B");
        assertTrue(isValid(endereco, endereco.getComplemento(), Delete.class, Update.class, Find.class));
    }

    /**
     * Deve aceitar um complemento com menos de 30 caracteres.
     */
    @Test
    public void deve_aceitar_um_complemento_com_menos_de_30_caracteres() {
        endereco.setComplemento(random(29, true, true));
        assertTrue(isValid(endereco, endereco.getComplemento(), Delete.class, Update.class, Find.class));
    }

    /**
     * Nao deve aceitar complemento com caracteres especiais.
     */
    @Test
    public void nao_deve_aceitar_complemento_com_caracteres_especiais() {
        endereco.setComplemento("$Apartamento 41-B");
        assertFalse(isValid(endereco, "Deve inserir um complemento válido.", Delete.class, Update.class, Find.class));
    }

    /**
     * Nao deve aceitar complemento com mais de 30 caracteres.
     */
    @Test
    public void nao_deve_aceitar_complemento_com_mais_de_30_caracteres() {
        endereco.setComplemento(random(31));
        assertFalse(isValid(endereco, "Complemento não pode ter mais de 30 caracteres.", Delete.class, Update.class, Find.class));
    }
    /*---------------------------------------------------------------------------------------*/

    /* Teste do número residencial */

    /**
     * Nao deve aceitar numero residencia negativo.
     */
    @Test
    public void nao_deve_aceitar_numero_residencia_negativo() {
        endereco.setNumeroResidencia(-1);
        assertFalse(isValid(endereco, "O número da residência não ser negativo.", Delete.class, Update.class, Find.class));
    }

    /**
     * Nao deve aceitar numero residencia maior que 1500.
     */
    @Test
    public void nao_deve_aceitar_numero_residencia_maior_que_1500() {
        endereco.setNumeroResidencia(1501);
        assertFalse(isValid(endereco, "O número da residência não pode ser maior que 1500.", Delete.class, Update.class, Find.class));
    }

    /**
     * Deve aceitar um numero de residencia valido.
     */
    @Test
    public void deve_aceitar_um_numero_de_residencia_valido() {
        endereco.setNumeroResidencia(999);
        assertTrue(isValid(endereco, String.valueOf(endereco.getNumeroResidencia()), Delete.class, Update.class, Find.class));
    }

    /**
     * Deve retornar falso se os enderecos forem diferentes.
     */
    @Test
    public void deve_retornar_falso_se_os_enderecos_forem_diferentes() {
        Endereco endereco2 = gerarEndereco();

        assertFalse(endereco.equals(endereco2));
    }

    /**
     * Deve retornar verdadeiro se os enderecos forem iguais.
     */
    @Test
    public void deve_retornar_verdadeiro_se_os_enderecos_forem_iguais() {
        Endereco endereco2 = endereco;

        assertTrue(endereco.equals(endereco2));
    }

    /**
     * Deve respeitar o construtor.
     */
    @Test
    public void deve_respeitar_o_construtor() {
        assertThat(Endereco.class, hasValidBeanConstructor());
    }

    /**
     * Deve respeitar os gets e sets.
     */
    @Test
    public void deve_respeitar_os_gets_e_sets() {
        assertThat(Endereco.class, hasValidGettersAndSetters());
    }

    /**
     * Deve respeitar o equals.
     */
    @Test
    public void deve_respeitar_o_equals() {
        EqualsVerifier.forClass(Endereco.class).suppress(Warning.STRICT_INHERITANCE, Warning.NONFINAL_FIELDS).withOnlyTheseFields("cep").verify();
    }

    /**
     * Deve respeitar o hashcode.
     */
    @Test
    public void deve_respeitar_o_hashcode() {
        assertThat(Endereco.class, hasValidBeanHashCodeFor("cep"));
    }

    /**
     * Deve respeitar o to string.
     */
    @Test
    public void deve_respeitar_o_toString() {
        endereco.setBairro("Itaquera");
        assertTrue(endereco.toString().contains("Itaquera"));
    }

    /**
     * Checks if is valid.
     *
     * @param endereco the endereco
     * @param mensagem the mensagem
     * @return true, if is valid
     */
    public boolean isValid(Endereco endereco, String mensagem, Class<?>... grupos) {
        validator = factory.getValidator();
        boolean valido = true;
        Set<ConstraintViolation<Endereco>> restricoes = validator.validate(endereco, grupos);
        for(ConstraintViolation<Endereco> constraintViolation : restricoes)
            if (constraintViolation.getMessage().equalsIgnoreCase(mensagem))
                valido = false;

        return valido;
    }

}
