package io.github.adventofcode2021.day3;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

class StringAsBinaryNumberTest {
  @Test
  void decimal() {
    assertThat(
      new StringAsBinaryNumber("101010").decimal(),
      equalTo(42L)
    );
  }

  @Test
  void inverse() {
    assertThat(
      new StringAsBinaryNumber("10110").inverse().decimal(),
      equalTo(9L)
    );
  }

  @Test
  void length() {
    assertThat(
      new StringAsBinaryNumber("0101010101").length(),
      equalTo(10)
    );
  }

  @Test
  void one() {
    assertThat(
      new StringAsBinaryNumber("0001000").one(3),
      equalTo(true)
    );
  }
}
