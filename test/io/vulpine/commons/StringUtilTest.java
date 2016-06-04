package io.vulpine.commons;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class StringUtilTest
{
  public static class Method_nullToEmpty {

    @Test
    public void When_Param1IsNull_ReturnEmptyString ()
    {
      assertEquals(
        "StringUtils.nullToEmpty() should return an empty string when passed a null value.",
        "",
        StringUtils.nullToEmpty(null)
      );
    }

    @Test
    public void When_Param1IsNotNull_ReturnParam1 ()
    {
      final String testString = "This is a test string.";

      assertEquals(
        "StringUtils.nullToEmpty() should return the value passed to it if that value is not null.",
        testString,
        StringUtils.nullToEmpty(testString)
      );
    }
  }

  public static class Method_implode {

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
        StringUtils.implode(glueString, testArray)
      );
    }

    @Test
    public void When_Param1IsNull_ReturnNull()
    {
      assertNull(
        "StringUtils.implode() should return null if passed null values to prevent internal errors.",
        StringUtils.implode(null, new String[] {"Test", "Values"})
      );
    }

    @Test
    public void When_Param2IsNull_ReturnNull()
    {
      assertNull(
        "StringUtils.implode() should return null if passed null values to prevent internal errors.",
        StringUtils.implode(" ", null)
      );
    }

    @Test
    public void When_Param2IsEmptyArray_ReturnEmptyString()
    {
      assertEquals(
        "StringUtils.implode() should return an empty string when passed an empty array of string 'pieces'.",
        "",
        StringUtils.implode(" ", new String[]{})
      );
    }
  }



  @Test
  public void wrapShouldWrapStringsToAGivenLengthOnSpacesOnly()
  {
    final String testInput = "I am a string that is 82 characters long and I should be wrapped at 20 characters.";
    final String expected = "I am a string that\nis 82 characters\nlong and I should be\nwrapped at 20\ncharacters.";

    assertEquals(
      "StringUtils.wrap() should wrap strings to a given length on the last space previous to hitting the length limit.",
      expected,
      StringUtils.wrap(testInput, 20)
    );
  }

  @Test
  public void wrapToArrayShouldWrapStringsToAnArrayOfSubStringsOfAGivenLengthOnSpacesOnly()
  {
    final String testInput = "I am a string that is 82 characters long and I should be wrapped at 20 characters.";
    final String expected = "I am a string that\nis 82 characters\nlong and I should be\nwrapped at 20\ncharacters.";

    assertEquals(
      "StringUtils.wrap() should wrap strings to a given length on the last space previous to hitting the length limit.",
      expected,
      StringUtils.wrap(testInput, 20)
    );
  }
}
