package io.github.raffaeleflorio.adventofcode2021.day5;

import java.util.Objects;
import java.util.function.Function;

/**
 * Frequencies of {@link Point}
 *
 * @author Raffaele Florio (raffaeleflorio@protonmail.com)
 */
public final class PointFrequencies implements FrequencyDiagram<Point> {
  private final FrequencyDiagram<Point> origin;
  private final Function<Point, Point> pointFn;

  /**
   * Build frequencies
   */
  public PointFrequencies() {
    this(new MapFrequencyDiagram<>(), EqualsAndHashCodePoint::new);
  }

  PointFrequencies(final FrequencyDiagram<Point> origin, final Function<Point, Point> pointFn) {
    this.origin = origin;
    this.pointFn = pointFn;
  }

  @Override
  public FrequencyDiagram<Point> increment(final Point element) {
    return new PointFrequencies(
      origin.increment(pointFn.apply(element)),
      pointFn
    );
  }

  @Override
  public FrequencyDiagram<Point> cut(final Long threshold) {
    return new PointFrequencies(
      origin.cut(threshold),
      pointFn
    );
  }

  @Override
  public Long count() {
    return origin.count();
  }

  private final static class EqualsAndHashCodePoint implements Point {
    private final Point origin;

    private EqualsAndHashCodePoint(final Point origin) {
      this.origin = origin;
    }

    @Override
    public Point translate(final Integer deltaX, final Integer deltaY) {
      return new EqualsAndHashCodePoint(origin.translate(deltaX, deltaY));
    }

    @Override
    public Integer x() {
      return origin.x();
    }

    @Override
    public Integer y() {
      return origin.y();
    }

    @Override
    public boolean equals(final Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;
      final EqualsAndHashCodePoint that = (EqualsAndHashCodePoint) o;
      return x().equals(that.x()) && y().equals(that.y());
    }

    @Override
    public int hashCode() {
      return Objects.hash(x(), y());
    }
  }
}
