package com.ryuqq.easyRandom.dummy;

import org.jeasy.random.api.Randomizer;

import java.util.Map;

public interface DummyDataFactory<T>{
    T createDummy(long... ids);

}
