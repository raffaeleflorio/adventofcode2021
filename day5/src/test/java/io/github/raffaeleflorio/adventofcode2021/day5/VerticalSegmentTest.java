package io.github.raffaeleflorio.adventofcode2021.day5;

import org.junit.jupiter.api.Test;

import static io.github.raffaeleflorio.adventofcode2021.hamcrest.RunnableThrowsWithMessage.throwsWithMessage;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

class VerticalSegmentTest {
  @Test
  void size() {
    assertThat(
      new VerticalSegment(
        3, -5,
        3, 0
      ).size(),
      equalTo(6)
    );
  }

  @Test
  void sizeSinglePoint() {
    assertThat(
      new VerticalSegment(
        1, 1,
        1, 1
      ).size(),
      equalTo(1)
    );
  }

  @Test
  void getSinglePoint() {
    assertThat(
      new VerticalSegment(
        1, 0,
        1, 0
      ).get(0).y(),
      equalTo(0)
    );
  }

  @Test
  void getSecondToLastPoint() {
    assertThat(
      new VerticalSegment(
        3, -5,
        3, 0
      ).get(4).y(),
      equalTo(-1)
    );
  }

  @Test
  void getLastPoint() {
    assertThat(
      new VerticalSegment(
        3, -5,
        3, 0
      ).get(5).y(),
      equalTo(0)
    );
  }

  @Test
  void getNonExistentPoint() {
    assertThat(
      () -> new VerticalSegment(
        3, -5,
        3, 0
      ).get(6),
      throwsWithMessage(IndexOutOfBoundsException.class, "Index out of range: 6")
    );
  }

  @Test
  void getOfNonVerticalPoints() {
    assertThat(
      () -> new VerticalSegment(
        123, 3,
        321, 4
      ).get(0),
      throwsWithMessage(IndexOutOfBoundsException.class, "Index out of range: 0")
    );
  }

  @Test
  void sizeOfNonVerticalPoints() {
    assertThat(
      new VerticalSegment(
        123, 3,
        321, 4
      ).size(),
      equalTo(0)
    );
  }

  @Test
  void getWithNegativeIndex() {
    assertThat(
      () -> new VerticalSegment(
        1, 1,
        1, 2
      ).get(-3),
      throwsWithMessage(IndexOutOfBoundsException.class, "Index out of range: -3")
    );
  }
}
