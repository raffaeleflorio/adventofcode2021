package io.github.adventofcode2021.day3;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * A line by line report
 *
 * @author Raffaele Florio (raffaeleflorio@protonmail.com)
 */
public final class LineByLineReport implements Report {
  private final List<String> entries;
  private final Function<String, BinaryNumber> numberFn;

  /**
   * Builds a report
   *
   * @param entries The report entries
   */
  public LineByLineReport(final List<String> entries) {
    this(entries, StringAsBinaryNumber::new);
  }

  LineByLineReport(final List<String> entries, final Function<String, BinaryNumber> numberFn) {
    this.entries = entries;
    this.numberFn = numberFn;
  }

  @Override
  public List<BinaryNumber> entries() {
    return entries.stream().map(numberFn).collect(Collectors.toUnmodifiableList());
  }
}
