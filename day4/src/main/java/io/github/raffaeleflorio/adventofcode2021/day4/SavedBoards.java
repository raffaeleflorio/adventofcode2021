package io.github.raffaeleflorio.adventofcode2021.day4;

import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * Boards saved according this format:
 * a b c d e
 * f g h i j
 * k l m n o
 * p q r s t
 * u v w x y
 * \n
 * \n
 * a b c d e
 * f g h i j
 * k l m n o
 * p q r s t
 * u v w x y
 * \n
 * \n
 * a b c d e
 * f g h i j
 * k l m n o
 * p q r s t
 * u v w x y
 *
 * @author Raffaele Florio (raffaeleflorio@protonmail.com)
 */
public final class SavedBoards implements Boards {
  private final Boards origin;

  public SavedBoards(final List<String> savedBoards) {
    this(
      new BoardsFromCollection(
        new SavedBoardsAsList(
          savedBoards,
          SavedBoard::new
        )
      )
    );
  }

  SavedBoards(final Boards origin) {
    this.origin = origin;
  }

  @Override
  public Boards mark(final Long number) {
    return origin.mark(number);
  }

  @Override
  public Boards filter(final Predicate<Board> filter) {
    return origin.filter(filter);
  }

  @Override
  public Iterator<Board> iterator() {
    return origin.iterator();
  }

  private final static class SavedBoardsAsList extends AbstractList<Board> {
    private final List<String> savedBoards;
    private final Function<String, Board> boardFn;

    private SavedBoardsAsList(final List<String> savedBoards, final Function<String, Board> boardFn) {
      this.savedBoards = savedBoards;
      this.boardFn = boardFn;
    }

    @Override
    public Board get(final int index) {
      return boardFn.apply(savedBoards.get(index));
    }

    @Override
    public int size() {
      return savedBoards.size();
    }
  }
}
