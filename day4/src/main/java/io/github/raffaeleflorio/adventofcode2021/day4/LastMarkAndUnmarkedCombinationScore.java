package io.github.raffaeleflorio.adventofcode2021.day4;

import java.util.function.BinaryOperator;

/**
 * A score based on a combination of last marked value and on an unmarked aggregation
 *
 * @author Raffaele Florio (raffaeleflorio@protonmail.com)
 */
public final class LastMarkAndUnmarkedCombinationScore implements Score {
  private final Board board;
  private final Long aggregationIdentity;
  private final BinaryOperator<Long> aggregationOp;
  private final BinaryOperator<Long> combinationOp;

  /**
   * Builds a score
   *
   * @param board               The winning board
   * @param aggregationIdentity The unmarked aggregation identity
   * @param aggregationOp       The unmarked aggregation operator
   * @param combinationOp       The last mark and aggregated unmarked combination operator
   */
  public LastMarkAndUnmarkedCombinationScore(
    final Board board,
    final Long aggregationIdentity,
    final BinaryOperator<Long> aggregationOp,
    final BinaryOperator<Long> combinationOp
  ) {
    this.board = board;
    this.aggregationIdentity = aggregationIdentity;
    this.aggregationOp = aggregationOp;
    this.combinationOp = combinationOp;
  }

  @Override
  public Long value() {
    return combinationOp.apply(unmarkedAggregation(), lastMark());
  }

  private Long unmarkedAggregation() {
    return board.unmarked().stream().reduce(aggregationIdentity, aggregationOp);
  }

  private Long lastMark() {
    var marked = board.marked();
    return marked.get(marked.size() - 1);
  }
}
