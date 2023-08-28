package com.ryuqq.easyRandom.domain.cart.embedded;

import com.ryuqq.easyRandom.domain.cart.Cart;
import lombok.*;

import javax.persistence.Embeddable;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@ToString
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Embeddable
public class CartDetails {

    @Min(value = 1, message = "productGroupId는 0보다 커야합니다.")
    private long productGroupId;
    @Min(value = 1, message = "productId는 0보다 커야합니다.")
    private long productId;
    @Min(value = 1, message = "재고의 수량은  0 보다 커야합니다.")
    @Max(value = 999, message = "재고의 수량은 999 보다 작아야 합니다.")
    private int quantity;
    @NotBlank(message = "판매자명은 빈칸이 될 수 없습니다.")
    private String sellerId;

    @Builder
    public CartDetails(long productGroupId, long productId, int quantity, String sellerId) {
        this.productGroupId = productGroupId;
        this.productId = productId;
        this.quantity = quantity;
        this.sellerId = sellerId;
    }

    public Cart toEntity(){
        return Cart.builder()
                .userId(1L)
                .cartDetails(this)
                .build();
    }

}
