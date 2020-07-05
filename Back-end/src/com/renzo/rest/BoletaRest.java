package com.renzo.rest;

import com.renzo.entidad.Boleta;
import com.renzo.entidad.Detalle_Boleta;
import com.renzo.entidad.Producto;
import com.renzo.entidad.Usuario;
import com.renzo.service.BoletaService;
import com.renzo.service.ProductoService;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Path("/product")
public class BoletaRest {

    // PlaceHolder!!!!

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public String createBoleta(List<String> ids, Usuario user){

        BoletaService bs = new BoletaService();

        Boleta boleta = new Boleta();

        List<Detalle_Boleta> temporal = new ArrayList<>();

        for (String id: ids) {

            Detalle_Boleta detalle_boleta = new Detalle_Boleta();

            //detalle_boleta.setProduct(Find Product(ids))

            temporal.add(detalle_boleta);
        }


        boleta.setId("Random ID");
        boleta.setFecha(new Date());

        boleta.setDetalle_boletas(temporal);

        boleta.setUsuario(user);

        bs.save(boleta);

        return "ok";
    }
}
