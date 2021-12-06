package io.github.adventofcode2021.day3;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

class GammaTest {
  @Test
  void decimalOfExampleGamma() {
    assertThat(
      new Gamma(
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
      equalTo(22L)
    );
  }

  @Test
  void length() {
    assertThat(
      new Gamma("000", "101", "111").length(),
      equalTo(3)
    );
  }

  @Test
  void inverseOfExampleGamma() {
    assertThat(
      new Gamma(
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
      equalTo(9L)
    );
  }

  @Test
  void one() {
    assertThat(
      new Gamma("011", "011").one(0),
      equalTo(false)
    );
  }
}
