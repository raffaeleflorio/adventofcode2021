package io.github.raffaeleflorio.adventofcode2021.day5;

import java.util.AbstractList;
import java.util.List;
import java.util.Optional;

/**
 * First non empty list among a group of List
 *
 * @param <T> The element type
 * @author Raffaele Florio (raffaeleflorio@protonmail.com)
 */
public final class FirstNonEmptyList<T> extends AbstractList<T> {
  private final List<List<T>> lists;

  /**
   * Builds list
   *
   * @param lists The lists
   */
  public FirstNonEmptyList(final List<List<T>> lists) {
    this.lists = lists;
  }

  @Override
  public T get(final int index) {
    if (size() <= index) {
      throw new IndexOutOfBoundsException(index);
    }
    return first().get().get(index);
  }

  private Optional<List<T>> first() {
    return lists.stream().filter(l -> !l.isEmpty()).findFirst();
  }

  @Override
  public int size() {
    return first().map(List::size).orElse(0);
  }
}
