package com.renzo.rest;

import com.algolia.search.DefaultSearchClient;
import com.algolia.search.SearchClient;
import com.algolia.search.SearchIndex;
import com.renzo.entidad.Boleta;
import com.renzo.entidad.Producto;
import com.renzo.entidad.Tipo;
import com.renzo.persistance.DataLoader;
import com.renzo.service.ProductoService;
import com.renzo.service.TipoService;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.io.File;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

@Path("/")
public class IndexRest {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getMessageIndex() {

        SearchClient client = DefaultSearchClient.create("AHNGOF29I6", "509028c67e4128f8af0e923e276f7455");
        SearchIndex<Producto> index = client.initIndex("products_NAME", Producto.class);

        ProductoService ps = new ProductoService();

        /*----*/
        /*
        * Info de las rutas,
        * Total de todos los modelos:
        *
        *  Productos: 20
        *  Tipo: 4
        *
        *  etc...
        *
        * */
        /*---*/

        /*for(Producto p : ps.findAll()){

            Producto tem = p;

            tem.setBoletas(null);
            tem.getTipo().setProductos(null);
            index.deleteObject(p.getObjectID());
            index.saveObject(tem);
        }*/

        return "API";
    }

    public void listFilesForFolder(final File folder) {

        /*
        *  File root = new File("C:\\Users\\Renzott-PC\\Desktop\\Proyectos\\Java\\Proyect-DSWII\\imagenes");

        Tipo t1 = new Tipo();
        t1.setId(1);
        t1.setNombre("Accesorios");

        ts.save(t1);

        Tipo t2 = new Tipo();
        t2.setId(2);
        t2.setNombre("Calzado");

        ts.save(t2);

        Tipo t3 = new Tipo();
        t3.setId(3);
        t3.setNombre("Ropa");

        ts.save(t3);

        Tipo t4 = new Tipo();
        t4.setId(4);
        t4.setNombre("Tecnologia");

        ts.save(t4);
        * ts.findAll()
        * */
        Object ts;
        List<Tipo> tipoList = new ArrayList<>();
        ProductoService ps = new ProductoService();
        for (final File dir : folder.listFiles()) {
            System.out.println(dir.getName());
            for (final File file : dir.listFiles()) {

                Producto producto = new Producto();

                int idNumber = (int) (Math.random() * (999 - 100)) + 100;
                producto.setObjectID(file.getName().substring(0, 4) + "-" + idNumber);
                producto.setNombre(file.getName().replace(".jpg", "").replaceAll("-", " "));
                producto.setDescripcion("placeholder");
                producto.setTipo(tipoList.stream().filter(e -> e.getNombre().equals(dir.getName())).findAny().orElse(null));
                producto.setFoto("https://images.renzo.workers.dev/productos/" + dir.getName() + "/" + file.getName());
                producto.setPrecio(10.00);
                producto.setStock(10);
                producto.setEstado(true);

                ps.save(producto);
            }
        }
    }


}
