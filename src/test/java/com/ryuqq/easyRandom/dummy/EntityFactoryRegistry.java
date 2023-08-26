package com.ryuqq.easyRandom.dummy;

import com.ryuqq.easyRandom.dmain.cart.Cart;
import com.ryuqq.easyRandom.dmain.product.Product;
import com.ryuqq.easyRandom.dmain.product.ProductGroup;

import java.util.HashMap;
import java.util.Map;
public class EntityFactoryRegistry<T> {

    private static final Map<Class<?>, DummyDataFactory<?>> FACTORY_MAP = new HashMap<>();

    static {
        FACTORY_MAP.put(Product.class, new ProductFactory());
        FACTORY_MAP.put(ProductGroup.class, new ProductGroupFactory());
        FACTORY_MAP.put(Cart.class, new CartFactory());
    }

    @SuppressWarnings("unchecked")
    public static <T> DummyDataFactory<T> getFactoryByEntity(Class<T> entityClass) {
        DummyDataFactory<T> factory = (DummyDataFactory<T>) FACTORY_MAP.get(entityClass);
        if (factory == null) {
            throw new IllegalArgumentException("No factory found for class: " + entityClass.getName());
        }
        return factory;
    }
}