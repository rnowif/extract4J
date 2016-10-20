package com.nrhumla.extract4j.core;

import reactor.core.publisher.Flux;

@FunctionalInterface
public interface ExtractionSource<T> {
    Flux<T> load();
}
