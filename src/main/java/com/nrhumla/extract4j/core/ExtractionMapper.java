package com.nrhumla.extract4j.core;

@FunctionalInterface
public interface ExtractionMapper<S, D> {
    D map(S source);
}
