package com.ryuqq.easyRandom.dummy;


public interface DummyDataFactory<T>{
    T createDummy(long... ids);

}
