package io.github.raffaeleflorio.adventofcode2021.day5;

import org.junit.jupiter.api.Test;

import static io.github.raffaeleflorio.adventofcode2021.hamcrest.RunnableThrowsWithMessage.throwsWithMessage;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

class DiagonalSegmentTest {
  @Test
  void size() {
    assertThat(
      new DiagonalSegment(
        9, 7,
        7, 9
      ).size(),
      equalTo(3)
    );
  }

  @Test
  void sizeOfNonDiagonalSegment() {
    assertThat(
      new DiagonalSegment(
        7, 0,
        12, 13
      ).size(),
      equalTo(0)
    );
  }

  @Test
  void getLastPointY() {
    assertThat(
      new DiagonalSegment(
        7, 9,
        9, 7
      ).get(2).y(),
      equalTo(7)
    );
  }

  @Test
  void getLastPointX() {
    assertThat(
      new DiagonalSegment(
        7, 9,
        9, 7
      ).get(2).x(),
      equalTo(9)
    );
  }

  @Test
  void getThirdPointX() {
    assertThat(
      new DiagonalSegment(
        5, 5,
        8, 2
      ).get(2).x(),
      equalTo(7)
    );
  }

  @Test
  void getThirdPointY() {
    assertThat(
      new DiagonalSegment(
        5, 5,
        8, 2
      ).get(2).y(),
      equalTo(3)
    );
  }

  @Test
  void getOfNonDiagonalPoints() {
    assertThat(
      () -> new DiagonalSegment(
        7, 0,
        12, 13
      ).get(0),
      throwsWithMessage(IndexOutOfBoundsException.class, "Index out of range: 0")
    );
  }

  @Test
  void getWithNegativeIndex() {
    assertThat(
      () -> new DiagonalSegment(
        7, 9,
        9, 7
      ).get(-1),
      throwsWithMessage(IndexOutOfBoundsException.class, "Index out of range: -1")
    );
  }
}
