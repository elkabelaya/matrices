/*
 * Application enter point
 */
package com.elkabelaya.matrices;

/**
 *
 * @author elkabelaya
 */


public class Main
{
  public static void main (String[]args) throws Exception
  {

    double[][] matrix = new double[][] {
                              new double[]{2d,	0d},
                              new double[]{-1d,	3d},
        };
        
        
    (new SquareMatrix(matrix)).multiplyTo( new SquareMatrix(matrix), 3 );

  }
}
