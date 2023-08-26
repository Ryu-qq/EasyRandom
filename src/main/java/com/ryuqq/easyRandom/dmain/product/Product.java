package com.ryuqq.easyRandom.dmain.product;

import com.ryuqq.easyRandom.dmain.common.BaseEntity;
import com.ryuqq.easyRandom.dmain.product.embedded.ProductStatus;
import lombok.*;

import javax.persistence.*;

@ToString
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Table(name = "PRODUCT")
@Entity
public class Product extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="PRODUCT_ID")
    private long id;
    private long productGroupId;
    @Embedded
    private ProductStatus productStatus;

    public Product(long id, long productGroupId, ProductStatus productStatus) {
        this.id = id;
        this.productGroupId = productGroupId;
        this.productStatus = productStatus;
    }
}
