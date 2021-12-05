package io.github.raffaeleflorio.adventofcode2021.day2;

import java.util.Map;
import java.util.function.Function;

/**
 * saved as {@link String} in the format "type units"
 *
 * @author Raffaele Florio (raffaeleflorio@protonmail.com)
 */
public final class SavedInstruction implements Instruction {
  private final String instruction;
  private final Map<String, Function<Long, Instruction>> typeToInstructionFn;

  /**
   * Builds the instruction
   *
   * @param instruction The saved instruction
   */
  public SavedInstruction(final String instruction) {
    this(
      instruction,
      Map.of(
        "forward", Forward::new,
        "down", Down::new,
        "up", Up::new
      )
    );
  }

  SavedInstruction(
    final String instruction,
    final Map<String, Function<Long, Instruction>> typeToInstructionFn
  ) {
    this.instruction = instruction;
    this.typeToInstructionFn = typeToInstructionFn;
  }


  @Override
  public Submarine submarine(final Submarine submarine) {
    return instruction().submarine(submarine);
  }

  private Instruction instruction() {
    return typeToInstructionFn.get(type()).apply(units());
  }

  private String type() {
    return instruction.split(" ")[0];
  }

  private Long units() {
    return Long.parseLong(instruction.split(" ")[1]);
  }
}
