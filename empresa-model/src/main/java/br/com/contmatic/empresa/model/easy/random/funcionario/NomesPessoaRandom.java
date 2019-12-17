package br.com.contmatic.empresa.model.easy.random.funcionario;

import static java.util.Arrays.asList;

import java.util.List;
import java.util.Random;

import org.jeasy.random.api.Randomizer;

public class NomesPessoaRandom implements Randomizer<String> {
    List<String> nomes = asList("Alice ", "Miguel", "Sophia", "Arthur", "Helena", " Bernardo,", "Valentina", " Heitor,", "Laura", "Davi", "Isabella", "Lorenzo", "Manuela", "Théo", "Júlia",
        "Pedro", "Heloísa", "Gabriel", "Luiza", "Enzo", "Maria Luiza", "Matheus", "Lorena", "Lucas", "Lívia ", "Benjamin", "Giovanna", "Nicolas", "Maria Eduarda", "Guilherme", "Beatriz", "Rafael",
        "Maria Clara", "Joaquim", "Cecília", "Samuel", "Eloá", "Enzo Gabriel", "Lara", "João Miguel", "Maria", "Júlia Henrique", "Isadora", "Gustavo", "Mariana", "Murilo", "Emanuelly",
        "Pedro Henrique", "Ana Júlia", "Pietro", "Ana Luiza", "Lucca", "Ana Clara", "Felipe", "Melissa", "João Pedro", "Yasmin", "Isaac", "Maria Alice", "Benício", "Isabelly", "Daniel", "Lavínia",
        "Anthony", "Esther", "Leonardo", "Sarah", "Davi Lucca", "Elisa", "Bryan", "Antonella", "Eduardo", "Rafaela", "João Lucas", "Maria Cecília", "Victor", "Liz", "João", "Marina", "Cauã", "Nicole",
        "Antônio", "Maitê", "Vicente", "Isis", " Caleb", "Alícia", "Gael", "Luna", "Bento", "Rebeca", "Caio", "Agatha", "Emanuel", "Letícia", "Vinícius", "Maria", "João Guilherme", "Gabriela",
        "Davi Lucas", "Ana Laura", "Noah", "Catarina", "João Gabriel", "Clara", "João Victor", "Ana Beatriz", "Luiz Miguel", "Vitória", "Francisco", "Olívia", "Kaique", "Maria Fernanda", "Otávio",
        "Emilly", "Augusto", "Maria Valentina", "Levi", "Milena", "Yuri", "Maria Helena", "Enrico,", "Bianca", "Thiago", "Larissa", "Ian", "Mirella", "Victor Hugo", "Maria Flor", "Thomas", "Allana",
        "Henry", "Ana Sophia", "Luiz Felipe", "Clarice", "Ryan", "Pietra", "Arthur Miguel", "Maria Vitória", "Davi Luiz", "Maya", "Nathan", "Laís", "Pedro Lucas", "Ayla", "Davi Miguel", "Ana Lívia",
        "Raul", "Eduarda", "Pedro Miguel", "Mariah", "Luiz Henrique", "Stella", "Luan", "Ana", "Erick", "Gabrielly", "Martin", "Sophie", "Bruno", "Carolina", "Rodrigo", "Maria Laura", "Luiz Gustavo",
        "Maria Heloísa", "Arthur Gabriel", "Maria Sophia", "Breno", "Fernanda ", "Kauê", "Malu", "Enzo Miguel", "Analu", "Fernando", "Amanda", "Arthur Henrique", "Aurora", "Luiz Otávio", "Maria Isis",
        "Carlos Eduardo", "Louise", "Tomás", "Heloise", "Lucas Gabriel", "Ana Vitória", "André", "Ana Cecília, José", "Ana Liz", "Yago", "Joana ", "Danilo", "Luana ", "Anthony Gabriel", "Antônia ",
        "Ruan,", "Isabel  ", "Miguel Henrique,", "Bruna   ", "Oliver");

    public String getRandomValue() {

        return nomes.get(new Random().nextInt(nomes.size()));
    }

}
