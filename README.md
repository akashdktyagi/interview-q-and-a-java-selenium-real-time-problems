# interview-q-and-a-java-selenium-real-time-problems
This aim of this repo is to maintain the questions and solutions for typical Automation Testing Code related Interviews.

---

> * Created by <b>Akash Tyagi</b> on 10 Feb 2021 for training purposes
> * Download the whole repo and navigate to the mentioned class to execute the program in your system.

---

### List of Programs and their solutions which are being asked in  Real Time Automation Testing interviews.

### 1.Problem: Find Factorial of the Number using Recursion technique

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

### 2.Problem: Write a code which takes any String and prints all the words and their corresponding count

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

### 3.Problem: Remove All numbers from the String

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

### 4. Cucumber tags And, Or, Not Operations.
    
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
---

### 5. Print Patterns

* These are very common code questions people ask in the interviews.
* There is no other way then to practice them and they also help in logic building.
* Not putting in whole code here. Please check the code under ```src/main/java/com/automationfraternity/_5_Print_Patterns.java``` file.
* Usefull Link: https://www.programiz.com/java-programming/examples/pyramid-pattern

```text
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
     
```

---

### 6. Read the Text file and Count each Word

* Counting words is already covered in Problem # 2
* In this once I am rather focusing on Reading the text files:
* There are in-fact many ways a Text file can be read in java. (This actually makes things more confusing)
* Each way has different use cases.
* I am presenting few ways here. Which are very generic for fetching the text as a String for a simple and small text file.
* Usefull Link: https://www.geeksforgeeks.org/different-ways-reading-text-file-java/


```java
package com.automationfraternity;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.stream.Stream;

public class _6_Read_Text_File_Count_Each_Word {

    public static void main(String[] args) throws IOException {
        String url = System.getProperty("user.dir") +
                "/src/main/resources/_6_Read_Text_File_Count_Each_Word.txt";
        System.out.println("Path of the file: " + url);

        // There are different ways to read a Text file
        // Using Scanner Class
        String string = m1_read_text_file_using_scanner_class(url);

        // Method to Count words is already present in the below class
        // So directly called the method
        _2_Count_All_Words_In_String.GetCountOfEachWordInAString(string);

        // Using Nio Files to read the file
        string = m2_read_text_file_using_nio_Files(url);
        _2_Count_All_Words_In_String.GetCountOfEachWordInAString(string);
    }

    public static String m1_read_text_file_using_scanner_class(String url) throws FileNotFoundException {
        File file = new File(url);
        Scanner sc = new Scanner(file);
        StringBuilder sb = new StringBuilder();
        while(sc.hasNext()){
            sb.append(sc.nextLine());
        }
        return sb.toString();
    }

    public static String m2_read_text_file_using_nio_Files(String url) throws IOException {
        Path path = Paths.get(url);
        return Files.readAllLines(path).get(0);
    }

    /* yet to complete
    public static void m3_read_text_file_using_buffer(String url) throws IOException {
        File file = new File(url);
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        Stream<String> stringStream = bufferedReader.lines();
    }
    */

}

```

---

### 7. Handle Web Table in Selenium. Use Xpath Axes to get the parent and sibling elements

```java
/*
Create by Akash Tyagi on 10 Feb 2021.
Download the whole repo and navigate to the mentioned class to execute the program in your system.
 */

/*
Problem: Use of Xpath Axes to handle various ops in Web Table
Use Link: https://www.w3schools.com/xml/xpath_axes.asp
 */
package com.automationfraternity;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class _7_Selenium_Xpath_Axes_Table_Handling {
    private static WebDriver  driver=null;


    public static void main(String[] args){

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://www.seleniumeasy.com/test/table-sort-search-demo.html");

        //To get the name of the Employee with Highest Salary
        getNameOfTheEmployeeWithHighestSalary();

    }

    public static void getNameOfTheEmployeeWithHighestSalary(){
        String tempString;
        int tempInt;
        int maxSalary=0;
        int rowIndexOfMaxSalary=0;
        //Get all the TD
        List<WebElement> listOfSalaries = driver.findElements(By.xpath("//td[6]")); //Assuming the column index is fixed

        //Use Iterator to loop through each element,
        // In each loop we are doing below things:
        // 1. get text
        // 2. replace the extra characters
        // 3. convert to Integer and
        // 4. find the max number and store the index
        Iterator<WebElement> iterator = listOfSalaries.iterator();
        int i=0;
        while(iterator.hasNext()){
            tempString = iterator.next().getText();
            tempString = tempString.replace("$","").
                    replace(",","").
                    replace("/","").
                    replace("y","");
            tempInt = Integer.parseInt(tempString);

            if  (tempInt>maxSalary){
                maxSalary = tempInt;
                rowIndexOfMaxSalary = i;
            }

            i = i +1;// incrementing the counter to know the max salary
        }

        System.out.println("Max salary: " + maxSalary +
                " found at row number: " + rowIndexOfMaxSalary +
                " Original Text: " + listOfSalaries.get(rowIndexOfMaxSalary));

        // Now once we have received the max salary and its associated Row number we can easily find the Corresponding Employee name
        // However there are two ways to do it:
            // One using the index
            // Second using the Salary Value: This would require xpath axes logic

        // Method 1: use index to get the name of the employee. Paramatrized Xpath
        // Smthing like this: //tbody/tr[2]/td
        String nameOfTheEmployee = driver.findElement(By.xpath("//tbody/tr[" + (rowIndexOfMaxSalary + 1)  +"]/td")).getText();
        System.out.println("Name of the Employee with Highest Salary is: " + nameOfTheEmployee);

        // Method 2: using the xpath axes and making use to the salary
        // Simple Xpath can be this: //td[text()='$206,850/y']/parent::tr/td
        String nameOfTheEmployee1 = driver.findElement
                (By.xpath("//td[text()='"+listOfSalaries.get(rowIndexOfMaxSalary)+"']/parent::tr/td")).getText();

        System.out.println("Name of the Employee with Highest Salary is: " + nameOfTheEmployee);

    }
}

```
* Xpath Axes example to identify the parent and sibling with respect to one element
  > ![Image](Screenshot%202021-02-14%20at%206.35.04%20PM.png)
  
* Some Use-full Xpath Axes. 
* Refer link for more info: https://www.w3schools.com/xml/xpath_axes.asp
 > ![Image](Screenshot%202021-02-14%20at%206.36.32%20PM.png)
 
 > ![Image](Screenshot%202021-02-14%20at%206.36.42%20PM.png)
 
---

### 8. Singleton Class Data Base Connection

```java
/*
Create by Akash Tyagi on 10 Feb 2021.
Download the whole repo and navigate to the mentioned class to execute the program in your system.
 */

/*
Problem: What is Singleton Class, where do we use it
* Link: https://www.geeksforgeeks.org/singleton-class-java/

*/
package com.automationfraternity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class _8_Singleton_Pattern_For_DB {
    private static _8_Singleton_Pattern_For_DB instance;
    private Connection conn;

    private _8_Singleton_Pattern_For_DB(String url) {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            this.conn = DriverManager.getConnection(url);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        return this.conn;
    }

    public static _8_Singleton_Pattern_For_DB getInstance(String url) throws SQLException {
        if (instance==null) {
            instance= new _8_Singleton_Pattern_For_DB(url);
        }else if (instance.getConnection().isClosed()) {
            instance= new _8_Singleton_Pattern_For_DB(url);
        }
        return instance;
    }
}
```