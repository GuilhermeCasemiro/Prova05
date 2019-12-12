package br.com.contmatic.empresa.model.easy.random.endereco;

import static org.jeasy.random.FieldPredicates.inClass;
import static org.jeasy.random.FieldPredicates.named;
import static org.jeasy.random.FieldPredicates.ofType;

import org.jeasy.random.EasyRandom;
import org.jeasy.random.EasyRandomParameters;
import org.jeasy.random.api.Randomizer;
import org.jeasy.random.randomizers.range.IntegerRangeRandomizer;

import br.com.contmatic.empresa.model.Endereco;

public class EnderecoRandom implements Randomizer<Endereco> {

    public static Endereco gerarEndereco() {
        EasyRandomParameters parametroEndereco = new EasyRandomParameters();

        parametroEndereco.ignoreRandomizationErrors(true);
        parametroEndereco.overrideDefaultInitialization(false);
        parametroEndereco.randomize(named("numeroResidencia"),new IntegerRangeRandomizer(1, 1500));
        parametroEndereco.randomize(named("bairro").and(ofType(String.class).and(inClass(Endereco.class))), new BairroRandom());
        parametroEndereco.randomize(named("cep").and(ofType(String.class).and(inClass(Endereco.class))), new CepRandom());

        EasyRandom easyRandom = new EasyRandom(parametroEndereco);
        Endereco endereco = easyRandom.nextObject(Endereco.class);
        return endereco;
    }

    @Override
    public Endereco getRandomValue() {
        return gerarEndereco();
    }
}
