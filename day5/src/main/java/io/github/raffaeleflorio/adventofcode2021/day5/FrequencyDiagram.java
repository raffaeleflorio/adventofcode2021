package io.github.raffaeleflorio.adventofcode2021.day5;

/**
 * A group of frequency
 *
 * @param <E> The element type
 * @author Raffaele Florio (raffaeleflorio@protonmail.com)
 */
public interface FrequencyDiagram<E> {
  /**
   * Increments the frequency of an element
   *
   * @param element The element
   * @return The updated frequencies
   */
  FrequencyDiagram<E> increment(E element);

  /**
   * Cuts the frequencies below a threshold
   *
   * @param threshold The threshold
   * @return The cut frequencies
   */
  FrequencyDiagram<E> cut(Long threshold);

  /**
   * Builds the count of the frequencies
   *
   * @return The count
   */
  Long count();
}
