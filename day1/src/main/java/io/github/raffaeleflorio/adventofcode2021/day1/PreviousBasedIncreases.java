package io.github.raffaeleflorio.adventofcode2021.day1;

/**
 * Measurement increases
 *
 * @author Raffaele Florio (raffaeleflorio@protonmail.com)
 */
public final class PreviousBasedIncreases implements Increases {
  private final Increases origin;

  /**
   * Builds increases from a report
   *
   * @param report The report
   */
  public PreviousBasedIncreases(final Report report) {
    this(
      new SlidingWindowIncreases(
        report,
        1
      )
    );
  }

  PreviousBasedIncreases(final Increases origin) {
    this.origin = origin;
  }

  @Override
  public Long count() {
    return origin.count();
  }
}
