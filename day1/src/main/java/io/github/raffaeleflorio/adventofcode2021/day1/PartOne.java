package io.github.raffaeleflorio.adventofcode2021.day1;

public final class PartOne {
  public static void main(final String[] args) {
    System.out.println(
      new PreviousBasedIncreases(
        new LineByLineReport(
          new LinesAtPath(
            "day1/src/main/resources/input"
          )
        )
      ).count()
    );
  }
}
