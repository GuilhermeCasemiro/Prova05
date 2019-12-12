package br.com.contmatic.empresa.model.easy.random.estado;

import static java.nio.charset.Charset.forName;

import org.jeasy.random.EasyRandom;
import org.jeasy.random.EasyRandomParameters;
import org.jeasy.random.FieldPredicates;
import org.jeasy.random.api.Randomizer;
import org.jeasy.random.randomizers.range.IntegerRangeRandomizer;

import br.com.contmatic.empresa.model.Estado;

public class EstadoRandom implements Randomizer<Estado>{

    public static Estado gerarEstado() {
        EasyRandomParameters parametroEstado = new EasyRandomParameters();

        parametroEstado.charset(forName("UTF-8"));
        parametroEstado.randomizationDepth(1);
        parametroEstado.randomize(FieldPredicates.named("codigoEstado"), new IntegerRangeRandomizer(1, 100));
        parametroEstado.randomize(FieldPredicates.named("nomeEstado"), new NomesEstadosRandom());
        parametroEstado.ignoreRandomizationErrors(true);
        parametroEstado.overrideDefaultInitialization(false);

        EasyRandom easyRandom = new EasyRandom(parametroEstado);
        Estado estado = easyRandom.nextObject(Estado.class);
        return estado;
    }

    @Override
    public Estado getRandomValue() {
        
        return gerarEstado();
    }

}
