package io.github.adventofcode2021.day3;

/**
 * A binary number
 *
 * @author Raffaele Florio (raffaeleflorio@protonmail.com)
 */
public interface BinaryNumber {
  /**
   * Builds true if the digit is one at a position
   *
   * @param position The position
   * @return True if digit is one, false otherwise
   */
  Boolean one(Integer position);

  /**
   * Builds the number length
   *
   * @return The length
   */
  Integer length();

  /**
   * Builds the inverse
   *
   * @return The inverse
   */
  BinaryNumber inverse();

  /**
   * Builds the decimal value
   *
   * @return The decimal value
   */
  Long decimal();

  /**
   * A binary number useful for testing
   *
   * @author Raffaele Florio (raffaeleflorio@protonmail.com)
   */
  final class Fake implements BinaryNumber {
    @Override
    public Boolean one(final Integer position) {
      return null;
    }

    @Override
    public Integer length() {
      return null;
    }

    @Override
    public BinaryNumber inverse() {
      return null;
    }

    @Override
    public Long decimal() {
      return null;
    }
  }
}
