package io.github.raffaeleflorio.adventofcode2021.day4;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

class StandardScoreTest {
  @Test
  void valueOfExample() {
    assertThat(
      new StandardScore(
        new Board.Fake(
          marked(
            7L, 4L, 9L, 5L, 11L, 17L, 23L, 2L, 0L, 14L, 21L, 24L
          ),
          unmarked(
            10L, 16L, 15L, 19L, 18L, 8L, 26L, 20L, 22L, 13L, 6L, 12L, 3L
          )
        )
      ).value(),
      equalTo(4512L)
    );
  }

  private List<Long> marked(final Long... numbers) {
    return Arrays.asList(numbers);
  }

  private List<Long> unmarked(final Long... numbers) {
    return Arrays.asList(numbers);
  }
}
