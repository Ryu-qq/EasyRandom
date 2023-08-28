package com.ryuqq.easyRandom.dummy.product;

import com.ryuqq.easyRandom.domain.product.Product;

import com.ryuqq.easyRandom.dummy.AbstractDummyDataFactory;
import org.jeasy.random.api.Randomizer;
import org.springframework.boot.test.context.TestConfiguration;

import java.util.HashMap;
import java.util.Map;

@TestConfiguration
public class ProductFactory extends AbstractDummyDataFactory<Product> {

    @Override
    public Class<Product> getTypeClass() {
        return Product.class;
    }

    @Override
    protected Map<String, Randomizer<?>> getFieldRandomizers(long... ids) {
        Map<String, Randomizer<?>> fieldRandomizers = new HashMap<>();
        fieldRandomizers.put("id", () -> ids[0]);
        fieldRandomizers.put("productGroupId", () -> ids[1]);
        return fieldRandomizers;
    }

}
