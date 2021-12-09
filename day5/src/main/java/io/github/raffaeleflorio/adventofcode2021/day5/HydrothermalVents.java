package io.github.raffaeleflorio.adventofcode2021.day5;

/**
 * A group of {@link HydrothermalVent}
 *
 * @author Raffaele Florio (raffaeleflorio@protonmail.com)
 */
public interface HydrothermalVents {
  /**
   * Plot themselves onto a diagram
   *
   * @param diagram The diagram
   * @return The diagram
   */
  FrequencyDiagram<Point> plot(FrequencyDiagram<Point> diagram);
}
