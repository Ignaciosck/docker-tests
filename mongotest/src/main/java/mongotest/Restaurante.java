package mongotest;

import org.bson.codecs.pojo.annotations.BsonId;
import org.bson.types.ObjectId;
import com.mongodb.client.model.geojson.Point;

public class Restaurante {

	@BsonId
    private ObjectId id;
    private Point ubicacion;
    private String nombre;

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public Point getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(Point ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    @Override
    public String toString() {
        return "Restaurante [id=" + id + ", ubicacion=" + ubicacion + ", nombre=" + nombre + "]";
    }
}
