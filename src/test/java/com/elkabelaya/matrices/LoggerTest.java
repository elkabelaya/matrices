
package com.elkabelaya.matrices;

import com.elkabelaya.matrices.Logger;
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
public class LoggerTest {
    
    public LoggerTest() {
    }
    

    /**
     * Test of getInstance method, of class Logger.
     */
    @Test
    public void testGetInstance() {
        System.out.println("getInstance");
        Logger result = Logger.getInstance();
        Logger other = Logger.getInstance();
        assertEquals(other, result);
        
    }

    
    
}
