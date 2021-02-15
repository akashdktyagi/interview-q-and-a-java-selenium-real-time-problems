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
