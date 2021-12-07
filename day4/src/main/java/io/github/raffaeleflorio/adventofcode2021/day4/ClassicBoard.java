package io.github.raffaeleflorio.adventofcode2021.day4;

import java.util.List;
import java.util.function.BiFunction;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * A classic bingo board
 *
 * @author Raffaele Florio (raffaeleflorio@protonmail.com)
 */
public final class ClassicBoard implements Board {
  private final List<List<Long>> rows;
  private final List<List<Long>> columns;
  private final List<Long> marked;
  private final BiFunction<List<Long>, Long, List<Long>> appendFn;

  /**
   * Builds a board
   *
   * @param rows    The rows
   * @param columns The columns
   */
  public ClassicBoard(final List<List<Long>> rows, final List<List<Long>> columns) {
    this(
      rows,
      columns,
      List.of(),
      (x, y) -> Stream.concat(x.stream(), Stream.of(y)).collect(Collectors.toUnmodifiableList())
    );
  }

  ClassicBoard(
    final List<List<Long>> rows,
    final List<List<Long>> columns,
    final List<Long> marked,
    final BiFunction<List<Long>, Long, List<Long>> appendFn
  ) {
    this.rows = rows;
    this.columns = columns;
    this.marked = marked;
    this.appendFn = appendFn;
  }

  @Override
  public Board mark(final Long number) {
    return new ClassicBoard(
      rows,
      columns,
      unmarked().contains(number) ? appendFn.apply(marked, number) : marked,
      appendFn
    );
  }

  @Override
  public List<Long> unmarked() {
    return rows
      .stream()
      .flatMap(List::stream)
      .filter(x -> !marked.contains(x))
      .collect(Collectors.toUnmodifiableList());
  }

  @Override
  public List<Long> marked() {
    return marked;
  }

  @Override
  public Boolean winning() {
    return anyMarkedFully(rows) || anyMarkedFully(columns);
  }

  private Boolean anyMarkedFully(final List<List<Long>> values) {
    return values.stream().anyMatch(value -> value.size() <= marked.size() && marked.containsAll(value));
  }
}
