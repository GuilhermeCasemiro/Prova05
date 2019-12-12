package br.com.contmatic.empresa.model.easy.random.funcionario;

import static org.apache.commons.lang3.RandomStringUtils.random;

import org.jeasy.random.api.Randomizer;

public class CPFRandom implements Randomizer<String> {

    public String getRandomValue() {

        return random(11, false, true);
    }
}
