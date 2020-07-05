package com.renzo.entidad;

import javax.persistence.*;
import java.util.List;

@Entity
public class Usuario {
    @Id
    private String id;
    private String nombre;
    private int edad;
    private String sexo;
    @ManyToOne
    @JoinColumn(name = "cargo_id")
    private Cargo cargo;
    private String correo;
    private String foto;

    @OneToMany(mappedBy = "usuario")
    private List<Boleta> boletas;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }
}
