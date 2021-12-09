package io.github.raffaeleflorio.adventofcode2021.day5;

/**
 * A constant point
 *
 * @author Raffaele Florio (raffaeleflorio@protonmail.com)
 */
public final class ConstPoint implements Point {
  private final Integer x;
  private final Integer y;

  /**
   * Builds point
   *
   * @param x The x coordinate
   * @param y The y coordinate
   */
  public ConstPoint(final Integer x, final Integer y) {
    this.x = x;
    this.y = y;
  }

  @Override
  public Point translate(final Integer deltaX, final Integer deltaY) {
    return new ConstPoint(x + deltaX, y + deltaY);
  }

  @Override
  public Integer x() {
    return x;
  }

  @Override
  public Integer y() {
    return y;
  }
}
