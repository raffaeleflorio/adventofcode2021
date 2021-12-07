package io.github.raffaeleflorio.adventofcode2021.day4;

/**
 * A score with standard rule. This means all unmarked board numbers multiplied for the last board mark
 *
 * @author Raffaele Florio (raffaeleflorio@protonmail.com)
 */
public final class StandardScore implements Score {
  private final Score origin;

  /**
   * Builds score
   *
   * @param board The winning board
   */
  public StandardScore(final Board board) {
    this(
      new LastMarkAndUnmarkedCombinationScore(
        board,
        0L,
        Long::sum,
        (x, y) -> x * y)
    );
  }

  StandardScore(final Score origin) {
    this.origin = origin;
  }

  @Override
  public Long value() {
    return origin.value();
  }
}
