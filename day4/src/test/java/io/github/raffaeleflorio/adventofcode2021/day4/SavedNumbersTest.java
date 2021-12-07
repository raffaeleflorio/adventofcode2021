package io.github.raffaeleflorio.adventofcode2021.day4;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.collection.IsIterableContainingInOrder.contains;

class SavedNumbersTest {
  @Test
  void size() {
    assertThat(
      new SavedNumbers("1,2,3,4,5,6,7,8,9,10").size(),
      equalTo(10)
    );
  }

  @Test
  void numbers() {
    assertThat(
      new SavedNumbers("1,2,3,4,5,6"),
      contains(1, 2, 3, 4, 5, 6)
    );
  }
}
