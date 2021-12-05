package io.github.raffaeleflorio.adventofcode2021.day2;

/**
 * A down instruction
 *
 * @author Raffaele Florio (raffaeleflorio@protonmail.com)
 */
public final class Down implements Instruction {
  private final Long units;

  /**
   * Builds a down
   *
   * @param units The units
   */
  public Down(final Integer units) {
    this(units.longValue());
  }

  /**
   * Builds a down
   *
   * @param units The units
   */
  public Down(final Long units) {
    this.units = units;
  }


  @Override
  public Submarine submarine(final Submarine submarine) {
    return submarine.down(units);
  }
}
