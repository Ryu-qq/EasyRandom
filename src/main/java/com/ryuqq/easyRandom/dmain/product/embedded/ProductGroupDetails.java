package com.ryuqq.easyRandom.dmain.product.embedded;

import lombok.*;

import javax.persistence.Embeddable;
import javax.persistence.Embedded;

@ToString
@Embeddable
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ProductGroupDetails {
    private String productGroupName;
    private String sellerId;
    private long brandId;
    private long categoryId;
    @Embedded
    private Price price;
    @Embedded
    private ProductStatus productStatus;
    @Builder
    public ProductGroupDetails(String productGroupName, String sellerId, long brandId, long categoryId, Price price, ProductStatus productStatus) {
        this.productGroupName = productGroupName;
        this.sellerId = sellerId;
        this.brandId = brandId;
        this.categoryId = categoryId;
        this.price = price;
        this.productStatus = productStatus;
    }

}
