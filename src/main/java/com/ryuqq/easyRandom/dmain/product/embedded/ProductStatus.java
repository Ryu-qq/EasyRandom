package com.ryuqq.easyRandom.dmain.product.embedded;

import lombok.*;

import javax.persistence.Embeddable;

@ToString
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Embeddable
public class ProductStatus {
    private String soldOutYn;
    private String displayYn;

    @Builder
    public ProductStatus(String soldOutYn, String displayYn) {
        this.soldOutYn = soldOutYn;
        this.displayYn = displayYn;
    }
}
