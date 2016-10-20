package com.nrhumla.extract4j.core;

@FunctionalInterface
public interface ExtractionDestination<T> {
    void consume(T value);
}
