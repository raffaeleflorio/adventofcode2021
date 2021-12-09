package io.github.raffaeleflorio.adventofcode2021.day5;

import java.nio.file.Path;
import java.util.function.BiFunction;

/**
 * {@link HydrothermalVents} at {@link Path}
 *
 * @author Raffaele Florio (raffaeleflorio@protonmail.com)
 */
public final class VentsAtPath implements HydrothermalVents {
  private final HydrothermalVents origin;

  /**
   * Builds vents
   *
   * @param path      The path
   * @param segmentFn The function to build segment
   */
  public VentsAtPath(final String path, final BiFunction<Point, Point, Segment> segmentFn) {
    this(Path.of(path), segmentFn);
  }

  /**
   * Builds vents
   *
   * @param path      The path
   * @param segmentFn The function to build segment
   */
  public VentsAtPath(final Path path, final BiFunction<Point, Point, Segment> segmentFn) {
    this(
      new SavedVents(
        new LinesAtPath(path),
        segmentFn
      )
    );
  }

  VentsAtPath(final HydrothermalVents origin) {
    this.origin = origin;
  }

  @Override
  public FrequencyDiagram<Point> plot(final FrequencyDiagram<Point> diagram) {
    return origin.plot(diagram);
  }
}
