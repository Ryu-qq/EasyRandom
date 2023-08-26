package com.ryuqq.easyRandom.dummy;

import com.ryuqq.easyRandom.dmain.cart.Cart;
import com.ryuqq.easyRandom.dummy.random.cart.CartDetailsRandomizer;

import org.jeasy.random.api.Randomizer;

import java.util.Map;

import static org.jeasy.random.FieldPredicates.*;

public class CartFactory extends AbstractDummyDataFactory<Cart> implements DummyDataFactory<Cart> {

    @Override
    protected Class<Cart> getTypeClass() {
        return Cart.class;
    }

    @Override
    public Cart createDummy(long... ids) {
        if(ids.length>0){
            fieldRandomizers.put("id", ()-> ids[0]);
            fieldRandomizers.putIfAbsent("cartDetails", new CartDetailsRandomizer(ids[1], ids[2]));
            return createWithParams(fieldRandomizers);
        }

        throw new IllegalArgumentException("ids size must bigger than 0 ");

    }
}
