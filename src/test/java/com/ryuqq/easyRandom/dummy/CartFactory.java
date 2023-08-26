package com.ryuqq.easyRandom.dummy;

import com.ryuqq.easyRandom.dmain.cart.Cart;
import com.ryuqq.easyRandom.dummy.random.cart.CartDetailsRandomizer;

import org.jeasy.random.api.Randomizer;

import java.util.HashMap;
import java.util.Map;

import static org.jeasy.random.FieldPredicates.*;

public class CartFactory extends AbstractDummyDataFactory<Cart> {

    @Override
    protected Class<Cart> getTypeClass() {
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
