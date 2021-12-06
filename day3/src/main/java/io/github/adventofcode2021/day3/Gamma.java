package io.github.adventofcode2021.day3;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * A gamma value
 *
 * @author Raffaele Florio (raffaeleflorio@protonmail.com)
 */
public final class Gamma implements BinaryNumber {
  private final List<BinaryNumber> numbers;
  private final Function<String, BinaryNumber> numberFn;
  private final Function<List<BinaryNumber>, List<Long>> frequencyFn;

  /**
   * Builds gamma value
   *
   * @param numbers The numbers
   */
  public Gamma(final String... numbers) {
    this(new StringsAsBinaryNumbers(numbers));
  }

  /**
   * Builds gamma value
   *
   * @param numbers The numbers
   */
  public Gamma(final List<BinaryNumber> numbers) {
    this(numbers, StringAsBinaryNumber::new, IndexedOneFrequencies::new);
  }

  Gamma(
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
    return gamma().one(position);
  }

  private BinaryNumber gamma() {
    return numberFn.apply(
      frequencyFn.apply(numbers)
        .stream()
        .map(f -> f >= numbers.size() - f ? "1" : "0")
        .collect(Collectors.joining())
    );
  }

  @Override
  public Integer length() {
    return numbers.stream().findAny().map(BinaryNumber::length).orElse(0);
  }

  @Override
  public BinaryNumber inverse() {
    return gamma().inverse();
  }

  @Override
  public Long decimal() {
    return gamma().decimal();
  }
}
