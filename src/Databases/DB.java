/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Databases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import org.apache.log4j.Logger;

/**
 *
 * @author nipun
 */
public class DB {

            
    private static Connection c;
    private static final String USERNAME = "root";
    private static final String PASSWORD = "1234";
    private static final String CON_STRING = "jdbc:mysql://localhost:3306/my_retail?useUnicode=yes&characterEncoding=UTF-8";

    public static synchronized Connection getConnection() throws Exception {
        if (c == null) {
            Class.forName("com.mysql.jdbc.Driver");
            c = DriverManager.getConnection(CON_STRING, USERNAME, PASSWORD);
        }
        return c;
    }

    public static boolean iud(String query) {
        try {
            getConnection().createStatement().executeUpdate(query);
            return true;
        } catch (Exception e) {
         processException(e);
        }
        return false;
    }

    public static ResultSet search(String query) {
        try {
      
            return getConnection().createStatement().executeQuery(query);
        } catch (Exception e) {
            processException(e);

        }
        return null;
    }

    public static void processException(Exception e) {
     
            
          Loggers.Log4JTest.exceptionLogger();
           Logger logger = Logger.getLogger("Excepection");
            
            logger.error(e);
      
    }

    public static int iudReturnId(String sql) {
        try {
            PreparedStatement prepareStatement = getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            prepareStatement.executeUpdate();
            ResultSet generatedKeys = prepareStatement.getGeneratedKeys();
            if (generatedKeys.next()) {
                return generatedKeys.getInt(1);
            }

        } catch (Exception e) {
            processException(e);
        }
        return -1;
    }
}