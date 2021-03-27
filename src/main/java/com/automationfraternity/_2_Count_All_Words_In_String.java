/*
Create by Akash Tyagi on 11 Feb 2021.
Download the whole repo and navigate to the mentioned class to execute the program in your system.
 */

/*
Problem: Write a code which takes any String and prints all the words and their corresponding count
 */
package com.automationfraternity;

import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class _2_Count_All_Words_In_String {

    public static void main(String[] args){
        String simpleStringOnlySpaces = "I am Akash I am Akash I am Akash I am Akash I am";
        GetCountOfEachWordInAString(simpleStringOnlySpaces);
    }

    // Assuming-Simple String no special characters.
    public static void GetCountOfEachWordInAString(String string){
        //First Split it using spaces
        String[] stringArray = string.split(" ");

        //This Hash Map will hold word and its count
        HashMap<String,Integer> hashMapWordCount = new HashMap<String,Integer>();

        int temp=0;// a simple temp variable to hold count
        for (int i=0;i< stringArray.length;i++){//loop through the array of words
            if (hashMapWordCount.containsKey(stringArray[i])){ //check if word is present in the hash map
                temp = (hashMapWordCount.get(stringArray[i])); //if yes then Get the value of the key
                hashMapWordCount.put(stringArray[i],temp+1); //increment it with 1 and save it under the same key i.e. update the count of the word
            }else{//if word is not found, then add it and add the count as 1
                hashMapWordCount.put(stringArray[i],1);
            }
        }
        System.out.println(hashMapWordCount.toString());
    }
}
/*
Output: {I=5, Akash=4, am=5}
 */
