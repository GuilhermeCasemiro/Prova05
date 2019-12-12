package br.com.contmatic.empresa.model.easy.random.funcionario;

import static br.com.contmatic.empresa.model.easy.random.endereco.EnderecoRandom.gerarEndereco;
import static br.com.contmatic.empresa.model.easy.random.funcionario.ContatoRandom.gerarContato;
import static org.jeasy.random.FieldPredicates.inClass;
import static org.jeasy.random.FieldPredicates.named;
import static org.jeasy.random.FieldPredicates.ofType;

import java.util.Set;

import org.jeasy.random.EasyRandom;
import org.jeasy.random.EasyRandomParameters;
import org.jeasy.random.api.Randomizer;
import org.jeasy.random.randomizers.EmailRandomizer;
import org.jeasy.random.randomizers.FirstNameRandomizer;
import org.jeasy.random.randomizers.collection.SetRandomizer;
import org.jeasy.random.randomizers.range.BigDecimalRangeRandomizer;
import org.joda.time.DateTime;

import br.com.contmatic.empresa.model.Contato;
import br.com.contmatic.empresa.model.Endereco;
import br.com.contmatic.empresa.model.Funcionario;

public class FuncionarioRandom implements Randomizer<Funcionario> {

    public static Funcionario gerarFuncionario() {
        EasyRandomParameters parametroFuncionario = new EasyRandomParameters();
        
        parametroFuncionario.ignoreRandomizationErrors(true);
        parametroFuncionario.overrideDefaultInitialization(false);
        parametroFuncionario.randomizationDepth(10);
        parametroFuncionario.randomize(named("nome").and(ofType(String.class).and(inClass(Funcionario.class))), new FirstNameRandomizer());
        parametroFuncionario.randomize(named("email").and(ofType(String.class).and(inClass(Funcionario.class))), new EmailRandomizer());
        parametroFuncionario.randomize(named("cpf").and(ofType(String.class).and(inClass(Funcionario.class))), new CPFRandom());
        parametroFuncionario.randomize(named("sexo").and(ofType(String.class).and(inClass(Funcionario.class))), new SexoRandom());
        parametroFuncionario.randomize(named("salario"), new BigDecimalRangeRandomizer(1000.00, 8500.00));
        parametroFuncionario.randomize(named("comissao"), new BigDecimalRangeRandomizer(0.00, 500.00));
        parametroFuncionario.randomize(named("departamento").and(ofType(String.class).and(inClass(Funcionario.class))), new DepartamentoRandom());
        parametroFuncionario.randomize(named("contatos").and(ofType(Set.class).and(inClass(Funcionario.class))), new SetRandomizer<Contato>(contatoRandomizer, 2));
        parametroFuncionario.randomize(named("endereco").and(ofType(Set.class).and(inClass(Funcionario.class))), new SetRandomizer<Endereco>(enderecoRandomizer, 2));
        parametroFuncionario.randomize(named("dataNascimento").and(ofType(DateTime.class).and(inClass(Funcionario.class))), new DateTimeRandom());

        EasyRandom easyRandom = new EasyRandom(parametroFuncionario);

        return easyRandom.nextObject(Funcionario.class);
    }

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
    public Funcionario getRandomValue() {

        return gerarFuncionario();
    }
}
