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

