package statisticanalyzer.service.impl;

import statisticanalyzer.service.Normalization;
import statisticanalyzer.service.impl.utils.MathUtils;

/**
 * Created by Kiosani on 14.07.2016.
 */
public class NormalizationMaxMinStrategy implements Normalization {
    @Override
    public double[][] norm(double input[][]) {
        double[] array;
        double max;
        double min;
        double avg;
        for (int j = 0; j < input[0].length; j++) {
            array = MathUtils.getColumnForMatrix(input, j);
            max = MathUtils.getMax(array);
            min = MathUtils.getMin(array);
            avg = MathUtils.getAverage(array);
            for (int i = 0; i < input.length; i++) {
                if (max == min) {
                    input[i][j] = 0;
                }
                else {
                    input[i][j] = (input[i][j] - avg) / (max - min);
                }
            }
        }
        return input;
    }
}
