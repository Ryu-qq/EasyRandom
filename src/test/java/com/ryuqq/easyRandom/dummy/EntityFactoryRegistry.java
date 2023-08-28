package com.ryuqq.easyRandom.dummy;

import com.ryuqq.easyRandom.common.AbstractProvider;
import java.util.List;

public class EntityFactoryRegistry extends AbstractProvider<Class<?>, DummyDataFactory<?>> {

    public EntityFactoryRegistry(List<DummyDataFactory<?>> DummyDataFactories){
        for(DummyDataFactory<?> factory : DummyDataFactories){
            map.put(factory.getTypeClass(), factory);
        }
    }


    public DummyDataFactory<?> getByClassType(Class<?> clazz) {
        DummyDataFactory<?> factory = super.get(clazz);
        if (!clazz.equals(factory.getTypeClass())) {
            throw new IllegalArgumentException("Factory for key: " + factory.getTypeClass() + " does not produce expected type: " + clazz.getName());
        }
        return factory;
    }

}
