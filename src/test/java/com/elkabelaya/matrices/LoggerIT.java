
package com.elkabelaya.matrices;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author elkabelaya
 */
public class LoggerIT {
    
    public LoggerIT() {
    }
   
    @Test
    public void testSaveMultiplyMatrixResult() {
        System.out.println("testSaveMultiplyMatrixResult");
        
        double[][] matrix = new double[][] {
                              new double[]{2d,	0d},
                              new double[]{-1d,	3d},
        };
        
        File f = new File("log.txt");
        Scanner scanner;
        String line;
        DateFormat df = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        df.setLenient(false);
           
            
        try{
            f.delete();
        } catch(Exception ex){
             //do nothing
        }
        
        try {
            (new SquareMatrix(matrix)).multiplyTo( new SquareMatrix(matrix), 3 );

        } catch (Exception ex){
           System.out.println(ex.toString()); 
        }
        
        
        try {
            scanner = new Scanner(f);
            line = scanner.nextLine();
            
            df.parse(line);//first line is date
            assert (true);
            
            line = scanner.nextLine();
            line = scanner.nextLine();
            assertEquals(line, "multiplyMatrixes: ");
            
            line = scanner.nextLine();
            assertEquals(line, "firstMatrix:");
            
            line = scanner.nextLine();
            assertEquals(line, " 		2.0		0.0");
            
            line = scanner.nextLine();
            line = scanner.nextLine();
            line = scanner.nextLine();
            assertEquals(line, "secondMatrix:");
            
            line = scanner.nextLine();
            line = scanner.nextLine();
            line = scanner.nextLine();
            line = scanner.nextLine();
            
            assertEquals(line, "using num of threads: 3");
            
            line = scanner.nextLine();
            
            line = scanner.nextLine();
            
            while(line.indexOf("--") != 0){
            assert(line.indexOf("run thread ") == 0 ||
                    line.indexOf("counts Element") > 0 ||
                    line.indexOf("stop thread ") == 0
                    );
            line = scanner.nextLine();
            }
            
            line = scanner.nextLine();
            assertEquals(line, "result of multiplication:");
            
            
            
            
        } catch(Exception e) { 
            fail(e);
        }
    }
    
}
