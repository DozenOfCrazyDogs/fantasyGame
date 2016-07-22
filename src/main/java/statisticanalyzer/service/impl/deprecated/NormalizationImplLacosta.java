package statisticanalyzer.service.impl.deprecated;

import statisticanalyzer.service.Normalization;

/**
 * Created by НОЗДОРМУ on 11.07.2016.
 */
public class NormalizationImplLacosta implements Normalization {
    @Override
    public double[][] norm(double[][] matrix) {

        double[][] result = new double[matrix.length][matrix[0].length];
        double sum;
        double[] avg = new double[matrix[0].length];
        double sum2;
        double[] a = new double[matrix[0].length];

        for (int j = 0; j < matrix[0].length; j++) {
            sum = 0;
            sum2 = 0;
            for (int i = 0; i < matrix.length; i++) {
                sum += matrix[i][j];
            }
            avg[j] = sum / matrix.length;
            for (int i = 0; i < matrix.length; i++) {
                sum2 += (matrix[i][j] - avg[j]) * (matrix[i][j] - avg[j]);
            }
            a[j] = Math.sqrt(sum2 / matrix.length);
            for (int i = 0; i < matrix.length; i++) {
                if (a[j] <= 0.0001) {
                    result[i][j] = 0;
                } else {
                    result[i][j] = (matrix[i][j] - avg[j]) / a[j];
                }
            }
        }

        return result;
    }
}
