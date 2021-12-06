package io.github.adventofcode2021.day3;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.AbstractList;
import java.util.List;

/**
 * Builds lines from a {@link Path}
 *
 * @author Raffaele Florio (raffaeleflorio@protonmail.com)
 */
public final class LinesAtPath extends AbstractList<String> {
  private final List<String> origin;

  /**
   * Builds lines
   *
   * @param path The path
   */
  public LinesAtPath(final String path) {
    this(Path.of(path));
  }

  /**
   * Builds lines
   *
   * @param path The path
   */
  public LinesAtPath(final Path path) {
    this(readAllLines(path));
  }

  LinesAtPath(final List<String> origin) {
    this.origin = origin;
  }

  @Override
  public String get(final int index) {
    return origin.get(index);
  }

  @Override
  public int size() {
    return origin.size();
  }

  private static List<String> readAllLines(final Path path) {
    try {
      return Files.readAllLines(path);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }
}
