package com.ryuqq.easyRandom;

import com.ryuqq.easyRandom.domain.cart.Cart;
import com.ryuqq.easyRandom.domain.product.Product;
import com.ryuqq.easyRandom.domain.product.ProductGroup;
import com.ryuqq.easyRandom.dummy.DummyDataFactory;
import com.ryuqq.easyRandom.dummy.EntityFactoryRegistry;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;

public class CartSetupUtility extends AbstractSetupUtility{

    private final List<Cart> carts = new ArrayList<>();

    public CartSetupUtility(EntityFactoryRegistry entityFactoryRegistry, EntityManager em) {
        super(entityFactoryRegistry, em);
    }

    public void init(List<ProductGroup> productGroups, List<Product> products){
        dummyCartGenerate(productGroups, products);
        mergeEntities(carts);
    }

    public void delete() {
        deleteEntities(carts);
    }

    private void dummyCartGenerate(List<ProductGroup> productGroups, List<Product> products) {
        DummyDataFactory<Cart> cartFactory = getDummyFactory(Cart.class);
        Map<Long, List<Product>> productMap = products.stream().collect(Collectors.groupingBy(Product::getProductGroupId));
        Random rand = new Random();

        for (ProductGroup pg : productGroups) {
            long id = pg.getId();
            List<Product> products1 = productMap.get(id);
            int size = products1.size();
            int randomValue = rand.nextInt(size) + 1;
            Product product = products1.get(randomValue-1);
            Cart cart = cartFactory.createDummy(id, product.getId(), 10);
            carts.add(cart);
        }
    }

    public List<Cart> getCarts() {
        return carts;
    }
}

