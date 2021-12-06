package io.github.adventofcode2021.day3;

import java.util.AbstractList;
import java.util.List;

/**
 * Indexed one digit frequencies of a group of {@link BinaryNumber}
 *
 * @author Raffaele Florio (raffaeleflorio@protonmail.com)
 */
public final class IndexedOneFrequencies extends AbstractList<Long> {
  private final List<BinaryNumber> numbers;

  /**
   * Builds indexed frequencies of one digit
   *
   * @param numbers The numbers
   */
  public IndexedOneFrequencies(final List<BinaryNumber> numbers) {
    this.numbers = numbers;
  }

  @Override
  public Long get(final int index) {
    return numbers
      .stream()
      .filter(number -> number.one(index))
      .count();
  }

  @Override
  public int size() {
    return numbers.get(0).length();
  }
}
