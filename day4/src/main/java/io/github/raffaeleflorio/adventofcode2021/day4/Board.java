package io.github.raffaeleflorio.adventofcode2021.day4;

import java.util.List;

/**
 * A bingo board
 *
 * @author Raffaele Florio (raffaeleflorio@protonmail.com)
 */
public interface Board {
  /**
   * Marks the board with a number
   *
   * @param number The number
   * @return The marked board
   */
  Board mark(Long number);

  /**
   * Builds the list of all unmarked numbers
   *
   * @return The numbers
   */
  List<Long> unmarked();

  /**
   * Builds the list of all marked numbers in order of arrival
   *
   * @return The numbers
   */
  List<Long> marked();

  /**
   * Builds true if the board is winning
   *
   * @return True if winning, otherwise false
   */
  Boolean winning();

  /**
   * A board useful for testing
   *
   * @author Raffaele Florio (raffaeleflorio@protonmail.com)
   */
  final class Fake implements Board {
    private final List<Long> marked;
    private final List<Long> unmarked;
    private final Boolean winning;

    /**
     * Builds a winning fake
     *
     * @param marked   The marked numbers
     * @param unmarked The unmarked numbers
     */
    public Fake(final List<Long> marked, final List<Long> unmarked) {
      this(marked, unmarked, true);
    }

    /**
     * Builds a fake
     *
     * @param marked   The marked numbers
     * @param unmarked The unmarked numbers
     * @param winning  True if the board is winning
     */
    public Fake(final List<Long> marked, final List<Long> unmarked, final Boolean winning) {
      this.marked = marked;
      this.unmarked = unmarked;
      this.winning = winning;
    }

    @Override
    public Board mark(final Long number) {
      return this;
    }

    @Override
    public List<Long> unmarked() {
      return unmarked;
    }

    @Override
    public List<Long> marked() {
      return marked;
    }

    @Override
    public Boolean winning() {
      return winning;
    }
  }
}
