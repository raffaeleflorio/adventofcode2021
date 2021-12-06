package io.github.adventofcode2021.day3;

public final class PartOne {
  public static void main(final String[] args) {
    System.out.println(
      new ReportedPowerConsumption(
        new ReportAtPath(
          "day3/src/main/resources/input"
        )
      ).value()
    );
  }
}
