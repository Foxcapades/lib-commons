package io.vulpine.common;

/**
 * String Utils
 * <hr />
 * <p>
 *   Helper functions for performing common string operations.
 * </p>
 *
 * @author Elizabeth Harper (elliefops@gmail.com)
 * @version 1.0
 * @since 1.0.0
 */
public class StringUtils
{
  /**
   * Wrap String
   * <hr />
   * <p>
   *   Wraps the string at the given line length at the last word boundary that
   *   will fit in the given length.
   * </p>
   *
   * @param in    String to wrap
   * @param width Column to wrap at
   *
   * @return Wrapped string.
   */
  public static String wrap ( final String in, final int width )
  {
    final StringBuilder sb;

    if (null == in) return null;
    sb = new StringBuilder(in);

    int i = 0;
    while (i + width < sb.length() && (i = sb.lastIndexOf(" ", i + width)) != -1) sb.replace(i, i + 1, "\n");
    return sb.toString();
  }

  /**
   * Wrap String to Array of Lines
   * <hr />
   * <p>
   *   Wraps the string at the given line length at the last word boundary that
   *   will fit within the given length.  The split lines will be returned as an
   *   array of strings instead of a string containing line break characters.
   * </p>
   *
   * @param in    String to wrap
   * @param width Column to wrap at.
   *
   * @return Lines from the wrapped string.
   */
  public static String[] wrapToLineArray ( final String in, final int width )
  {
    if (in == null) return null;
    return wrap(in, width).split("\n");
  }

  /**
   * Implode or Join String
   * <hr />
   * <p>
   *   Joins the separate strings given with the "glue" string between them.
   * </p>
   *
   * @param glue   Inserted join string.
   * @param pieces Individual Strings to join.
   *
   * @return Single string consisting of the given pieces with the "glue" string
   *         between them.
   */
  public static String implode ( final String glue, final String[] pieces )
  {
    final StringBuilder sb = new StringBuilder();
    if (null == glue || null == pieces) return null;
    for (final String s : pieces) sb.append(s).append(glue);
    return sb.toString().substring(0, sb.length() - glue.length());
  }

  /**
   * Convert Value to Empty String When null
   *
   * @param n String to check.
   *
   * @return Original String, or if null, an empty string.
   */
  public static String nullToEmpty ( final String n )
  {
    return null == n ? "" : n;
  }

  /**
   * Right Pad a given String to the given length using the given character.
   *
   * @param padThis      String to pad
   * @param withThis     Character To Pad With
   * @param toThisLength Length to pad String to
   *
   * @return Padded string, or original string if it is already equal to or
   *         greater than the desired length.
   */
  public static String padRight ( final String padThis, final char withThis, final int toThisLength )
  {
    final int           inLen, diff, rem;
    final StringBuilder sb;

    if (null == padThis) return null;
    if (0 >= toThisLength) return padThis;

    inLen = padThis.length();

    if (inLen >= toThisLength) return padThis;

    diff = toThisLength - inLen;

    sb = new StringBuilder(padThis);

    if (diff > 5) {
      final char[] f = new char[] { withThis, withThis, withThis, withThis, withThis };
      final int    div;
      rem = diff % 5;
      div = (diff - rem) / 5;
      for (int i = 0; i < div; i++) sb.append(f);

      return sb.toString();
    } else {
      rem = diff;
    }

    for (int i = 0; i < rem; i++) sb.append(withThis);

    return sb.toString();
  }

  public static String padRight ( final String s, final int l )
  {
    return padRight(s, ' ', l);
  }

  public static String padLeft ( final String padThis, final char withThis, final int toThisLength )
  {
    final int           inLen, diff, rem;
    final StringBuilder sb;

    if (null == padThis) return null;
    if (0 >= toThisLength) return padThis;

    inLen = padThis.length();

    if (inLen >= toThisLength) return padThis;

    diff = toThisLength - inLen;

    sb = new StringBuilder(padThis);

    if (diff > 5) {
      final char[] f = new char[] { withThis, withThis, withThis, withThis, withThis };
      final int    div;
      rem = diff % 5;
      div = (diff - rem) / 5;
      for (int i = 0; i < div; i++) sb.insert(0, f);

      return sb.toString();
    } else {
      rem = diff;
    }

    for (int i = 0; i < rem; i++) sb.insert(0, withThis);

    return sb.toString();
  }

  public static String padLeft ( final String s, final int l )
  {
    return padLeft(s, ' ', l);
  }
}
