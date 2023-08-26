package com.ryuqq.easyRandom.dmain.product.embedded;

import lombok.*;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.Embeddable;

@ToString
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Embeddable
public class Price {
    private long regularPrice;
    private long currentPrice;
    private long salePrice;
    private int directDiscountRate;
    private long directDiscountPrice;
    private int discountRate;
    @Builder
    public Price(long regularPrice, long currentPrice, long salePrice, int directDiscountRate, long directDiscountPrice, int discountRate) {
        this.regularPrice = regularPrice;
        this.currentPrice = currentPrice;
        this.salePrice = salePrice;
        this.directDiscountRate = directDiscountRate;
        this.directDiscountPrice = directDiscountPrice;
        this.discountRate = discountRate;
    }

}
