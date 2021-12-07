package io.github.raffaeleflorio.adventofcode2021.day4;

import java.util.AbstractList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * A cached {@link List}
 *
 * @param <T> The element type
 * @author Raffaele Florio (raffaeleflorio@protonmail.com)
 */
public final class CachedList<T> extends AbstractList<T> {
  private final List<T> origin;
  private final ConcurrentMap<Integer, T> cache;

  /**
   * Builds list
   *
   * @param origin The list to cache
   */
  public CachedList(final List<T> origin) {
    this(origin, new ConcurrentHashMap<>());
  }

  CachedList(final List<T> origin, final ConcurrentMap<Integer, T> cache) {
    this.origin = origin;
    this.cache = cache;
  }

  @Override
  public T get(final int index) {
    return cache.computeIfAbsent(
      index,
      origin::get
    );
  }

  @Override
  public int size() {
    return origin.size();
  }
}
