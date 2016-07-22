package statisticanalyzer.service.impl;

import org.junit.Assert;
import org.junit.Test;
import statisticanalyzer.service.Normalization;
import statisticanalyzer.service.impl.deprecated.NormalizationImplPaxan;

import static org.junit.Assert.assertEquals;

/**
 * Created by Igor on 11.07.2016.
 */
public class NormalizationStandartDeviationStrategyTest {

    private NormalizationStandartDeviationStrategy normilizer = new NormalizationStandartDeviationStrategy();

    @Test
    public void shouldWorkForDefaultNumbers() throws Exception {
        //given
        double[][] matrix = new double[][]{
                {11, 142, 173},
                {121, 12, 139},
                {11, 112, 153},
                {131, 12, 133},
        };
        //when
        double[][] result = normilizer.norm(matrix);
        //then

        double[][] expected = new double[][]{
                {-0.9981, 1.2400, 1.5273},
                {0.9113, -0.9834, -0.6824},
                {-0.9981, 0.7269, 0.2275},
                {1.0849, -0.9834, -1.0724},

        };
        assertMatrixEquals(expected, result);
    }

    @Test
    public void shouldSetValueToZeroIfColumnCollectSameValues() throws Exception {
        //given
        double[][] matrix = new double[][]{
                {11, 142, 173},
                {11, 12, 139},
                {11, 112, 153},
                {11, 12, 133},
        };
        //when
        double[][] result = normilizer.norm(matrix);
        //then
        double[][] expected = new double[][]{
                {0, 1.2400, 1.5273},
                {0, -0.9834, -0.6824},
                {0, 0.7269, 0.2275},
                {0, -0.9834, -1.0724},

        };
        assertMatrixEquals(expected, result);
    }

    @Test
    public void shouldWorkForNegativeValues() throws Exception {
        //given
        double[][] matrix = new double[][]{
                {-11, -142, -173},
                {-11, -12, -139},
                {-14, -112, -153},
                {-15, -12, -133},
        };
        //when
        double[][] result = normilizer.norm(matrix);
        //then
        double[][] expected = new double[][]{
                {0.9802, -1.2400, -1.5273},
                {0.9802, 0.9834, 0.6824},
                {-0.7001, -0.7269, -0.2275},
                {-1.2603, 0.9834, 1.0724},

        };
        assertMatrixEquals(expected, result);
    }

    @Test
    public void shouldWorkForOneRow() throws Exception {
        //given
        double[][] matrix = new double[][]{
                {-11, -142, -173}

        };
        //when
        double[][] result = normilizer.norm(matrix);
        //then
        double[][] expected = new double[][]{
                {0, 0, 0}
        };
        assertMatrixEquals(expected, result);
    }

    @Test
    public void shouldWorkForOneColumn() throws Exception {
        //given
        double[][] matrix = new double[][]{
                {-11},
                {-142},
                {-173}
        };
        //when
        double[][] result = normilizer.norm(matrix);
        //then
        double[][] expected = new double[][]{
                {1.3910},
                {-0.4748},
                {-0.9163}
        };
        assertMatrixEquals(expected, result);
    }
  @Test
    public void shouldWorkForMatrixOnexOne() throws Exception {
        //given
        double[][] matrix = new double[][]{
                {-11}
        };
        //when
        double[][] result = normilizer.norm(matrix);
        //then
        double[][] expected = new double[][]{
                {0}
        };
        assertMatrixEquals(expected, result);
    }

    private void assertMatrixEquals(double[][] expected, double[][] result) {
        if (expected.length != result.length)
            Assert.fail("Rows are not equals: expected=" + expected.length + "; actual=" + result.length);
        if (expected[0].length != result[0].length)
            Assert.fail("Columns are not equals: expected=" + expected[0].length + "; actual=" + result[0].length);
        for (int i = 0; i < expected.length; i++)
            for (int j = 0; j < expected[0].length; j++)
                assertEquals(expected[i][j], result[i][j], 0.0001);
    }

    private void printMatrix(double[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(String.format("%.4f    ", matrix[i][j]));
            }
            System.out.println();
        }
    }
}