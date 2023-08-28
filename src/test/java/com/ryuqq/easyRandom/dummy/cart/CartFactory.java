package com.ryuqq.easyRandom.dummy.cart;

import com.ryuqq.easyRandom.domain.cart.Cart;
import com.ryuqq.easyRandom.dummy.AbstractDummyDataFactory;
import com.ryuqq.easyRandom.dummy.cart.random.CartDetailsRandomizer;

import org.jeasy.random.api.Randomizer;
import org.springframework.boot.test.context.TestConfiguration;

import java.util.HashMap;
import java.util.Map;
@TestConfiguration
public class CartFactory extends AbstractDummyDataFactory<Cart> {

    @Override
    public Class<Cart> getTypeClass() {
        return Cart.class;
    }
    @Override
    protected Map<String, Randomizer<?>> getFieldRandomizers(long... ids) {
        Map<String, Randomizer<?>> fieldRandomizers = new HashMap<>();
        fieldRandomizers.put("id", () -> ids[0]);
        fieldRandomizers.putIfAbsent("cartDetails", new CartDetailsRandomizer(ids[1], ids[2]));
        return fieldRandomizers;
    }

}
