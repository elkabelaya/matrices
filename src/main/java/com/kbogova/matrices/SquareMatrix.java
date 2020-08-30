/*
 * Describes SquareMatrix
 */
package com.kbogova.matrices;

/**
 *
 * @author elkabelaya
 */
public class SquareMatrix {
    private int size;
    private double[][] matrix;

    private MatricsIterator iterator;

    //creates empty square matrix
    SquareMatrix(int size){
        this.size = size;
        matrix = new double[size][size];
        iterator = new MatricsIterator(size);
    }

    //creates matrix with data
    SquareMatrix(double[][] matrix)   throws Exception {
        if (!areDataCorrect(matrix)){
            throw new Exception ("invalid initial data");
        }

        this.matrix = matrix;
        size = matrix[0].length;
        iterator = new MatricsIterator(size);
    }

    //checks sizes of initial data
    private boolean areDataCorrect(double[][] matrix){
        int size = matrix.length;
        for (int i = 0; i < matrix.length; i++){
            if (matrix[i].length != size){
                return false;
            }
        }

        return true;
    }

    // returns size of square matrix (i.e. number of rows/columns)
    int getSize(){
        return size;
    }

    //returns matrix string presentation
    public String  toString(){
        String result = "";
        for (int i = 0; i < size; i++){
            for (int j = 0; j < size; j++){
                result += "\t\t" + matrix[i][j];
            }
            result += "\n";
        }
        return result;
    }

    //returns matrix iterator
    MatricsIterator getIterator(){
        return iterator;
    }

    //returns new matrix, as a resutl of multiplying current matrix and sended one;
    //the multiplying is processed using number of threads
    SquareMatrix multiplyTo(SquareMatrix matrixToMultiply, int inThreads)  throws Exception{

        if (this.getSize() != matrixToMultiply.getSize()){
            throw new Exception("impossible to multiply matrixes with different sizes");
        }

        if (inThreads <= 0){
            throw new Exception("num of threads must be > 0");
        }

        MatricsThread thread;
        MatricsThread[] threads = new MatricsThread[inThreads];
        SquareMatrix resultMatrix = new SquareMatrix(this.size);

        Logger.info ("----------------------");
        Logger.info ("multiplyMatrixes: ");
        Logger.info ("firstMatrix:\n " + this.toString());
        Logger.info ("secondMatrix:\n " + matrixToMultiply.toString());
        Logger.info ("using num of threads: " + inThreads);
        Logger.info ("----------------------");


        resultMatrix.getIterator().start();

        for (int i=0; i<threads.length; i++){
            threads[i] = new MatricsThread(resultMatrix,this, matrixToMultiply);
            threads[i].start();

        }

        for (int i=0; i<threads.length; i++){
            try {
                threads[i].join();
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }

        }
        Logger.info ("----------------------");
        Logger.info ("result of multiplication:\n " +resultMatrix.toString());
        Logger.info ("----------------------");
        return resultMatrix;

    }

    //returns value of Cij
    double getValue(CellPosition position){
      return this.matrix[position.i][position.j];
    }

    //sets value to Cij
    void setValue(CellPosition position, double value){
      this.matrix[position.i][position.j] = value;
    }
}
