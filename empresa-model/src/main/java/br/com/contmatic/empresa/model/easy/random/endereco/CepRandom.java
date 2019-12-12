package br.com.contmatic.empresa.model.easy.random.endereco;

import static org.apache.commons.lang3.RandomStringUtils.random;

import org.jeasy.random.api.Randomizer;

public class CepRandom implements Randomizer<String>{

    public String getRandomValue() {
        
        return random(9, false, true);
    }

}
