package io.github.raffaeleflorio.adventofcode2021.day2;

import java.util.function.Supplier;

/**
 * A {@link Submarine} instructed by an {@link Instruction}
 */
public final class InstructedSubmarine implements Submarine {
  private final Supplier<Submarine> submarineSupplier;
  private final Instruction instruction;

  /**
   * Builds a submarine
   *
   * @param submarineSupplier The initial submarine
   * @param instruction       The instruction
   */
  public InstructedSubmarine(final Supplier<Submarine> submarineSupplier, final Instruction instruction) {
    this.submarineSupplier = submarineSupplier;
    this.instruction = instruction;
  }

  @Override
  public Submarine down(final Long units) {
    return instructed().down(units);
  }

  private Submarine instructed() {
    return instruction.submarine(submarineSupplier.get());
  }

  @Override
  public Submarine up(final Long units) {
    return instructed().up(units);
  }

  @Override
  public Submarine forward(final Long units) {
    return instructed().forward(units);
  }

  @Override
  public Long multiplication() {
    return instructed().multiplication();
  }
}
