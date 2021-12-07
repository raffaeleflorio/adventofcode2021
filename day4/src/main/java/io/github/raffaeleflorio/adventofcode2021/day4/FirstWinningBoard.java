package io.github.raffaeleflorio.adventofcode2021.day4;

import java.util.List;

/**
 * First winning board among multiple boards
 *
 * @author Raffaele Florio (raffaeleflorio@protonmail.com)
 */
public final class FirstWinningBoard implements Board {
  private final Boards boards;
  private final List<Long> numbers;

  /**
   * Builds board
   *
   * @param boards  The boards
   * @param numbers The marks
   */
  public FirstWinningBoard(final Boards boards, final List<Long> numbers) {
    this.boards = boards;
    this.numbers = numbers;
  }

  @Override
  public Board mark(final Long number) {
    return winningBoard().mark(number);
  }

  private Board winningBoard() {
    var winningBoards = markedBoards().filter(Board::winning).iterator();
    return winningBoards.hasNext() ? winningBoards.next() : nextWinningBoard();
  }

  private Boards markedBoards() {
    return boards.mark(numbers.iterator().next());
  }

  private Board nextWinningBoard() {
    return new FirstWinningBoard(markedBoards(), numbers.subList(1, numbers.size()));
  }

  @Override
  public List<Long> unmarked() {
    return winningBoard().unmarked();
  }

  @Override
  public List<Long> marked() {
    return winningBoard().marked();
  }

  @Override
  public Boolean winning() {
    return winningBoard().winning();
  }
}
