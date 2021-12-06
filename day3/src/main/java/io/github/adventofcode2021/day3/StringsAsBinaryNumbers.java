package io.github.adventofcode2021.day3;

import java.util.AbstractList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

/**
 * {@link List} of {@link String} as {@link List} of {@link BinaryNumber}
 *
 * @author Raffaele Florio (raffaeleflorio@protonmail.com)
 */
public final class StringsAsBinaryNumbers extends AbstractList<BinaryNumber> {
  private final List<String> numbers;
  private final Function<String, BinaryNumber> numberFn;

  /**
   * Builds list
   *
   * @param numbers The numbers
   */
  public StringsAsBinaryNumbers(final String... numbers) {
    this(Arrays.asList(numbers));
  }

  /**
   * Builds list
   *
   * @param numbers The numbers
   */
  public StringsAsBinaryNumbers(final List<String> numbers) {
    this(numbers, StringAsBinaryNumber::new);
  }

  StringsAsBinaryNumbers(final List<String> numbers, final Function<String, BinaryNumber> numberFn) {
    this.numbers = numbers;
    this.numberFn = numberFn;
  }

  @Override
  public BinaryNumber get(final int index) {
    return numberFn.apply(numbers.get(index));
  }

  @Override
  public int size() {
    return numbers.size();
  }
}
