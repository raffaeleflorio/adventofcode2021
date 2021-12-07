package io.github.raffaeleflorio.adventofcode2021.day4;

public final class PartOne {
  public static void main(final String[] args) {
    System.out.println(
      new StandardScore(
        new FirstWinningBoard(
          new BoardsAtPath("day4/src/main/resources/input"),
          new NumbersAtPath("day4/src/main/resources/input")
        )
      ).value()
    );
  }
}
