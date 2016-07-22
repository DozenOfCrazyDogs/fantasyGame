package statisticanalyzer.service.impl.utils;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Igor on 14.07.2016.
 */
public class MathUtilsTest {


    @Test
    public void testDispersion(){
        double[] x = new double[]{11,121,11,131};

        System.out.println(MathUtils.getDispersion(x));
    }
}