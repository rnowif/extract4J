package com.nrhumla.extract4j.features;

import com.nrhumla.extract4j.core.ExtractionStreamBuilder;
import org.junit.Test;
import reactor.core.publisher.Flux;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.hasItems;
import static org.junit.Assert.assertThat;

public class ExtractAndLoadFeatureTest {
    
    @Test
    public void should_extract_from_input_and_load_to_output_with_no_transformation() {
        List<String> output = new ArrayList<>();

        ExtractionStreamBuilder
                .from(() -> Flux.just("a", "b", "c"))
                .to(output::add)
                .run();

        assertThat(output, hasItems("a", "b", "c"));
    }

    @Test
    public void should_extract_from_input_and_load_to_output_with_transformation() {
        List<String> output = new ArrayList<>();

        ExtractionStreamBuilder
                .from(() -> Flux.just(0, 1, 2))
                .map(Object::toString)
                .to(output::add)
                .run();

        assertThat(output, hasItems("0", "1", "2"));
    }

    @Test
    public void should_extract_from_input_and_load_to_output_with_multiple_transformations() {
        List<String> output = new ArrayList<>();

        ExtractionStreamBuilder
                .from(() -> Flux.just(0, 1, 2))
                .map(source -> source + 1)
                .map(Object::toString)
                .to(output::add)
                .run();

        assertThat(output, hasItems("1", "2", "3"));
    }

}
