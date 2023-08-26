package com.ryuqq.easyRandom.dmain.cart;

import com.ryuqq.easyRandom.dmain.cart.embedded.CartDetails;
import lombok.*;

import javax.persistence.*;
@ToString
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Table(name = "CART")
@Entity
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CART_ID")
    private long id;
    private long userId;
    @Embedded
    private CartDetails cartDetails;

    public Cart(long cartId, long userId, CartDetails cartDetails) {
        this.id = cartId;
        this.userId = userId;
        this.cartDetails = cartDetails;
    }

}

