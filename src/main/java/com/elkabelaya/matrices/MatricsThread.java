/*
 * Thread which counts one of the cells when multiply
 */
package com.elkabelaya.matrices;

/**
 *
 * @author elkabelaya
 */
public class MatricsThread  extends Thread
{

  SquareMatrix matrix;
  SquareMatrix firstMatrix;
  SquareMatrix secondMatrix;

  MatricsThread ( SquareMatrix resultMatrix, SquareMatrix firstMatrix,  SquareMatrix secondMatrix)
  {
    this.matrix = resultMatrix;
    this.firstMatrix = firstMatrix;
    this.secondMatrix = secondMatrix;
  }

  public void run ()
  {
    CellPosition position;
    Double countedValue;

    Logger.getInstance().debug ("run thread " + this.getName());

    while ( matrix.getIterator().hasNext() ) {

        position = matrix.getIterator().next (this.getName());

        if (position != null){
            countedValue = 0d;
            for (int k = 0; k < matrix.getSize(); k++) {
                countedValue += firstMatrix.getValue(new CellPosition(position.i,k)) * secondMatrix.getValue(new CellPosition(k,position.j));
            }

            matrix.setValue (position, countedValue);
        }

        //pause the thread to free the matrix for other threads
	    try {
	        Thread.sleep(1);
	    } catch (InterruptedException ex) {
                ex.printStackTrace();
        }

      }

       Logger.getInstance().debug ("stop thread " + this.getName());
  }
}
