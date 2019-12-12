package br.com.contmatic.empresa.model.easy.random.empresa;

import static br.com.contmatic.empresa.model.easy.random.endereco.EnderecoRandom.gerarEndereco;
import static br.com.contmatic.empresa.model.easy.random.funcionario.ContatoRandom.gerarContato;
import static br.com.contmatic.empresa.model.easy.random.funcionario.FuncionarioRandom.gerarFuncionario;
import static org.jeasy.random.FieldPredicates.inClass;
import static org.jeasy.random.FieldPredicates.named;
import static org.jeasy.random.FieldPredicates.ofType;

import java.util.Set;

import org.jeasy.random.EasyRandom;
import org.jeasy.random.EasyRandomParameters;
import org.jeasy.random.api.Randomizer;
import org.jeasy.random.randomizers.CompanyRandomizer;
import org.jeasy.random.randomizers.collection.SetRandomizer;

import br.com.contmatic.empresa.model.Cidade;
import br.com.contmatic.empresa.model.Contato;
import br.com.contmatic.empresa.model.Empresa;
import br.com.contmatic.empresa.model.Endereco;
import br.com.contmatic.empresa.model.Estado;
import br.com.contmatic.empresa.model.Funcionario;
import br.com.contmatic.empresa.model.easy.random.cidade.CidadeRandom;
import br.com.contmatic.empresa.model.easy.random.estado.EstadoRandom;

public class EmpresaRandom implements Randomizer<Empresa> {

    public static Empresa gerarEmpresa() {

        EasyRandomParameters parametroEmpresa = new EasyRandomParameters();
        parametroEmpresa.ignoreRandomizationErrors(false);
        parametroEmpresa.overrideDefaultInitialization(false);
        parametroEmpresa.collectionSizeRange(1, 5);

        parametroEmpresa.randomize(named("cnpj").and(ofType(String.class).and(inClass(Empresa.class))), new CNPJRandom());
        parametroEmpresa.randomize(named("razaoSocial").and(ofType(String.class).and(inClass(Empresa.class))), new RazaoSocialRandom());
        parametroEmpresa.randomize(named("nomeFantasia").and(ofType(String.class).and(inClass(Empresa.class))), new CompanyRandomizer());
        parametroEmpresa.randomize(named("cidade").and(ofType(Cidade.class).and(inClass(Empresa.class))), new CidadeRandom());
        parametroEmpresa.randomize(named("estado").and(ofType(Estado.class).and(inClass(Empresa.class))), new EstadoRandom());
        parametroEmpresa.randomize(named("funcionarios").and(ofType(Set.class)).and(inClass(Empresa.class)), new SetRandomizer<Funcionario>(funcionarioRandomizer, 2));
        parametroEmpresa.randomize(named("contatos").and(ofType(Set.class).and(inClass(Empresa.class))), new SetRandomizer<Contato>(contatoRandomizer, 2));
        parametroEmpresa.randomize(named("enderecos").and(ofType(Set.class).and(inClass(Empresa.class))), new SetRandomizer<Endereco>(enderecoRandomizer, 2));

        EasyRandom easyRandom = new EasyRandom(parametroEmpresa);

        return easyRandom.nextObject(Empresa.class);
    }

    static Randomizer<Funcionario> funcionarioRandomizer = new Randomizer<Funcionario>() {

        @Override
        public Funcionario getRandomValue() {

            return gerarFuncionario();
        }

    };

    static Randomizer<Contato> contatoRandomizer = new Randomizer<Contato>() {

        @Override
        public Contato getRandomValue() {

            return gerarContato();
        }

    };

    static Randomizer<Endereco> enderecoRandomizer = new Randomizer<Endereco>() {

        @Override
        public Endereco getRandomValue() {

            return gerarEndereco();
        }

    };

    @Override
    public Empresa getRandomValue() {

        return gerarEmpresa();
    }
}
