/*
 * Writes info to console; Singleton
 */
package com.elkabelaya.matrices;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;

/**
 *
 * @author elkabelaya
 */
public class Logger {
    private static volatile Logger instance;
    public boolean allowDebug = true;
    public boolean allowInfo = true;
    
    public static Logger getInstance() {
        Logger localInstance = instance;
        if (localInstance == null){
            synchronized (Logger.class) {
                localInstance = instance;
                if (localInstance == null){
                    instance = localInstance = new Logger();
                    Date date = new Date();
                    SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
                    instance.info(formatter.format(date));
                }
            }
        }

       return localInstance;
   }

    void debug(String value){
        if (allowDebug){
            writeToFile(value);
        }
    }
    void info(String value){
        if (allowInfo){
            writeToFile(value);
        }
    }
    
    synchronized void writeToFile(String str) {
    
        FileWriter writer = null;
        var path = "log.txt";
        try {
            
            //System.out.println("write log to " + path);
            writer = new FileWriter(new File(path), true);
            writer.write(str + System.lineSeparator());
        } catch (IOException ex) {
            System.out.println( ex);
        } finally {
            try {
                writer.close();
            } catch (IOException ex) {
                System.out.println(ex);
            }
        }
        
        
    }
    
}
