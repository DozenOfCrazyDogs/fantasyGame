package statisticanalyzer.service.impl.deprecated;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import statisticanalyzer.service.Normalization;
import statisticanalyzer.service.impl.utils.MathUtils;

/**
 * Created by Kiosani on 09.07.2016.
 */

@Slf4j
public class NormalizationImplPaxan implements Normalization {

    public double[][] norm(double input[][]) {

        double[][] result = new double[input.length][input[0].length];
        double[] array;
        double avg;
        double dev;
        for (int j = 0; j < input[0].length; j++) {
            array = MathUtils.getColumnForMatrix(input, j);
            avg = MathUtils.getAverage(array);
            dev = MathUtils.getStandardDeviation(array, avg);

            for (int i = 0; i < input.length; i++) {
                if (dev == 0) {
                    result[i][j] = 0;
                    log.info("[" + i + "][" + j + "]");
                }
                else {
                    result[i][j] = (input[i][j] - avg)/dev;
                    log.info("[" + i + "][" + j + "]");
                }
            }
        }

        /*double[] avg = average(input);
        double[] dev = deviation(input, avg);

        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < input[0].length; j++) {
                if (dev[j] == 0) {
                    result[i][j] = 0;
                    log.info("[" + i + "][" + j + "]");
                }
                else {
                    result[i][j] = (input[i][j] - avg[j])/dev[j];
                    log.info("[" + i + "][" + j + "]");
                }
            }
        }*/

        return result;
    }

    /*public double[][] norm4(double input[][]) {

        //double[][] result = new double[input.length][input[0].length];
        double[] array;
        double max;

        for (int j = 0; j < input[0].length; j++) {
            array = MathUtils.getColumnForMatrix(input, j);
            max = MathUtils.getMax(array);

            for (int i = 0; i < input.length; i++) {
                if (max == 0) {
                    input[i][j] = 0;
                }
                else {
                    input[i][j] = input[i][j] / max;
                }
            }
        }

        return input;

        double[] max_in_column = maxInColumn(input);

        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < input[0].length; j++) {
                if (max_in_column[j] == 0) {
                    result[i][j] = 0;
                    log.info("[" + i + "][" + j + "]");
                }
                else {
                    result[i][j] = input[i][j] / max_in_column[j];
                    log.info("[" + i + "][" + j + "]");
                }
            }
        }

        return result;
    }*/

   /* public double[][] norm5(double input[][]) {

        double[][] result = new double[input.length][input[0].length];
        double[] avg = average(input);
        double[] max_in_column = maxInColumn(input);
        double[] min_in_column = minInColumn(input);

        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < input[0].length; j++) {
                if (max_in_column[j] == min_in_column[j]) {
                    result[i][j] = 0;
                    log.info("[" + i + "][" + j + "]");
                }
                else {
                    result[i][j] = (input[i][j] - avg[j]) / (max_in_column[j] - min_in_column[j]);
                    log.info("[" + i + "][" + j + "]");
                }
            }
        }

        return result;
    }*/

    private double[] deviation(double mtrx[][], double avg_calc[]) {

        double[] dev_calc = new  double[mtrx[0].length];

        for (int j = 0; j < mtrx[0].length; j++) {
            double dev_temp_for_column = 0;
            for (int i = 0; i < mtrx.length; i++) {
                dev_temp_for_column = dev_temp_for_column + Math.pow((mtrx[i][j] - avg_calc[j]), 2);
            }
            dev_calc[j] = Math.sqrt(dev_temp_for_column / mtrx.length);
            log.info(" Deviation [" + j + "][" + dev_calc[j] + "]");
        }

        return dev_calc;
    }

    private double[] average(double mtrx[][]) {
        double[] avg_calc = new double[mtrx[0].length];

        for (int j = 0; j < mtrx[0].length; j++) {
            avg_calc[j] = 0;
            for (int i = 0; i < mtrx.length; i++) {
                avg_calc[j] = avg_calc[j] + mtrx[i][j];
            }
            avg_calc[j] = avg_calc[j] / mtrx.length;
            log.info(" Average [" + j + "][" + avg_calc[j] + "]");
        }
        return avg_calc;
    }

    private double[] maxInColumn(double mtrx[][]) {
        double[] max_calc = new double[mtrx[0].length];

        for (int j = 0; j < mtrx[0].length; j++) {
            max_calc[j] = mtrx[0][j];
            for (int i = 0; i < mtrx.length; i++) {
                if (mtrx[i][j] > max_calc[j]) {
                    max_calc[j] = mtrx[i][j];
                }
            }
        }
        return max_calc;
    }

    private double[] minInColumn(double mtrx[][]) {
        double[] min_calc = new double[mtrx[0].length];

        for (int j = 0; j < mtrx[0].length; j++) {
            min_calc[j] = mtrx[0][j];
            for (int i = 0; i < mtrx.length; i++) {
                if (mtrx[i][j] < min_calc[j]) {
                    min_calc[j] = mtrx[i][j];
                }
            }
        }
        return min_calc;
    }
}
