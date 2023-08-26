package com.ryuqq.easyRandom.dummy.random.product;

import com.ryuqq.easyRandom.dmain.product.embedded.Price;
import com.ryuqq.easyRandom.dmain.product.embedded.ProductGroupDetails;
import com.ryuqq.easyRandom.dmain.product.embedded.ProductStatus;
import org.jeasy.random.EasyRandom;
import org.jeasy.random.EasyRandomParameters;
import org.jeasy.random.api.Randomizer;

public class ProductGroupDetailsRandomizer  implements Randomizer<ProductGroupDetails> {

    private long categoryId;
    private long brandId;

    public ProductGroupDetailsRandomizer(long categoryId, long brandId) {
        this.categoryId = categoryId;
        this.brandId = brandId;
    }

    @Override
    public ProductGroupDetails getRandomValue() {
        return ProductGroupDetails.builder()
                .productGroupName("test")
                .categoryId(categoryId)
                .brandId(brandId)
                .sellerId("ryuqq")
                .price(makeDummyPrice())
                .productStatus(makeDummyProductStatus())
                .build();
    }

    private Price makeDummyPrice(){
        EasyRandomParameters parameters = new EasyRandomParameters()
                .randomize(Price.class, new PriceRandomizer());
        return new EasyRandom(parameters).nextObject(Price.class);
    }

    private ProductStatus makeDummyProductStatus(){
        return new EasyRandom(defaultParameters()).nextObject(ProductStatus.class);
    }

    private EasyRandomParameters defaultParameters() {
        return new EasyRandomParameters()
                .stringLengthRange(1, 10);
    }
}
