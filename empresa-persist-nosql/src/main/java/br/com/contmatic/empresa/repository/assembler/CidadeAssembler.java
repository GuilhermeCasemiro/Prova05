package br.com.contmatic.empresa.repository.assembler;

import org.bson.Document;

import br.com.contmatic.empresa.model.Cidade;
import br.com.contmatic.empresa.repository.assembler.util.Assembler;

/**
 * The Class CidadeAssembler.
 */
public class CidadeAssembler implements Assembler<Cidade, Document> {

    /*
     * (non-Javadoc)
     * 
     * @see br.com.contmatic.empresa.repository.assembler.util.Assembler#toResource(org.bson.Document)
     */
    @Override
    public Cidade toResource(Document document) {
        Cidade cidade = null;
        if (document != null) {
            cidade = new Cidade();
            cidade.setNomeCidade(document.get("cidade", Document.class).getString("nomeCidade"));
            cidade.setCodigoCidade(document.get("cidade", Document.class).getInteger("codigoCidade"));
        }
        return cidade;
    }

    /*
     * (non-Javadoc)
     * 
     * @see br.com.contmatic.empresa.repository.assembler.util.Assembler#toDocument(java.lang.Object)
     */
    @Override
    public Document toDocument(Cidade model) {
        Document document = null;
        if (model != null) {
            document = new Document(Document.parse(model.toString()));
        }
        return document;
    }

}
