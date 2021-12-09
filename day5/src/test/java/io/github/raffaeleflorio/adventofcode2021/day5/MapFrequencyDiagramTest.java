package io.github.raffaeleflorio.adventofcode2021.day5;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

class MapFrequencyDiagramTest {
  @Test
  void countAfterACut() {
    assertThat(
      new MapFrequencyDiagram<Integer>()
        .increment(1)
        .increment(1)
        .increment(1)
        .increment(2)
        .increment(2)
        .increment(3)
        .increment(42)
        .cut(2L)
        .count(),
      equalTo(2L)
    );
  }
}
