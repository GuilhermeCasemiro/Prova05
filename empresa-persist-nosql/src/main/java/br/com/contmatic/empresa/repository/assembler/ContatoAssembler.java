package br.com.contmatic.empresa.repository.assembler;

import org.bson.Document;

import br.com.contmatic.empresa.model.Contato;
import br.com.contmatic.empresa.model.DDD;
import br.com.contmatic.empresa.model.Telefone;
import br.com.contmatic.empresa.repository.assembler.util.Assembler;

/**
 * The Class ContatoAssembler.
 */
public class ContatoAssembler implements Assembler<Contato, Document> {

    /*
     * (non-Javadoc)
     * 
     * @see br.com.contmatic.empresa.repository.assembler.util.Assembler#toResource(org.bson.Document)
     */
    @Override
    public Contato toResource(Document document) {
        Contato contato = null;
        if (document != null) {
            contato = new Contato();
            contato.setDdd(DDD.valueOf(document.getString("ddd")));
            contato.setTelefone(Telefone.valueOf(document.getString("telefone")));
        }
        return contato;
    }

    /*
     * (non-Javadoc)
     * 
     * @see br.com.contmatic.empresa.repository.assembler.util.Assembler#toDocument(java.lang.Object)
     */
    @Override
    public Document toDocument(Contato model) {
        Document document = null;
        if (model != null) {
            document = new Document(Document.parse(model.toString()));
        }
        return document;
    }

}
