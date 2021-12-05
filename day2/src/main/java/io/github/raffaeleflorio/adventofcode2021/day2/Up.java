package io.github.raffaeleflorio.adventofcode2021.day2;

/**
 * An up instruction
 *
 * @author Raffaele Florio (raffaeleflorio@protonmail.com)
 */
public final class Up implements Instruction {
  private final Long units;

  /**
   * Builds an up
   *
   * @param units The units
   */
  public Up(final Integer units) {
    this(units.longValue());
  }

  /**
   * Builds an up
   *
   * @param units The units
   */
  public Up(final Long units) {
    this.units = units;
  }

  @Override
  public Submarine submarine(final Submarine submarine) {
    return submarine.up(units);
  }
}
