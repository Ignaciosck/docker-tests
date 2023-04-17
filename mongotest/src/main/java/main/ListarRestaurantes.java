package main;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClients;
import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import mongotest.Restaurante;

import org.bson.codecs.configuration.CodecRegistries;
import org.bson.codecs.pojo.PojoCodecProvider;

import java.util.ArrayList;
import java.util.List;

public class ListarRestaurantes {

	public static List<Restaurante> getAll(MongoCollection<Restaurante> restaurantes) throws Exception  {
		try {
			// Realizar una consulta para obtener todos los documentos en la colección de restaurantes.
			FindIterable<Restaurante> resultados = restaurantes.find();
			MongoCursor<Restaurante> it = resultados.iterator();
			List<Restaurante> listaRestaurantes = new ArrayList<Restaurante>();
			while (it.hasNext()) {
				// Agregar cada documento a una lista de objetos Restaurante.
				listaRestaurantes.add(it.next());
			}
			return listaRestaurantes;
		} catch (Exception e) {
			// Lanzar cualquier excepción que ocurra durante la obtención de los restaurantes.
			throw e;
		}
	}
    public static void main(String[] args) {
       
        	// Establecer la cadena de conexión a MongoDB con el usuario root y la contraseña password.
            ConnectionString connectionString = new ConnectionString("mongodb://root:password@localhost:27018/?authSource=admin");

            // Crear un cliente de MongoDB.
            com.mongodb.client.MongoClient mongoClient = MongoClients.create(connectionString);

            // Seleccionar la base de datos.
            MongoDatabase database = mongoClient.getDatabase("test");

            // Seleccionar la colección de restaurantes y especificar que se usará un codec para mapear
            // los documentos BSON a objetos Restaurante.
            MongoCollection<Restaurante> collection = database.getCollection("restaurantes",Restaurante.class).withCodecRegistry(CodecRegistries.fromRegistries(
			MongoClientSettings.getDefaultCodecRegistry(),
			CodecRegistries.fromProviders(PojoCodecProvider.builder().automatic(true).build())));

            try {
				// Obtener todos los restaurantes y recorrerlos para imprimirlos en consola.
				for (Restaurante restaurante : getAll(collection)) {
				    System.out.println(restaurante.toString());
				}
			} catch (Exception e) {
				// Imprimir cualquier excepción que ocurra durante la obtención de los restaurantes.
				e.printStackTrace();
			}        
    }
}
