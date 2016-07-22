package statisticanalyzer.service.impl;

import statisticanalyzer.service.Normalization;
import statisticanalyzer.service.impl.utils.MathUtils;

/**
 * Created by Kiosani on 14.07.2016.
 */
public class NormalizationStandartDeviationStrategy implements Normalization {
    @Override
    public double[][] norm(double input[][]) {
        double[] array;
        double avg;
        double dev;
        for (int j = 0; j < input[0].length; j++) {
            array = MathUtils.getColumnForMatrix(input, j);
            avg = MathUtils.getAverage(array);
            dev = MathUtils.getStandardDeviation(array, avg);
            for (int i = 0; i < input.length; i++) {
                if (dev == 0) {
                    input[i][j] = 0;
                }
                else {
                    input[i][j] = (input[i][j] - avg)/dev;
                }
            }
        }
        return input;
    }
}
