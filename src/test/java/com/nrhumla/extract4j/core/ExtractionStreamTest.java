package com.nrhumla.extract4j.core;

import org.junit.Test;
import reactor.core.publisher.Flux;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.hasItems;
import static org.junit.Assert.*;

public class ExtractionStreamTest {
    
    @Test
    public void should_extract_from_input_and_load_to_output() {
        List<String> output = new ArrayList<>();

        new ExtractionStream<>(
                () -> Flux.just("a", "b", "c"),
                String::toUpperCase,
                output::add
        ).run();

        assertThat(output, hasItems("A", "B", "C"));
    }


}