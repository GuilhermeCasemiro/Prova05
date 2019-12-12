package br.com.contmatic.empresa.testes;

import static br.com.contmatic.empresa.model.easy.random.empresa.EmpresaRandom.gerarEmpresa;
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

import br.com.contmatic.empresa.model.Empresa;
import br.com.contmatic.empresa.model.groups.Create;
import br.com.contmatic.empresa.model.groups.Delete;
import br.com.contmatic.empresa.model.groups.Find;
import br.com.contmatic.empresa.model.groups.Update;
import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;

/**
 * The Class EmpresaTest.
 */
public class EmpresaTest {

    /** The validator. */
    private Validator validator;

    /** The factory. */
    private ValidatorFactory factory = Validation.buildDefaultValidatorFactory();

    /** The empresa. */
    private Empresa empresa = gerarEmpresa();

    /** The empresa 2. */
    Empresa empresa2 = new Empresa();

    /* Testes do CNPJ */

    /**
     * Nao deve aceita cnpj nulo.
     */
    @Test
    public void nao_deve_aceita_cnpj_nulo() {
        empresa.setCnpj(null);
        assertFalse(isValid(empresa, "CNPJ obrigatório.", Create.class, Delete.class, Find.class, Update.class));
    }

    /**
     * Nao deve aceitar cnpj vazio.
     */
    @Test
    public void nao_deve_aceitar_cnpj_vazio() {
        empresa.setCnpj(EMPTY);
        assertFalse(isValid(empresa, "CNPJ obrigatório.", Create.class, Delete.class, Find.class, Update.class));
    }

    /**
     * Nao deve aceitar cnpj com mais de 14 caracteres.
     */
    @Test
    public void nao_deve_aceitar_cnpj_com_mais_de_14_caracteres() {

        empresa.setCnpj(random(15, false, true));
        assertFalse(isValid(empresa, "CNPJ deve conter exatamente 14 caracteres.", Create.class, Delete.class, Find.class, Update.class));
    }

    /**
     * Nao deve aceitar cnpj com menos de 14 caracteres.
     */
    @Test
    public void nao_deve_aceitar_cnpj_com_menos_de_14_caracteres() {

        empresa.setCnpj(random(13, false, true));
        assertFalse(isValid(empresa, "CNPJ deve conter exatamente 14 caracteres.", Create.class, Delete.class, Find.class, Update.class));
    }

    /**
     * So deve aceitar cnpj com 14 caracteres.
     */
    @Test
    public void deve_aceitar_cnpj_com_valido_14_caracteres() {

        empresa.setCnpj("20.504.365/0001-60");
        assertTrue(isValid(empresa, "20.504.365/0001-60", Create.class, Delete.class, Find.class, Update.class));
    }

    /**
     * Deve aceitar so cnpj valido.
     */
    @Test
    public void deve_aceitar_cnpj_valido() {

        empresa.setCnpj("41.081.011/0001-20");
        assertTrue(isValid(empresa, "41.081.011/0001-20", Create.class, Delete.class, Find.class, Update.class));
    }

    /**
     * Nao deve aceitar um cnpj invalido.
     */
    @Test
    public void nao_deve_aceitar_um_cnpj_invalido() {

        empresa.setCnpj("18.317.482/001-73");
        assertFalse(isValid(empresa, "O CNPJ deve ser válido.", Create.class, Delete.class, Find.class, Update.class));
    }
    /* Testes da Razão Social */

    /**
     * Nao deve aceitar razao social nula.
     */
    @Test
    public void nao_deve_aceitar_razao_social_nula() {

        empresa.setRazaoSocial(null);
        assertFalse(isValid(empresa, "Razão Social é obrigatório.", Create.class, Delete.class, Find.class, Update.class));
    }

    /**
     * Nao deve aceitar razao social vazia.
     */
    @Test
    public void nao_deve_aceitar_razao_social_vazia() {

        empresa.setRazaoSocial(EMPTY);
        assertFalse(isValid(empresa, "Razão Social é obrigatório.", Create.class, Delete.class, Find.class, Update.class));
    }

    /**
     * Deve so aceitar razao sociao valida.
     */
    @Test
    public void deve_so_aceitar_razao_sociao_valida() {

        empresa.setRazaoSocial("Rodrigo e Milena Alimentos ME");
        assertTrue(isValid(empresa, "Rodrigo e Milena Alimentos ME", Create.class, Delete.class, Find.class, Update.class));
    }

    /**
     * Nao deve aceitar razao social com numeros.
     */
    @Test
    public void nao_deve_aceitar_razao_social_com_numeros() {
        empresa.setRazaoSocial("Rodrig0 e Milena 4limentos M3");
        assertFalse(isValid(empresa, "Razão Social inválida.", Create.class, Delete.class, Find.class, Update.class));
    }

    /**
     * Nao deve aceitar razao social com caracteres especiais.
     */
    @Test
    public void nao_deve_aceitar_razao_social_com_caracteres_especiais() {
        empresa.setRazaoSocial("Rodrig0 e Milen@ 4lim$ntos M3");
        assertFalse(isValid(empresa, "Razão Social inválida.", Create.class, Delete.class, Find.class, Update.class));
    }

    /**
     * Nao deve aceitar razao social com mais de 30 caracteres.
     */
    @Test
    public void nao_deve_aceitar_razao_social_com_mais_de_30_caracteres() {

        empresa.setRazaoSocial(random(31, true, false));
        assertFalse(isValid(empresa, "Razão social deve ter no minino 10 caracteres e no maixmo 30 caracteres.", Create.class, Delete.class, Find.class, Update.class));
    }

    /**
     * Nao deve aceitar razao social com menos de 10 caracteres.
     */
    @Test
    public void nao_deve_aceitar_razao_social_com_menos_de_10_caracteres() {

        empresa.setRazaoSocial(random(9, true, false));
        assertFalse(isValid(empresa, "Razão social deve ter no minino 10 caracteres e no maixmo 30 caracteres.", Create.class, Delete.class, Find.class, Update.class));
    }

    /**
     * So deve aceitar razao social entre 10 e 30 caracteres.
     */
    @Test
    public void so_deve_aceitar_razao_social_entre_10_e_30_caracteres() {
        empresa.setRazaoSocial("Nicolas e Severino Comercio de Bebidas Ltda");
        assertTrue(isValid(empresa, "Nicolas e Severino Comercio de Bebidas Ltda", Create.class, Delete.class, Find.class, Update.class));
    }

    /**
     * Deve aceitar razao social valida.
     */
    @Test
    public void deve_aceitar_razao_social_valida() {

        empresa.setRazaoSocial("Lara e Enrico Filmagens");
        assertTrue(isValid(empresa, "Lara e Enrico Filmagens", Create.class, Delete.class, Find.class, Update.class));
    }

    /* Testes da Nome Fantasia */

    /**
     * Nao deve aceitar nome fantasia nulo.
     */
    @Test
    public void nao_deve_aceitar_nome_fantasia_nulo() {

        empresa.setNomeFantasia(null);
        assertFalse(isValid(empresa, "Nome fantasia é obrigatório.", Create.class, Delete.class, Find.class, Update.class));
    }

    /**
     * Nao deve aceitar nome fantasia vazia.
     */
    @Test
    public void nao_deve_aceitar_nome_fantasia_vazia() {

        empresa.setNomeFantasia(EMPTY);
        assertFalse(isValid(empresa, "Nome fantasia é obrigatório.", Create.class, Delete.class, Find.class, Update.class));
    }

    /**
     * Deve so aceitar nome fantasia valida.
     */
    @Test
    public void deve_so_aceitar_nome_fantasia_valida() {

        empresa.setNomeFantasia("StarWood Games");
        assertTrue(isValid(empresa, "StarWood Games", Create.class, Delete.class, Find.class, Update.class));
    }

    /**
     * Nao deve aceitar nome fantasia invalida.
     */
    @Test
    public void nao_deve_aceitar_nome_fantasia_invalida() {
        empresa.setNomeFantasia("St4rW00d G4m3s");
        assertFalse(isValid(empresa, "Nome Fantasia inválido.", Create.class, Delete.class, Find.class, Update.class));
    }

    /**
     * Nao deve aceitar nome fantasia com caracteres especiais.
     */
    @Test
    public void nao_deve_aceitar_nome_fantasia_com_caracteres_especiais() {
        empresa.setNomeFantasia("St@rW**d Games");
        assertFalse(isValid(empresa, "Nome Fantasia inválido.", Create.class, Delete.class, Find.class, Update.class));
    }

    /**
     * Nao deve aceitar razao social com mais de 30 caracteres.
     */
    @Test
    public void nao_deve_aceitar_nome_fantasia_com_mais_de_30_caracteres() {

        empresa.setNomeFantasia(random(31, true, false));
        assertFalse(isValid(empresa, "Nome fantasia deve ter no minimo 10 caracteres e no maixmo 30 caracteres.", Create.class, Delete.class, Find.class, Update.class));
    }

    /**
     * Nao deve aceitar razao social com menos de 10 caracteres.
     */
    @Test
    public void nao_deve_aceitar_nome_fantasia_com_menos_de_10_caracteres() {

        empresa.setNomeFantasia(random(9, true, false));
        assertFalse(isValid(empresa, "Nome fantasia deve ter no minimo 10 caracteres e no maixmo 30 caracteres.", Create.class, Delete.class, Find.class, Update.class));
    }

    /**
     * So deve aceitar nome fantasia entre 10 e 30 caracteres.
     */
    @Test
    public void so_deve_aceitar_nome_fantasia_entre_10_e_30_caracteres() {
        empresa.setNomeFantasia("Mercearia União");
        assertTrue(isValid(empresa, "Mercearia União", Create.class, Delete.class, Find.class, Update.class));
    }

    /**
     * Deve aceitar nome fantasia valida.
     */
    @Test
    public void deve_aceitar_nome_fantasia_valida() {

        empresa.setNomeFantasia("Western Games");
        assertTrue(isValid(empresa, "Western Games", Create.class, Delete.class, Find.class, Update.class));
    }

    /**
     * Deve retornar falso se os cnpjs forem diferentes.
     */
    @Test
    public void deve_retornar_falso_se_os_cnpjs_forem_diferentes() {

        empresa.setCnpj("18.317.482/0001-73");
        empresa2.setCnpj("96.827.078/0001-53");
        assertFalse(empresa.equals(empresa2));
    }

    /**
     * Deve retornar verdadeiro se os cnpjs forem iguais.
     */
    @Test
    public void deve_retornar_verdadeiro_se_os_cnpjs_forem_iguais() {

        empresa.setCnpj("11.296.795/0001-43");
        empresa2.setCnpj("11.296.795/0001-43");
        assertTrue(empresa.equals(empresa2));
    }

    /**
     * Deve aceitar as regras do equals.
     */
    @Test
    public void deve_aceitar_as_regras_do_equals() {
        EqualsVerifier.forClass(Empresa.class).suppress(Warning.NONFINAL_FIELDS, Warning.STRICT_INHERITANCE).withOnlyTheseFields("cnpj").verify();
    }

    /**
     * Deve aceitar as regras do hashcode.
     */
    @Test
    public void deve_aceitar_as_regras_do_hashcode() {
        assertThat(Empresa.class, hasValidBeanHashCodeFor("cnpj"));
    }

    @Test
    public void deve_respeitar_o_hash_code() {
        assertThat(Empresa.class, hasValidGettersAndSetters());
    }

    /**
     * Deve aceitar as regras do contrutor.
     */
    @Test
    public void deve_aceitar_as_regras_do_contrutor() {
        assertThat(Empresa.class, hasValidBeanConstructor());
    }

    /**
     * Deve aceitar as regras do to string.
     */
    @Test
    public void deve_aceitar_as_regras_do_toString() {

        empresa = new Empresa("26957703000104");
        assertTrue(empresa.toString().contains("26957703000104"));
    }

    /**
     * Checks if is valid.
     *
     * @param empresa the empresa
     * @param mensagem the mensagem
     * @return true, if is valid
     */
    public boolean isValid(Empresa empresa, String mensagem, Class<?>... grupo) {
        validator = factory.getValidator();
        boolean valido = true;
        Set<ConstraintViolation<Empresa>> restricoes = validator.validate(empresa, grupo);
        for(ConstraintViolation<Empresa> constraintViolation : restricoes)
            if (constraintViolation.getMessage().equalsIgnoreCase(mensagem))
                valido = false;

        return valido;
    }
}
