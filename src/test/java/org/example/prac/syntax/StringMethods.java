package org.example.prac.syntax;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Locale;

@RunWith(SpringRunner.class)
public class StringMethods {
    @Test
    public void testStringMethods() {
        // length of string
        String str = "Hello";
        System.out.println("Length of str is " + str.length());

        //concatenation
        System.out.println("Concatenated string " + str.concat("rohan"));

        //case changes
        System.out.println("case changes " + str.toLowerCase(Locale.ROOT) +  str.toUpperCase(Locale.ROOT));

        //trim removes space from start and end of string
        String exp = "     Batman    ,    ";
        System.out.println("trimmed string is : " + exp.trim());

        //char at
        System.out.println("hello at 1"+ "hello".charAt(1));

        //indexof return intedex of substring in main string
        String mainStr = "hello";
        String toTest = "lo";
        System.out.println("index is : " + mainStr.indexOf(toTest));

        //substring firstarg is starting index second is lastindex + 1
        System.out.println("substring  : " + str.substring(1,3));

        //equals, euqalsignorecase
    }

}
