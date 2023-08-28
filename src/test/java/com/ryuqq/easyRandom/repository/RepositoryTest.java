package com.ryuqq.easyRandom.repository;


import com.ryuqq.easyRandom.config.TestConfig;
import com.ryuqq.easyRandom.dummy.DummyDataFactory;
import com.ryuqq.easyRandom.dummy.EntityFactoryRegistry;
import com.ryuqq.easyRandom.dummy.cart.CartFactory;
import com.ryuqq.easyRandom.dummy.product.ProductFactory;
import com.ryuqq.easyRandom.dummy.product.ProductGroupFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;

@Import({
        TestConfig.class,
        CartFactory.class,
        ProductFactory.class,
        ProductGroupFactory.class
}
)
@DataJpaTest
public class RepositoryTest {

    
}
