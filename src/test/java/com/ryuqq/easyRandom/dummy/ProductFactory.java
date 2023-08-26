package com.ryuqq.easyRandom.dummy;

import com.ryuqq.easyRandom.dmain.product.Product;

import com.ryuqq.easyRandom.dummy.random.cart.CartDetailsRandomizer;
import org.jeasy.random.api.Randomizer;

import java.util.HashMap;
import java.util.Map;

public class ProductFactory extends AbstractDummyDataFactory<Product> implements DummyDataFactory<Product> {

    @Override
    protected Class<Product> getTypeClass() {
        return Product.class;
    }

    @Override
    public Product createDummy(long... ids) {
        if(ids.length>0){
            fieldRandomizers.put("id", ()-> ids[0]);
            return create();
        }
        throw new IllegalArgumentException("ids size must bigger than 0 ");
    }
}
