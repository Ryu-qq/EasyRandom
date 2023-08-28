package com.ryuqq.easyRandom.config;

import com.ryuqq.easyRandom.CartSetupUtility;
import com.ryuqq.easyRandom.ProductSetupUtility;
import com.ryuqq.easyRandom.dummy.DummyDataFactory;
import com.ryuqq.easyRandom.dummy.EntityFactoryRegistry;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

import javax.persistence.EntityManager;
import java.util.List;

@TestConfiguration
public class TestConfig {

    @Bean
    public EntityFactoryRegistry entityFactoryRegistry(List<DummyDataFactory<?>> factories) {
        return new EntityFactoryRegistry(factories);
    }


    @Bean
    public ProductSetupUtility productSetupUtility(EntityFactoryRegistry entityFactoryRegistry, EntityManager em) {
        return new ProductSetupUtility(entityFactoryRegistry, em);
    }

    @Bean
    public CartSetupUtility cartSetupUtility(EntityFactoryRegistry entityFactoryRegistry, EntityManager em){
        return new CartSetupUtility(entityFactoryRegistry, em);
    }

}
