package org.example;

import java.util.function.Function;

public record KeyValue<K, V>(K key, V value) {

    /**
     * The purpose of the method is to transform the value of the KeyValue pair by applying a Function to it, returning
     * a new KeyValue with the same key as the KeyValue that the method is called on,
     * and a new value that is the result of applying the Function to the value.
     * @param mapper
     * @return
     * @param <T>
     */
    public <T> KeyValue<K, T> mapValue(Function<V, T> mapper) {
        T apply = mapper.apply(value);
        return new KeyValue<>(key, apply);
    }
}
