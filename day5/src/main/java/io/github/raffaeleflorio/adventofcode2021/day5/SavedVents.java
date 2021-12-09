package io.github.raffaeleflorio.adventofcode2021.day5;

import java.util.Iterator;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * An {@link HydrothermalVent} saved in the format:
 * first
 * \n
 * second
 * \n
 * third
 *
 * @author Raffaele Florio (raffaeleflorio@protonmail.com)
 */
public final class SavedVents implements HydrothermalVents {
  private final List<String> savedVents;
  private final Function<String, HydrothermalVent> ventFn;

  /**
   * Builds vents
   *
   * @param savedVents The saved vents
   * @param segmentFn  The function to build segment
   */
  public SavedVents(final List<String> savedVents, final BiFunction<Point, Point, Segment> segmentFn) {
    this(
      savedVents,
      s -> new SavedVent(s, segmentFn)
    );
  }

  SavedVents(final List<String> savedVents, final Function<String, HydrothermalVent> ventFn) {
    this.savedVents = savedVents;
    this.ventFn = ventFn;
  }

  @Override
  public FrequencyDiagram<Point> plot(final FrequencyDiagram<Point> diagram) {
    var result = diagram;
    var vents = vents();
    while (vents.hasNext()) {
      result = vents.next().plot(result);
    }
    return result;
  }

  private Iterator<HydrothermalVent> vents() {
    return savedVents
      .stream()
      .map(ventFn)
      .iterator();
  }
}
