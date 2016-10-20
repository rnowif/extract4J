package com.nrhumla.extract4j.core;

public class ExtractionStream<T> {

    private final ExtractionSource<T> extractionSource;
    private final ExtractionDestination<T> extractionDestination;

    public ExtractionStream(ExtractionSource<T> extractionSource, ExtractionDestination<T> extractionDestination) {
        this.extractionSource = extractionSource;
        this.extractionDestination = extractionDestination;
    }

    public void run() {
        extractionSource.load().subscribe(extractionDestination::consume);
    }
}
