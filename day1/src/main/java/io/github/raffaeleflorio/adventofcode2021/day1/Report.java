package io.github.raffaeleflorio.adventofcode2021.day1;

import java.util.List;

/**
 * A sonar sweep report
 *
 * @author Raffaele Florio (raffaeleflorio@protonmail.com)
 */
public interface Report {
  /**
   * Builds the measurements
   *
   * @return The measurements
   */
  List<Long> measurements();

  /**
   * A fake report useful for testing
   *
   * @author Raffaele Florio (raffaeleflorio@protonmail.com)
   */
  final class Fake implements Report {
    private final List<Long> measurements;

    /**
     * Builds an empty fake
     */
    public Fake() {
      this(List.of());
    }

    /**
     * Builds a fake
     *
     * @param measurements The measurements
     */
    public Fake(final List<Long> measurements) {
      this.measurements = measurements;
    }

    @Override
    public List<Long> measurements() {
      return measurements;
    }
  }
}
