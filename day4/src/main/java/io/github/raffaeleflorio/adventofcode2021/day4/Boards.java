package io.github.raffaeleflorio.adventofcode2021.day4;

import java.util.function.Predicate;

/**
 * Group of {@link Boards}
 *
 * @author Raffaele Florio (raffaeleflorio@protonmail.com)
 */
public interface Boards extends Iterable<Board> {
  /**
   * Marks a number on all the boards
   *
   * @return The marked boards
   */
  Boards mark(Long number);

  /**
   * Filters the boards
   *
   * @param filter The filter
   * @return The filtered boards
   */
  Boards filter(Predicate<Board> filter);
}
