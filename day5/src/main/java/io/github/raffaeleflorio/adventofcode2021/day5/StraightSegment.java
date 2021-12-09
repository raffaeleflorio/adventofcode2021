package io.github.raffaeleflorio.adventofcode2021.day5;

import java.util.AbstractList;
import java.util.List;

/**
 * A horizontal or vertical segment
 *
 * @author Raffaele Florio (raffaeleflorio@protonmail.com)
 */
public final class StraightSegment extends AbstractList<Point> implements Segment {
  private final List<Point> origin;

  /**
   * Build segment
   *
   * @param x1 The x coordinate of the source point
   * @param y1 The y coordinate of the source point
   * @param x2 The x coordinate of the destination point
   * @param y2 The y coordinate of the destination point
   */
  public StraightSegment(final Integer x1, final Integer y1, final Integer x2, final Integer y2) {
    this(
      new ConstPoint(x1, y1),
      new ConstPoint(x2, y2)
    );
  }

  /**
   * Build segment
   *
   * @param source      The source
   * @param destination The destination
   */
  public StraightSegment(final Point source, final Point destination) {
    this(
      new FirstNonEmptyList<>(
        List.of(
          new HorizontalSegment(source, destination),
          new VerticalSegment(source, destination)
        )
      )
    );
  }

  StraightSegment(final List<Point> origin) {
    this.origin = origin;
  }

  @Override
  public Point get(final int index) {
    return origin.get(index);
  }

  @Override
  public int size() {
    return origin.size();
  }
}
