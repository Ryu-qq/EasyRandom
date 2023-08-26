package com.ryuqq.easyRandom.dummy.random.cart;

import com.ryuqq.easyRandom.dmain.cart.embedded.CartDetails;
import org.jeasy.random.api.Randomizer;

import java.util.Random;

public class CartDetailsRandomizer implements Randomizer<CartDetails> {

    private final long productGroupId;
    private final long productId;
    private final int quantity;
    private final String sellerId;

    private final Random random = new Random();


    public CartDetailsRandomizer(long productGroupId, long productId) {
        this.productGroupId = productGroupId;
        this.productId = productId;
        this.quantity = random.nextInt(999) + 1;  // 랜덤한 수를 1~999 사이로 생성
        this.sellerId = "ryuqq";
    }

    @Override
    public CartDetails getRandomValue() {
        return CartDetails.builder()
                .productGroupId(productGroupId)
                .productId(productId)
                .quantity(quantity)
                .sellerId(sellerId)
                .build();
    }
}
