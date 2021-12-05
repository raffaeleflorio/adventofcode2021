package io.github.raffaeleflorio.adventofcode2021.day2;

/**
 * A forward instruction
 *
 * @author Raffaele Florio (raffaeleflorio@protonmail.com)
 */
public final class Forward implements Instruction {
  private final Long units;

  /**
   * Builds a forward
   *
   * @param units The units
   */
  public Forward(final Integer units) {
    this(units.longValue());
  }

  /**
   * Builds a forward
   *
   * @param units The units
   */
  public Forward(final Long units) {
    this.units = units;
  }

  @Override
  public Submarine submarine(final Submarine submarine) {
    return submarine.forward(units);
  }
}
