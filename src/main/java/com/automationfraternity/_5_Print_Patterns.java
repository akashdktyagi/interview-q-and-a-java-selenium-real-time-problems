/*
Create by Akash Tyagi on 14 Feb 2021.
Download the whole repo and navigate to the mentioned class to execute the program in your system.
 */

/*
Usefull Links: https://www.programiz.com/java-programming/examples/pyramid-pattern
 */
package com.automationfraternity;

public class _5_Print_Patterns {

    public static void main(String[] args){
        //Problem:1 Write a method which accepts a String and prints it in Pyramid pattern
        // Hint: For pyramid only two things to remember. 2i-1 for pyramid and (maxNum -2i) for inverted Pyramid
        m1_print_a_string_as_pyramid("Akash123456");

        //Problem:2 Write a method which accepts a number of rows and a character and prints it in half Pyramid pattern
        m2_print_half_pyramid_using_star('*',5);

        //Problem:3 Write a method which accepts a number of rows and prints numbers in half  Pyramid pattern
        m3_print_half_pyramid_using_numbers(5);

        //Problem:4 Write a method which accepts a number of rows and prints  half pyramid using alphabets
        m4_print_half_pyramid_using_alphabets(5);

        //Problem:5 Write a method which accepts a number of rows and prints  half pyramid using alphabets
        m5_print_half_pyramid_using_alphabets(5);

        //Problem:6 Write a method which accepts a number of rows and prints inverted half pyramid of *
        m6_print_inverted_half_pyramid(5);

        //Problem:7 Write a method which accepts a number of rows and prints inverted pyramid of *
        //Hint: For pyramid only two things to remember. 2i-1 for pyramid and (maxNum -2i) for inverted Pyramid
        m7_print_inverted_pyramid_of_star(9);

        //Pascal
        //yet to be done

        //Febonachi Series
        //Yet to be written


    }

    public static void m1_print_a_string_as_pyramid(String str){
        System.out.println("\nOutput for: m1_print_a_string_as_pyramid");
        int i=0;

        outerloop:
        while(true){
            //insert space
            for(int j=0;j<(str.length()/2) - i + 1;j++){
                System.out.print(" ");
            }

            //insert Character
            for (int k=0; k < (2*i-1) ;k++){
                System.out.print(str.charAt(k));
                if(k==str.length()-1){
                    break outerloop;
                }
            }
            System.out.println("");
            i=i+1;
        }
    }

    public static void m2_print_half_pyramid_using_star(char c, int numberOfRows){
        System.out.println("\n\nOutput for: m2_print_half_pyramid_using_star");
        for (int i=0;i<numberOfRows;i++){
            for(int j=0; j < i; j++){
                System.out.print(c);
            }
            System.out.println("");
        }
    }

    public static void m3_print_half_pyramid_using_numbers(int numberOfRows){
        System.out.println("\nOutput for: m3_print_half_pyramid_using_numbers");
        for (int i=0;i<numberOfRows;i++){
            for(int j=0;j<=i;j++){
                System.out.print(j+1);
            }
            System.out.println("");
        }
    }

    public static void m4_print_half_pyramid_using_alphabets(int numberOfRows){
        System.out.println("\nOutput for: m4_print_half_pyramid_using_alphabets");
        for (int i=0;i<numberOfRows;i++){
            for (int j=0;j<i;j++){
                System.out.print((char)(65+j));
            }
            System.out.println("");
        }
    }

    public static void m5_print_half_pyramid_using_alphabets(int numberOfRows){
        System.out.println("\nOutput for: m5_print_half_pyramid_using_alphabets");
        int alpAsciiCode=65;
        for (int i=0;i<numberOfRows;i++){
            for (int j=0;j<=i;j++){
                System.out.print((char)(alpAsciiCode));
            }
            alpAsciiCode = alpAsciiCode +1;
            System.out.println("");
        }
    }

    public static void m6_print_inverted_half_pyramid(int numberOfRows){
        System.out.println("\nOutput for: m6_print_inverted_half_pyramid");
        for(int i=numberOfRows;i > 0; i--){
            for (int j=0;j<i;j++){
                System.out.print("*");
            }
            System.out.println("");
        }
    }

    public static void m7_print_inverted_pyramid_of_star(int pyramidMaxCharacters){
        System.out.println("\nOutput for: m7_print_inverted_pyramid_of_star");
        for(int i=0;i<pyramidMaxCharacters;i++){

            //write gaps
            for(int j=0;j<i;j++){
                System.out.print(" ");
            }

            //write character
            for(int k=0;k<(pyramidMaxCharacters - 2*i);k++){
                System.out.print("*");
            }
            System.out.print("\n");
        }
    }
}

/* Text:
These are very common code questions people ask in the interviews.
There is no other way then to practice them and they also help in logic building.
Not putting in whole code here. Please check the code under ```src/main/java/com/automationfraternity/_5_Print_Patterns.java``` file.
Usefull Link: Usefull Links: https://www.programiz.com/java-programming/examples/pyramid-pattern

Below are the patterns covered:
Output for: m1_print_a_string_as_pyramid

     A
    Aka
   Akash
  Akash12
 Akash1234
Akash123456

Output for: m2_print_half_pyramid_using_star

*
**
***
****

Output for: m3_print_half_pyramid_using_numbers
1
12
123
1234
12345

Output for: m4_print_half_pyramid_using_alphabets

A
AB
ABC
ABCD

Output for: m5_print_half_pyramid_using_alphabets
A
BB
CCC
DDDD
EEEEE

Output for: m6_print_inverted_half_pyramid
*****
****
***
**
*

Output for: m7_print_inverted_pyramid_of_star
*********
 *******
  *****
   ***
    *
*/