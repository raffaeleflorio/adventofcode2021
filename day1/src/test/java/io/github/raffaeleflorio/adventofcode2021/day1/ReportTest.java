package io.github.raffaeleflorio.adventofcode2021.day1;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.IsEmptyCollection.empty;
import static org.hamcrest.collection.IsIterableContainingInOrder.contains;

class ReportTest {
  @Nested
  class FakeTest {
    @Test
    void emptyMeasurements() {
      assertThat(
        new Report.Fake().measurements(),
        empty()
      );
    }

    @Test
    void measurements() {
      assertThat(
        new Report.Fake(List.of(1L, 2L, 3L, 0L)).measurements(),
        contains(1L, 2L, 3L, 0L)
      );
    }
  }
}
