package com.ryuqq.easyRandom;

import com.ryuqq.easyRandom.domain.product.Product;
import com.ryuqq.easyRandom.domain.product.ProductGroup;
import com.ryuqq.easyRandom.dummy.DummyDataFactory;
import com.ryuqq.easyRandom.dummy.EntityFactoryRegistry;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class ProductSetupUtility extends AbstractSetupUtility{
    private final List<ProductGroup> productGroups = new ArrayList<>();
    private final List<Product> products = new ArrayList<>();

    
    public ProductSetupUtility(EntityFactoryRegistry entityFactoryRegistry, EntityManager em) {
        super(entityFactoryRegistry, em);
    }

    public void init(){
        dummyProductGroupGenerate();
        dummyProductGenerate();
    }


    public void delete() {
        deleteEntities(products);
        deleteEntities(productGroups);
    }



    private void dummyProductGroupGenerate() {
        DummyDataFactory<ProductGroup> productGroupFactory = getDummyFactory(ProductGroup.class);
        for (long l = 1; l <= 10; l++) {
            ProductGroup dummy = productGroupFactory.createDummy(l, l);
            productGroups.add(dummy);
        }
        mergeEntities(productGroups);
    }
    
    private void dummyProductGenerate(){
        DummyDataFactory<Product> productFactory = getDummyFactory(Product.class);
        for(ProductGroup pg: productGroups){
            Product dummy = productFactory.createDummy(pg.getId());
            products.add(dummy);
        }
        mergeEntities(products);
    }

    
    public List<ProductGroup> getProductGroups() {
        return productGroups;
    }

    public List<Product> getProducts() {
        return products;
    }

}
