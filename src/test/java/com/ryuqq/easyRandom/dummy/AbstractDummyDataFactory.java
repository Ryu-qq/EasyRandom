package com.ryuqq.easyRandom.dummy;

import org.jeasy.random.EasyRandom;
import org.jeasy.random.EasyRandomParameters;
import org.jeasy.random.api.Randomizer;
import org.jeasy.random.randomizers.range.IntegerRangeRandomizer;
import org.jeasy.random.randomizers.range.LongRangeRandomizer;

import java.util.Map;
import java.util.Random;

import static org.jeasy.random.FieldPredicates.inClass;
import static org.jeasy.random.FieldPredicates.named;

public abstract class AbstractDummyDataFactory<T> implements DummyDataFactory<T>  {

    protected abstract Map<String, Randomizer<?>> getFieldRandomizers(long... ids);

    @Override
    public T createDummy(long... ids) {
        if (ids.length == 0) {
            throw new IllegalArgumentException("ids size must be greater than 0");
        }

        Map<String, Randomizer<?>> fieldRandomizers = getFieldRandomizers(ids);
        return createWithParams(fieldRandomizers);
    }

    public T createWithParams(Map<String, Randomizer<?>> fieldRandomizers) {
        EasyRandomParameters parameters = setParam(fieldRandomizers);
        return new EasyRandom(parameters).nextObject(getTypeClass());
    }

    private EasyRandomParameters setParam(Map<String, Randomizer<?>> fieldRandomizers){
        EasyRandomParameters parameters = defaultParameters();
        for (Map.Entry<String, Randomizer<?>> entry : fieldRandomizers.entrySet()) {
            parameters.randomize(named(entry.getKey()).and(inClass(getTypeClass())), entry.getValue());
        }
        return parameters;
    }

    private EasyRandomParameters defaultParameters() {
        return new EasyRandomParameters()
                .stringLengthRange(1, 10)
                .randomize(Long.class, new LongRangeRandomizer(1L, 1000L))
                .randomize(Integer.class, new IntegerRangeRandomizer(1, 1000))
                .randomize(Double.class, () -> Math.abs(new Random().nextDouble() * 1000))
                .randomize(Float.class, () -> Math.abs(new Random().nextFloat() * 1000));
    }
}
