package com.ryuqq.easyRandom.dummy;

import com.ryuqq.easyRandom.domain.cart.Cart;
import com.ryuqq.easyRandom.domain.product.Product;
import com.ryuqq.easyRandom.domain.product.ProductGroup;
import com.ryuqq.easyRandom.repository.RepositoryTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class TestDummyData extends RepositoryTest {

    @Test
    public void testProductDummyDataCreation() {
        DummyDataFactory<Product> productFactory = getDummyFactory(Product.class);
        Product dummyProduct = productFactory.createDummy(1L, 1L);
        System.out.println("dummyProduct = " + dummyProduct);
        Assertions.assertNotNull(dummyProduct);
        Assertions.assertNotNull(dummyProduct.getProductStatus());
    }

    @Test
    public void testProductGroupDummyDataCreation() {
        DummyDataFactory<ProductGroup> productGroupFactory = getDummyFactory(ProductGroup.class);
        ProductGroup dummyProductGroup = productGroupFactory.createDummy(1L, 1L, 1L);
        System.out.println("dummyProductGroup = " + dummyProductGroup);
        Assertions.assertNotNull(dummyProductGroup);
        Assertions.assertNotNull(dummyProductGroup.getProductGroupDetails());
    }

    @Test
    public void testCartDummyDataCreation() {
        DummyDataFactory<Cart> cartFactory =  getDummyFactory(Cart.class);
        Cart dummyCart = cartFactory.createDummy(1L, 1L, 1L);
        System.out.println("dummyCart = " + dummyCart);
        Assertions.assertNotNull(dummyCart);
        Assertions.assertNotNull(dummyCart.getCartDetails());
    }

}


