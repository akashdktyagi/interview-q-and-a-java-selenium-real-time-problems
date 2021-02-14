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
