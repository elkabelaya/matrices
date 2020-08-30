/*
 * Runs tests for SquareMatrix.multiplyTo method
 */
package com.kbogova.matrices;

/**
 *
 * @author elkabelaya
 */
public class Tester {
    static void test(){
        Logger.allowInfo = true;
        //Logger.allowDebug = true;//uncomment if need to see which thread counted the cell
        try {
            if( incorrectMatrixSizesTest() &&
               incorrectThreadsNumberTest() &&
               zeroMatrix5threadsTest() &&
               zeroMatrix10threadsTest() &&
               matrixXMatrix3ThreadsTest() &&
               matrixXMatrix7ThreadsTest()){
                   Logger.print("all tests passed");
                   return;
               }

        } catch (Exception ex){

        }

        Logger.print("something failed");

    }

    private static boolean testTemplate(double[][] matrix1, double[][] matrix2 , double[][] expectedResult, int numThreads) throws Exception{
        try {
            return MatrixIsEqualTo( (new SquareMatrix(matrix1)).multiplyTo( new SquareMatrix(matrix2), numThreads ), expectedResult );

        } catch (Exception ex){
            throw ex;
        }

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

    private static boolean incorrectMatrixSizesTest() throws Exception{
        Logger.debug ("incorrectMatrixSizesTest");
        try{
           testTemplate (   new double[][] {
                              new double[]{2d, 0d},
                              new double[]{-1d, 3d},

                            },
                            new double[][] {
                              new double[]{2d, 0d, 0d},
                              new double[]{-1d, 0d, 0d},

                            },
                            null,
                            5

                        );
        } catch (Exception ex){
            return true;
        }
        return false;
    }

    private static boolean incorrectThreadsNumberTest() throws Exception{
        Logger.debug ("incorrectThreadsNumberTest");
        try{
           testTemplate (   new double[][] {
                              new double[]{2d, 0d},
                              new double[]{-1d, 3d},

                            },
                            new double[][] {
                              new double[]{2d, 0d},
                              new double[]{-1d, 3d},

                            },
                            null,
                            0

                        );
        } catch (Exception ex){
            return true;
        }
        return false;
    }

    private static boolean zeroMatrix5threadsTest() throws Exception{
       Logger.debug ("zeroMatrix5threadsTest");
       try{
           return testTemplate (
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

                        );
       } catch (Exception ex){
            throw ex;
        }

    }

    private static boolean zeroMatrix10threadsTest() throws Exception{
       Logger.debug ("zeroMatrix10threadsTest");
       try{
           return testTemplate (
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

                        );
       } catch (Exception ex){
            throw ex;
        }

    }

    private static boolean matrixXMatrix3ThreadsTest() throws Exception{
        Logger.debug ("matrixXMatrix3ThreadsTest");
        double[][] matrix = new double[][] {
                              new double[]{2d,	0d},
                              new double[]{-1d,	3d},

                            };
        try  {
            return testTemplate (
                        matrix,
                        matrix,
                        new double[][] {
                          new double[]{4d,	0d},
                          new double[]{-5d,	9d},

                        },
                        3

                    );
        } catch (Exception ex){
            throw ex;
        }

    }

    private static boolean matrixXMatrix7ThreadsTest() throws Exception{
        Logger.debug ("matrixXMatrix7ThreadsTest");
        double[][] matrix = new double[][] {
                              new double[]{2d,	0d},
                              new double[]{-1d,	3d},

                            };
        try {
            return testTemplate (
                        matrix,
                        matrix,
                        new double[][] {
                          new double[]{4d,	0d},
                          new double[]{-5d,	9d},

                        },
                        7

                    );
        } catch (Exception ex){
            throw ex;
        }

    }
}
