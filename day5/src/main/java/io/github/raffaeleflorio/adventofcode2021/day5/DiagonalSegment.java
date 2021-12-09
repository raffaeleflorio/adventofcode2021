package io.github.raffaeleflorio.adventofcode2021.day5;

import java.util.AbstractList;
import java.util.function.Function;

/**
 * A diagonal segment
 *
 * @author Raffaele Florio (raffaeleflorio@protonmail.com)
 */
public final class DiagonalSegment extends AbstractList<Point> implements Segment {
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
  public DiagonalSegment(final Integer x1, final Integer y1, final Integer x2, final Integer y2) {
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
  public DiagonalSegment(final Point source, final Point destination) {
    this(source, destination, Math::abs);
  }

  DiagonalSegment(final Point source, final Point destination, final Function<Integer, Integer> absFn) {
    this.source = source;
    this.destination = destination;
    this.absFn = absFn;
  }

  @Override
  public Point get(final int index) {
    if (size() <= index || index < 0) {
      throw new IndexOutOfBoundsException(index);
    }
    return source.translate(deltaX(index), deltaY(index));
  }

  private Integer deltaX(final int index) {
    return leftToRight() ? index : -index;
  }

  private Boolean leftToRight() {
    return source.x() < destination.x();
  }

  private Integer deltaY(final int index) {
    return downToUp() ? index : -index;
  }

  private Boolean downToUp() {
    return source.y() < destination.y();
  }

  @Override
  public int size() {
    return diagonal() ? distance() + 1 : 0;
  }

  private Boolean diagonal() {
    var distX = distance(source.x(), destination.x());
    var distY = distance(source.y(), destination.y());
    return distX.equals(distY);
  }

  private Integer distance(final Integer first, final Integer second) {
    return absFn.apply(first - second);
  }

  private Integer distance() {
    return distance(source.x(), destination.x());
  }
}
