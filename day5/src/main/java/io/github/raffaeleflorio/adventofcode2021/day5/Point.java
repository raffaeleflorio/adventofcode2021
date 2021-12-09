package io.github.raffaeleflorio.adventofcode2021.day5;

/**
 * A 2D point
 *
 * @author Raffaele Florio (raffaeleflorio@protonmail.com)
 */
public interface Point {
  /**
   * Translates itself
   *
   * @param deltaX The delta x
   * @param deltaY The delta y
   * @return The translated point
   */
  Point translate(Integer deltaX, Integer deltaY);

  /**
   * Builds the x coordinate
   *
   * @return The coordinate
   */
  Integer x();

  /**
   * Builds the y coordinate
   *
   * @return The coordinate
   */
  Integer y();
}
