# interview-q-and-a-java-selenium-real-time-problems
This aim of this repo is to maintain the questions and solutions for typical Automation Testing Code related Interviews.

---

> * Created by <b>Akash Tyagi</b> on 10 Feb 2021 for training purposes
> * Download the whole repo and navigate to the mentioned class to execute the program in your system.

---

### List of Programs and their solutions which are being asked in  Real Time Automation Testing interviews.

* 1. Problem: Find Factorial of the Number using Recursion technique

```java
/*
Create by Akash Tyagi on 10 Feb 2021.
Download the whole repo and navigate to the mentioned class to execute the program in your system.
 */

/*
Problem: Find Factorial of the Number using Recursion technique
 */
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

```
---

* 2. Problem: Write a code which takes any String and prints all the words and their corresponding count

```java
/*
Create by Akash Tyagi on 11 Feb 2021.
Download the whole repo and navigate to the mentioned class to execute the program in your system.
 */

/*
Problem: Write a code which takes any String and prints all the words and their corresponding count
 */
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

```

---

* 4. Problem: Remove All numbers from the String
* Use Link to know more on Regular Expression: https://www.w3schools.com/java/java_regex.asp

```java
/*
Create by Akash Tyagi on 11 Feb 2021.
Download the whole repo and navigate to the mentioned class to execute the program in your system.
 */

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

```

---

* 5. Cucumber tags And, Or, Not Operations.
    
* Tags can be sent from maven command line using: ```mvn test -Dcucumber.filter.tags="@sanity and @regression"```
* Also can be sent from cucumber options: ```@CucumberOptions(tags = "@smoke and @fast")```
  
* ```tags="@Sanity"``` :  Will Run Scenario which is tagged with Sanity. Does not matter if it has other tags as well.
* ```tags="@Sanity and @Regression"``` : Will Run Scenario which is tagged with Sanity as well as Regression.
* ```tags="@Sanity and not @Regression"``` :  Will Run Scenario which is tagged with Sanity but not Regression.
* ```tags="@Sanity or @Regression"``` : Will Run Scenario tagged with Sanity or Regression.

* Complex Case: I want to run @Sanity and @ui, but not @Regression
* ```tags="@Sanity and @ui"``` : Will Run Scenario tagged with @Sanity and @ui. But this also run test case which has @Sanity, @Ui but other tags as well.
* So, I should write: ```tags="@Sanity and @ui and (not @Regression)```

* Check this link for more: https://cucumber.io/docs/cucumber/api/

> ![Image](1.png)

* Runner File:

```java
package com.automationfraternity;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
@RunWith(Cucumber.class)
@CucumberOptions(
        features="classpath:features/MyFeature.feature",//this file is under src/main/resources
        glue="com.automationfraternity",
        tags="@Sanity and @ui and (not @Regression)",
        plugin = {"pretty",
                "html:target/html/htmlreport.html"
        },
        publish=false,
        dryRun=false
)
public class _4_Cucumber_Tags_Problem {
}
```

* Glue File:

```java
package com.automationfraternity;
import io.cucumber.java.en.Given;
public class _4_Cucumber_Tags_Problem_Glue {
    @Given("I am Scenario1 Sanity Only")
    public void i_am_scenario1_sanity_only() { System.out.println("Scn 1 - Sanity");}

    @Given("I am Scenario2 Sanity Only")
    public void i_am_scenario2_sanity_only() { System.out.println("Scn 2 - Sanity");}

    @Given("I am Scenario3 Regression Only")
    public void i_am_scenario3_regression_only() { System.out.println("Scn 3 - Regression");}

    @Given("I am Scenario4 Regression Only")
    public void i_am_scenario4_regression_only() { System.out.println("Scn 4 - Regression");}

    @Given("I am Scenario5 Sanity and Regression both")
    public void i_am_scenario5_sanity_and_regression_both() { System.out.println("Scn 5 - Sanity & Regression");}

    @Given("I am Scenario6 Sanity and Regression both")
    public void i_am_scenario6_sanity_and_regression_both() { System.out.println("Scn 6 - Sanity & Regression");}

    @Given("I am Scenario7 Sanity and Regression both")
    public void i_am_scenario7_sanity_and_regression_both() { System.out.println("Scn 7 - Sanity & Regression");}

    @Given("I am Scenario8 Sanity and Regression both")
    public void i_am_scenario8_sanity_and_regression_both() { System.out.println("Scn 8 - Sanity & Regression");}
}
```
