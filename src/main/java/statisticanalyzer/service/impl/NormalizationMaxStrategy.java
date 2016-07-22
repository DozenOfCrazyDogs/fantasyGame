package statisticanalyzer.service.impl;

import statisticanalyzer.service.Normalization;
import statisticanalyzer.service.impl.utils.MathUtils;

/**
 * Created by Kiosani on 14.07.2016.
 */
public class NormalizationMaxStrategy implements Normalization {
    @Override
    public double[][] norm(double input[][]) {
        double[][] result = new double[input.length][input[0].length];
        double[] array;
        double max;
        for (int j = 0; j < input[0].length; j++) {
            array = MathUtils.getColumnForMatrix(input, j);
            max = MathUtils.getMax(array);
            for (int i = 0; i < input.length; i++) {
                if (max == 0) {
                    result[i][j] = 0;
                }
                else {
                    result[i][j] = input[i][j] / max;
                }
            }
        }
        return result;
    }
}
