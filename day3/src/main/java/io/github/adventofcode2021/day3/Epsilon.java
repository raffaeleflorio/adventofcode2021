package io.github.adventofcode2021.day3;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * An epsilon value
 *
 * @author Raffaele Florio (raffaeleflorio@protonmail.com)
 */
public final class Epsilon implements BinaryNumber {
  private final List<BinaryNumber> numbers;
  private final Function<String, BinaryNumber> numberFn;
  private final Function<List<BinaryNumber>, List<Long>> frequencyFn;

  /**
   * Builds epsilon value
   *
   * @param numbers The numbers
   */
  public Epsilon(final String... numbers) {
    this(new StringsAsBinaryNumbers(numbers));
  }

  /**
   * Builds epsilon value
   *
   * @param numbers The numbers
   */
  public Epsilon(final List<BinaryNumber> numbers) {
    this(numbers, StringAsBinaryNumber::new, IndexedOneFrequencies::new);
  }

  Epsilon(
    final List<BinaryNumber> numbers,
    final Function<String, BinaryNumber> numberFn,
    final Function<List<BinaryNumber>, List<Long>> frequencyFn
  ) {
    this.numbers = numbers;
    this.numberFn = numberFn;
    this.frequencyFn = frequencyFn;
  }

  @Override
  public Boolean one(final Integer position) {
    return epsilon().one(position);
  }

  private BinaryNumber epsilon() {
    return numberFn.apply(
      frequencyFn.apply(numbers)
        .stream()
        .map(f -> f >= numbers.size() - f ? "0" : "1")
        .collect(Collectors.joining())
    );
  }

  @Override
  public Integer length() {
    return numbers.stream().findAny().map(BinaryNumber::length).orElse(0);
  }

  @Override
  public BinaryNumber inverse() {
    return epsilon().inverse();
  }

  @Override
  public Long decimal() {
    return epsilon().decimal();
  }
}
