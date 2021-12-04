package io.github.raffaeleflorio.adventofcode2021.day1;

import java.util.List;
import java.util.stream.Collectors;

/**
 * A report made line by line
 *
 * @author Raffaele Florio (raffaeleflorio@protonmail.com)
 */
public final class LineByLineReport implements Report {
  private final List<String> lines;

  /**
   * Builds a report
   *
   * @param lines The lines
   */
  public LineByLineReport(final List<String> lines) {
    this.lines = lines;
  }

  @Override
  public List<Long> measurements() {
    return lines.stream().map(Long::parseLong).collect(Collectors.toUnmodifiableList());
  }
}
