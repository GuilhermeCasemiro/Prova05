package br.com.contmatic.empresa.repository;

import static br.com.contmatic.empresa.model.easy.random.empresa.EmpresaRandom.gerarEmpresa;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.bson.Document;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;

import br.com.contmatic.empresa.model.Empresa;
import de.flapdoodle.embed.mongo.MongodExecutable;
import de.flapdoodle.embed.mongo.MongodProcess;
import de.flapdoodle.embed.mongo.MongodStarter;
import de.flapdoodle.embed.mongo.config.MongodConfigBuilder;
import de.flapdoodle.embed.mongo.config.Net;
import de.flapdoodle.embed.mongo.distribution.Version;
import de.flapdoodle.embed.process.runtime.Network;

public class MongoDataSourceTest {

    private static final MongodStarter STARTER = MongodStarter.getDefaultInstance();

    private static MongodProcess _mongod;

    private static MongodExecutable _mongodExe;

    private static MongoClient _mongo;

    private static MongoDatabase database;

    private static EmpresaRepository repository;

    @BeforeClass
    public static void setUp() throws Exception {

        _mongo = new MongoClient("localhost", 12345);
        database = _mongo.getDatabase("Prova05");
        repository = new EmpresaRepository(database);
        _mongodExe = STARTER.prepare(new MongodConfigBuilder().version(Version.Main.V3_4).net(new Net("localhost", 12345, Network.localhostIsIPv6())).build());
        _mongod = _mongodExe.start();
        database.createCollection("MongoTest");
    }

    @Test
    public void testInsert() {
        Empresa empresa = gerarEmpresa();
        System.out.println(empresa.toString());

        assertTrue(repository.insert(empresa));
        deletarTudo();
    }

    @Test
    public void testUpdateById() {
        Empresa empresa = gerarEmpresa();
        repository.insert(empresa);

        assertTrue(repository.updateById(empresa.getCnpj(), "razaoSocial", "Contmatic Phoenix"));
        deletarTudo();
    }

    @Test
    public void testUpdateByFilter() {
        Empresa empresa = gerarEmpresa();
        repository.insert(empresa);

        assertTrue(repository.updateByFilter("estado.codigoEstado", empresa.getEstado().getCodigoEstado(), "estado.codigoEstado", 150));
        deletarTudo();
    }

    @Test
    public void testeFindAll() {
        int expected = 10;
        adicionarEmpresas(10);
        int actual = repository.findAll().size();

        assertEquals("Número de documentos não são iguais.", expected, actual);
        deletarTudo();
    }

    @Test
    public void testDeleteById() {
        Empresa empresa = gerarEmpresa();

        repository.insert(empresa);
        assertTrue(repository.deleteById(empresa.getCnpj()));
        deletarTudo();
    }

    @Test
    public void testDeleteByFilter() {
        Empresa empresa = gerarEmpresa();
        repository.insert(empresa);

        assertTrue(repository.deleteByFilter("nomeFantasia", empresa.getNomeFantasia()));
        deletarTudo();
    }

    @Test
    public void testeFindByFilter() {
        adicionarEmpresas(5);
        List<Document> empresas = repository.findByFilter("_id");
        empresas.forEach(System.out::println);

        assertNotNull(empresas);
        deletarTudo();
    }

    @Test
    public void testeFindByFilter2() {
        adicionarEmpresas(5);
        List<Document> empresas = repository.findByFilter("razaoSocial");
        empresas.forEach(System.out::println);

        assertNotNull(empresas);
        deletarTudo();
    }

    @Test
    public void testeFindByFilter3() {
        adicionarEmpresas(5);
        List<Document> empresas = repository.findByFilter("nomeFantasia");
        empresas.forEach(System.out::println);

        assertNotNull(empresas);
        deletarTudo();
    }

    @Test
    public void testeFindByFilter4() {
        adicionarEmpresas(5);
        List<Document> empresas = repository.findByFilter("funcionarios");
        empresas.forEach(System.out::println);

        assertNotNull(empresas);
        deletarTudo();
    }

    @Test
    public void testeFindByFilter5() {
        adicionarEmpresas(5);
        List<Document> empresas = repository.findByFilter("funcionarios.salario");
        empresas.forEach(System.out::println);

        assertNotNull(empresas);
        deletarTudo();
    }

    @Test
    public void testeFindByFilter6() {
        adicionarEmpresas(5);
        List<Document> empresas = repository.findByFilter("funcionarios.comissao");
        empresas.forEach(System.out::println);

        assertNotNull(empresas);
        deletarTudo();
    }

    @Test
    public void testeFindByFilter7() {
        adicionarEmpresas(5);
        List<Document> empresas = repository.findByFilter("funcionarios.departamento");
        empresas.forEach(System.out::println);

        assertNotNull(empresas);
        deletarTudo();
    }

    @Test
    public void testeFindByFilter8() {
        adicionarEmpresas(5);
        List<Document> empresas = repository.findByFilter("cidade");
        empresas.forEach(System.out::println);

        assertNotNull(empresas);
        deletarTudo();
    }

    @Test
    public void testeFindByFilter9() {
        adicionarEmpresas(5);
        List<Document> empresas = repository.findByFilter("cidade.nomeCidade");
        empresas.forEach(System.out::println);

        assertNotNull(empresas);
        deletarTudo();
    }

    @Test
    public void testeFindByFilter10() {
        adicionarEmpresas(5);
        List<Document> empresas = repository.findByFilter("cidade.codigoCidade");
        empresas.forEach(System.out::println);

        assertNotNull(empresas);
        deletarTudo();
    }

    @Test
    public void testeFindByFilter11() {
        adicionarEmpresas(5);
        List<Document> empresas = repository.findByFilter("estado");
        empresas.forEach(System.out::println);

        assertNotNull(empresas);
        deletarTudo();
    }

    @Test
    public void testeFindByFilter12() {
        adicionarEmpresas(5);
        List<Document> empresas = repository.findByFilter("estado.nomeEstado");
        empresas.forEach(System.out::println);

        assertNotNull(empresas);
        deletarTudo();
    }

    @Test
    public void testeFindByFilter13() {
        adicionarEmpresas(5);
        List<Document> empresas = repository.findByFilter("estado.codigoEstado");
        empresas.forEach(System.out::println);

        assertNotNull(empresas);
        deletarTudo();
    }

    @Test
    public void testeFindByFilter14() {
        adicionarEmpresas(5);
        List<Document> empresas = repository.findByFilter("enderecos");
        empresas.forEach(System.out::println);

        assertNotNull(empresas);
        deletarTudo();
    }

    @Test
    public void testeFindByFilter15() {
        adicionarEmpresas(5);
        List<Document> empresas = repository.findByFilter("enderecos.bairro");
        empresas.forEach(System.out::println);

        assertNotNull(empresas);
        deletarTudo();
    }

    @Test
    public void testeFindByFilter16() {
        adicionarEmpresas(5);
        List<Document> empresas = repository.findByFilter("enderecos.complemento");
        empresas.forEach(System.out::println);

        assertNotNull(empresas);
        deletarTudo();
    }

    @Test
    public void testeFindByFilter17() {
        adicionarEmpresas(5);
        List<Document> empresas = repository.findByFilter("enderecos.cep");
        empresas.forEach(System.out::println);

        assertNotNull(empresas);
        deletarTudo();
    }

    @Test
    public void testeFindByFilter18() {
        adicionarEmpresas(5);
        List<Document> empresas = repository.findByFilter("enderecos.numeroResidencia");
        empresas.forEach(System.out::println);

        assertNotNull(empresas);
        deletarTudo();
    }

    @Test
    public void testeFindByFilter19() {
        adicionarEmpresas(5);
        List<Document> empresas = repository.findByFilter("contatos.ddd");
        empresas.forEach(System.out::println);

        assertNotNull(empresas);
        deletarTudo();
    }

    @Test
    public void testeFindByFilter20() {
        adicionarEmpresas(5);
        List<Document> empresas = repository.findByFilter("contatos.telefone");
        empresas.forEach(System.out::println);

        assertNotNull(empresas);
        deletarTudo();
    }

    @Test
    public void testeFindByFilterLimit() {
        adicionarEmpresas(20);
        List<Empresa> empresas = repository.findByFilterLimit("funcionarios.departamento", "Desenvolvimento", 10);

        empresas.forEach(System.out::println);
        assertTrue(empresas.size() > 0);
        deletarTudo();
    }

    public void adicionarEmpresas(int quantidade) {
        for(int i = 1 ; i <= quantidade ; i++) {
            Empresa empresa = gerarEmpresa();
            repository.insert(empresa);
        }
    }

    public void deletarTudo() {
        repository.deleteAll();
    }

    @AfterClass
    public static void tearDown() throws Exception {
        _mongod.stop();
        _mongodExe.stop();
    }

}
