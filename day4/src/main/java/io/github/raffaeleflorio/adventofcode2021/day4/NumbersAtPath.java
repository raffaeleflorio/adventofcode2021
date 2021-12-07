package io.github.raffaeleflorio.adventofcode2021.day4;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.AbstractList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Stream;

/**
 * Numbers at path
 *
 * @author Raffaele Florio (raffaeleflorio@protonmail.com)
 */
public final class NumbersAtPath extends AbstractList<Long> {
  private final Path path;
  private final Function<Path, Stream<String>> linesFn;
  private final Function<String, List<Long>> numbersFn;

  /**
   * Builds numbers
   *
   * @param path The path
   */
  public NumbersAtPath(final String path) {
    this(Path.of(path));
  }

  /**
   * Builds numbers
   *
   * @param path The path
   */
  public NumbersAtPath(final Path path) {
    this(path, NumbersAtPath::lines, SavedNumbers::new);
  }

  NumbersAtPath(
    final Path path,
    final Function<Path, Stream<String>> linesFn,
    final Function<String, List<Long>> numbersFn
  ) {
    this.path = path;
    this.linesFn = linesFn;
    this.numbersFn = numbersFn;
  }

  @Override
  public Long get(final int index) {
    return numbers().get(index);
  }

  private List<Long> numbers() {
    return numbersFn.apply(firstLine());
  }

  private String firstLine() {
    return linesFn.apply(path).findFirst().get();
  }

  @Override
  public int size() {
    return numbers().size();
  }

  private static Stream<String> lines(final Path path) {
    try {
      return Files.lines(path);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }
}
