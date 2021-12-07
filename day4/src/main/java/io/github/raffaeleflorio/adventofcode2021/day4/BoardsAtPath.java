package io.github.raffaeleflorio.adventofcode2021.day4;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * A boards saved at a path
 *
 * @author Raffaele Florio (raffaeleflorio@protonmail.com)
 */
public final class BoardsAtPath implements Boards {
  private final Path path;
  private final Function<Path, String> readFn;
  private final Function<String[], List<String>> listFn;
  private final Function<List<String>, Boards> boardsFn;

  /**
   * Builds boards
   *
   * @param path The path
   */
  public BoardsAtPath(final String path) {
    this(Path.of(path));
  }

  /**
   * Builds boards
   *
   * @param path The path
   */
  public BoardsAtPath(final Path path) {
    this(path, BoardsAtPath::readString, Arrays::asList, SavedBoards::new);
  }

  BoardsAtPath(
    final Path path,
    final Function<Path, String> readFn,
    final Function<String[], List<String>> listFn,
    final Function<List<String>, Boards> boardsFn
  ) {
    this.path = path;
    this.readFn = readFn;
    this.listFn = listFn;
    this.boardsFn = boardsFn;
  }

  @Override
  public Boards mark(final Long number) {
    return boards().mark(number);
  }

  private Boards boards() {
    var lines = readFn.apply(path).split("\n\n");
    return boardsFn.apply(listFn.apply(lines).subList(1, lines.length));
  }

  @Override
  public Boards filter(final Predicate<Board> filter) {
    return boards().filter(filter);
  }

  @Override
  public Iterator<Board> iterator() {
    return boards().iterator();
  }

  private static String readString(final Path path) {
    try {
      return Files.readString(path);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }
}
