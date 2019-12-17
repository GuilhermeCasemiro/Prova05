package br.com.contmatic.empresa.model.easy.random.estado;

import static java.nio.charset.StandardCharsets.UTF_8;
import static org.jeasy.random.FieldPredicates.named;

import org.jeasy.random.EasyRandom;
import org.jeasy.random.EasyRandomParameters;
import org.jeasy.random.api.Randomizer;
import org.jeasy.random.randomizers.range.IntegerRangeRandomizer;

import br.com.contmatic.empresa.model.Estado;

public class EstadoRandom implements Randomizer<Estado> {

    public static Estado gerarEstado() {
        EasyRandomParameters parametroEstado = new EasyRandomParameters();

        parametroEstado.charset(UTF_8);
        parametroEstado.randomizationDepth(1);
        parametroEstado.randomize(named("codigoEstado"), new IntegerRangeRandomizer(1, 100));
        parametroEstado.randomize(named("nomeEstado"), new NomesEstadosRandom());
        parametroEstado.ignoreRandomizationErrors(true);
        parametroEstado.overrideDefaultInitialization(false);

        EasyRandom easyRandom = new EasyRandom(parametroEstado);

        return easyRandom.nextObject(Estado.class);
    }

    @Override
    public Estado getRandomValue() {

        return gerarEstado();
    }

}
