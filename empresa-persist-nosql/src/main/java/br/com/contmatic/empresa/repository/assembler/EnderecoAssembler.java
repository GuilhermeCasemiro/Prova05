package br.com.contmatic.empresa.repository.assembler;

import org.bson.Document;

import br.com.contmatic.empresa.model.Endereco;
import br.com.contmatic.empresa.repository.assembler.util.Assembler;

/**
 * The Class EnderecoAssembler.
 */
public class EnderecoAssembler implements Assembler<Endereco, Document> {

    /*
     * (non-Javadoc)
     * 
     * @see br.com.contmatic.empresa.repository.assembler.util.Assembler#toResource(org.bson.Document)
     */
    @Override
    public Endereco toResource(Document document) {
        Endereco endereco = null;
        if (document != null) {
            endereco = new Endereco();
            endereco.setBairro(document.getString("bairro"));
            endereco.setCep(document.getString("cep"));
            endereco.setComplemento(document.getString("complemento"));
            endereco.setNumeroResidencia(document.getInteger("numeroResidencia"));
        }
        return endereco;
    }

    /*
     * (non-Javadoc)
     * 
     * @see br.com.contmatic.empresa.repository.assembler.util.Assembler#toDocument(java.lang.Object)
     */
    @Override
    public Document toDocument(Endereco model) {
        Document document = null;
        if (model != null) {
            document = new Document(Document.parse(model.toString()));
        }
        return document;
    }

}
