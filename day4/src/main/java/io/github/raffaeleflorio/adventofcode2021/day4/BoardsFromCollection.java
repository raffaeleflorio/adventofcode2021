package io.github.raffaeleflorio.adventofcode2021.day4;

import java.util.Collection;
import java.util.Iterator;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * {@link Boards} from a {@link Collection} of {@link Board}
 *
 * @author Raffaele Florio (raffaeleflorio@protonmail.com)
 */
public final class BoardsFromCollection implements Boards {
  private final Collection<Board> boards;

  /**
   * Builds boards
   *
   * @param boards The boards
   */
  public BoardsFromCollection(final Collection<Board> boards) {
    this.boards = boards;
  }


  @Override
  public Boards mark(final Long number) {
    return new BoardsFromCollection(
      boards.stream().map(board -> board.mark(number)).collect(Collectors.toUnmodifiableList())
    );
  }

  @Override
  public Boards filter(final Predicate<Board> filter) {
    return new BoardsFromCollection(
      boards.stream().filter(filter).collect(Collectors.toUnmodifiableList())
    );
  }

  @Override
  public Iterator<Board> iterator() {
    return boards.iterator();
  }
}
