package com.ryuqq.easyRandom.dummy.cart;

import com.ryuqq.easyRandom.domain.cart.Cart;
import com.ryuqq.easyRandom.dummy.AbstractDummyDataFactory;
import com.ryuqq.easyRandom.dummy.cart.random.CartDetailsRandomizer;

import org.jeasy.random.EasyRandomParameters;
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
    protected EasyRandomParameters getFieldRandomizers(long... ids) {
        Map<String, Randomizer<?>> fieldRandomizers = new HashMap<>();
        fieldRandomizers.put("userId", () -> 1L);
        fieldRandomizers.putIfAbsent("cartDetails", new CartDetailsRandomizer(ids[0], ids[1]));
        return setParam(fieldRandomizers, true);
    }

}
