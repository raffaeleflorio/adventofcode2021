package io.github.raffaeleflorio.adventofcode2021.day2;

public final class PartTwo {
  public static void main(final String[] args) {
    System.out.println(
      new InstructedSubmarine(
        PartTwoSubmarine::new,
        new CourseAtPath(
          "day2/src/main/resources/input"
        )
      ).multiplication()
    );
  }
}
