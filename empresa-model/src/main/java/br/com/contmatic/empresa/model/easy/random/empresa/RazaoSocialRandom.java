package br.com.contmatic.empresa.model.easy.random.empresa;

import java.util.Random;

import org.apache.commons.lang3.RandomStringUtils;
import org.jeasy.random.api.Randomizer;

public class RazaoSocialRandom implements Randomizer<String> {

    public String getRandomValue() {

        return RandomStringUtils.random(new Random().nextInt(10) + 30, true, false);
    }

}
