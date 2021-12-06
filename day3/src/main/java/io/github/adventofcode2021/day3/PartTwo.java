package io.github.adventofcode2021.day3;

public final class PartTwo {
  public static void main(final String[] args) {
    System.out.println(
      new ReportedLifeSupportRating(
        new ReportAtPath(
          "day3/src/main/resources/input"
        )
      ).value()
    );
  }
}
