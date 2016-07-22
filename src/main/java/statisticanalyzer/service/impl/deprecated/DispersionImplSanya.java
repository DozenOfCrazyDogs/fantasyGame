package statisticanalyzer.service.impl.deprecated;

/**
 * Created by Neifn on 09/07/2016.
 */
public class DispersionImplSanya {

    public double[] disp(int[][] matrix) {

    double []z =  new double[matrix.length];



        for (int i = 0; i < matrix.length; i++) {
            double avrG = 0;
            for (int j = 0; j < matrix[0].length; j++) {
                avrG = avrG + matrix[i][j];
            }
            System.out.println(avrG + " rabotaet2");
            double averageG = avrG/matrix[0].length;
            double sum = 0;
            for (int j = 0; j < matrix[0].length; j++) {
                double sqr = (matrix[i][j] - averageG)*(matrix[i][j] - averageG);
                sum = sum + sqr;
            }
            z[i] = (sum/matrix[0].length);
            System.out.println(z[i] + "normas");
        }
            return z;
    }
}
