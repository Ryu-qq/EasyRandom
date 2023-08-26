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
    protected Map<String, Randomizer<?>> getFieldRandomizers(long... ids) {
        Map<String, Randomizer<?>> fieldRandomizers = new HashMap<>();
        fieldRandomizers.put("id", () -> ids[0]);
        fieldRandomizers.putIfAbsent("productGroupDetails", new ProductGroupDetailsRandomizer(ids[1], ids[2]));
        return fieldRandomizers;
    }

}
