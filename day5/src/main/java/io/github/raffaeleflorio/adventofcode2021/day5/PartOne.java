package io.github.raffaeleflorio.adventofcode2021.day5;

public final class PartOne {
  public static void main(final String[] args) {
    System.out.println(
      new TwoOverlappingPoints(
        new VentsAtPath(
          "day5/src/main/resources/input",
          StraightSegment::new
        ),
        new PointFrequencies()
      ).count()
    );
  }
}
