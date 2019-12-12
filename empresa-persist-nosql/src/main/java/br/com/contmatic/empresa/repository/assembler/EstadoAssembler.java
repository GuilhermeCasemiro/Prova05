package br.com.contmatic.empresa.repository.assembler;

import org.bson.Document;

import br.com.contmatic.empresa.model.Estado;
import br.com.contmatic.empresa.repository.assembler.util.Assembler;

/**
 * The Class EstadoAssembler.
 */
public class EstadoAssembler implements Assembler<Estado, Document> {

    /*
     * (non-Javadoc)
     * 
     * @see br.com.contmatic.empresa.repository.assembler.util.Assembler#toResource(org.bson.Document)
     */
    @Override
    public Estado toResource(Document document) {
        Estado estado = null;
        if (document != null) {
            estado = new Estado();
            estado.setNomeEstado(document.get("estado", Document.class).getString("nomeEstado"));
            estado.setCodigoEstado(document.get("estado", Document.class).getInteger("codigoEstado"));
        }
        return estado;
    }

    /*
     * (non-Javadoc)
     * 
     * @see br.com.contmatic.empresa.repository.assembler.util.Assembler#toDocument(java.lang.Object)
     */
    @Override
    public Document toDocument(Estado model) {
        Document document = null;
        if (model != null) {
            document = new Document(Document.parse(model.toString()));
        }
        return document;
    }

}
