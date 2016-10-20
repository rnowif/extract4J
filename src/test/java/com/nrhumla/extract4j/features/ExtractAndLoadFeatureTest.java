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
    public void should_extract_from_input_and_load_to_output() {
        List<String> output = new ArrayList<>();

        ExtractionStreamBuilder
                .from(() -> Flux.just("a", "b", "c"))
                .to(output::add)
                .run();

        assertThat(output, hasItems("a", "b", "c"));
    }

}
