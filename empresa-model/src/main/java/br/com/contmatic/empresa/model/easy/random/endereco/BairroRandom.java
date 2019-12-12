package br.com.contmatic.empresa.model.easy.random.endereco;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import org.jeasy.random.api.Randomizer;

public class BairroRandom implements Randomizer<String> {

    List<String> bairros = Arrays.asList("Água Rasa‎", "Alto de Pinheiros‎", "Anhanguera‎", "Aricanduva‎", "Artur Alvim‎", "Barra Funda‎", "Bela Vista‎", "Belém‎", "Bom Retiro‎", "Brasilândia‎",
        "Butantã‎", "Cachoeirinha‎", "Cambuci‎", "Campo Belo‎", "Campo Grande", "Campo Limpo‎", "Cangaíba‎", "Capão Redondo‎", "Carrão‎", "Casa Verde‎", "Cidade Ademar‎", "Cidade Dutra‎",
        "Cidade Líder‎", "Cidade Tiradentes‎", "Consolação‎", "Cursino‎", "Ermelino Matarazzo‎", "Freguesia do Ó‎", "Grajaú‎", "Guaianases‎", "Iguatemi‎", "Ipiranga‎", "Itaim Bibi‎",
        "Itaim Paulista‎", "Itaquera‎", "Jabaquara‎", "Jaçanã‎", "Jaguara‎", "Jaguaré", "Jaraguá‎", "Jardim Ângela‎", "Jardim Helena‎", "Jardim Paulista‎", "Jardim São Luís‎", "Lapa‎", "Liberdade‎",
        "Limão‎", "Mandaqui‎", "Marsilac‎", "Moema‎", "Mooca‎", "Morumbi‎", "Parelheiros‎", "Pari‎", "Parque do Carmo‎", "Penha‎", "Perdizes‎", "Pinheiros‎", "Ponte Rasa‎", "Raposo Tavares‎",
        "República‎", "Rio Pequeno‎", "Sacomã‎", "Santa Cecília", "Santana‎", "Santo Amaro‎", "São Domingos‎", "São Lucas‎", "São Mateus", "São Miguel Paulista‎", "São Rafael‎", "Sapopemba‎",
        "Saúde‎", "Sé‎", "Tatuapé‎", "Tremembé‎", "Tucuruvi", "Vila Andrade‎", "Vila Curuçá‎", "Vila Formosa‎", "Vila Guilherme‎", "Vila Jacuí‎", "Vila Leopoldina‎", "Vila Maria‎", "Vila Mariana‎",
        "Vila Matilde‎", "Vila Medeiros‎", "Vila Prudente‎", "Vila Sônia‎");

    public String getRandomValue() {

        return bairros.get(new Random().nextInt(bairros.size()));
    }

}
