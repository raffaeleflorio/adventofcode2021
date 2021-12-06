package io.github.adventofcode2021.day3;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Oxygen generator rating
 *
 * @author Raffaele Florio (raffaeleflorio@protonmail.com)
 */
public final class OxygenGeneratorRating implements BinaryNumber {
  private final List<BinaryNumber> numbers;
  private final Function<List<BinaryNumber>, List<Long>> frequencyFn;

  /**
   * Builds the rating
   *
   * @param numbers The numbers
   */
  public OxygenGeneratorRating(final String... numbers) {
    this(new StringsAsBinaryNumbers(numbers));
  }

  /**
   * Builds the rating
   *
   * @param numbers The numbers
   */
  public OxygenGeneratorRating(final List<BinaryNumber> numbers) {
    this(numbers, IndexedOneFrequencies::new);
  }

  OxygenGeneratorRating(final List<BinaryNumber> numbers, final Function<List<BinaryNumber>, List<Long>> frequencyFn) {
    this.numbers = numbers;
    this.frequencyFn = frequencyFn;
  }

  @Override
  public Boolean one(final Integer position) {
    return rating().one(position);
  }


  private BinaryNumber rating() {
    var filtered = numbers;
    for (var i = 0; i < length() && filtered.size() > 1; i++) {
      var oneFrequency = frequencyFn.apply(filtered).get(i);
      var zeroFrequency = filtered.size() - oneFrequency;
      var j = i;
      filtered = filtered
        .stream()
        .filter(number -> (oneFrequency >= zeroFrequency) == number.one(j))
        .collect(Collectors.toUnmodifiableList());
    }
    return filtered.get(0);
  }

  @Override
  public Integer length() {
    return numbers.stream().findAny().map(BinaryNumber::length).orElse(0);
  }

  @Override
  public BinaryNumber inverse() {
    return rating().inverse();
  }

  @Override
  public Long decimal() {
    return rating().decimal();
  }
}
