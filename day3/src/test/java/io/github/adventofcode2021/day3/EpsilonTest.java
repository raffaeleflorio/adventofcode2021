package io.github.adventofcode2021.day3;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

class EpsilonTest {
  @Test
  void decimalOfExampleEpsilon() {
    assertThat(
      new Epsilon(
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
      equalTo(9L)
    );
  }

  @Test
  void length() {
    assertThat(
      new Epsilon("000", "101", "111").length(),
      equalTo(3)
    );
  }

  @Test
  void inverseOfExampleEpsilon() {
    assertThat(
      new Epsilon(
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
      ).inverse().decimal(),
      equalTo(22L)
    );
  }

  @Test
  void one() {
    assertThat(
      new Epsilon("011", "011").one(0),
      equalTo(true)
    );
  }

}
