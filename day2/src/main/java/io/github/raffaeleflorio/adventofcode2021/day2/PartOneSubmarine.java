package io.github.raffaeleflorio.adventofcode2021.day2;

/**
 * A submarine for part one.
 *
 * <p>
 * It's thread-safe.
 * </p>
 *
 * @author Raffaele Florio (raffaeleflorio@protonmail.com)
 */
public final class PartOneSubmarine implements Submarine {
  private final Long depth;
  private final Long horizontal;

  /**
   * Builds a submarine at rest. This mean with a zero multiplication.
   */
  public PartOneSubmarine() {
    this(0, 0);
  }

  /**
   * Builds a submarine
   *
   * @param depth      The depth
   * @param horizontal The horizontal position
   */
  PartOneSubmarine(final Integer depth, final Integer horizontal) {
    this(depth.longValue(), horizontal.longValue());
  }

  /**
   * Builds a submarine
   *
   * @param depth      The depth
   * @param horizontal The horizontal position
   */
  PartOneSubmarine(final Long depth, final Long horizontal) {
    this.depth = depth;
    this.horizontal = horizontal;
  }

  @Override
  public Submarine down(final Long units) {
    return new PartOneSubmarine(depth + units, horizontal);
  }

  @Override
  public Submarine up(final Long units) {
    return new PartOneSubmarine(depth - units, horizontal);
  }

  @Override
  public Submarine forward(final Long units) {
    return new PartOneSubmarine(depth, horizontal + units);
  }

  @Override
  public Long multiplication() {
    return depth * horizontal;
  }
}
