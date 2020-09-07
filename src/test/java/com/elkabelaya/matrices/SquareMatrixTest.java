/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.elkabelaya.matrices;

import com.elkabelaya.matrices.CellPosition;
import com.elkabelaya.matrices.SquareMatrix;
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
public class SquareMatrixTest {
    
    public SquareMatrixTest() {
    }
    
    private static boolean Template(double[][] matrix1, double[][] matrix2 , double[][] expectedResult, int numThreads) throws Exception{
        try {
            return( MatrixIsEqualTo( (new SquareMatrix(matrix1)).multiplyTo( new SquareMatrix(matrix2), numThreads ), expectedResult ));

        } catch (Exception ex){
           System.out.println(ex.toString()); 
        }
        return false;
    }

    private static boolean MatrixIsEqualTo(SquareMatrix matrix, double[][] rawMatrix){
        for (int i=0; i< rawMatrix.length; i++){
            for (int j=0; j< rawMatrix[i].length; j++){
                if (matrix.getValue(new CellPosition(i,j)) != rawMatrix[i][j]){
                    return false;
                }
            }
        }

        return true;

    }
    
    /**
     * Test of getSize method, of class SquareMatrix.
     */
    @Test
    public void testGetSize() {
        System.out.println("getSize");
        int expResult = 2;
        SquareMatrix instance  = new SquareMatrix(2);
        int result = instance.getSize();
        assertEquals(expResult, result);
        
        try {
            instance  = new SquareMatrix(new double[][] {
                              new double[]{4d,	0d},
                              new double[]{-5d,	9d},

                            });
            result = instance.getSize();
            assertEquals(expResult, result);
        } catch(Exception ex){
            fail(ex.toString());
        }
        
    }

    /**
     * Test of toString method, of class SquareMatrix.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
         try {
            SquareMatrix instance = new SquareMatrix(new double[][] {
                                  new double[]{4,	0},
                                  new double[]{-5,	9},

                                });
            String expResult = "\t\t4.0\t\t0.0\n\t\t-5.0\t\t9.0\n";
            String result = instance.toString();
            assertEquals(expResult, result);
        } catch(Exception ex){
            fail(ex.toString());
        }
    }

    

    /**
     * Test of multiplyTo method, of class SquareMatrix.
     */
    @Test
    public void testMultiplyToIncorrectMatrixSizes() throws Exception {
        System.out.println("multiplyToIncorrectMatrixSizes");
        
        assertFalse( Template(
                new double[][] {
                    new double[]{2d, 0d},
                    new double[]{-1d, 3d},

                },
                new double[][] {
                  new double[]{2d, 0d, 0d},
                  new double[]{-1d, 0d, 0d},

                },
                null,
                5
        ));
        
    }
    
    
    
    @Test
    public void testMultiplyToIncorrectThreadsNumber() throws Exception {
        System.out.println("incorrectThreadsNumber");
        
        assertFalse( Template(
                new double[][] {
                    new double[]{2d, 0d},
                    new double[]{-1d, 3d},

                  },
                  new double[][] {
                    new double[]{2d, 0d},
                    new double[]{-1d, 3d},

                  },
                  null,
                  0
        ));
        
    }
    
    @Test
    public void testMultiplyToZeroMatrix5threads() throws Exception {
        System.out.println("zeroMatrix5threads");
        
        assert( Template(
                new double[][] {
                    new double[]{1d,	0d,	2d,	-1d},
                    new double[]{-2d,	0d,	-4d,	2d},
                    new double[]{1d,	0d,	2d,	-1d},
                    new double[]{3d,	0d,	6d,	-3d},

                  },
                  new double[][] {
                    new double[]{2d,	1d,	3d,	-1d},
                    new double[]{-4d,	-2d,	-6d,	2d},
                    new double[]{2d,	1d,	3d,	-1d},
                    new double[]{6d,	3d,	9d,	-3d},

                  },
                  new double[][] {
                    new double[]{0d,	0d,	0d,	0d},
                    new double[]{0d,	0d,	0d,	0d},
                    new double[]{0d,	0d,	0d,	0d},
                    new double[]{0d,	0d,	0d,	0d},

                  },
                  5
        ));
        
    }
    
     @Test
    public void testMultiplyToZeroMatrix10threads() throws Exception {
        System.out.println("zeroMatrix10threads");
        
        assert( Template(
                new double[][] {
                  new double[]{1d,	0d,	2d,	-1d},
                  new double[]{-2d,	0d,	-4d,	2d},
                  new double[]{1d,	0d,	2d,	-1d},
                  new double[]{3d,	0d,	6d,	-3d},

                },
                new double[][] {
                  new double[]{2d,	1d,	3d,	-1d},
                  new double[]{-4d,	-2d,	-6d,	2d},
                  new double[]{2d,	1d,	3d,	-1d},
                  new double[]{6d,	3d,	9d,	-3d},

                },
                new double[][] {
                  new double[]{0d,	0d,	0d,	0d},
                  new double[]{0d,	0d,	0d,	0d},
                  new double[]{0d,	0d,	0d,	0d},
                  new double[]{0d,	0d,	0d,	0d},

                },
                10
    ));
        
    }
     @Test
    public void testMultiplyToMatrixXMatrix3Threads() throws Exception {
        System.out.println("matrixXMatrix3Threads");
        
        
    
        double[][] matrix = new double[][] {
                              new double[]{2d,	0d},
                              new double[]{-1d,	3d},

                            };
        assert( Template(
                        matrix,
                        matrix,
                        new double[][] {
                          new double[]{4d,	0d},
                          new double[]{-5d,	9d},

                        },
                        3
));
        
    }

     @Test
    public void testMultiplyToMatrixXMatrix7Threads() throws Exception {
        System.out.println("matrixXMatrix7Threads");
        double[][] matrix = new double[][] {
                              new double[]{2d,	0d},
                              new double[]{-1d,	3d},

                            };
         assert( Template(
                        matrix,
                        matrix,
                        new double[][] {
                          new double[]{4d,	0d},
                          new double[]{-5d,	9d},

                        },
                        7
));
        
    }
    /**
     * Test of getValue method, of class SquareMatrix.
     */
    @Test
    public void testGetValue() {
        System.out.println("getValue");
        try {
            CellPosition position = new CellPosition(1,1);
            SquareMatrix instance = new SquareMatrix(new double[][] {
                                  new double[]{4,	0},
                                  new double[]{-5,	9},

                                });
            double expResult = 9;
            double result = instance.getValue(position);
            assertEquals(expResult, result, 0.0);
        } catch(Exception ex){
            fail(ex.toString());
        }
       
    }

    /**
     * Test of setValue method, of class SquareMatrix.
     */
    @Test
    public void testSetValue() {
        System.out.println("setValue");
        try {
            CellPosition position = new CellPosition(1,1);
            SquareMatrix instance = new SquareMatrix(new double[][] {
                                  new double[]{4,	0},
                                  new double[]{-5,	9},

                                });
            double expResult = 9;
            double result = instance.getValue(position);
            instance.setValue(position, expResult);
            assertEquals(expResult, result, 0.0);
        } catch(Exception ex){
            fail(ex.toString());
        }
    }
    
}
