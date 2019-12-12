package br.com.contmatic.empresa.repository.assembler.util;

import org.bson.Document;

/**
 * The Interface Assembler.
 *
 * @param <E> the element type
 * @param <R> the generic type
 */
public interface Assembler<E, R extends Document> {

    /**
     * To resource.
     *
     * @param document the document
     * @return the e
     */
    E toResource(R document);

    /**
     * To document.
     *
     * @param model the model
     * @return the r
     */
    R toDocument(E model);
}
