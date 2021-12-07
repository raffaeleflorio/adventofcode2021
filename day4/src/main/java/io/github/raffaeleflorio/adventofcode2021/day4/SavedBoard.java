package io.github.raffaeleflorio.adventofcode2021.day4;

import java.util.AbstractList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * A board saved in the format:
 * a b c d e
 * f g h i j
 * k l m n o
 * p q r s t
 * u v w x y
 *
 * <p>
 * It's thread safe
 * </p>
 *
 * @author Raffaele Florio (raffaeleflorio@protonmail.com)
 */
public final class SavedBoard implements Board {
  private final Board origin;

  /**
   * Builds board
   *
   * @param savedBoard The board
   */
  public SavedBoard(final String savedBoard) {
    this(
      new ClassicBoard(
        new CachedList<>(
          new SavedRows(savedBoard, Long::parseLong, Arrays::stream)
        ),
        new CachedList<>(
          new SavedColumns(savedBoard, Long::parseLong, Arrays::stream)
        )
      )
    );
  }

  SavedBoard(final Board origin) {
    this.origin = origin;
  }

  @Override
  public Board mark(final Long number) {
    return origin.mark(number);
  }

  @Override
  public List<Long> unmarked() {
    return origin.unmarked();
  }

  @Override
  public List<Long> marked() {
    return origin.marked();
  }

  @Override
  public Boolean winning() {
    return origin.winning();
  }

  private final static class SavedRows extends AbstractList<List<Long>> {
    private final String savedBoard;
    private final Function<String, Long> longFn;
    private final Function<String[], Stream<String>> streamFn;

    private SavedRows(
      final String savedBoard,
      final Function<String, Long> longFn,
      final Function<String[], Stream<String>> streamFn
    ) {
      this.savedBoard = savedBoard;
      this.longFn = longFn;
      this.streamFn = streamFn;
    }

    @Override
    public List<Long> get(final int index) {
      return row(savedRow(index).split("\\s+"));
    }

    private List<Long> row(final String[] cells) {
      return streamFn.apply(cells).filter(s -> !s.isBlank()).map(longFn).collect(Collectors.toUnmodifiableList());
    }

    private String savedRow(final int index) {
      return savedBoard.lines().skip(index).findFirst().get();
    }

    @Override
    public int size() {
      return savedBoard.split("\n").length;
    }
  }

  private final static class SavedColumns extends AbstractList<List<Long>> {
    private final List<List<Long>> rows;

    private SavedColumns(
      final String savedBoard,
      final Function<String, Long> longFn,
      final Function<String[], Stream<String>> streamFn
    ) {
      this(
        new SavedRows(savedBoard, longFn, streamFn)
      );
    }

    private SavedColumns(final List<List<Long>> rows) {
      this.rows = rows;
    }

    @Override
    public List<Long> get(final int index) {
      return rows
        .stream()
        .map(row -> row.get(index))
        .collect(Collectors.toUnmodifiableList());
    }

    @Override
    public int size() {
      return rows.size();
    }
  }
}
