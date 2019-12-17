package br.com.contmatic.empresa.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import br.com.contmatic.empresa.model.groups.Delete;
import br.com.contmatic.empresa.model.groups.Find;
import br.com.contmatic.empresa.model.groups.Update;

/**
 * The Enum DDD.
 */
public enum DDD {

                 /** The acre. */
                 ACRE("AC", "68"),

                 /** The alagoas. */
                 ALAGOAS("AL", "82"),

                 /** The amapa. */
                 AMAPA("AP", "96"),

                 /** The amazonas. */
                 AMAZONAS("AM", "92"),

                 /** The bahia. */
                 BAHIA("BA", "71"),

                 /** The ceara. */
                 CEARA("CE", "88"),

                 /** The distrito federal. */
                 DISTRITO_FEDERAL("DF", "61"),

                 /** The espirito santo. */
                 ESPIRITO_SANTO("ES", "27"),

                 /** The goias. */
                 GOIAS("GO", "62"),

                 /** The maranhao. */
                 MARANHAO("MA", "98"),

                 /** The mato grosso. */
                 MATO_GROSSO("MT", "65"),

                 /** The mato grosso do sul. */
                 MATO_GROSSO_DO_SUL("MS", "84"),

                 /** The minas gerais. */
                 MINAS_GERAIS("MG", "31"),

                 /** The parana. */
                 PARANA("PR", "41"),

                 /** The paraiba. */
                 PARAIBA("PB", "83"),

                 /** The para. */
                 PARA("PA", "91"),

                 /** The pernambuco. */
                 PERNAMBUCO("PE", "81"),

                 /** The piaui. */
                 PIAUI("PI", "86"),

                 /** The rio de janeiro. */
                 RIO_DE_JANEIRO("RJ", "21"),

                 /** The rio grande do norte. */
                 RIO_GRANDE_DO_NORTE("RN", "84"),

                 /** The rio grande do sul. */
                 RIO_GRANDE_DO_SUL("RS", "51"),

                 /** The roraima. */
                 RORAIMA("RR", "95"),

                 /** The rondonia. */
                 RONDONIA("RO", "69"),

                 /** The santa catarina. */
                 SANTA_CATARINA("ST", "48"),

                 /** The sergipe. */
                 SERGIPE("SE", "79"),

                 /** The sao paulo. */
                 SAO_PAULO("SP", "11"),

                 /** The tocantins. */
                 TOCANTINS("TO", "63");

    /** The uf. */
    @NotBlank(message = "UF é obrigatório.", groups = { Delete.class, Find.class, Update.class })
    @Size(min = 2, max = 2, message = "UF não pode ter menos ou mais de 2 caracteres.", groups = { Delete.class, Find.class, Update.class })
    @Pattern(regexp = "[A-Z\\D]", message = "UF não pode conter letras minúsculas, números e caracteres especiais.", groups = { Delete.class, Find.class, Update.class })
    private String uf;

    /** The ddd. */
    @NotBlank(message = "DDD é obrigatório.", groups = { Delete.class, Update.class, Find.class })
    @Size(min = 2, max = 2, message = "DDD não pode ter menos ou mais de 2 caracteres.", groups = { Delete.class, Find.class, Update.class })
    @Pattern(regexp = "\\d", message = "DDD não pode conter letras e caracteres especiais.", groups = { Delete.class, Find.class, Update.class })
    private String dddEstado;

    /**
     * Instantiates a new ddd.
     *
     * @param uf the uf
     * @param ddd the ddd
     */
    DDD(String uf, String ddd) {
        this.uf = uf;
        this.dddEstado = ddd;
    }

    /**
     * Gets the uf.
     *
     * @return the uf
     */
    public String getUf() {
        return this.uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    /**
     * Gets the ddd.
     *
     * @return the ddd
     */
    public String getDDD() {
        return this.dddEstado;
    }

    public void setDdd(String ddd) {
        this.dddEstado = ddd;
    }

}
