package io.github.raffaeleflorio.adventofcode2021.day5;

import java.util.AbstractList;
import java.util.function.Function;

/**
 * A vertical segment
 *
 * @author Raffaele Florio (raffaeleflorio@protonmail.com)
 */
public final class VerticalSegment extends AbstractList<Point> implements Segment {
  private final Point source;
  private final Point destination;
  private final Function<Integer, Integer> absFn;

  /**
   * Build segment
   *
   * @param x1 The x coordinate of the source point
   * @param y1 The y coordinate of the source point
   * @param x2 The x coordinate of the destination point
   * @param y2 The y coordinate of the destination point
   */
  public VerticalSegment(final Integer x1, final Integer y1, final Integer x2, final Integer y2) {
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
  public VerticalSegment(final Point source, final Point destination) {
    this(source, destination, Math::abs);
  }

  VerticalSegment(
    final Point source,
    final Point destination,
    final Function<Integer, Integer> absFn
  ) {
    this.source = source;
    this.destination = destination;
    this.absFn = absFn;
  }

  @Override
  public Point get(final int index) {
    if (size() <= index || index < 0) {
      throw new IndexOutOfBoundsException(index);
    }
    return source.translate(0, delta(index));
  }

  private Integer delta(final int index) {
    return downToUp() ? index : -index;
  }

  private Boolean downToUp() {
    return source.y() < destination.y();
  }

  @Override
  public int size() {
    return vertical() ? distance() + 1 : 0;
  }

  private Boolean vertical() {
    return source.x().equals(destination.x());
  }

  private Integer distance() {
    return absFn.apply(source.y() - destination.y());
  }
}
