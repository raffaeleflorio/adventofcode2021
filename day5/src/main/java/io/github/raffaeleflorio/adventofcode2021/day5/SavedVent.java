package io.github.raffaeleflorio.adventofcode2021.day5;

import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * An {@link HydrothermalVent} saved in the format: x1,y1 -> x2,y2
 *
 * @author Raffaele Florio (raffaeleflorio@protonmail.com)
 */
public final class SavedVent implements HydrothermalVent {
  private final String savedVent;
  private final BiFunction<Point, Point, Segment> segmentFn;
  private final Function<String, Point> pointFn;

  /**
   * Builds vent
   *
   * @param savedVent The saved vent
   * @param segmentFn The function to build segment
   */
  public SavedVent(final String savedVent, final BiFunction<Point, Point, Segment> segmentFn) {
    this(savedVent, segmentFn, SavedPoint::new);
  }

  SavedVent(
    final String savedVent,
    final BiFunction<Point, Point, Segment> segmentFn,
    final Function<String, Point> pointFn
  ) {
    this.savedVent = savedVent;
    this.segmentFn = segmentFn;
    this.pointFn = pointFn;
  }

  @Override
  public FrequencyDiagram<Point> plot(final FrequencyDiagram<Point> diagram) {
    var result = diagram;
    for (var point : segmentFn.apply(from(), to())) {
      result = result.increment(point);
    }
    return result;
  }

  private Point from() {
    return pointFn.apply(splitted()[0]);
  }

  private Point to() {
    return pointFn.apply(splitted()[1]);
  }

  private String[] splitted() {
    return savedVent.split(" -> ");
  }
}
