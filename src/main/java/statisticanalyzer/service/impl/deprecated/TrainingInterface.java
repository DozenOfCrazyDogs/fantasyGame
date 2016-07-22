package statisticanalyzer.service.impl.deprecated;

/**
 * Created by Igor on 16.07.2016.
 */
public interface TrainingInterface {
    /**
     * return max element from the input array
     */
    double findMax(double[] array);

    /**
     * find min element from input array
     */
    double finxMin(double[]array);

    /**
     * return first min and then max element from array
     */
    double[] findMaxAndMin(double[] array);

    /**
     * method should return new array with length equals to sum of length of input arrays
     */
    double[] uniteTwoArraysIntoOne(double[]array1, double[] array2);

    /**
     * sum arrays. 1st element of result = 1st element of array1 + 1st element of array2 etc.
     */
    double[] sumArrays(double [] array1, double[] array2);

    /**
     * result = 1st element of array1 * 1st element of array2 etc.
     */
    double[] multiplyArrays(double[] array1, double[] array2);

    /**
     * find sum of all elements of array
     */
    double[] findSumOfArray(double[] array);

    /**
     * fin average element for array
     */
    double findAverage(double[] array);

    /**
     * fill all elements of matrix with 1
     * 1 1 1 1
     * 1 1 1 1
     * 1 1 1 1
     * 1 1 1 1
     */
    double[][] fillWIthOne(double[][] matrix);

    /**
     * fill all elements in first and last row
     * 1 1 1 1
     * 0 0 0 0
     * 0 0 0 0
     * 1 1 1 1
     */
    double[][] fillFirstAndLastRow(double[][] matrix);

    /**
     * fill all elements in first and last column
     * 1 0 0 1
     * 1 0 0 1
     * 1 0 0 1
     * 1 0 0 1
     */
    double[][] fillFirstAndLastColumn(double[][] matrix);

    /**
     * fill all elements for with their sum of indexes
     * 0+0 0+1 0+2 0+3
     * 1+0 1+1 1+2 1+3
     * 2+0 2+1 2+2 2+3
     * 3+0 3+1 3+2 3+3
     */
    double[][] fillElementsForSumOfIndexes(double[][] matrix);

    /**
     * 1 1 1 1
     * 1 0 0 1
     * 1 0 0 1
     * 1 1 1 1
     */
    double[][] frameFill(double[][] matrix);

    /**
     * Matrix only square-form 1x1 2x2 3x3 4x4 etc
     * 1 0 0 0
     * 0 1 0 0
     * 0 0 1 0
     * 0 0 0 1
     */
    double[][] fillDiagonal(double[][] matrix);

    /**
     * Matrix only square-form 1x1 2x2 3x3 4x4 etc
     * 0 0 0 1
     * 0 0 1 0
     * 0 1 0 0
     * 1 0 0 0
     */
    double[][] fillSecondDiagonal(double[][] matrix);

    /**
     * Matrix only square-form 1x1 2x2 3x3 4x4 etc
     * 1 0 0 1
     * 0 1 1 0
     * 0 1 1 0
     * 1 0 0 1
     */
    double[][] fillTwoDiagonals(double[][] matrix);

    /**
     * Matrix only square-form 1x1 2x2 3x3 4x4 etc
     * 1 0 0 1
     * 0 0 0 0
     * 0 0 0 0
     * 1 0 0 1
     */
    double[][] fillCorners(double[][] matrix);

    /**
     * Matrix only square-form 1x1 2x2 3x3 4x4 etc
     * 0  1  2  3
     * 4  5  6  7
     * 8  9  10 11
     * 12 13 14 15
     */
    double[][] fillIncrementally(double[][] matrix);

    /**
     * sort array: 1 4 5 3 7 -> 1 3 4 5 7
     */
    double[] sort(double[] array);

    /**
     * sort every array in matrix
     * 1 4 5 3 7     1 3 4 5 7
     * 9 3 4 5 6  -> 3 4 5 6 9
     * 9 2 2 2 1     1 2 2 2 9
     */
    double[][] sortMatrixByRows(double[][] matrix);



}
