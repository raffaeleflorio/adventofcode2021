package io.github.adventofcode2021.day3;

import java.nio.file.Path;
import java.util.List;

/**
 * A report saved at path
 *
 * @author Raffaele Florio (raffaeleflorio@protonmail.com)
 */
public final class ReportAtPath implements Report {
  private final Report origin;

  public ReportAtPath(final String path) {
    this(Path.of(path));
  }

  public ReportAtPath(final Path path) {
    this(
      new LineByLineReport(
        new LinesAtPath(path)
      )
    );
  }

  ReportAtPath(final Report origin) {
    this.origin = origin;
  }

  @Override
  public List<BinaryNumber> entries() {
    return origin.entries();
  }
}
