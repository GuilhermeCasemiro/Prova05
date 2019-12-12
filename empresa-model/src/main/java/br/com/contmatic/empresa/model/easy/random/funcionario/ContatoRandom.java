package br.com.contmatic.empresa.model.easy.random.funcionario;

import static java.nio.charset.Charset.forName;

import org.jeasy.random.EasyRandom;
import org.jeasy.random.EasyRandomParameters;
import org.jeasy.random.api.Randomizer;

import br.com.contmatic.empresa.model.Contato;

public class ContatoRandom implements Randomizer<Contato> {

    public static Contato gerarContato() {
        EasyRandomParameters parametroContato = new EasyRandomParameters();

        parametroContato.charset(forName("UTF-8"));
        parametroContato.ignoreRandomizationErrors(true);
        parametroContato.overrideDefaultInitialization(false);

        EasyRandom easyRandom = new EasyRandom(parametroContato);
        Contato contato = easyRandom.nextObject(Contato.class);
        return contato;
    }

    @Override
    public Contato getRandomValue() {

        return gerarContato();
    }
}
