package com.renzo.persistance;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.ws.rs.Path;
import javax.ws.rs.ext.Provider;

public class DataLoader{

    private static DataLoader instance = null;

    private EntityManager manager;


    public DataLoader(){
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("persistenciaTest");
        EntityManager manager = factory.createEntityManager();

        this.manager = manager;

    }

    public static DataLoader getInstance() {
        if(instance == null){
            instance  = new DataLoader();
        }
        return instance;
    }

    public EntityManager getManager() {
        return manager;
    }

}
