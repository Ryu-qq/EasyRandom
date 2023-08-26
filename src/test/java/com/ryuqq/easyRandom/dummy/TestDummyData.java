package com.ryuqq.easyRandom.dummy;

import com.ryuqq.easyRandom.dmain.cart.Cart;
import com.ryuqq.easyRandom.dmain.product.Product;
import com.ryuqq.easyRandom.dmain.product.ProductGroup;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class TestDummyData {

    @Test
    public void testProductDummyDataCreation() {
        DummyDataFactory<Product> productFactory = EntityFactoryRegistry.getFactoryByEntity(Product.class);
        Product dummyProduct = productFactory.createDummy(1L);
        System.out.println("dummyProduct = " + dummyProduct);
        Assertions.assertNotNull(dummyProduct);
        Assertions.assertNotNull(dummyProduct.getProductStatus());
    }

    @Test
    public void testProductGroupDummyDataCreation() {
        DummyDataFactory<ProductGroup> productGroupFactory = EntityFactoryRegistry.getFactoryByEntity(ProductGroup.class);
        ProductGroup dummyProductGroup = productGroupFactory.createDummy(1L, 1L, 1L);
        System.out.println("dummyProductGroup = " + dummyProductGroup);
        Assertions.assertNotNull(dummyProductGroup);
        Assertions.assertNotNull(dummyProductGroup.getProductGroupDetails());
    }

    @Test
    public void testCartDummyDataCreation() {
        DummyDataFactory<Cart> cartFactory =  EntityFactoryRegistry.getFactoryByEntity(Cart.class);
        Cart dummyCart = cartFactory.createDummy(1L, 1L, 1L);
        System.out.println("dummyCart = " + dummyCart);
        Assertions.assertNotNull(dummyCart);
        Assertions.assertNotNull(dummyCart.getCartDetails());
    }

}
