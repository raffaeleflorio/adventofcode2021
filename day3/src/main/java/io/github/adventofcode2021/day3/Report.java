package io.github.adventofcode2021.day3;

import java.util.List;

/**
 * A diagnostic report
 *
 * @author Raffaele Florio (raffaeleflorio@protonmail.com)
 */
public interface Report {
  /**
   * Builds the report entries
   *
   * @return The entries
   */
  List<BinaryNumber> entries();

  /**
   * A report useful for testing
   *
   * @author Raffaele Florio (raffaeleflorio@protonmail.com)
   */
  final class Fake implements Report {
    private final List<BinaryNumber> numbers;

    /**
     * Builds a fake
     *
     * @param numbers The numbers
     */
    public Fake(final List<BinaryNumber> numbers) {
      this.numbers = numbers;
    }

    @Override
    public List<BinaryNumber> entries() {
      return numbers;
    }
  }
}
