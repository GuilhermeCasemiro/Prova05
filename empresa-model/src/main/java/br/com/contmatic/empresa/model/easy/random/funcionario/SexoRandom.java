package br.com.contmatic.empresa.model.easy.random.funcionario;

import static java.util.Arrays.asList;

import java.util.List;
import java.util.Random;

import org.jeasy.random.api.Randomizer;

public class SexoRandom implements Randomizer<String> {
    List<String> sexos = asList("Masculino", "Feminino");

    public String getRandomValue() {

        return sexos.get(new Random().nextInt(sexos.size()));
    }

}
