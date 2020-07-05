package com.renzo.entidad;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Producto")
public class Producto implements Serializable {

    @Id
    @Column(name = "id")
    private String objectID;
    private String nombre;
    private String descripcion;
    @ManyToOne
    @JoinColumn(name = "tipo_id")
    private Tipo tipo;
    private String foto;
    private Double precio;
    private int stock;
    private boolean estado;
    @OneToMany(mappedBy = "producto")
    private List<Detalle_Boleta> boletas = new ArrayList<>();

    public String getObjectID() {
        return objectID;
    }

    public void setObjectID(String objectID) {
        this.objectID = objectID;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public List<Detalle_Boleta> getBoletas() {
        return boletas;
    }

    public void setBoletas(List<Detalle_Boleta> boletas) {
        this.boletas = boletas;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "objectID='" + objectID + '\'' +
                ", nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", tipo=" + tipo.toString() +
                ", foto='" + foto + '\'' +
                ", precio=" + precio +
                ", stock=" + stock +
                ", estado=" + estado +
                ", boletas=" + boletas +
                '}';
    }
}
