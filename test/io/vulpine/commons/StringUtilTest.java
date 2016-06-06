package io.vulpine.commons;

import org.junit.Test;

import static io.vulpine.commons.StringUtils.*;
import static org.junit.Assert.*;

public class StringUtilTest
{
  public static class nullToEmpty
  {

    @Test
    public void When_Param1IsNull_ReturnEmptyString ()
    {
      assertEquals(
        "StringUtils.nullToEmpty() should return an empty string when passed a null value.",
        "",
        nullToEmpty(null)
      );
    }

    @Test
    public void When_Param1IsNotNull_ReturnParam1 ()
    {
      final String testString = "This is a test string.";

      assertEquals(
        "StringUtils.nullToEmpty() should return the value passed to it if that value is not null.",
        testString,
        nullToEmpty(testString)
      );
    }
  }

  public static class implode
  {

    @Test
    public void When_Param1IsStringAndParam2IsStringArray_ReturnConcatenatedArrayValues ()
    {
      final String[] testArray  = new String[] { "This", "is", "the", "expected", "output", "value" };
      final String   glueString = "-_-";
      final String testString = testArray[0] + glueString + testArray[1] + glueString + testArray[2] + glueString
        + testArray[3] + glueString + testArray[4] + glueString + testArray[5];

      assertEquals(
        "StringUtils.implode() should join a string using the specified 'glue' string.",
        testString,
        implode(glueString, testArray)
      );
    }

    @Test
    public void When_Param1IsNull_ReturnNull ()
    {
      assertNull(
        "StringUtils.implode() should return null if passed null values to prevent internal errors.",
        implode(null, new String[] { "Test", "Values" })
      );
    }

    @Test
    public void When_Param2IsNull_ReturnNull ()
    {
      assertNull(
        "StringUtils.implode() should return null if passed null values to prevent internal errors.",
        implode(" ", null)
      );
    }

    @Test
    public void When_Param2IsEmptyArray_ReturnEmptyString ()
    {
      assertEquals(
        "StringUtils.implode() should return an empty string when passed an empty array of string 'pieces'.",
        "",
        implode(" ", new String[] {})
      );
    }
  }

  public static class wrap
  {
    @Test
    public void When_Param2IsLessThan1_ReturnOriginalString ()
    {
      final String
        testInput = "This is a test string that should be returned unchanged.",
        expectedOutput = "This is a test string that should be returned unchanged.";

      assertEquals(
        "StringUtils.wrap() should not attempt to wrap the given string when the wrap length is invalid (less than 1).",
        expectedOutput,
        wrap(testInput, 0)
      );
    }

    @Test
    public void When_Param1IsNull_ReturnNull ()
    {
      assertNull(
        "StringUtils.wrap() should return null when passed a null value to wrap.",
        wrap(null, 80)
      );
    }

    @Test
    public void wrapShouldWrapStringsToAGivenLengthOnSpacesOnly ()
    {
      final String testInput = "I am a string that is 82 characters long and I should be wrapped at 20 characters.";
      final String expected  = "I am a string that\nis 82 characters\nlong and I should be\nwrapped at 20\ncharacters.";

      assertEquals(
        "StringUtils.wrap() should wrap strings to a given length on the last space previous to hitting the length limit.",
        expected,
        wrap(testInput, 20)
      );
    }
  }

  public static class wrapToLineArray
  {
    @Test
    public void When_Param1IsNull_ReturnNull ()
    {
      assertNull(
        "StringUtils.wrapToLineArray() should return null when passed a null value to wrap.",
        wrapToLineArray(null, 80)
      );
    }

    @Test
    public void When_Param2IsLessThan1_ReturnArrayContainingOnlyOriginalString ()
    {
      final String   testInput      = "This is a test string that should be returned unchanged.";
      final String[] expectedOutput = new String[] { "This is a test string that should be returned unchanged." };

      assertArrayEquals(
        "StringUtils.wrapToLineArray() should not attempt to wrap the given string when the wrap length is invalid (less than 1).",
        expectedOutput,
        wrapToLineArray(testInput, 0)
      );
    }

    @Test
    public void When_ParamsAreValid_ReturnArrayOfStringsOfGivenLength ()
    {
      final String testInput = "I am a string that is 82 characters long and I should be wrapped at 20 characters.";
      final String[] expected = new String[] {
        "I am a string that",
        "is 82 characters",
        "long and I should be",
        "wrapped at 20",
        "characters."
      };

      assertArrayEquals(
        "StringUtils.wrapToLineArray() should wrap strings to a given length on the last space previous to hitting the length limit.",
        expected,
        wrapToLineArray(testInput, 20)
      );
    }
  }

  public static class padRight
  {
    @Test
    public void When_TargetParamIsNull_ReturnNull ()
    {
      assertNull("StringUtils.padRight(null, _, _) should return null.", StringUtils.padRight(null, '-', 9001));
      assertNull("StringUtils.padRight(null, _) should return null.", StringUtils.padRight(null, 9001));
    }

    @Test
    public void When_ParamsAreValid_ReturnStringPaddedOnRight ()
    {
      final int  padTo         = 80;
      final char padChar3Param = '-';
      final String
        stringToPad = "I am a test string.",
        expected3Param = "I am a test string.-------------------------------------------------------------",
        expected2Param = "I am a test string.                                                             ";

      assertEquals(
        "StringUtils.padRight(_, _, >5) should pad a given string to the given length with the given character.",
        expected3Param,
        StringUtils.padRight(stringToPad, padChar3Param, padTo)
      );

      assertEquals(
        "StringUtils.padRight(_, >5) should pad a given string to the given length with space characters.",
        expected2Param,
        StringUtils.padRight(stringToPad, padTo)
      );
    }

    @Test
    public void When_LengthParamIsShorterThanBreakOff_ReturnCorrectlyPaddedString ()
    {
      final int    padTo       = 4;
      final char   padChar     = 't';
      final String
        stringToPad = "Tes",
        expected3Param = "Test",
        expected2Param = "Tes ";

      assertEquals(
        "StringUtils.padRight(_, _, <5) should pad a given string to the given length with the given character.",
        expected3Param,
        StringUtils.padRight(stringToPad, padChar, padTo)
      );

      assertEquals(
        "StringUtils.padRight(_, <5) should pad a given string to the given length with the space character.",
        expected2Param,
        StringUtils.padRight(stringToPad, padTo)
      );
    }

    @Test
    public void When_LengthParamIsShorterThanTargetLength_ReturnOriginalString()
    {
      final int    padTo       = 4;
      final char   padChar     = 't';
      final String
        stringToPad = "Testing",
        expected3Param = "Testing",
        expected2Param = "Testing";

      assertEquals(
        "StringUtils.padRight(_, _, <5) should pad a given string to the given length with the given character.",
        expected3Param,
        StringUtils.padRight(stringToPad, padChar, padTo)
      );

      assertEquals(
        "StringUtils.padRight(_, <5) should pad a given string to the given length with the space character.",
        expected2Param,
        StringUtils.padRight(stringToPad, padTo)
      );
    }
  }

  public static class padLeft
  {
    @Test
    public void When_TargetParamIsNull_ReturnNull ()
    {
      assertNull("StringUtils.padLeft(null, _, _) should return null.", StringUtils.padLeft(null, '-', 9001));
      assertNull("StringUtils.padLeft(null, _) should return null.", StringUtils.padLeft(null, 9001));
    }

    @Test
    public void When_ParamsAreValid_ReturnStringPaddedOnRight ()
    {
      final int  padTo         = 80;
      final char padChar3Param = '-';
      final String
        stringToPad = "I am a test string.",
        expected3Param = "-------------------------------------------------------------I am a test string.",
        expected2Param = "                                                             I am a test string.";

      assertEquals(
        "StringUtils.padLeft(_, _, >5) should pad a given string to the given length with the given character.",
        expected3Param,
        StringUtils.padLeft(stringToPad, padChar3Param, padTo)
      );

      assertEquals(
        "StringUtils.padLeft(_, >5) should pad a given string to the given length with space characters.",
        expected2Param,
        StringUtils.padLeft(stringToPad, padTo)
      );
    }

    @Test
    public void When_LengthParamIsShorterThanBreakOff_ReturnCorrectlyPaddedString ()
    {
      final int    padTo       = 4;
      final char   padChar     = 'T';
      final String
        stringToPad = "est",
        expected3Param = "Test",
        expected2Param = " est";

      assertEquals(
        "StringUtils.padLeft(_, _, <5) should pad a given string to the given length with the given character.",
        expected3Param,
        StringUtils.padLeft(stringToPad, padChar, padTo)
      );

      assertEquals(
        "StringUtils.padLeft(_, <5) should pad a given string to the given length with the space character.",
        expected2Param,
        StringUtils.padLeft(stringToPad, padTo)
      );
    }

    @Test
    public void When_LengthParamIsShorterThanTargetLength_ReturnOriginalString()
    {
      final int    padTo       = 4;
      final char   padChar     = 't';
      final String
        stringToPad = "Testing",
        expected3Param = "Testing",
        expected2Param = "Testing";

      assertEquals(
        "StringUtils.padLeft(_, _, <5) should pad a given string to the given length with the given character.",
        expected3Param,
        StringUtils.padLeft(stringToPad, padChar, padTo)
      );

      assertEquals(
        "StringUtils.padLeft(_, <5) should pad a given string to the given length with the space character.",
        expected2Param,
        StringUtils.padLeft(stringToPad, padTo)
      );
    }
  }
}
