package io.github.raffaeleflorio.adventofcode2021.day5;

import org.junit.jupiter.api.Test;

import static io.github.raffaeleflorio.adventofcode2021.hamcrest.RunnableThrowsWithMessage.throwsWithMessage;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

class StraightSegmentTest {
  @Test
  void sizeVertical() {
    assertThat(
      new StraightSegment(
        -10, -5,
        -10, 0
      ).size(),
      equalTo(6)
    );
  }

  @Test
  void sizeHorizontal() {
    assertThat(
      new StraightSegment(
        -3, 42,
        3, 42
      ).size(),
      equalTo(7)
    );
  }

  @Test
  void getHorizontal() {
    assertThat(
      new StraightSegment(
        0, 0,
        3, 0
      ).get(1).x(),
      equalTo(1)
    );
  }

  @Test
  void getVertical() {
    assertThat(
      new StraightSegment(
        1, 0,
        1, 0
      ).get(0).y(),
      equalTo(0)
    );
  }

  @Test
  void getOfNonStraightPoints() {
    assertThat(
      () -> new StraightSegment(
        -392, 382,
        8, 1337
      ).get(0),
      throwsWithMessage(IndexOutOfBoundsException.class, "Index out of range: 0")
    );
  }

  @Test
  void sizeOfNonStraightPoints() {
    assertThat(
      new StraightSegment(
        -392, 382,
        8, 1337
      ).size(),
      equalTo(0)
    );
  }
}
