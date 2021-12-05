package io.github.raffaeleflorio.adventofcode2021.day2;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

class PartOneSubmarineTest {
  @Test
  void multiplicationAtRest() {
    assertThat(
      new PartOneSubmarine().multiplication(),
      equalTo(0L)
    );
  }

  @Test
  void multiplication() {
    assertThat(
      new PartOneSubmarine(11, 11).multiplication(),
      equalTo(121L)
    );
  }

  @Test
  void up() {
    assertThat(
      new PartOneSubmarine(4, 21).up(2L).multiplication(),
      equalTo(42L)
    );
  }

  @Test
  void down() {
    assertThat(
      new PartOneSubmarine(0, 21).down(4L).multiplication(),
      equalTo(84L)
    );
  }

  @Test
  void forward() {
    assertThat(
      new PartOneSubmarine(6, 10).forward(11L).multiplication(),
      equalTo(126L)
    );
  }
}
