package br.com.contmatic.empresa.model.easy.random.funcionario;

import static java.util.Arrays.asList;

import java.util.List;
import java.util.Random;

import org.jeasy.random.api.Randomizer;

public class DepartamentoRandom implements Randomizer<String> {
    List<String> departamentos = asList("Desenvolvimento", "Consultoria", "Marketing", "Recursos Humanos", "Diretoria", "QA", "Legal");

    public String getRandomValue() {

        return departamentos.get(new Random().nextInt(departamentos.size()));
    }
}
