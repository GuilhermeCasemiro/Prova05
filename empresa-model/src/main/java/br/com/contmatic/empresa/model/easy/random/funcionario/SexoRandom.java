package br.com.contmatic.empresa.model.easy.random.funcionario;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import org.jeasy.random.api.Randomizer;

public class SexoRandom implements Randomizer<String> {
    List<String> sexos = Arrays.asList("Masculino", "Feminino");

    public String getRandomValue() {

        return sexos.get(new Random().nextInt(sexos.size()));
    }

}
