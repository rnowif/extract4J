package com.nrhumla.extract4j.core;

public class ExtractionStreamBuilder<S, D> {

    private final ExtractionSource<S> extractionSource;
    private final ExtractionMapper<S, D> extractionMapper;

    public ExtractionStreamBuilder(ExtractionSource<S> extractionSource, ExtractionMapper<S, D> extractionMapper) {
        this.extractionSource = extractionSource;
        this.extractionMapper = extractionMapper;
    }

    public static <S> ExtractionStreamBuilder<S, S> from(ExtractionSource<S> extractionSource) {
        return new ExtractionStreamBuilder<>(extractionSource, source -> source);
    }

    public <D2> ExtractionStreamBuilder<S, D2> map(ExtractionMapper<S, D2> extractionMapper) {
        return new ExtractionStreamBuilder<>(extractionSource, extractionMapper);
    }

    public ExtractionStream<S, D> to(ExtractionDestination<D> extractionDestination) {
        return new ExtractionStream<>(extractionSource, extractionMapper, extractionDestination);
    }
}
