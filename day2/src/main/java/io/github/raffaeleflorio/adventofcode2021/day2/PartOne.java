package io.github.raffaeleflorio.adventofcode2021.day2;

public final class PartOne {
  public static void main(final String[] args) {
    System.out.println(
      new InstructedSubmarine(
        PartOneSubmarine::new,
        new CourseAtPath(
          "day2/src/main/resources/input"
        )
      ).multiplication()
    );
  }
}
