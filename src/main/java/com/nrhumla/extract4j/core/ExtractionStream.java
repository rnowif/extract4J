package com.nrhumla.extract4j.core;

public class ExtractionStream<S, D> {

    private final ExtractionSource<S> extractionSource;
    private final ExtractionDestination<D> extractionDestination;
    private final ExtractionMapper<S, D> extractionMapper;

    public ExtractionStream(ExtractionSource<S> extractionSource, ExtractionMapper<S, D> extractionMapper, ExtractionDestination<D> extractionDestination) {
        this.extractionSource = extractionSource;
        this.extractionMapper = extractionMapper;
        this.extractionDestination = extractionDestination;
    }

    public void run() {
        extractionSource.load()
                .map(extractionMapper::map)
                .subscribe(extractionDestination::consume);
    }
}
