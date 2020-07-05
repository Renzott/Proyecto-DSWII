package com.renzo.service;

import com.renzo.commons.GenericServiceImpl;
import com.renzo.dao.TipoDao;
import com.renzo.entidad.Tipo;

public class TipoService extends GenericServiceImpl<Tipo,Integer> implements TipoDao {

    public TipoService() {
        super(Tipo.class);
    }
}
