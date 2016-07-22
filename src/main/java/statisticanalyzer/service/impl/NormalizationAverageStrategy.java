package statisticanalyzer.service.impl;

import statisticanalyzer.service.Normalization;
import statisticanalyzer.service.impl.utils.MathUtils;

/**
 * Created by Neifn on 12/07/2016.
 */
public class NormalizationAverageStrategy implements Normalization {
    @Override
    public double[][] norm(double[][] matrix) {
        double[] columb = new double[matrix[0].length]; // количество колонок - длина рядка, мы задали 0 рядок и его размер.
        for (int j = 0; j < matrix[0].length; j++) { // мы перебираем от первой колонки до последней
            for (int y = 0; y < matrix.length; y++){ // от первого рядка до последнего
                columb [y] = matrix[y][j];
            }
            double avrG = MathUtils.getAverage(columb);
            System.out.println(avrG + " rabotaet2");
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][j] = matrix[i][j] / avrG;
                System.out.println(matrix[i][j]);
            }
        }
        return matrix;
    }
}


