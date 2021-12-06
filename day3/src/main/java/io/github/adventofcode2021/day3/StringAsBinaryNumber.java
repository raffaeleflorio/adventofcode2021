package io.github.adventofcode2021.day3;

/**
 * A {@link String} as {@link BinaryNumber}
 *
 * @author Raffaele Florio (raffaeleflorio@protonmail.com)
 */
public final class StringAsBinaryNumber implements BinaryNumber {
  private final String origin;

  /**
   * Builds a binary number
   *
   * @param origin The string
   */
  public StringAsBinaryNumber(final String origin) {
    this.origin = origin;
  }

  @Override
  public Boolean one(final Integer position) {
    return origin.charAt(position) == '1';
  }

  @Override
  public Integer length() {
    return origin.length();
  }

  @Override
  public BinaryNumber inverse() {
    return new StringAsBinaryNumber(
      origin
        .replace('0', 'A')
        .replace('1', '0')
        .replace('A', '1')
    );
  }

  @Override
  public Long decimal() {
    return Long.parseLong(origin, 2);
  }
}
