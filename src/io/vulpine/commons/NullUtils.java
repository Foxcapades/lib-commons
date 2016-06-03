package io.vulpine.commons;

public class NullUtils
{
  @SafeVarargs
  public static < T > T coalesce ( T... tries )
  {
    for (final T t : tries) if (null != t) return t;
    return null;
  }
}
