package br.com.contmatic.empresa.model.easy.random.funcionario;

import static java.nio.charset.StandardCharsets.UTF_8;

import org.jeasy.random.EasyRandom;
import org.jeasy.random.EasyRandomParameters;
import org.jeasy.random.api.Randomizer;

import br.com.contmatic.empresa.model.Contato;

public class ContatoRandom implements Randomizer<Contato> {

    public static Contato gerarContato() {
        EasyRandomParameters parametroContato = new EasyRandomParameters();

        parametroContato.charset(UTF_8);
        parametroContato.ignoreRandomizationErrors(true);
        parametroContato.overrideDefaultInitialization(false);

        EasyRandom easyRandom = new EasyRandom(parametroContato);
        
        return easyRandom.nextObject(Contato.class);
    }

    @Override
    public Contato getRandomValue() {

        return gerarContato();
    }
}
