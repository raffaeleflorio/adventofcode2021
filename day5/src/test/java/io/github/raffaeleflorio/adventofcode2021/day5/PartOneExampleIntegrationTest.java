package io.github.raffaeleflorio.adventofcode2021.day5;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.function.BiFunction;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class PartOneExampleIntegrationTest {
  @Test
  void count() {
    assertThat(
      new TwoOverlappingPoints(
        new SavedVents(
          List.of(
            "0,9 -> 5,9",
            "8,0 -> 0,8",
            "9,4 -> 3,4",
            "2,2 -> 2,1",
            "7,0 -> 7,4",
            "6,4 -> 2,0",
            "0,9 -> 2,9",
            "3,4 -> 1,4",
            "0,0 -> 8,8",
            "5,5 -> 8,2"
          ),
          (BiFunction<Point, Point, Segment>) StraightSegment::new
        ),
        new PointFrequencies()
      ).count(),
      equalTo(5L)
    );
  }
}
