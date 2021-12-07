package io.github.raffaeleflorio.adventofcode2021.day4;

import java.util.List;

/**
 * Last winning board among multiple boards
 *
 * @author Raffaele Florio (raffaeleflorio@protonmail.com)
 */
public final class LastWinningBoard implements Board {
  private final Boards boards;
  private final List<Long> numbers;

  /**
   * Builds board
   *
   * @param boards  The boards
   * @param numbers The marks
   */
  public LastWinningBoard(final Boards boards, final List<Long> numbers) {
    this.boards = boards;
    this.numbers = numbers;
  }

  @Override
  public Board mark(final Long number) {
    return winningBoard().mark(number);
  }

  private Board winningBoard() {
    var markedBoards = boards.mark(numbers.iterator().next());
    var notWinningBoards = markedBoards.filter(b -> !b.winning());
    if (notWinningBoards.iterator().hasNext()) {
      return new LastWinningBoard(
        notWinningBoards,
        numbers.subList(1, numbers.size())
      );
    }
    return markedBoards.filter(Board::winning).iterator().next();
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
