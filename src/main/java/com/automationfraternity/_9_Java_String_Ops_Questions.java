package com.automationfraternity;
import java.util.*;

public class _9_Java_String_Ops_Questions {
    public static void main(String[] args){

        //-------------------------------------------------------------------------------------------------
        /* Problem1: Write an efficient Java/C/Python program to return the maximum occurring character in the input string,
            e.g., if the input string is "Java" then the function should return 'a'.
         */
        m1_get_the_max_occuring_char_in_string("AkashTyagi");
        /* Output:
            Character Count of the String: {A=1, a=2, s=1, T=1, g=1, h=1, y=1, i=1, k=1}
            Character with Max number: a
         */

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



    }

    public static void m1_get_the_max_occuring_char_in_string(String str){

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
}
