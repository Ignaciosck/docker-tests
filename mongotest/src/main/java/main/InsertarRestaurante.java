// Importar las clases y paquetes necesarios
package main;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.geojson.Point;
import com.mongodb.client.model.geojson.Position;

import mongotest.Restaurante;

import org.bson.codecs.configuration.CodecRegistries;
import org.bson.codecs.pojo.PojoCodecProvider;
import org.bson.types.ObjectId;

public class InsertarRestaurante {

    public static void main(String[] args) {

        // Establecer la cadena de conexión a MongoDB
        ConnectionString connectionString = new ConnectionString("mongodb://root:password@localhost:27018/admin?authSource=admin");
        
     // Crear un cliente de MongoDB.
        com.mongodb.client.MongoClient mongoClient = MongoClients.create(connectionString);

        // Seleccionar la base de datos.
        MongoDatabase database = mongoClient.getDatabase("test");

        // Seleccionar la colección de restaurantes
        MongoCollection<Restaurante> collection = database.getCollection("restaurantes", Restaurante.class)
                .withCodecRegistry(CodecRegistries.fromRegistries(
                        MongoClientSettings.getDefaultCodecRegistry(),
                        CodecRegistries.fromProviders(PojoCodecProvider.builder().automatic(true).build())));

        // Crear un nuevo restaurante
        Restaurante nuevoRestaurante = new Restaurante();
        nuevoRestaurante.setId(new ObjectId());
        nuevoRestaurante.setUbicacion(new Point(new Position(77.0, 39.0)));
        nuevoRestaurante.setNombre("Mi Restaurante");

        // Insertar el objeto Restaurante en la colección de restaurantes
        collection.insertOne(nuevoRestaurante);

        // Cerrar la conexión
        mongoClient.close();
    }
}
