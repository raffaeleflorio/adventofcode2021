package io.github.raffaeleflorio.adventofcode2021.day2;

/**
 * A submarine
 *
 * @author Raffaele Florio (raffaeleflorio@protonmail.com)
 */
public interface Submarine {
  /**
   * Goes down
   *
   * @param units The units
   * @return The moved submarine
   */
  Submarine down(Long units);

  /**
   * Goes up
   *
   * @param units The units
   * @return The moved submarine
   */
  Submarine up(Long units);

  /**
   * Forwards
   *
   * @param units The units
   * @return The forwarded submarine
   */
  Submarine forward(Long units);

  /**
   * Builds the multiplication between depth and horizontal position
   *
   * @return The multiplication
   */
  Long multiplication();
}
