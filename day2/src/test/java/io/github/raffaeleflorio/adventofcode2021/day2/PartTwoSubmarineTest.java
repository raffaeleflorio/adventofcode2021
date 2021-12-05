package io.github.raffaeleflorio.adventofcode2021.day2;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

class PartTwoSubmarineTest {
  @Test
  void multiplicationAtRest() {
    assertThat(
      new PartTwoSubmarine().multiplication(),
      equalTo(0L)
    );
  }

  @Test
  void multiplication() {
    assertThat(
      new PartTwoSubmarine(3, 5, 7).multiplication(),
      equalTo(15L)
    );
  }

  @Test
  void up() {
    assertThat(
      new PartTwoSubmarine(2, 5, 7).up(3L).multiplication(),
      equalTo(10L)
    );
  }

  @Test
  void down() {
    assertThat(
      new PartTwoSubmarine(12, 6, 123).down(3L).multiplication(),
      equalTo(72L)
    );
  }

  @Test
  void forward() {
    assertThat(
      new PartTwoSubmarine(8, 3, 14).forward(7L).multiplication(),
      equalTo(1060L)
    );
  }
}
