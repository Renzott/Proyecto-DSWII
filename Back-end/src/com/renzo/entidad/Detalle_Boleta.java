package com.renzo.entidad;

import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
public class Detalle_Boleta {

    @Id
    private String id;
    @ManyToOne
    @JoinColumn(name = "boleta_id")
    private Boleta boleta;
    @ManyToOne
    @JoinColumn(name = "producto_id")
    private Producto producto;
    private int cantidad;
    private double precio;



}
