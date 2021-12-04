package io.github.raffaeleflorio.adventofcode2021.day1;

/**
 * Sliding window measurement increases
 *
 * @author Raffaele Florio (raffaeleflorio@protonmail.com)
 */
public final class SlidingWindowIncreases implements Increases {
  private final Report report;
  private final Integer window;

  /**
   * Builds an increases with a three-measurement sliding window
   *
   * @param report The report
   */
  public SlidingWindowIncreases(final Report report) {
    this(report, 3);
  }

  /**
   * Builds an increases with a custom sliding window size
   *
   * @param report The report
   * @param window The window size
   */
  public SlidingWindowIncreases(final Report report, final Integer window) {
    this.report = report;
    this.window = window;
  }

  @Override
  public Long count() {
    var result = 0L;
    var measurements = report.measurements();
    for (var i = 0; i < measurements.size() - window; i++) {
      var current = measurements.stream().skip(i).limit(window).reduce(0L, Long::sum);
      var next = current + measurements.get(i + window) - measurements.get(i);
      result = next > current ? result + 1 : result;
    }
    return result;
  }
}
