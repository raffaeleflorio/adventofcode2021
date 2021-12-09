package io.github.raffaeleflorio.adventofcode2021.hamcrest;

import org.hamcrest.Description;
import org.hamcrest.TypeSafeDiagnosingMatcher;


public final class RunnableThrowsWithMessage extends TypeSafeDiagnosingMatcher<Runnable> {
  private final Class<? extends Throwable> expectedClass;
  private final String expectedMessage;

  public RunnableThrowsWithMessage(final Class<? extends Throwable> expectedClass, final String expectedMessage) {
    this.expectedClass = expectedClass;
    this.expectedMessage = expectedMessage;
  }

  @Override
  protected boolean matchesSafely(final Runnable runnable, final Description description) {
    try {
      runnable.run();
      description.appendText("none was thrown");
      return false;
    } catch (Throwable actual) {
      var matches = actualMatches(actual);
      if (!matches) {
        description.appendText(message(actual));
      }
      return matches;
    }
  }

  private boolean actualMatches(final Throwable actual) {
    var actualClass = actual.getClass();
    var actualMessage = actual.getMessage();
    return actualClass.equals(expectedClass) && actualMessage.equals(expectedMessage);
  }

  private String message(final Throwable actual) {
    return message(actual.getClass(), actual.getMessage());
  }

  private String message(final Class<? extends Throwable> clazz, final String message) {
    return clazz.toString().concat(": ").concat(message);
  }

  @Override
  public void describeTo(final Description description) {
    description.appendText(message(expectedClass, expectedMessage));
  }

  public static RunnableThrowsWithMessage throwsWithMessage(
    final Class<? extends Throwable> expectedClass,
    final String expectedMessage
  ) {
    return new RunnableThrowsWithMessage(expectedClass, expectedMessage);
  }
}
