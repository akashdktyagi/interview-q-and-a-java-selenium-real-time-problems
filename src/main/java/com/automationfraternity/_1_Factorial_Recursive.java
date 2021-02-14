/*
Create by Akash Tyagi on 10 Feb 2021.
Download the whole repo and navigate to the mentioned class to execute the program in your system.
 */

/*
Problem: Find Factorial of the Number using Recursion technique
 */
package com.automationfraternity;
public class _1_Factorial_Recursive {
    /*
    Recursive means calling itself. For some people, if you are fond of using for loops its not very natural.
    But, it not complicated either.
    In the below example, every time the same method is called but with one reduced value, unless reduced value becomes 1
    Then recursive method will start returning the product.
    You can visualize it as a Stack. Last method will start returning, which contains the product of the first two numbers.
     */
    public static void main(String[] args){

        //Simple factorial Example
        System.out.println("Simple Factorial Program Output: " + SimpleFactorial(5));

        //Recursive factorial Example
        System.out.println("Recursive Factorial Program Output: " + RecursiveFactorial(5));
    }

    public static int SimpleFactorial(int num){
        int result = 1;
        for (int i=1;i<num;i++){
            result = result * (i+1);
        }
        return result;
    }

    public static int RecursiveFactorial(int num){
        if (num>0){
            int result = num * RecursiveFactorial((num-1));
            return result;
        }else{
            return 1;
        }

    }
}
/*
Output:
Simple Factorial Program Output: 120
Recursive Factorial Program Output: 120
 */
