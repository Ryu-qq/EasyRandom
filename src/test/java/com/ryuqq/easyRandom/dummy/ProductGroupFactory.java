package com.ryuqq.easyRandom.dummy;

import com.ryuqq.easyRandom.dmain.product.ProductGroup;
import com.ryuqq.easyRandom.dummy.random.product.ProductGroupDetailsRandomizer;

import org.jeasy.random.api.Randomizer;

import java.util.HashMap;
import java.util.Map;


public class ProductGroupFactory extends AbstractDummyDataFactory<ProductGroup> implements DummyDataFactory<ProductGroup> {
    @Override
    protected Class<ProductGroup> getTypeClass() {
        return ProductGroup.class;
    }

    @Override
    public ProductGroup createDummy(long... ids) {
        if(ids.length>0){
            fieldRandomizers.put("id", ()-> ids[0]);
            fieldRandomizers.putIfAbsent("cartDetails", new ProductGroupDetailsRandomizer(ids[1], ids[2]));
            return createWithParams(fieldRandomizers);
        }
        throw new IllegalArgumentException("ids size must bigger than 0 ");
    }

}
