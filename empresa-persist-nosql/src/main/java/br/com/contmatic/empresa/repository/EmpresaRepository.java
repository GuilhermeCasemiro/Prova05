package br.com.contmatic.empresa.repository;

import static br.com.contmatic.empresa.model.validator.ValidadorCNPJ.isCNPJ;
import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Projections.fields;
import static com.mongodb.client.model.Projections.include;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;

import com.mongodb.client.MongoDatabase;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;

import br.com.contmatic.empresa.model.Empresa;
import br.com.contmatic.empresa.repository.assembler.EmpresaAssembler;

/**
 * The Class EmpresaRepository.
 */
public class EmpresaRepository {

    /** The Constant COLLECTION_NAME. */
    private static final String COLLECTION_NAME = "MongoTest";

    /** The database. */
    private MongoDatabase database;

    /**
     * Instantiates a new empresa repository.
     *
     * @param database the database
     */
    public EmpresaRepository(MongoDatabase database) {
        this.database = database;
    }

    /**
     * Insert.
     *
     * @param empresa the empresa
     * @return true, if successful
     */
    public boolean insert(Empresa empresa) {
        if (empresa != null) {
            Document doc = new EmpresaAssembler().toDocument(empresa);
            database.getCollection(COLLECTION_NAME).insertOne(doc);
            return true;
        } else {
            return false;
        }
    }

    /**
     * Update by id.
     *
     * @param cnpj the cnpj
     * @param campoUpdate the campo update
     * @param novoValor the novo valor
     * @return true, if successful
     */
    public boolean updateById(String cnpj, String campoUpdate, Object novoValor) {
        if (isCNPJ(cnpj)) {
            UpdateResult result = database.getCollection(COLLECTION_NAME).updateOne(eq("_id", cnpj), new Document("$set", new Document(campoUpdate, novoValor)));
            return result.getModifiedCount() != 0;

        } else {
            return false;
        }
    }

    /**
     * Update by filter.
     *
     * @param campo the campo
     * @param valor the valor
     * @param campoUpdate the campo update
     * @param novoValor the novo valor
     * @return true, if successful
     */
    public boolean updateByFilter(String campo, Object valor, String campoUpdate, Object novoValor) {
        UpdateResult result = database.getCollection(COLLECTION_NAME).updateOne(eq(campo, valor), new Document("$set", new Document(campoUpdate, novoValor)));

        return result.getModifiedCount() != 0;
    }

    /**
     * Delete by id.
     *
     * @param cnpj the cnpj
     * @return true, if successful
     */
    public boolean deleteById(String cnpj) {
        if (isCNPJ(cnpj)) {
            DeleteResult delete = database.getCollection(COLLECTION_NAME).deleteOne(eq("_id", cnpj));

            return delete.getDeletedCount() != 0;
        } else {
            return false;
        }
    }

    /**
     * Delete by filter.
     *
     * @param campo the campo
     * @param valor the valor
     * @return true, if successful
     */
    public boolean deleteByFilter(String campo, Object valor) {
        DeleteResult delete = database.getCollection(COLLECTION_NAME).deleteMany(eq(campo, valor));

        return delete.getDeletedCount() != 0;
    }

    /**
     * Delete all.
     */
    public void deleteAll() {
        database.getCollection(COLLECTION_NAME).deleteMany(new Document());
    }

    /**
     * Find all.
     *
     * @return the list
     */
    public List<Empresa> findAll() {
        List<Empresa> empresas = new ArrayList<>();
        List<Document> documents = database.getCollection(COLLECTION_NAME).find().into(new ArrayList<Document>());

        if (documents != null && !documents.isEmpty()) {
            for(Document document : documents) {
                Empresa empresa = new EmpresaAssembler().toResource(document);
                empresas.add(empresa);
            }
        }
        return empresas;
    }

    /**
     * Find by id.
     *
     * @param cnpj the cnpj
     * @return the empresa
     */
    public Empresa findById(String cnpj) {
        Document doc = database.getCollection(COLLECTION_NAME).find(eq("_id", cnpj)).first();

        if (doc != null) {
            return new EmpresaAssembler().toResource(doc);
        } else {
            return new Empresa();
        }
    }

    /**
     * Find by filter limit.
     *
     * @param campo the campo
     * @param valor the valor
     * @param limite the limite
     * @return the list
     */
    public List<Empresa> findByFilterLimit(String campo, Object valor, int limite) {
        List<Empresa> empresas = new ArrayList<>();
        List<Document> doc = database.getCollection(COLLECTION_NAME).find(eq(campo, valor)).limit(limite).into(new ArrayList<Document>());
        if (doc != null) {
            for(Document document : doc) {
                empresas.add(new EmpresaAssembler().toResource(document));
            }
        }
        return empresas;
    }

    /**
     * Find by filter.
     *
     * @param campos the campos
     * @return the list
     */
    public List<Document> findByFilter(String... campos) {
        Iterable<Document> documents = database.getCollection(COLLECTION_NAME).find().projection(fields(include(campos)));
        List<Document> empresas = new ArrayList<>();
        if (documents != null) {
            for(Document document : documents) {
                empresas.add(document);
            }
        }
        return empresas;
    }
}
