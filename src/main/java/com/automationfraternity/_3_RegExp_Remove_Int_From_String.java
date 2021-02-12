
/*
Create by Akash Tyagi on 11 Feb 2021.
Download the whole repo and navigate to the mentioned class to execute the program in your system.
 */
package com.automationfraternity;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
* Problem: Remove All numbers from the String
* Use Link to know more on Regular Expression: https://www.w3schools.com/java/java_regex.asp
 */
public class _3_RegExp_Remove_Int_From_String {

    public static void main(String[] args){

        String string = "I am A45ka6sh I 7am8 Akash I9 Am A0kas4h 234345";
        Pattern pattern = Pattern.compile("[0-9]");
        Matcher matcher = pattern.matcher(string);
        System.out.println(matcher.replaceAll(""));
    }
}
/*
Output: I am Akash I am Akash I Am Akash
 */
