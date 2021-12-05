package io.github.raffaeleflorio.adventofcode2021.day2;

/**
 * An instruction
 *
 * @author Raffaele Florio (raffaeleflorio@protonmail.com)
 */
public interface Instruction {
  /**
   * Builds a submarine according the instruction
   *
   * @param submarine The initial submarine
   * @return The new submarine
   */
  Submarine submarine(Submarine submarine);
}
