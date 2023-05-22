/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Loggers;

import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;
import org.apache.log4j.RollingFileAppender;



/**
 *
 * @author nipun
 */
public class Log4JTest {
    public static void exceptionLogger() {
        try {
            
    String path = "D:/Exception_File/Exception";
    PatternLayout layout = new PatternLayout("%-10d %-3p %m %l %c %n");
    RollingFileAppender appender = new RollingFileAppender(layout, path);
    appender.setName("loggerdata");
    appender.setMaxFileSize("1MB");
    appender.activateOptions();
    Logger.getRootLogger().addAppender(appender);
        } catch (Exception e) {
            e.printStackTrace();
        }
  
    }
    
    
}
