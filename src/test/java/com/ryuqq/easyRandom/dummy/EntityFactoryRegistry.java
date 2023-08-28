package com.ryuqq.easyRandom.dummy;

import com.ryuqq.easyRandom.common.AbstractProvider;
import java.util.List;

public class EntityFactoryRegistry extends AbstractProvider<Class<?>, DummyDataFactory<?>> {

    public EntityFactoryRegistry(List<DummyDataFactory<?>> DummyDataFactories){
        for(DummyDataFactory<?> factory : DummyDataFactories){
            map.put(factory.getClassType(), factory);
        }
    }


    public DummyDataFactory<?> getByClassType(Class<?> clazz) {
        DummyDataFactory<?> factory = super.get(clazz);
        if (!clazz.equals(factory.getClassType())) {
            throw new IllegalArgumentException("Factory for key: " + factory.getClassType() + " does not produce expected type: " + clazz.getName());
        }
        return factory;
    }

}
