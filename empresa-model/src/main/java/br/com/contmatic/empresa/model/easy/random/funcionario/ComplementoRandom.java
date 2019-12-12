package br.com.contmatic.empresa.model.easy.random.funcionario;

import java.util.Random;

import org.apache.commons.lang3.RandomStringUtils;
import org.jeasy.random.api.Randomizer;

public class ComplementoRandom implements Randomizer<String>{

    public String getRandomValue() {
        
        return RandomStringUtils.random(new Random().nextInt(1)+30, true, true);
    }
    
}
