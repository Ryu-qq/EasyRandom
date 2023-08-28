package com.ryuqq.easyRandom.common;

public interface Provider<K, T> {
    T get(K key);

}
