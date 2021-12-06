package io.github.adventofcode2021.day3;

import java.util.List;
import java.util.function.Function;

/**
 * Power consumption from a {@link Report}
 *
 * @author Raffaele Florio (raffaeleflorio@protonmail.com)
 */
public final class ReportedPowerConsumption implements PowerConsumption {
  private final Report report;
  private final Function<List<BinaryNumber>, BinaryNumber> gammaFn;

  /**
   * Builds a power consumption
   *
   * @param report The report
   */
  public ReportedPowerConsumption(final Report report) {
    this(report, Gamma::new);
  }

  ReportedPowerConsumption(final Report report, final Function<List<BinaryNumber>, BinaryNumber> gammaFn) {
    this.report = report;
    this.gammaFn = gammaFn;
  }

  @Override
  public Long value() {
    var gamma = gammaFn.apply(report.entries());
    var epsilon = gamma.inverse();
    return gamma.decimal() * epsilon.decimal();
  }
}
