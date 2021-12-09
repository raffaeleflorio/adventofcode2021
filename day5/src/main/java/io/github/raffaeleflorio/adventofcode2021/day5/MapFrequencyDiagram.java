package io.github.raffaeleflorio.adventofcode2021.day5;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.function.BiFunction;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * A thread-safe implementation of {@link FrequencyDiagram}. It requires its element to implement equals and hashcode.
 *
 * @param <E> The element type
 * @author Raffaele Florio (raffaeleflorio@protonmail.com)
 */
public final class MapFrequencyDiagram<E> implements FrequencyDiagram<E> {
  private final Map<E, Long> frequencies;
  private final BiFunction<Map<E, Long>, E, Map<E, Long>> updateFn;
  private final Collector<Map.Entry<E, Long>, ?, ConcurrentMap<E, Long>> mapCollector;

  /**
   * Builds mutable thread-safe frequencies
   */
  public MapFrequencyDiagram() {
    this(
      new ConcurrentHashMap<>(),
      (result, element) -> {
        result.merge(element, 1L, (k, v) -> v + 1);
        return result;
      },
      Collectors.toConcurrentMap(Map.Entry::getKey, Map.Entry::getValue)
    );
  }

  MapFrequencyDiagram(
    final Map<E, Long> frequencies,
    final BiFunction<Map<E, Long>, E, Map<E, Long>> updateFn,
    final Collector<Map.Entry<E, Long>, ?, ConcurrentMap<E, Long>> mapCollector
  ) {
    this.frequencies = frequencies;
    this.updateFn = updateFn;
    this.mapCollector = mapCollector;
  }

  @Override
  public FrequencyDiagram<E> increment(final E element) {
    return new MapFrequencyDiagram<>(
      updateFn.apply(frequencies, element),
      updateFn,
      mapCollector
    );
  }

  @Override
  public FrequencyDiagram<E> cut(final Long threshold) {
    return new MapFrequencyDiagram<>(
      frequencies
        .entrySet()
        .stream()
        .filter(entry -> entry.getValue() >= threshold)
        .collect(mapCollector),
      updateFn,
      mapCollector
    );
  }

  @Override
  public Long count() {
    return Long.valueOf(frequencies.size());
  }
}
