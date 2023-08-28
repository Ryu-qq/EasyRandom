package com.ryuqq.easyRandom.repository;

import com.ryuqq.easyRandom.CartSetupUtility;
import com.ryuqq.easyRandom.ProductSetupUtility;
import com.ryuqq.easyRandom.domain.cart.Cart;
import com.ryuqq.easyRandom.domain.product.Product;
import com.ryuqq.easyRandom.domain.product.ProductGroup;
import lombok.Getter;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@TestInstance(TestInstance.Lifecycle.PER_METHOD)
@Getter
public class SetUpCartDummyRepository extends RepositoryTest{
    @Autowired
    private ProductSetupUtility productSetupUtility;
    @Autowired
    private CartSetupUtility cartSetupUtility;



    @BeforeEach
    public void setUp() {
        productSetupUtility.init();
        List<ProductGroup> productGroups = productSetupUtility.getProductGroups();
        List<Product> products = productSetupUtility.getProducts();
        cartSetupUtility.init(productGroups, products);
    }

    @AfterEach
    public void tearDown(){
        productSetupUtility.delete();
        cartSetupUtility.delete();
    }


    public void showDummyData(){
        List<ProductGroup> productGroups = productSetupUtility.getProductGroups();
        List<Product> products = productSetupUtility.getProducts();
        List<Cart> carts = cartSetupUtility.getCarts();

        productGroups.forEach(productGroup -> System.out.println("productGroup = " + productGroup));
        products.forEach(product -> System.out.println("product = " + product));
        carts.forEach(cart -> System.out.println("cart = " + cart));


    }
}
