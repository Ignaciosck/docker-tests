package model;

import javax.persistence.*;

@Entity
@Table(name = "restaurante")
public class Restaurante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nombre;
    private String direccion;

    public Restaurante() {}

    public Restaurante(String name, String address) {
        this.nombre = name;
        this.direccion = address;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String name) {
        this.nombre = name;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String address) {
        this.direccion = address;
    }
    @Override
    public String toString() {
        return "Restaurante [id=" + id + ", nombre=" + nombre + ", direccion=" + direccion + "]";
    }
    
}
