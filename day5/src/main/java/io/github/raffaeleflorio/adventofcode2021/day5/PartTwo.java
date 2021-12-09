package io.github.raffaeleflorio.adventofcode2021.day5;

public final class PartTwo {
  public static void main(final String[] args) {
    System.out.println(
      new TwoOverlappingPoints(
        new VentsAtPath(
          "day5/src/main/resources/input",
          AllSegment::new
        ),
        new PointFrequencies()
      ).count()
    );
  }
}
