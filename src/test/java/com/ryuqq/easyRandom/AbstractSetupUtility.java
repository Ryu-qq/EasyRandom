package com.ryuqq.easyRandom;

import com.ryuqq.easyRandom.dummy.DummyDataFactory;
import com.ryuqq.easyRandom.dummy.EntityFactoryRegistry;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.function.Function;

public class AbstractSetupUtility {

    private final EntityFactoryRegistry entityFactoryRegistry;
    private final EntityManager em;

    public AbstractSetupUtility(EntityFactoryRegistry entityFactoryRegistry, EntityManager em) {
        this.entityFactoryRegistry = entityFactoryRegistry;
        this.em = em;
    }


    protected void merge(Object o){
        em.persist(o);
    }

    protected void delete(Object o){
        if (!em.contains(o)) {
            o = em.merge(o);
        }
        em.remove(o);
    }

    protected <T> void mergeEntities(List<T> entities) {
        for (T entity : entities) {
            merge(entity);
        }
    }

    protected <T> void deleteEntities(List<T> entities) {
        for (T entity : entities) {
            delete(entity);
        }
    }

    protected <T> DummyDataFactory<T> getDummyFactory(Class<T> entityType) {
        return (DummyDataFactory<T>) entityFactoryRegistry.getByClassType(entityType);
    }

    protected  <T> long getNextId(List<T> entities, Function<T, Long> idExtractor) {
        if (entities.isEmpty()) {
            return 1;
        }
        return idExtractor.apply(entities.get(entities.size() - 1)) + 1;
    }




}
