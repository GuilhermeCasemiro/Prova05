package br.com.contmatic.empresa.testes;

import static br.com.contmatic.empresa.model.easy.random.funcionario.FuncionarioRandom.gerarFuncionario;
import static com.google.code.beanmatchers.BeanMatchers.hasValidBeanConstructor;
import static com.google.code.beanmatchers.BeanMatchers.hasValidBeanHashCodeFor;
import static com.google.code.beanmatchers.BeanMatchers.registerValueGenerator;
import static org.apache.commons.lang3.RandomStringUtils.random;
import static org.apache.commons.lang3.StringUtils.EMPTY;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;
import java.util.Random;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.joda.time.DateTime;
import org.junit.Test;

import com.google.code.beanmatchers.ValueGenerator;

import br.com.contmatic.empresa.model.Funcionario;
import br.com.contmatic.empresa.model.groups.Delete;
import br.com.contmatic.empresa.model.groups.Find;
import br.com.contmatic.empresa.model.groups.Update;
import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;

/**
 * The Class FuncionarioTest.
 */
public class FuncionarioTest {

    /** The validator. */
    private Validator validator;

    /** The factory. */
    private ValidatorFactory factory = Validation.buildDefaultValidatorFactory();

    /** The funcionario. */
    private Funcionario funcionario = gerarFuncionario();

    /** The funcionario 2. */
    private Funcionario funcionario2 = new Funcionario();

    /**
     * Nao deve ter nome nulo.
     */
    @Test
    public void nao_deve_ter_nome_nulo() {
        funcionario.setNome(null);
        assertFalse(isValid(funcionario, "Nome é obrigatório", Find.class, Update.class));
    }

    /**
     * Nao deve ter nome vazio.
     */
    @Test()
    public void nao_deve_ter_nome_vazio() {

        funcionario.setNome(EMPTY);
        assertFalse(isValid(funcionario, "Nome é obrigatório", Find.class, Update.class));
    }

    /**
     * Deve aceitar se conter nome valido.
     */
    @Test
    public void deve_aceitar_se_conter_nome_valido() {

        funcionario.setNome("Guilherme");
        assertTrue(isValid(funcionario, "Guilherme", Find.class, Update.class));
    }

    /**
     * Pode aceitar nome com acentos.
     */
    @Test
    public void pode_aceitar_nome_com_acentos() {
        funcionario.setNome("Márcio");
        assertTrue(isValid(funcionario, "Márcio", Find.class, Update.class));
    }

    /**
     * Nao deve aceitar se conter nome invalido.
     */
    @Test
    public void nao_deve_aceitar_nome_com_a_primeira_letra_miniscula() {

        funcionario.setNome("mÁRCIO");
        assertFalse(isValid(funcionario, "Nome não pode ter números ou caracteres especiais.", Find.class, Update.class));
    }

    /**
     * Nao deve aceitar nome com numeros.
     */
    @Test
    public void nao_deve_aceitar_nome_com_numeros() {

        funcionario.setNome("Guilherm3");
        assertFalse(isValid(funcionario, "Nome não pode ter números ou caracteres especiais.", Find.class, Update.class));
    }

    /**
     * Nao deve aceitar nome com caracteres especiais.
     */
    @Test
    public void nao_deve_aceitar_nome_com_caracteres_especiais() {
        funcionario.setNome("Guilherm##");
        assertFalse(isValid(funcionario, "Nome não pode ter números ou caracteres especiais.", Find.class, Update.class));
    }

    /**
     * Nao deve aceitar nome com menos de 2 caracteres.
     */
    @Test
    public void nao_deve_aceitar_nome_com_menos_de_2_caracteres() {

        funcionario.setNome(random(1, true, false));
        assertFalse(isValid(funcionario, "Nome não pode ter menos de 3 ou mais de 30 caracteres.", Find.class, Update.class));
    }

    /**
     * Nao deve aceitar nome com mais de 30 caracteres.
     */
    @Test()
    public void nao_deve_aceitar_nome_com_mais_de_30_caracteres() {

        funcionario.setNome(random(60, true, false));
        assertFalse(isValid(funcionario, "Nome não pode ter menos de 3 ou mais de 30 caracteres.", Find.class, Update.class));
    }

    /**
     * Deve aceitar nomes com mais de 2 caracteres.
     */
    @Test
    public void deve_aceitar_nomes_com_mais_de_2_caracteres() {

        funcionario.setNome(random(10, true, false));
        assertTrue(isValid(funcionario, funcionario.getNome(), Find.class, Update.class));
    }

    /**
     * Deve aceitar nomes com menos de 30 caracteres.
     */
    @Test
    public void deve_aceitar_nomes_com_menos_de_30_caracteres() {

        funcionario.setNome(random(25));
        assertTrue(isValid(funcionario, funcionario.getNome(), Find.class, Update.class));
    }

    /* Testes do Email */

    /**
     * Nao deve ter email nulo.
     */
    @Test
    public void nao_deve_ter_email_nulo() {

        funcionario.setEmail(null);
        assertFalse(isValid(funcionario, "E-mail é obrigatório.", Find.class, Update.class));
    }

    /**
     * Deve aceitar email valido.
     */
    @Test
    public void deve_aceitar_email_valido() {

        funcionario.setEmail("guilherme@contmatic.com.br");
        assertTrue(isValid(funcionario, "guilherme@contmatic.com.br", Find.class, Update.class));
    }

    /**
     * Nao deve conter email invalido.
     */
    @Test
    public void nao_deve_conter_email_invalido() {

        funcionario.setEmail("teste@@@contmatic.com.br");
        assertFalse(isValid(funcionario, "Deve inserir um e-mail válido.", Find.class, Update.class));
    }

    /* Testes dos Contatos */

    /**
     * Nao deve ter contato nulo.
     */
    @Test
    public void nao_deve_ter_contato_nulo() {

        funcionario.setContatos(null);
        assertFalse(isValid(funcionario, "Não pode conter lista de contatos nula.", Delete.class, Update.class, Find.class));
    }
    
    @Test
    public void nao_deve_ter_endereco_nulo() {

        funcionario.setEndereco(null);
        assertFalse(isValid(funcionario, "Não pode conter lista de enderecos nula.", Delete.class, Update.class, Find.class));
    }

    /**
     * Nao deve conter salarios acima de 9999.
     */
    @Test
    public void nao_deve_conter_salarios_acima_de_8500() {
        funcionario.setSalario(new BigDecimal(9000));
        assertFalse(isValid(funcionario, "O salário não pode ser maior que R$: 8500.", Find.class));
    }

    /**
     * Nao deve conter salarios abaixo de 1000.
     */
    @Test
    public void nao_deve_conter_salarios_abaixo_de_1000() {
        funcionario.setSalario(new BigDecimal(900));
        assertFalse(isValid(funcionario, "O salário não pode ser menor que a base de R$: 1000.", Find.class));
    }

    /**
     * Nao deve conter comissoes acima de 500.
     */
    @Test
    public void nao_deve_conter_comissoes_acima_de_500() {
        funcionario.setComissao(new BigDecimal(1100));
        assertFalse(isValid(funcionario, "A comissão não pode ser maior que R$: 500.", Find.class));
    }

    /**
     * Nao deve conter comissoes abaixo de 0.
     */
    @Test
    public void nao_deve_conter_comissoes_abaixo_de_0() {
        funcionario.setComissao(new BigDecimal(-1));
        assertFalse(isValid(funcionario, "A comissão não pode ser menor que R$: 0.", Find.class));
    }

    /**
     * Nao deve aceitar departamento com caracteres especiais.
     */
    @Test
    public void nao_deve_aceitar_departamento_com_caracteres_especiais() {
        funcionario.setDepartamento("D&senvolviment#");
        assertFalse(isValid(funcionario, "A primeira letra deve ser maiuscula e não pode conter acentuação e caracteres especiais.", Find.class));
    }

    /**
     * Nao deve aceitar departamento nulo.
     */
    @Test
    public void nao_deve_aceitar_departamento_nulo() {
        funcionario.setDepartamento(null);
        assertFalse(isValid(funcionario, "Ter um departamento é obrigatório.", Find.class));
    }

    /**
     * Nao deve aceitar departamento vazio.
     */
    @Test
    public void nao_deve_aceitar_departamento_vazio() {
        funcionario.setDepartamento(EMPTY);
        assertFalse(isValid(funcionario, "Ter um departamento é obrigatório.", Find.class));
    }

    /**
     * Nao deve aceitar departamento com numeros.
     */
    @Test
    public void nao_deve_aceitar_departamento_com_numeros() {
        funcionario.setDepartamento(random(20, true, true));
        assertFalse(isValid(funcionario, "A primeira letra deve ser maiuscula e não pode conter acentuação e caracteres especiais.", Find.class));
    }

    /**
     * Nao deve aceitar departamento com acentos.
     */
    @Test
    public void nao_deve_aceitar_departamento_com_acentos() {
        funcionario.setDepartamento("Comunicação");
        assertFalse(isValid(funcionario, "A primeira letra deve ser maiuscula e não pode conter acentuação e caracteres especiais.", Find.class));
    }

    /**
     * Deve aceitar um departamento valido.
     */
    @Test
    public void deve_aceitar_um_departamento_valido() {
        funcionario.setDepartamento("Desenvolvimento");
        assertTrue(isValid(funcionario, "Desenvolvimento", Find.class));
    }

    /**
     * Nao deve conter departamento com mais de 30 caracteres.
     */
    @Test
    public void nao_deve_conter_departamento_com_mais_de_30_caracteres() {
        funcionario.setDepartamento(random(35));
        assertFalse(isValid(funcionario, "O departamento não pode conter menos de 5 e mais de 30 caracteres.", Find.class));
    }

    /**
     * Nao deve conter departamento com menos de 5 caracteres.
     */
    @Test
    public void nao_deve_conter_departamento_com_menos_de_5_caracteres() {
        funcionario.setDepartamento(random(4, true, false));
        assertFalse(isValid(funcionario, "O departamento não pode conter menos de 5 e mais de 30 caracteres.", Find.class));
    }

    /**
     * Deve aceitar departamento com ate 30 caracteres.
     */
    @Test
    public void deve_aceitar_departamento_com_ate_30_caracteres() {
        funcionario.setDepartamento(random(25, true, false));
        assertTrue(isValid(funcionario, funcionario.getDepartamento(), Find.class));
    }

    /**
     * Deve retornar falso se o cpf dos funcionarios forem diferentes.
     */
    @Test
    public void deve_retornar_falso_se_o_cpf_dos_funcionarios_forem_diferentes() {
        funcionario.setCpf("756.953.220-14");
        funcionario2.setCpf("781.040.350-88");
        assertFalse(funcionario.equals(funcionario2));
    }

    /**
     * Deve retornar verdadeiro se os funcionarios forem iguais.
     */
    @Test
    public void deve_retornar_verdadeiro_se_os_funcionarios_forem_iguais() {
        funcionario.setCpf("070.678.110-40");
        funcionario2.setCpf("070.678.110-40");
        assertTrue(funcionario.equals(funcionario2));
    }

    /**
     * Deve respeitar o to string.
     */
    @Test
    public void deve_respeitar_o_toString() {
        funcionario.setDepartamento("Desenvolvimento");
        assertTrue(funcionario.toString().contains("Desenvolvimento"));
    }

    /**
     * Deve respeitar o construtor.
     */
    @Test
    public void deve_respeitar_o_construtor() {
        assertThat(Funcionario.class, hasValidBeanConstructor());
    }

    /**
     * Deve respeitar o equals.
     */
    @Test
    public void deve_respeitar_o_equals() {
        EqualsVerifier.forClass(Funcionario.class).suppress(Warning.STRICT_INHERITANCE, Warning.NONFINAL_FIELDS).withRedefinedSuperclass().withOnlyTheseFields("cpf").verify();
    }

    /**
     * Deve respeitar o hashcode.
     */
    @Test
    public void deve_respeitar_o_hashcode() {
        gerarData();
        assertThat(Funcionario.class, hasValidBeanHashCodeFor());
    }

    /**
     * Checks if is valid.
     *
     * @param funcionario the funcionario
     * @param mensagem the mensagem
     * @return true, if is valid
     */
    public boolean isValid(Funcionario funcionario, String mensagem, Class<?>... grupos) {
        validator = factory.getValidator();
        boolean valido = true;
        Set<ConstraintViolation<Funcionario>> restricoes = validator.validate(funcionario, grupos);
        for(ConstraintViolation<Funcionario> constraintViolation : restricoes)
            if (constraintViolation.getMessage().equalsIgnoreCase(mensagem))
                valido = false;

        return valido;
    }

    /**
     * Gerar data.
     */
    public void gerarData() {
        registerValueGenerator(new ValueGenerator<DateTime>() {
            public DateTime generate() {
                return new DateTime(new Random().nextLong()).withMillisOfSecond(0);
            }
        }, DateTime.class);
    }
}
