package com.ryuqq.easyRandom.dummy.product;

import com.ryuqq.easyRandom.domain.product.ProductGroup;
import com.ryuqq.easyRandom.dummy.AbstractDummyDataFactory;
import com.ryuqq.easyRandom.dummy.product.random.ProductGroupDetailsRandomizer;

import org.jeasy.random.EasyRandomParameters;
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
    protected EasyRandomParameters getFieldRandomizers(long... ids) {
        Map<String, Randomizer<?>> fieldRandomizers = new HashMap<>();
        fieldRandomizers.putIfAbsent("productGroupDetails", new ProductGroupDetailsRandomizer(ids[0], ids[0]));
        return setParam(fieldRandomizers, true);
    }

}
