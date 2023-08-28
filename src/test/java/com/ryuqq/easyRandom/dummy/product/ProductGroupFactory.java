package com.ryuqq.easyRandom.dummy.product;

import com.ryuqq.easyRandom.domain.product.ProductGroup;
import com.ryuqq.easyRandom.dummy.AbstractDummyDataFactory;
import com.ryuqq.easyRandom.dummy.product.random.ProductGroupDetailsRandomizer;

import org.jeasy.random.api.Randomizer;
import org.springframework.boot.test.context.TestConfiguration;

import java.util.HashMap;
import java.util.Map;

@TestConfiguration
public class ProductGroupFactory extends AbstractDummyDataFactory<ProductGroup> {
    @Override
    public Class<ProductGroup> getTypeClass() {
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
