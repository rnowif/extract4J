package com.nrhumla.extract4j.core;

public class ExtractionStreamBuilder<T> {

    private final ExtractionSource<T> extractionSource;

    public ExtractionStreamBuilder(ExtractionSource<T> extractionSource) {
        this.extractionSource = extractionSource;
    }

    public static <S> ExtractionStreamBuilder<S> from(ExtractionSource<S> extractionSource) {
        return new ExtractionStreamBuilder<>(extractionSource);
    }

    public ExtractionStream<T> to(ExtractionDestination<T> extractionDestination) {
        return new ExtractionStream<>(extractionSource, extractionDestination);
    }
}
