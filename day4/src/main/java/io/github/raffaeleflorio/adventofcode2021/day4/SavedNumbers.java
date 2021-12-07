package io.github.raffaeleflorio.adventofcode2021.day4;

import java.util.AbstractList;
import java.util.function.Function;

/**
 * Builds saved numbers in the format n,m,p,q
 *
 * @author Raffaele Florio (raffaeleflorio@protonmail.com)
 */
public final class SavedNumbers extends AbstractList<Long> {
  private final String savedNumbers;
  private final Function<String, Long> longFn;

  /**
   * Builds numbers
   *
   * @param savedNumbers The numbers
   */
  public SavedNumbers(final String savedNumbers) {
    this(savedNumbers, Long::parseLong);
  }

  SavedNumbers(final String savedNumbers, final Function<String, Long> longFn) {
    this.savedNumbers = savedNumbers;
    this.longFn = longFn;
  }

  @Override
  public Long get(final int index) {
    return longFn.apply(splitted()[index]);
  }

  private String[] splitted() {
    return savedNumbers.split(",");
  }

  @Override
  public int size() {
    return splitted().length;
  }
}
