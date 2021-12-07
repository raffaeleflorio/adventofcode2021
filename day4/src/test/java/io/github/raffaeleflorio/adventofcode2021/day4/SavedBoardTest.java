package io.github.raffaeleflorio.adventofcode2021.day4;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.collection.IsEmptyCollection.empty;

class SavedBoardTest {
  @Test
  void winningFalse() {
    assertThat(
      new SavedBoard(
        "14 21 17 24  4\n10 16 15  9 19\n18  8 23 26 20\n22 11 13  6  5\n2  0 12  3  7"
      ).winning(),
      equalTo(false)
    );
  }

  @Test
  void winningRow() {
    assertThat(
      new SavedBoard(
        "14 21 17 24  4\n10 16 15  9 19\n18  8 23 26 20\n22 11 13  6  5\n2  0 12  3  7"
      ).mark(8L).mark(18L).mark(23L).mark(26L).mark(20L).winning(),
      equalTo(true)
    );
  }

  @Test
  void winningColumn() {
    assertThat(
      new SavedBoard(
        "14 21 17 24  4\n10 16 15  9 19\n18  8 23 26 20\n22 11 13  6  5\n2  0 12  3  7"
      ).mark(16L).mark(8L).mark(11L).mark(21L).mark(0L).winning(),
      equalTo(true)
    );
  }

  @Test
  void markedWhenNoMatch() {
    assertThat(
      new SavedBoard(
        "14 21 17 24  4\n10 16 15  9 19\n18  8 23 26 20\n22 11 13  6  5\n2  0 12  3  7"
      ).mark(37828738L).mark(1232131L).mark(3231321L).marked(),
      empty()
    );
  }

  @Test
  void marked() {
    assertThat(
      new SavedBoard(
        "14 21 17 24  4\n10 16 15  9 19\n18  8 23 26 20\n22 11 13  6  5\n2  0 12  3  7"
      ).mark(21L).mark(20L).mark(6L).mark(42L).marked(),
      contains(21L, 20L, 6L)
    );
  }

  @Test
  void unmarked() {
    assertThat(
      new SavedBoard(
        "14 21 17 24  4\n10 16 15  9 19\n18  8 23 26 20\n22 11 13  6  5\n2  0 12  3  7"
      ).mark(22L).mark(11L).mark(13L).mark(6L).mark(5L).unmarked(),
      containsInAnyOrder(14L, 21L, 17L, 24L, 4L, 10L, 16L, 15L, 9L, 19L, 18L, 8L, 23L, 26L, 20L, 2L, 0L, 12L, 3L, 7L)
    );
  }

  @Test
  void fixBlankCharacter() {
    assertThat(
      new SavedBoard(
        " 2 60 64 25 55\n89  1 21 65 41\n 6 12 58 11 68\n23 49 44 91 14\n45 52 99 47 63"
      ).winning(),
      equalTo(false)
    );
  }

  @Test
  void fixWinningWithPartialRow() {
    assertThat(
      new SavedBoard(
        " 2 60 64 25 55\n89  1 21 65 41\n 6 12 58 11 68\n23 49 44 91 14\n45 52 99 47 63"
      ).mark(2L).mark(60L).winning(),
      equalTo(false)
    );
  }

  @Test
  void fixWinningWithPartialColumn() {
    assertThat(
      new SavedBoard(
        " 2 60 64 25 55\n89  1 21 65 41\n 6 12 58 11 68\n23 49 44 91 14\n45 52 99 47 63"
      ).mark(2L).mark(89L).winning(),
      equalTo(false)
    );
  }

  @Test
  void fixWinningWithMarksOfDifferentRow() {
    assertThat(
      new SavedBoard(
        "14 21 17 24  4\n10 16 15  9 19\n18  8 23 26 20\n22 11 13  6  5\n2  0 12  3  7"
      ).mark(18L).mark(8L).mark(23L).mark(26L).mark(20L).mark(2L).winning(),
      equalTo(true)
    );
  }


  @Test
  void fixWinningWithMarksOfDifferentColumn() {
    assertThat(
      new SavedBoard(
        "14 21 17 24  4\n10 16 15  9 19\n18  8 23 26 20\n22 11 13  6  5\n2  0 12  3  7"
      ).mark(21L).mark(16L).mark(8L).mark(11L).mark(0L).mark(17L).mark(14L).winning(),
      equalTo(true)
    );
  }
}
