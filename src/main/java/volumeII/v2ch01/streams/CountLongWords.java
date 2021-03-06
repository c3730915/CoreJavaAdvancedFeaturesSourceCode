package volumeII.v2ch01.streams;

/**
 * @version 1.01 2018-05-01
 * @author Cay Horstmann
 */

import org.junit.Test;

import java.io.*;
import java.nio.charset.*;
import java.nio.file.*;
import java.util.*;

public class CountLongWords
{
    @Test
   public  void countLongWords() throws IOException
   {
      var contents = new String(Files.readAllBytes(
         Paths.get("src/main/java/volumeII/gutenberg/alice30.txt")), StandardCharsets.UTF_8);
      List<String> words = List.of(contents.split("\\PL+"));

      long count = 0;
      for (String w : words)
      {
         if (w.length() > 12) count++;
      }
      System.out.println(count);

      count = words.stream().filter(w -> w.length() > 12).count();
      System.out.println(count);

      count = words.parallelStream().filter(w -> w.length() > 12).count();
      System.out.println(count);
   }
}
