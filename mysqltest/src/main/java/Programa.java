import dao.RestauranteDAO;
import model.Restaurante;

public class Programa {

    public static void main(String[] args) {
        RestauranteDAO dao = new RestauranteDAO();

        // Crear un nuevo restaurante
        Restaurante r1 = new Restaurante();
        r1.setNombre("Mi restaurante");
        r1.setDireccion("Calle 1");
        Restaurante r2 = new Restaurante();
        r2.setNombre("Mi otro restaurante");
        r2.setDireccion("Calle 1");
        dao.create(r1);
        System.out.println("Restaurante creado: " + r1);

        // Leer un restaurante por su id
        Restaurante r3 = dao.read(r1.getId());
        System.out.println("Restaurante leído: " + r3);

        // Actualizar un restaurante
        r1.setDireccion("Calle 2");
        dao.update(r1);
        System.out.println("Restaurante actualizado: " + r1);

        // Eliminar un restaurante
        dao.delete(r2);
        System.out.println("Restaurante eliminado");
    }
}

