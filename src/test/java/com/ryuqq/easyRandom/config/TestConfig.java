package com.ryuqq.easyRandom.config;

import com.ryuqq.easyRandom.dummy.DummyDataFactory;
import com.ryuqq.easyRandom.dummy.EntityFactoryRegistry;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

import java.util.List;

@TestConfiguration
public class TestConfig {

    @Bean
    public EntityFactoryRegistry entityFactoryRegistry(List<DummyDataFactory<?>> factories) {
        return new EntityFactoryRegistry(factories);
    }

}
