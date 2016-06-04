package io.vulpine.commons;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

public class NullUtilsTest
{
  @Test
  public void testCoalesceReturnsNull()
  {
    assertNull(
      "NullUtils.coalesce() should return null when no non-null value is provided.",
      NullUtils.coalesce(null, null, null, null, null)
    );
  }

  @Test
  public void testCoalesceReturnsNotNull()
  {
    assertNotNull(
      "NullUtils.coalesce() should not return null if a non-null value is provided.",
      NullUtils.coalesce(null, null, null, null, "Test")
    );
  }

  @Test
  public void testCoalesceReturnsFirstNonNull()
  {
    final Map < String, String > realValue = new HashMap <>();
    final Map < String, String > fakeValue = new HashMap <>();

    realValue.put("This is", "a test map");
    realValue.put("that should", "be the one returned from coalesce.");

    fakeValue.put("This is", "a test map");
    fakeValue.put("that shouldn't", "be returned from coalesce.");

    assertEquals(
      "NullUtils.coalesce() should return the first non-null value provided to it.",
      NullUtils.coalesce(null, null, null, realValue, fakeValue),
      realValue
    );
  }
}
