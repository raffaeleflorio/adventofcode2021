package io.github.raffaeleflorio.adventofcode2021.day5;

/**
 * Group of at least two overlapping points
 *
 * @author Raffaele Florio (raffaeleflorio@protonmail.com)
 */
public final class TwoOverlappingPoints implements OverlappingPoints {
  private final HydrothermalVents vents;
  private final FrequencyDiagram<Point> diagram;

  /**
   * Builds overlapping points
   *
   * @param vents   The vents
   * @param diagram The diagram
   */
  public TwoOverlappingPoints(final HydrothermalVents vents, final FrequencyDiagram<Point> diagram) {
    this.vents = vents;
    this.diagram = diagram;
  }

  @Override
  public Long count() {
    return vents.plot(diagram).cut(2L).count();
  }
}
