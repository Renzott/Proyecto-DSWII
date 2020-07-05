package com.renzo.service;

import com.renzo.commons.GenericServiceImpl;
import com.renzo.dao.BoletaDao;
import com.renzo.entidad.Boleta;

public class BoletaService extends GenericServiceImpl<Boleta,String> implements BoletaDao {

    public BoletaService(){
        super(Boleta.class);
    }

}
