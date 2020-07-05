package com.renzo.rest;

import com.algolia.search.DefaultSearchClient;
import com.algolia.search.SearchClient;
import com.algolia.search.SearchIndex;
import com.renzo.entidad.Producto;
import com.renzo.service.ProductoService;

import javax.persistence.EntityResult;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/product")
public class ProductRest {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getAllProducts() {

        ProductoService ps = new ProductoService();

        return Response.ok(ps.findAll()).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public String setProduct(Producto entity){

        ProductoService ps = new ProductoService();

        ps.save(entity);

        return "ok";
    }
}
