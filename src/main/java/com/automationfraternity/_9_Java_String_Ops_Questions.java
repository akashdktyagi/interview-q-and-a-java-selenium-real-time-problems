/*
Create by Akash Tyagi on 10 Feb 2021.
Download the whole repo and navigate to the mentioned class to execute the program in your system.
 */

/*
* Listing below String manipulation Interview Questions. Wrote my own solutions as well. Use below link for original link
* Link: https://www.java67.com/2018/04/21-string-programming-and-coding-interview-questions-answers.html

*/
package com.automationfraternity;
import java.util.*;


public class _9_Java_String_Ops_Questions {
    public static void main(String[] args){

        //-------------------------------------------------------------------------------------------------
        /* Problem1: Write an efficient Java/C/Python program to return the maximum occurring character in the input string,
            e.g., if the input string is "Java" then the function should return 'a'.
         */
        m1_get_the_max_occuring_char_in_string("AkashTyagi");

        //-------------------------------------------------------------------------------------------------
        /* Problem2: How to remove all duplicates from a given string?
            Write a program to remove all the duplicate characters from a given input String, like,
            if the given String is "Java" then the output should be "Java".
            The second or further occurrence of duplicates should be removed.
         */
        m2_remove_all_duplicates_from_string("AkashAkashAkashAkash");

        //-------------------------------------------------------------------------------------------------
        /* Problem 3:How to remove characters from the first String which are present in the second String
            For example, if the first String "India is great"
            and the second String is "in" then the output should be "da s great"
         */
        m3_remove_duplicate_characters_from_first_string_present_in_second_string("India is great","In");
        //-------------------------------------------------------------------------------------------------

        /* Problem 4:How to check if two strings are rotations of each other?
            Write an efficient program to test if two given String is a rotation of each other or not,
            e.g. if the given String is "XYZ" and "ZXY" then your function should return true,
            but if the input is "XYZ" and "YXZ" then return false.
        */
        m4_check_string_is_rotation_or_not("AKASH","KASAH");
        m4_check_string_is_rotation_or_not("XYZS","ZSXY");

        //-------------------------------------------------------------------------------------------------
        //yet to be written
        /*
        5. Reverse a string
        6. print all permutations
        7. Reverse the words in the Sentence
        8. Check two string is an anagram
        9. Check String is palindrome
        10. Roman Numeral to Integer
        11. Integer to Roman Numeral
        12. How do you check if a given string contains valid parentheses?
         */
    }

    public static void m1_get_the_max_occuring_char_in_string(String str){
        System.out.println("==>Output of Program: m1_get_the_max_occuring_char_in_string");
        Character tempChar;
        HashMap<Character,Integer> hm = new HashMap<Character,Integer>();

        //First get all the chars and their count in Hash Map
        for (int i=0;i<str.length();i++){
            tempChar = str.charAt(i);

            if (hm.containsKey(tempChar)){
                hm.put(tempChar,hm.get(tempChar)+1);
            }else{
                hm.put(tempChar,1);
            }
        }

        System.out.println("Character Count of the String: " + hm.toString());

        //Iterate through the Hash Map to get the max number
        Character maxNumberChar=null;
        Integer maxNumber=0;
        for(Map.Entry<Character,Integer> entry:hm.entrySet()){
            if (entry.getValue()>maxNumber){
                maxNumber = entry.getValue();
                maxNumberChar = entry.getKey();
            }
        }
        System.out.println("Character with Max number: " + maxNumberChar);
    }

    public static void m2_remove_all_duplicates_from_string(String str){
        System.out.println("==>Output of Program: m2_remove_all_duplicates_from_string");
        System.out.println("Original String: " + str);
        Set<Character> characterSet = new LinkedHashSet<Character>();
        for(int i=0;i<str.length();i++){
            characterSet.add(str.charAt(i));
        }

        //Convert Set to String
        StringBuilder sb = new StringBuilder();
        Iterator<Character> iterator = characterSet.iterator();
        while (iterator.hasNext()){
            sb.append(iterator.next());
        }

        System.out.println(sb.toString());
    }

    public static void m3_remove_duplicate_characters_from_first_string_present_in_second_string(String parentStr, String childStr ){
        System.out.println("==>Output of Program: m3_remove_duplicate_characters_from_first_string_present_in_second_string");
        Set<Character> characterSetParent = new LinkedHashSet<Character>();
        Set<Character> characterSetChild = new LinkedHashSet<Character>();

        for (int i=0;i<parentStr.length();i++){
            characterSetParent.add(parentStr.charAt(i));
        }

        for (int i=0;i<childStr.length();i++){
            characterSetChild.add(childStr.charAt(i));
        }

        //for removing we need difference of these two sets
        characterSetParent.removeAll(characterSetChild);

        //Convert set in String
        StringBuilder sb = new StringBuilder();
        Iterator<Character> iterator = characterSetParent.iterator();
        while(iterator.hasNext()){
            sb.append(iterator.next());
        }

        System.out.println(sb.toString());
    }

    public static void m4_check_string_is_rotation_or_not(String parentString, String childString){
        System.out.println("==>Output of Program: m4_check_string_is_rotation_or_not");
        String tempBack=null;
        String tempFront=null;
        String temp;
        boolean bIsCircular = false;
        ArrayList<String> list = new ArrayList<String>();
        for (int i=0;i<parentString.length()-1;i++){
            tempBack = parentString.substring(0,i+1);
            tempFront = parentString.substring(i+1,parentString.length());
            String.join("",tempFront,tempBack);
            list.add(String.join("",tempFront,tempBack));

            if ( String.join("",tempFront,tempBack).equals(childString) ){
                bIsCircular=true;
                break;
            }else{
                bIsCircular=false;
            }
        }

        System.out.println("Possible combinations: " + list.toString());

        if (bIsCircular){
            System.out.println("Child String is a Circular form of the parent String.");

        }else{
            System.out.println("Child String is a not Circular form of the parent String.");
        }

    }
}

/*Outputs of Above program:
==>Output of Program: m1_get_the_max_occuring_char_in_string
Character Count of the String: {A=1, a=2, s=1, T=1, g=1, h=1, y=1, i=1, k=1}
Character with Max number: a
==>Output of Program: m2_remove_all_duplicates_from_string
Original String: AkashAkashAkashAkash
Akash
==>Output of Program: m3_remove_duplicate_characters_from_first_string_present_in_second_string
dia sgret
==>Output of Program: m4_check_string_is_rotation_or_not
Possible combinations: [KASHA, ASHAK, SHAKA, HAKAS]
Child String is a not Circular form of the parent String.
==>Output of Program: m4_check_string_is_rotation_or_not
Possible combinations: [YZSX, ZSXY]
Child String is a Circular form of the parent String.


 */