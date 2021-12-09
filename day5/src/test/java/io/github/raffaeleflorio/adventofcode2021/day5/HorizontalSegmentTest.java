package io.github.raffaeleflorio.adventofcode2021.day5;

import org.junit.jupiter.api.Test;

import static io.github.raffaeleflorio.adventofcode2021.hamcrest.RunnableThrowsWithMessage.throwsWithMessage;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

class HorizontalSegmentTest {
  @Test
  void size() {
    assertThat(
      new HorizontalSegment(
        1, 2,
        6, 2
      ).size(),
      equalTo(6)
    );
  }

  @Test
  void sizeSinglePoint() {
    assertThat(
      new HorizontalSegment(
        1, 1,
        1, 1
      ).size(),
      equalTo(1)
    );
  }

  @Test
  void getSinglePoint() {
    assertThat(
      new HorizontalSegment(
        1, 0,
        1, 0
      ).get(0).x(),
      equalTo(1)
    );
  }

  @Test
  void sizeOfNonHorizontalPoints() {
    assertThat(
      new HorizontalSegment(
        42, 42,
        15, 16
      ).size(),
      equalTo(0)
    );
  }

  @Test
  void getSecondSegmentPoint() {
    assertThat(
      new HorizontalSegment(
        0, 0,
        3, 0
      ).get(1).x(),
      equalTo(1)
    );
  }

  @Test
  void getFirstSegmentPoint() {
    assertThat(
      new HorizontalSegment(
        1, 0,
        4, 0
      ).get(0).x(),
      equalTo(1)
    );
  }

  @Test
  void getLastSegmentPoint() {
    assertThat(
      new HorizontalSegment(
        3, 8,
        8, 8
      ).get(5).x(),
      equalTo(8)
    );
  }

  @Test
  void getNonExistentSegmentPoint() {
    assertThat(
      () -> new HorizontalSegment(
        3, 8,
        8, 8
      ).get(6),
      throwsWithMessage(IndexOutOfBoundsException.class, "Index out of range: 6")
    );
  }

  @Test
  void getSegmentWithSourceGreaterThanDestination() {
    assertThat(
      new HorizontalSegment(
        7, -123,
        3, -123
      ).get(1).x(),
      equalTo(6)
    );
  }

  @Test
  void getOfNonHorizontalPoints() {
    assertThat(
      () -> new HorizontalSegment(
        0, 123,
        3, 321
      ).get(0),
      throwsWithMessage(IndexOutOfBoundsException.class, "Index out of range: 0")
    );
  }

  @Test
  void getWithNegativeIndex() {
    assertThat(
      () -> new HorizontalSegment(
        0, 0,
        3, 0
      ).get(-123),
      throwsWithMessage(IndexOutOfBoundsException.class, "Index out of range: -123")
    );
  }
}
