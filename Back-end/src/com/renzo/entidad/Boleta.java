package com.renzo.entidad;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Boleta {

    @Id
    private String id;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;

    @OneToMany(mappedBy = "boleta")
    private List<Detalle_Boleta> detalle_boletas;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public List<Detalle_Boleta> getDetalle_boletas() {
        return detalle_boletas;
    }

    public void setDetalle_boletas(List<Detalle_Boleta> detalle_boletas) {
        this.detalle_boletas = detalle_boletas;
    }
}
