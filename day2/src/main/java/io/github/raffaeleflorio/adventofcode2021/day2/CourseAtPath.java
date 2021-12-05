package io.github.raffaeleflorio.adventofcode2021.day2;

import java.nio.file.Path;

/**
 * Course saved at path
 *
 * @author Raffaele Florio (raffaeleflorio@protonmail.com)
 */
public final class CourseAtPath implements Instruction {
  private final Instruction origin;

  /**
   * Builds a course
   *
   * @param path The path
   */
  public CourseAtPath(final String path) {
    this(Path.of(path));
  }

  /**
   * Builds a course
   *
   * @param path The path
   */
  public CourseAtPath(final Path path) {
    this(
      new Course(
        new SavedInstructions(
          new LinesAtPath(
            path
          )
        )
      )
    );
  }

  CourseAtPath(final Instruction origin) {
    this.origin = origin;
  }

  @Override
  public Submarine submarine(final Submarine submarine) {
    return origin.submarine(submarine);
  }
}
