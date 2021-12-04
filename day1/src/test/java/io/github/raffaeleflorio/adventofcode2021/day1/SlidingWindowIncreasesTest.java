package io.github.raffaeleflorio.adventofcode2021.day1;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

class SlidingWindowIncreasesTest {
  @Test
  void countWithEmptyReport() {
    assertThat(
      new SlidingWindowIncreases(new Report.Fake()).count(),
      equalTo(0L)
    );
  }

  @Test
  void countOfExample() {
    assertThat(
      new SlidingWindowIncreases(
        new Report.Fake(
          List.of(
            199L,
            200L,
            208L,
            210L,
            200L,
            207L,
            240L,
            269L,
            260L,
            263L
          )
        )
      ).count(),
      equalTo(5L)
    );
  }

  @Test
  void countWithOneMeasurementSlidingWindow() {
    assertThat(
      new SlidingWindowIncreases(
        new Report.Fake(
          List.of(
            1L,
            42L,
            0L,
            -1L,
            0L
          )
        ),
        1
      ).count(),
      equalTo(2L)
    );
  }

  @Test
  void countWithTwoMeasurementsSlidingWindow() {
    assertThat(
      new SlidingWindowIncreases(
        new Report.Fake(
          List.of(
            1L,
            42L,
            0L,
            -1L,
            0L
          )
        ),
        2
      ).count(),
      equalTo(0L)
    );
  }
}
