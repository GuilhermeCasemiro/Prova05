package br.com.contmatic.empresa.model.easy.random.cidade;

import org.jeasy.random.EasyRandom;
import org.jeasy.random.EasyRandomParameters;
import org.jeasy.random.FieldPredicates;
import org.jeasy.random.api.Randomizer;
import org.jeasy.random.randomizers.CityRandomizer;
import org.jeasy.random.randomizers.range.IntegerRangeRandomizer;

import br.com.contmatic.empresa.model.Cidade;

public class CidadeRandom implements Randomizer<Cidade> {

    public static Cidade gerarCidade() {
        EasyRandomParameters parametroCidade = new EasyRandomParameters();
        parametroCidade.ignoreRandomizationErrors(true);
        parametroCidade.randomize(FieldPredicates.named("nomeCidade"), new CityRandomizer());
        parametroCidade.randomize(FieldPredicates.named("codigoCidade"), new IntegerRangeRandomizer(1, 100));
        EasyRandom easyRandom = new EasyRandom(parametroCidade);

        return easyRandom.nextObject(Cidade.class);
    }

    @Override
    public Cidade getRandomValue() {
        return gerarCidade();
    }
}
