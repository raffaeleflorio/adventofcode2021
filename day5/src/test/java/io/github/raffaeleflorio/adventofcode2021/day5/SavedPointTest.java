package io.github.raffaeleflorio.adventofcode2021.day5;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

class SavedPointTest {
  @Test
  void x() {
    assertThat(
      new SavedPoint("1,2").x(),
      equalTo(1)
    );
  }

  @Test
  void y() {
    assertThat(
      new SavedPoint("1,2").y(),
      equalTo(2)
    );
  }

  @Test
  void translatedX() {
    assertThat(
      new SavedPoint("1,2").translate(1, -1).x(),
      equalTo(2)
    );
  }

  @Test
  void translatedY() {
    assertThat(
      new SavedPoint("1,2").translate(1, -10).y(),
      equalTo(-8)
    );
  }
}
