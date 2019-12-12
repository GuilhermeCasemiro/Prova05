package br.com.contmatic.empresa.model.easy.random.estado;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import org.jeasy.random.api.Randomizer;

public class NomesEstadosRandom implements Randomizer<String> {

    public String getRandomValue() {
        List<String> estados = Arrays.asList("Acre", "Alagoas", "Amazonas", "Amapá", "Bahia", "Ceará", "Distrito Federal", "Espírito Santo", "Goiás", "Maranhão", "Minas Gerais", "Mato Grosso do Sul",
            "Mato Grosso", "Pará", "Paraíba", "Pernambuco", "Piauí", "Paraná", "Rio de Janeiro", "Rio Grande do Norte", "Roraima", "Rio Grande do Sul", "Santa Catarina", "Sergipe", "São Paulo",
            "Tocantins");

        return estados.get(new Random().nextInt(estados.size()));
    }

}
