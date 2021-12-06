package io.github.adventofcode2021.day3;

import java.util.List;
import java.util.function.Function;

/**
 * Life support rating from a {@link Report}
 *
 * @author Raffaele Florio (raffaeleflorio@protonmail.com)
 */
public final class ReportedLifeSupportRating implements PowerConsumption {
  private final Report report;
  private final Function<List<BinaryNumber>, BinaryNumber> co2RatingFn;
  private final Function<List<BinaryNumber>, BinaryNumber> oxygenRatingFn;

  /**
   * Builds life support rating
   *
   * @param report The report
   */
  public ReportedLifeSupportRating(final Report report) {
    this(report, CO2ScrubberRating::new, OxygenGeneratorRating::new);
  }

  ReportedLifeSupportRating(final Report report, final Function<List<BinaryNumber>, BinaryNumber> co2RatingFn, final Function<List<BinaryNumber>, BinaryNumber> oxygenRatingFn) {
    this.report = report;
    this.co2RatingFn = co2RatingFn;
    this.oxygenRatingFn = oxygenRatingFn;
  }

  @Override
  public Long value() {
    var entries = report.entries();
    return co2RatingFn.apply(entries).decimal() * oxygenRatingFn.apply(entries).decimal();
  }
}
