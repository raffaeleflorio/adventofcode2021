package io.github.raffaeleflorio.adventofcode2021.day2;

/**
 * A submarine for part two.
 *
 * <p>
 * It's thread-safe
 * </p>
 *
 * @author Raffaele Florio (raffaeleflorio@protonmail.com)
 */
public final class PartTwoSubmarine implements Submarine {
  private final Long depth;
  private final Long horizontal;
  private final Long aim;

  /**
   * Builds a submarine at rest. This mean with a zero multiplication.
   */
  public PartTwoSubmarine() {
    this(0, 0, 0);
  }

  /**
   * Builds a submarine
   *
   * @param depth      The depth
   * @param horizontal The horizontal position
   * @param aim        The aim
   */
  PartTwoSubmarine(final Integer depth, final Integer horizontal, final Integer aim) {
    this(depth.longValue(), horizontal.longValue(), aim.longValue());
  }

  /**
   * Builds a submarine
   *
   * @param depth      The depth
   * @param horizontal The horizontal position
   * @param aim        The aim
   */
  PartTwoSubmarine(final Long depth, final Long horizontal, final Long aim) {
    this.depth = depth;
    this.horizontal = horizontal;
    this.aim = aim;
  }

  @Override
  public Submarine down(final Long units) {
    return new PartTwoSubmarine(depth, horizontal, aim + units);
  }

  @Override
  public Submarine up(final Long units) {
    return new PartTwoSubmarine(depth, horizontal, aim - units);
  }

  @Override
  public Submarine forward(final Long units) {
    return new PartTwoSubmarine(depth + (aim * units), horizontal + units, aim);
  }

  @Override
  public Long multiplication() {
    return depth * horizontal;
  }
}
