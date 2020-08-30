/*
 * Writes info to console; Singleton
 */
package com.kbogova.matrices;

/**
 *
 * @author elkabelaya
 */
public class Logger {
    static boolean allowDebug = false;
    static boolean allowInfo = false;
    static void print(String value){
       System.out.println(value);
    }
    static void debug(String value){
        if (allowDebug){
            System.out.println(value);
        }
    }
    static void info(String value){
        if (allowInfo){
            System.out.println(value);
        }
    }
}
