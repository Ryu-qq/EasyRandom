package com.ryuqq.easyRandom.dmain.product;

import com.ryuqq.easyRandom.dmain.common.BaseEntity;
import com.ryuqq.easyRandom.dmain.product.embedded.ProductGroupDetails;
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
