package com.nrhumla.extract4j.core;

@FunctionalInterface
public interface ExtractionMapper<S, D> {
    D map(S source);

    default <D2> ExtractionMapper<S, D2> andThen(ExtractionMapper<D, D2> extractionMapper) {
        return source -> extractionMapper.map(map(source));
    }
}
