package com.renzo.commons;

import com.renzo.entidad.BaseEntity;
import com.renzo.persistance.DataLoader;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.List;
import java.util.Optional;


public class GenericServiceImpl<T, ID extends Serializable> implements IGenericService<T,ID>  {

    @PersistenceContext
    private DataLoader dataLoader = DataLoader.getInstance();
    private EntityManager entityManager = dataLoader.getManager();

    private Class<T> persistentClass;


    public GenericServiceImpl(Class<T> persistentClass) {
        this.persistentClass = persistentClass;
    }

    protected EntityManager getEntityManager() {
        return entityManager;
    }

    @PersistenceContext
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public Class<T> getPersistentClass() {
        return persistentClass;
    }

    @Override
    public T save(T entity) {
        EntityTransaction tx = getEntityManager().getTransaction();
        tx.begin();
        getEntityManager().persist(entity);
        tx.commit();

        return entity;
    }

    @Override
    public T update(T entity) {

        EntityTransaction tx = getEntityManager().getTransaction();
        tx.begin();
        T mergedEntity = getEntityManager().merge(entity);
        tx.commit();
        return mergedEntity;
    }

    @Override
    public void delete(T entity) {
        if (BaseEntity.class.isAssignableFrom(persistentClass)) {
            getEntityManager().remove(
                    getEntityManager().getReference(entity.getClass(),
                            ((BaseEntity)entity).getId()));
        } else {
            entity = getEntityManager().merge(entity);
            getEntityManager().remove(entity);
        }
    }

    @Override
    public T findById(ID id) {
        T entity = (T) getEntityManager().find(getPersistentClass(), id);
        return entity;
    }

    @Override
    public List<T> findAll() {
        return getEntityManager()
                .createQuery("select x from " + getPersistentClass().getSimpleName() + " x")
                .getResultList();
    }

    @Override
    public void flush() {
        getEntityManager().flush();
    }
}
