package statisticanalyzer.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import statisticanalyzer.service.Normalization;
import statisticanalyzer.service.impl.utils.MathUtils;


/**
 * Created by Igor on 11.07.2016.
 */
@Service
@Slf4j
public class NormalizationDispersionStrategy implements Normalization {


    @Override
    public double[][] norm(double[][] matrix) {

        for (int columnIndex = 0; columnIndex < matrix[0].length; columnIndex++) {

            double[] column = getColumnForMatrix(matrix, columnIndex);
            double average = MathUtils.getAverage(column);
            double standardDeviation = MathUtils.getStandardDeviation(column, average);

            for (int rowIndex = 0; rowIndex < matrix.length; rowIndex++) {
                double element = matrix[rowIndex][columnIndex];
                matrix[rowIndex][columnIndex] = normalizedValue(average, standardDeviation, element);
            }
        }
        return matrix;
    }

    private double[] getColumnForMatrix(double[][] matrix, int columnIndex) {
        double[] array = new double[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            array[i] = matrix[i][columnIndex];
        }
        return array;
    }


    private double normalizedValue(double average, double standardDeviation, double element) {
        if (standardDeviation == 0)
            return 0;
        return (element - average) / standardDeviation;
    }
}
