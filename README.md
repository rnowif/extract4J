# Extract4J

## Goal

Extract4J is a reactive library based upon Reactor 3.0 to extract, transform and load data from any source and to any destination.

## Usage

Load from a source to a destination with no transformation :

```java
List<String> output = new ArrayList<>();

ExtractionStreamBuilder
        .from(() -> Flux.just("a", "b", "c"))
        .to(output::add)
        .run();

assertThat(output, hasItems("a", "b", "c"));
```

Load from a source to a destination with a transformation

```java
List<String> output = new ArrayList<>();

ExtractionStreamBuilder
        .from(() -> Flux.just(0, 1, 2))
        .map(Object::toString)
        .to(output::add)
        .run();

assertThat(output, hasItems("0", "1", "2"));
```

Load from a source to a destination with multiple transformations


```java
List<String> output = new ArrayList<>();

ExtractionStreamBuilder
        .from(() -> Flux.just(0, 1, 2))
        .map(source -> source + 1)
        .map(Object::toString)
        .to(output::add)
        .run();

assertThat(output, hasItems("1", "2", "3"));
```