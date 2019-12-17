package br.com.contmatic.empresa.model.easy.random.cidade;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import org.jeasy.random.api.Randomizer;

public class NomesCidadesRandom implements Randomizer<String> {

    private List<String> cidades = Arrays.asList("Afonso Cláudio", "Água Doce do Norte", "Abadia de Goiás", "Abadia dos Dourados", "Abadiânia", "Abaeté", "Abaetetuba", "Abaiara", "Abaíra", "Abaré",
        "Abatiá", "Abdon Batista", "Abel Figueiredo", "Abelardo Luz", "Abre Campo", "Abreu e Lima", "Abreulândia", "Abu Dhabi", "Acaiaca", "Açailândia", "Acajutiba", "Acará", "Acarape", "Acaraú",
        "Acari", "Acauã", "Aceguá", "Acopiara", "Acorizal", "Acra", "Acrelândia", "Acreúna", "Açucena", "Adamantina", "Adelândia", "Adolfo", "Adrianópolis", "Adustina", "Afogados da Ingazeira",
        "Afonso Bezerra", "Afonso Cláudio", "Afonso Cunha", "Afrânio", "Afuá", "Agrestina", "Agricolândia", "Agrolândia", "Agronômica", "Agrovila São Sebastião Do Caburi", "Água Azul do Norte",
        "Água Boa", "Água Boa", "Água Clara", "Água Comprida", "Água Da Prata", "Água Doce", "Água Doce do Maranhão", "Água Doce do Norte", "Água Fria", "Água Fria de Goiás", "Água Limpa",
        "Água Nova", "Água Preta", "Água Santa", "Aguaí", "Aguanil", "Aguapés", "Águas Belas", "Águas da Prata", "Águas de Chapecó", "Águas de Lindóia", "Águas de Santa Bárbara", "Águas de São Pedro",
        "Águas Formosas", "Águas Frias", "Águas Lindas de Goiás", "Águas Mornas", "Águas Vermelhas", "Agudo", "Agudos", "Agudos do Sul", "Águia Branca", "Aguiar", "Aguiarnópolis", "Aimorés",
        "Aiquara", "Aiuaba", "Aiuruoca", "Ajuricaba", "Alagoa", "Alagoa Grande", "Alagoa Nova", "Alagoinha", "Alagoinha", "Alagoinha do Piauí", "Alagoinhas", "Alambari", "Albertina", "Alcântara",
        "Alcântaras", "Alcantil", "Alcinópolis", "Alcobaça", "Aldeias Altas", "Alecrim", "Alegre", "Alegrete", "Alegrete do Piauí", "Alegria", "Além Paraíba", "Alenquer", "Alexandria", "Alexânia",
        "Alfenas", "Alfredo Chaves", "Alfredo Marcondes", "Alfredo Vasconcelos", "Alfredo Wagner", "Algodão de Jandaíra", "Alhandra", "Aliança", "Aliança do Tocantins", "Almadina", "Almas",
        "Almeirim", "Almenara", "Almino Afonso", "Almirante Tamandaré", "Almirante Tamandaré do Sul", "Aloândia", "Alpercata", "Alpestre", "Alpinópolis", "Alta Alegre dos Parecis", "Alta Floresta",
        "Alta Floresta do Oeste", "Altair", "Altamira", "Altamira do Maranhão", "Altamira do Paraná", "Altaneira", "Alterosa", "Altinho", "Altinópolis", "Alto Alegre", "Alto Alegre do Maranhão",
        "Alto Alegre do Pindaré", "Alto Araguaia", "Alto Bela Vista", "Alto Boa Vista", "Alto Caparaó", "Alto do Rodrigues", "Alto Feliz", "Alto Garças", "Alto Horizonte", "Alto Jequitibá",
        "Alto Longá", "Alto Paraguai", "Alto Paraíso", "Alto Paraíso", "Alto Paraíso de Goiás", "Alto Paraná", "Alto Parnaíba", "Alto Piquiri", "Alto Rio Doce", "Alto Rio Novo", "Alto Santo",
        "Alto Taquari", "Altônia", "Altos", "Alumínio", "Alvarães", "Alvarenga", "Álvares Florence", "Álvares Machado", "Álvaro de Carvalho", "Alverne", "Alvinlândia", "Alvinópolis", "Alvorada",
        "Alvorada de Minas", "Alvorada do Gurguéia", "Alvorada do Norte", "Alvorada do Oeste", "Alvorada do Sul", "Amã", "Amajarí", "Amambai", "Amapá", "Amapá do Maranhão", "Amapari", "Amaporã",
        "Amaraji", "Amaral Ferrador", "Amaralina", "Amarante", "Amarante do Maranhão", "Amargosa", "Amaturá", "Amélia Rodrigues", "América Dourada", "Americana", "Americano do Brasil",
        "Américo Brasiliense", "Américo de Campos", "Ametista do Sul", "Amontada", "Amorinópolis", "Amparo", "Amparo", "Amparo da Serra", "Amparo de São Francisco", "Ampére", "Amsterdã", "Anadia",
        "Anagé", "Anahy", "Anajás", "Anajatuba", "Analândia", "Anamã", "Ananás", "Ananindeua", "Anápolis", "Anapu", "Anapurus", "Anastácio", "Anaurilândia", "Ancara", "Anchieta", "Anchieta",
        "Andaraí", "Andirá", "Andorinha", "Andradas", "Andradina", "André da Rocha", "Andrelândia", "Angatuba", "Angelândia", "Angélica", "Angelim", "Angelina", "Angical", "Angical do Piauí",
        "Angico", "Angicos", "Angra dos Reis", "Anguera", "Ângulo", "Anhanguera", "Anhembi", "Anhumas", "Anicuns", "Anil", "Anísio de Abreu", "Anita Garibaldi", "Anitápolis", "Anori", "Anta Gorda",
        "Antas", "Antonina", "Antonina do Norte", "Antônio Almeida", "Antônio Cardoso", "Antônio Carlos", "Antônio Carlos", "Antônio Dias", "Antônio Gonçalves", "Antônio João", "Antônio Martins",
        "Antônio Olinto", "Antônio Prado", "Antônio Prado de Minas", "Aparecida", "Aparecida", "Aparecida D'Oeste", "Aparecida de Goiânia", "Aparecida do Rio Doce", "Aparecida do Rio Negro",
        "Aparecida do Taboado", "Aperibé", "Apiacá", "Apiacás", "Apiaí", "Apicum-Açu", "Apiúna", "Apodi", "Aporá", "Aporé", "Apuarema", "Apucarana", "Apuí", "Apuiarés", "Aquidabã", "Aquidauana",
        "Aquiraz", "Arabá", "Arabutã", "Araçagi", "Araçaí", "Aracaju", "Araçariguama", "Araçás", "Aracati", "Aracatu", "Araçatuba", "Araci", "Aracitaba", "Aracoiaba", "Araçoiaba",
        "Araçoiaba da Serra", "Aracruz", "Araçu", "Araçuaí", "Aragarças", "Aragoiânia", "Aragominas", "Araguacema", "Araguaçu", "Araguaiana", "Araguaína", "Araguainha", "Araguanã", "Araguanã",
        "Araguapaz", "Araguari", "Araguatins", "Araióses", "Aral Moreira", "Aramari", "Arambaré", "Arame", "Aramina", "Arandu", "Arantina", "Arantina", "Arapeí", "Arapiraca", "Arapoema", "Araponga",
        "Arapongas", "Araporã", "Arapoti", "Arapuá", "Arapuã", "Araputanga", "Araquari", "Arara", "Araranguá", "Araraquara", "Araras", "Araras", "Ararendá", "Arari", "Araricá", "Araripe", "Araripina",
        "Araruama", "Araruna", "Araruna", "Arataca", "Aratiba", "Aratuba", "Aratuípe", "Arauá", "Araucária", "Araújos", "Araxá", "Arceburgo", "Arco-Íris", "Arcos", "Arcoverde", "Areado", "Areal",
        "Arealva", "Areia", "Areia Branca", "Areia Branca", "Areia de Baraúnas", "Areial", "Areias", "Areias", "Areiópolis", "Arenápolis", "Arenópolis", "Arez", "Argirita", "Aricanduva", "Arinos",
        "Aripuanã", "Ariquemes", "Ariranha", "Ariranha do Ivaí", "Armação dos Búzios", "Armazém", "Arneiroz", "Aroazes", "Aroeiras", "Aroeiras Do Itaim", "Arraial", "Arraial do Cabo", "Arraias",
        "Arroio do Meio", "Arroio do Padre", "Arroio do Sal", "Arroio do Tigre", "Arroio dos Ratos", "Arroio Grande", "Arroio Trinta", "Artur Nogueira", "Aruanã", "Arujá", "Arvoredo", "Arvorezinha",
        "Ascurra", "Aspásia", "Assaí", "Assaré", "Assis", "Assis", "Assis Brasil", "Assis Chateaubriand", "Assis Chateaubriand", "Assu", "Assunção", "Assunção", "Assunção do Piauí", "Astana",
        "Astolfo Dutra", "Astorga", "Atalaia", "Atalaia", "Atalaia do Norte", "Atalanta", "Ataléia", "Atapus", "Atenas", "Atibaia", "Atílio Vivácqua", "Atlanta", "Augustinópolis", "Augusto Corrêa",
        "Augusto de Lima", "Augusto Pestana", "Augusto Severo", "Áurea", "Aurelino Leal", "Auriflama", "Aurilândia", "Aurora", "Aurora", "Aurora do Pará", "Aurora do Tocantins", "Austin", "Autazes",
        "Avaí", "Avanhandava", "Avaré", "Aveiro", "Avelino Lopes", "Avelinópolis", "Axixá", "Axixá do Tocantins", "B", "Babaçulândia", "Bacabal", "Bacabeira", "Bacuri", "Bacurituba", "Bady Bassitt",
        "Baependi", "Bagdá", "Bagé", "Bagre", "Baía da Traição", "Baía Formosa", "Baianópolis", "Baião", "Baixa Grande", "Baixa Grande", "Baixa Grande do Ribeiro", "Baixa Quente", "Baixio",
        "Baixio Das Palmeiras", "Baixo Guandu", "Baku", "Balbinos", "Baldim", "Baliza", "Balneário Arroio do Silva", "Balneário Barra do Sul", "Balneário Camboriú", "Balneário Gaivota",
        "Balneário Piçarras", "Balneário Pinhal", "Balneário Rincão", "Balsa Nova", "Bálsamo", "Balsas", "Bambuí", "Banabuiú", "Bananal", "Bananas", "Bananeiras", "Bandeira", "Bandeira do Sul",
        "Bandeirante", "Bandeirantes", "Bandeirantes", "Bandeirantes do Tocantins", "Bangcoc", "Bannach", "Banzaê", "Barão", "Barão de Antonina", "Barão de Cocais", "Barão de Cotegipe",
        "Barão de Grajaú", "Barão de Melgaço", "Barão de Monte Alto", "Barão do Triunfo", "Baraúna", "Baraúna", "Barbacena", "Barbada", "Barbalha", "Barbosa", "Barbosa Ferraz", "Barcarena",
        "Barcelona", "Barcelona", "Barcelos", "Bariri", "Barra", "Barra Avenida", "Barra Bonita", "Barra Bonita", "Barra D'Alcântara", "Barra da Estiva", "Barra de Guabiraba", "Barra de Santa Rosa",
        "Barra de Santana", "Barra de Santo Antônio", "Barra de São Francisco", "Barra de São Miguel", "Barra de São Miguel", "Barra do Bugres", "Barra do Chapéu", "Barra do Choça", "Barra do Corda",
        "Barra do Garças", "Barra do Guarita", "Barra do Jacaré", "Barra do Mendes", "Barra do Ouro", "Barra do Piraí", "Barra do Quaraí", "Barra do Ribeiro", "Barra do Rio Azul", "Barra do Rocha",
        "Barra Do Sahy", "Barra do Turvo", "Barra dos Coqueiros", "Barra Funda", "Barra Longa", "Barra Mansa", "Barra Velha", "Barracão", "Barracão", "Barras", "Barreira", "Barreiras", "Barreiras",
        "Barreiras do Piauí", "Barreirinha", "Barreirinhas", "Barreiros", "Barreiros", "Barretos", "Barrinha", "Barro", "Barro Alto", "Barro Alto", "Barro Duro", "Barro Preto", "Barro Vermelho",
        "Barrocas", "Barrolândia", "Barroquinha", "Barros Cassal", "Barroso", "Barueri", "Bastos", "Bataguassu", "Batalha", "Batalha", "Batatais", "Batayporã", "Baturité", "Bauru", "Bayeux",
        "Bebedouro", "Beberibe", "Beirute", "Bela Cruz", "Bela Vista", "Bela Vista", "Bela Vista da Caroba", "Bela Vista de Goiás", "Bela Vista de Minas", "Bela Vista do Caroba",
        "Bela Vista do Maranhão", "Bela Vista do Paraíso", "Bela Vista do Piauí", "Bela Vista do Toldo", "Belagua", "Belém", "Belém de Maria", "Belém De Solimões", "Belém do Brejo do Cruz",
        "Belém do Piauí", "Belém do São Francisco", "Belford Roxo", "Belgrado", "Belmiro Braga", "Belmonte", "Belo Campo", "Belo Horizonte", "Belo Jardim", "Belo Monte", "Belo Monte", "Belo Oriente",
        "Belo Vale", "Belterra", "Beneditinos", "Benedito Leite", "Benedito Novo", "Benevides", "Benghazi", "Benjamin Constant", "Benjamin Constant do Sul", "Bento de Abreu", "Bento Fernandes",
        "Bento Gonçalves", "Bequimão", "Berilo", "Berizal", "Berlim", "Berna", "Bernardino Batista", "Bernardino de Campos", "Bernardo do Mearim", "Bernardo Sayão", "Bertioga", "Bertolínia",
        "Bertópolis", "Beruri", "Betânia", "Betânia do Piauí", "Betim", "Bezerros", "Bias Fortes", "Bicas", "Biguaçu", "Bilac", "Biquinhas", "Birigui", "Biritiba-Mirim", "Biritinga", "Bituruna",
        "Blumenau", "Boa Esperança", "Boa Esperança do Iguaçu", "Boa Esperança do Sul", "Boa Hora", "Boa Nova", "Boa Saúde", "Boa Ventura", "Boa Ventura de São Roque", "Boa Viagem", "Boa Vista",
        "Boa Vista", "Boa Vista da Aparecida", "Boa Vista das Missões", "Boa Vista De Pacarana", "Boa Vista do Buricá", "Boa Vista do Cadeado", "Boa Vista do Gurupi", "Boa Vista do Incra",
        "Boa Vista do Ramos", "Boa Vista do Sul", "Boa Vista do Tupim", "Boca da Mata", "Boca do Acre", "Bocaina", "Bocaina", "Bocaina de Minas", "Bocaína do Sul", "Bocaiúva", "Bocaiúva do Sul",
        "Bocaiuval", "Bodó", "Bodocó", "Bodoquena", "Bofete", "Bogotá", "Boituva", "Bom Conselho", "Bom Despacho", "Bom Futuro", "Bom Jardim", "Bom Jardim da Serra", "Bom Jardim de Goiás",
        "Bom Jardim de Minas", "Bom Jesus", "Bom Jesus", "Bom Jesus da Lapa", "Bom Jesus da Penha", "Bom Jesus da Serra", "Bom Jesus das Selvas", "Bom Jesus de Goiás", "Bom Jesus do Amparo",
        "Bom Jesus do Araguaia", "Bom Jesus do Galho", "Bom Jesus do Itabapoana", "Bom Jesus do Norte", "Bom Jesus do Oeste", "Bom Jesus Do Prata", "Bom Jesus do Sul", "Bom Jesus do Tocantins",
        "Bom Jesus do Tocantins", "Bom Jesus dos Perdões", "Bom Lugar", "Bom Princípio", "Bom Princípio", "Bom Princípio do Piauí", "Bom Progresso", "Bom Recreio", "Bom Repouso", "Bom Retiro",
        "Bom Retiro do Sul", "Bom Sucesso", "Bom Sucesso de Itararé", "Bom Sucesso do Sul", "Bombinhas", "Bonfim", "Bonfim", "Bonfim do Piauí", "Bonfinópolis", "Bonfinópolis de Minas", "Bonito",
        "Bonito de Minas", "Bonito de Santa Fé", "Bonópolis", "Bonsucesso", "Boqueirão do Leão", "Boqueirão do Piauí", "Boquim", "Boquira", "Borá", "Boracéia", "Borba", "Borborema", "Borborema",
        "Borda da Mata", "Borebi", "Borrazópolis", "Borussia", "Bossoroca", "Boston", "Botafogo", "Botelhos", "Botucatu", "Botumirim", "Botuporã", "Botuverá", "Bozano", "Braço do Norte",
        "Braço do Trombudo", "Braga", "Bragança", "Bragança Paulista", "Braganey", "Branquinha", "Brás Pires", "Brasil Novo", "Brasilândia", "Brasilândia de Minas", "Brasilândia do Sul",
        "Brasilândia do Tocantins", "Brasiléia", "Brasileira", "Brasília", "Brasília de Minas", "Brasnorte", "Brasópolis", "Braúna", "Braúnas", "Brazabrantes", "Brazlândia", "Brazópolis", "Brejão",
        "Brejetuba", "Brejinho", "Brejinho", "Brejinho de Nazaré", "Brejo", "Brejo Alegre", "Brejo da Madre de Deus", "Brejo de Areia", "Brejo do Cruz", "Brejo do Piauí", "Brejo dos Santos",
        "Brejo Grande", "Brejo Grande do Araguaia", "Brejo Santo", "Brejões", "Brejolândia", "Breu Branco", "Breves", "Britânia", "Brochier", "Brodowski", "Brotas", "Brotas de Macaúbas", "Brumadinho",
        "Brumado", "Brunópolis", "Brusque", "Bruxelas", "Bucareste", "Budapeste", "Bueno Brandão", "Buenópolis", "Buenos Aires", "Buenos Aires", "Buerarema", "Bugre", "Buíque", "Bujari", "Bujaru",
        "Buri", "Buritama", "Buriti", "Buriti Alegre", "Buriti Bravo", "Buriti de Goiás", "Buriti do Tocantins", "Buriti dos Lopes", "Buriti dos Montes", "Buriticupu", "Buritinópolis", "Buritirama",
        "Buritirama", "Buritirana", "Buritis", "Buritis", "Buritizal", "Buritizeiro", "Butiá", "C", "Caapiranga", "Caaporã", "Caarapó", "Caatiba", "Cabaceiras", "Cabaceiras do Paraguaçu",
        "Cabeceira Do Jibóia", "Cabeceira Grande", "Cabeceiras", "Cabeceiras do Piauí", "Cabedelo", "Cabixi", "Cabo de Santo Agostinho", "Cabo Frio", "Cabo Verde", "Cabôto", "Cabrália Paulista",
        "Cabreúva", "Cabrobó", "Cabul", "Caçador", "Caçapava", "Caçapava do Sul", "Cacau Pirêra", "Cacaulândia", "Cacequi", "Cáceres", "Cachoeira", "Cachoeira", "Cachoeira Alta", "Cachoeira da Prata",
        "Cachoeira Da Serra", "Cachoeira de Goiás", "Cachoeira de Minas", "Cachoeira de Pajeú", "Cachoeira de Piriá", "Cachoeira do Arari", "Cachoeira Do Pinto", "Cachoeira do Sul",
        "Cachoeira dos Índios", "Cachoeira Dourada", "Cachoeira Dourada", "Cachoeira Grande", "Cachoeira Paulista", "Cachoeira Seca", "Cachoeiras de Macacu", "Cachoeirinha", "Cachoeiro de Itapemirim",
        "Cacimba de Areia", "Cacimba de Dentro", "Cacimbas", "Cacimbinhas", "Cacique Doble", "Cacoal", "Caconde", "Caçu", "Caculé", "Caém", "Caetanópolis", "Caetanos", "Caeté", "Caetés", "Caetité",
        "Cafarnaum", "Cafeara", "Cafelândia", "Cafelândia", "Cafemirim", "Cafezal do Sul", "Caiabu", "Caiana", "Caiapônia", "Caibaté", "Caibi", "Caiçara", "Caiçara", "Caiçara do Norte",
        "Caiçara do Rio do Vento", "Caicó", "Caieiras", "Cairo", "Cairu", "Caiuá", "Cajamar", "Cajapió", "Cajari", "Cajati", "Cajazeiras", "Cajazeiras", "Cajazeiras do Piauí", "Cajazeirinhas",
        "Cajobi", "Cajueiro", "Cajueiro da Praia", "Cajuri", "Cajuru", "Calçado", "Calçoene", "Caldas", "Caldas Brandão", "Caldas Novas", "Caldazinha", "Caldeirão", "Caldeirão Grande",
        "Caldeirão Grande do Piauí", "Califórnia", "Califórnia Da Barra", "Calmon", "Calumbi", "Camacan", "Camaçari", "Camacho", "Camalaú", "Camamu", "Camanducaia", "Camapuã", "Camaquã", "Camaragibe",
        "Camargo", "Cambará", "Cambará do Sul", "Cambé", "Cambira", "Camboriú", "Cambridge", "Cambuci", "Cambuí", "Cambuquira", "Cametá", "Camocim", "Camocim de São Félix", "Campanário", "Campanha",
        "Campestre", "Campestre", "Campestre da Serra", "Campestre de Goiás", "Campestre do Maranhão", "Campina da Lagoa", "Campina das Missões", "Campina do Monte Alegre", "Campina do Simão",
        "Campina Grande", "Campina Grande do Sul", "Campina Verde", "Campinaçu", "Campinápolis", "Campinas", "Campinas do Piauí", "Campinas do Sul", "Campinorte", "Campo Alegre",
        "Campo Alegre de Goiás", "Campo Alegre de Lourdes", "Campo Alegre do Fidalgo", "Campo Azul", "Campo Belo", "Campo Belo do Sul", "Campo Bom", "Campo Bonito", "Campo de Santana",
        "Campo do Brito", "Campo do Meio", "Campo do Tenente", "Campo Erê", "Campo Florido", "Campo Formoso", "Campo Grande", "Campo Grande do Piauí", "Campo Largo", "Campo Largo do Piauí",
        "Campo Limpo de Goiás", "Campo Limpo Paulista", "Campo Magro", "Campo Maior", "Campo Mourão", "Campo Novo", "Campo Novo de Rondônia", "Campo Novo do Parecis", "Campo Redondo", "Campo Verde",
        "Campos Altos", "Campos Belos", "Campos Borges", "Campos de Júlio", "Campos do Jordão", "Campos dos Goytacazes", "Campos Gerais", "Campos Lindos", "Campos Novos", "Campos Novos Paulista",
        "Campos Sales", "Campos Verdes", "Camutanga", "Cana Brava", "Cana Verde", "Canaã", "Canaã dos Carajás", "Canabrava do Norte", "Cananéia", "Canapi", "Canápolis", "Canápolis", "Canarana",
        "Canarana", "Canas", "Canavieira", "Canavieiras", "Cancún", "Candangolândia", "Candeal", "Candeia", "Candeias", "Candeias", "Candeias do Jamari", "Candelária", "Candiba", "Cândido de Abreu",
        "Cândido Godói", "Cândido Mendes", "Cândido Mota", "Cândido Rodrigues", "Cândido Sales", "Candiota", "Candói", "Canela", "Canelinha", "Canguaretama", "Canguçu", "Canhoba", "Canhotinho",
        "Canindé", "Canindé de São Francisco", "Canitar", "Canoas", "Canoinhas", "Cansanção", "Cantá", "Cantagalo", "Cantanhede", "Canto do Buriti", "Canudos", "Canudos do Vale", "Canutama",
        "Capanema", "Capanema", "Capão Alto", "Capão Bonito", "Capão Bonito do Sul", "Capão da Canoa", "Capão do Cipó", "Capão do Leão", "Caparaó", "Capela", "Capela", "Capela de Santana",
        "Capela do Alto", "Capela do Alto Alegre", "Capela Nova", "Capelinha", "Capetinga", "Capim", "Capim Branco", "Capim Grosso", "Capinópolis", "Capinzal", "Capinzal do Norte", "Capistrano",
        "Capitão", "Capitão Andrade", "Capitão de Campos", "Capitão Enéas", "Capitão Gervásio Oliveira", "Capitão Leônidas Marques", "Capitão Poço", "Capitólio", "Capivari", "Capivari de Baixo",
        "Capivari do Sul", "Capixaba", "Capoeiras", "Caputira", "Caraá", "Caracaraí", "Caracas", "Caracol", "Caraguatatuba", "Caraí", "Caraíbas", "Caraíbas", "Carambeí", "Caramuru", "Caranaíba",
        "Carandaí", "Carangola", "Carapebus", "Carapicuíba", "Caratinga", "Carauari", "Caraúba Torta", "Caraúbas", "Caraúbas", "Caraúbas do Piauí", "Caravelas", "Carazinho", "Carbonita",
        "Cardeal da Silva", "Cardoso", "Cardoso Moreira", "Careaçu", "Careiro", "Careiro da Várzea", "Careiro Parauá", "Cariacica", "Caridade", "Caridade do Piauí", "Carinhanha", "Carira", "Cariré",
        "Cariri do Tocantins", "Caririaçu", "Cariús", "Carlinda", "Carlópolis", "Carlos Barbosa", "Carlos Chagas", "Carlos Gomes", "Carmésia", "Carmo", "Carmo da Cachoeira", "Carmo da Mata",
        "Carmo de Minas", "Carmo do Cajuru", "Carmo do Paranaíba", "Carmo do Rio Claro", "Carmo do Rio Verde", "Carmolândia", "Carmópolis", "Carmópolis de Minas", "Carnaíba", "Carnaúba dos Dantas",
        "Carnaubais", "Carnaubal", "Carnaubeira da Penha", "Carne-De-Vaca", "Carneirinho", "Carneiros", "Caroalina", "Caroba", "Caroebe", "Carolina", "Carpina", "Carrancas", "Carrapateira",
        "Carrasco Bonito", "Caruaru", "Carutapera", "Carvalhópolis", "Carvalhos", "Casa Branca", "Casa Grande", "Casa Nova", "Casca", "Cascalho Rico", "Cascavel", "Cascavel", "Caseara", "Caseiros",
        "Casimiro de Abreu", "Casinhas", "Casserengue", "Cássia", "Cássia dos Coqueiros", "Cassilândia", "Castanhal", "Castanheira", "Castanheiras", "Castelândia", "Castelo", "Castelo - ES",
        "Castelo do Piauí", "Castilho", "Castro", "Castro Alves", "Cataguases", "Catalão", "Catanduva", "Catanduvas", "Catanduvas", "Catarina", "Catas Altas", "Catas Altas da Noruega", "Catende",
        "Catiguá", "Catimbau", "Catingueira", "Catolândia", "Catolé Da Pista", "Catolé do Rocha", "Catu", "Catuípe", "Catuji", "Catunda", "Caturaí", "Caturama", "Caturité", "Catuti", "Caucaia",
        "Cavalcante", "Cavalo Ruço De Deus", "Caviana", "Caxambu", "Caxambu do Sul", "Caxias", "Caxias do Sul", "Caxingó", "Ceará-Mirim", "Cedral", "Cedro", "Cedro de São João", "Cedro do Abaeté",
        "Ceilândia", "Celso Ramos", "Centenário", "Centenário", "Centenário do Sul", "Central", "Central de Minas", "Central do Maranhão", "Centralina", "Centro do Guilherme",
        "Centro Novo do Maranhão", "Cercadinho", "Cerejeiras", "Ceres", "Cerqueira César", "Cerquilho", "Cerrito", "Cerro Azul", "Cerro Branco", "Cerro Corá", "Cerro Grande", "Cerro Grande do Sul",
        "Cerro Largo", "Cerro Negro", "Cesário Lange", "Céu Azul", "Cezarina", "Chã de Alegria", "Chã De Cruz", "Chã Grande", "Chã Preta", "Chácara", "Chalé", "Chapada", "Chapada da Areia",
        "Chapada da Natividade", "Chapada do Norte", "Chapada dos Guimarães", "Chapada Gaúcha", "Chapadão do Céu", "Chapadão do Lageado", "Chapadão do Sul", "Chapadinha", "Chapecó", "Chapéu D'Uvas",
        "Charco", "Charqueada", "Charqueadas", "Charrua", "Chattanooga", "Chaval", "Chavantes", "Chaves", "Chaves", "Chiador", "Chiapeta", "Chicago", "Chopinzinho", "Choró", "Chorozinho", "Chorrochó",
        "Chuí", "Chupinguaia", "Chuvisca", "Cianorte", "Cícero Dantas", "Cidade de Gaza", "Cidade do México", "Cidade do Panamá", "Cidade Gaúcha", "Cidade Ocidental", "Cidelândia", "Cidreira",
        "Cine Ímpar", "Cipó", "Cipotânea", "Ciríaco", "Claraval", "Claro dos Poções", "Cláudia", "Cláudio", "Clementina", "Clevelândia", "Coaraci", "Coari", "Cocal", "Cocal de Telha", "Cocal do Sul",
        "Cocal dos Alves", "Cocalinho", "Cocalzinho de Goiás", "Cocos", "Codajás", "Codó", "Coelho Neto", "Coimbra", "Coité");

    public String getRandomValue() {
        return cidades.get(new Random().nextInt(cidades.size()));
    }

}
