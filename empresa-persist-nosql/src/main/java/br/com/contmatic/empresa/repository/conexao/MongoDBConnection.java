package br.com.contmatic.empresa.repository.conexao;

import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

import org.bson.Document;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;

import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class MongoDBConnection {

    private static MongoDBConnection mongoDBConnection;

    private MongoDBConnection() {
    }

    /**
     * Gets the single instance of MongoDBConnection.
     *
     * @return single instance of MongoDBConnection
     */
    public static MongoDBConnection getInstance() {
        if (mongoDBConnection == null) {
            mongoDBConnection = new MongoDBConnection();
        }

        return mongoDBConnection;
    }

    public static final CodecRegistry pojoCodecRegistry = fromRegistries(MongoClientSettings.getDefaultCodecRegistry(), fromProviders(PojoCodecProvider.builder().automatic(true).build()));

    public static final MongoClientSettings settings = MongoClientSettings.builder().codecRegistry(pojoCodecRegistry).build();

    public static final MongoClient mongoClient = MongoClients.create(settings);

    public static final MongoDatabase db = mongoClient.getDatabase("Prova05");

    public static final MongoCollection<Document> collection = db.getCollection("Empresa");

}
