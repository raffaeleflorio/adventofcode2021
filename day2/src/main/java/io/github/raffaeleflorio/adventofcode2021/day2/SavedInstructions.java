package io.github.raffaeleflorio.adventofcode2021.day2;

import java.util.AbstractList;
import java.util.List;
import java.util.function.Function;

/**
 * Instructions saved in the format "type units"
 *
 * @author Raffaele Florio (raffaeleflorio@protonmail.com)
 */
public final class SavedInstructions extends AbstractList<Instruction> {
  private final List<String> instructions;
  private final Function<String, Instruction> instructionFn;

  /**
   * Builds instructions
   *
   * @param instructions The saved instructions
   */
  public SavedInstructions(final List<String> instructions) {
    this(instructions, SavedInstruction::new);
  }

  SavedInstructions(final List<String> instructions, final Function<String, Instruction> instructionFn) {
    this.instructions = instructions;
    this.instructionFn = instructionFn;
  }

  @Override
  public Instruction get(final int index) {
    return instructionFn.apply(instructions.get(index));
  }

  @Override
  public int size() {
    return instructions.size();
  }
}
