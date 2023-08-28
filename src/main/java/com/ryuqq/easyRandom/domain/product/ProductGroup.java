package com.ryuqq.easyRandom.domain.product;

import com.ryuqq.easyRandom.domain.common.BaseEntity;
import com.ryuqq.easyRandom.domain.product.embedded.ProductGroupDetails;
import lombok.*;

import javax.persistence.*;
@ToString
@Builder
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "PRODUCT_GROUP")
@Entity
public class ProductGroup extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PRODUCT_GROUP_ID")
    private long id;
    @Embedded
    private ProductGroupDetails productGroupDetails;

    public ProductGroup(long productGroupId, ProductGroupDetails productGroupDetails) {
        this.id = productGroupId;
        this.productGroupDetails = productGroupDetails;
    }

}
