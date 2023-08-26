package com.ryuqq.easyRandom.dummy.random.product;

import com.ryuqq.easyRandom.dmain.product.embedded.Price;
import org.jeasy.random.api.Randomizer;

import java.util.Random;

public class PriceRandomizer implements Randomizer<Price> {

    private final Random random = new Random();

    @Override
    public Price getRandomValue() {
        long regularPrice = 1000000L + random.nextInt(900000);

        // currentPrice is between 500 and regularPrice
        long currentPrice = 800000L + random.nextInt((int) (regularPrice - 499000));

        // salePrice is between 100 and currentPrice
        long salePrice = 400000L + random.nextInt((int) (currentPrice - 399000));

        long directDiscountPrice = random.nextInt((int) salePrice - 399000);

        int directDiscountRate = directDiscountRateWithPrice(currentPrice, salePrice);
        int discountRate = discountRate(regularPrice, salePrice);

        return new Price(regularPrice, currentPrice, salePrice, directDiscountRate, directDiscountPrice, discountRate);
    }


    private int discountRate(long regularPrice, long salePrice){
        long price = regularPrice - salePrice;
        double val = price / (double) regularPrice;
        double ceil = (int)  Math.round((double) val * 100);
        String discountRate = String.format("%.0f", ceil);
        return Integer.parseInt(discountRate);
    }

    private int directDiscountRateWithPrice(long currentPrice, long salePrice){
        long price = currentPrice - salePrice;
        double val = price / (double) currentPrice;
        double ceil = (int)  Math.round((double) val * 100);
        String discountRate = String.format("%.0f", ceil);
        return Integer.parseInt(discountRate);
    }


}
