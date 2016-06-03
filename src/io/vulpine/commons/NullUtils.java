package io.vulpine.common;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.Nullable;

public class NullUtils
{
  @Nullable
  @Contract( pure = true )
  @SafeVarargs
  public static < T > T coalesce ( T... tries )
  {
    for (final T t : tries) if (null != t) return t;
    return null;
  }
}
