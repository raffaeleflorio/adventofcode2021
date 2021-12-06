package io.github.adventofcode2021.day3;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

class OxygenGeneratorRatingTest {
  @Test
  void decimalOfExampleRating() {
    assertThat(
      new OxygenGeneratorRating(
        "00100",
        "11110",
        "10110",
        "10111",
        "10101",
        "01111",
        "00111",
        "11100",
        "10000",
        "11001",
        "00010",
        "01010"
      ).decimal(),
      equalTo(23L)
    );
  }
}
