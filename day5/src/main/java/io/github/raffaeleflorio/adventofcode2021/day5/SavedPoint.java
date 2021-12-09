package io.github.raffaeleflorio.adventofcode2021.day5;

import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * A point saved in the format: x,y
 *
 * @author Raffaele Florio (raffaeleflorio@protonmail.com)
 */
public final class SavedPoint implements Point {
  private final String savedPoint;
  private final Function<String, Integer> intFn;
  private final BiFunction<Integer, Integer, Point> translatedFn;

  /**
   * Builds point
   *
   * @param savedPoint The saved point
   */
  public SavedPoint(final String savedPoint) {
    this(savedPoint, Integer::parseInt, ConstPoint::new);
  }

  SavedPoint(
    final String savedPoint,
    final Function<String, Integer> intFn,
    final BiFunction<Integer, Integer, Point> translatedFn
  ) {
    this.savedPoint = savedPoint;
    this.intFn = intFn;
    this.translatedFn = translatedFn;
  }

  @Override
  public Point translate(final Integer deltaX, final Integer deltaY) {
    return translatedFn.apply(x() + deltaX, y() + deltaY);
  }

  @Override
  public Integer x() {
    return intFn.apply(splitted()[0]);
  }

  private String[] splitted() {
    return savedPoint.split(",");
  }

  @Override
  public Integer y() {
    return intFn.apply(splitted()[1]);
  }
}
