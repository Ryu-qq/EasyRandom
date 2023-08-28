package com.ryuqq.easyRandom.dummy;

import com.ryuqq.easyRandom.domain.cart.Cart;
import com.ryuqq.easyRandom.domain.product.Product;
import com.ryuqq.easyRandom.domain.product.ProductGroup;
import com.ryuqq.easyRandom.repository.RepositoryTest;
import com.ryuqq.easyRandom.repository.SetUpCartDummyRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class TestDummyData extends SetUpCartDummyRepository {

    @Test
    public void testProductDummyDataCreation() {

        //Todo :: 여기서 CRUD 테스트를 진행한다.
        showDummyData();
    }

}


