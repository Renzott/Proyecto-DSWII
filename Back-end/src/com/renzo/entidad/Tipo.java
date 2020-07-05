package com.renzo.entidad;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class Tipo implements Serializable {
    @Id
    private int id;
    private String nombre;
    @OneToMany(mappedBy = "tipo")
    private List<Producto> productos;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }

    @Override
    public String toString() {
        return "Tipo{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}
