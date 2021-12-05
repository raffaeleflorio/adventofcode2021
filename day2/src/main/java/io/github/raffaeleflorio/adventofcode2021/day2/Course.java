package io.github.raffaeleflorio.adventofcode2021.day2;

import java.util.List;

/**
 * A group of {@link Instruction}
 *
 * @author Raffaele Florio (raffaeleflorio@protonmail.com)
 */
public final class Course implements Instruction {
  private final List<Instruction> instructions;

  /**
   * Builds a course
   *
   * @param instructions The instructions
   */
  public Course(final List<Instruction> instructions) {
    this.instructions = instructions;
  }

  @Override
  public Submarine submarine(final Submarine submarine) {
    var result = submarine;
    for (var instruction : instructions) {
      result = instruction.submarine(result);
    }
    return result;
  }
}
