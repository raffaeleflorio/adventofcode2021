package io.github.raffaeleflorio.adventofcode2021.day1;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

class PreviousBasedIncreasesTest {
  @Test
  void countWithEmptyReport() {
    assertThat(
      new PreviousBasedIncreases(new Report.Fake()).count(),
      equalTo(0L)
    );
  }

  @Test
  void countOfExample() {
    assertThat(
      new PreviousBasedIncreases(
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
      equalTo(7L)
    );
  }
}
