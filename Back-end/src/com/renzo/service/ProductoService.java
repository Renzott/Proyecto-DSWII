package com.renzo.service;

import com.renzo.commons.GenericServiceImpl;
import com.renzo.dao.ProductoDao;
import com.renzo.entidad.Producto;

public class ProductoService extends GenericServiceImpl<Producto,String> implements ProductoDao {

    public ProductoService(){
        super(Producto.class);
    }

}
