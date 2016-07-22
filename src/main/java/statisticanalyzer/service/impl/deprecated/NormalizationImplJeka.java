package statisticanalyzer.service.impl.deprecated;

import statisticanalyzer.service.Normalization;

/**
 * Created by НОЗДОРМУ on 10.07.2016.
 */
public class NormalizationImplJeka implements Normalization {
    @Override
    public double[][] norm(double[][] matrix) {


        System.out.println("Посчитаем каждый элемент матриц U и L");
        //comment
        double[][] a = new double[matrix.length][matrix.length];
        double[][] b = new double[matrix.length][matrix.length];
        for (int j=0; j< matrix.length; j++){
            a[0][j]=matrix[0][j];
        }
        for (int j =0; j<matrix.length; j++){
            b[j][0]=matrix[j][0]/a[0][0];
            b[j][j]=1;
        }
        double sum = 0;
        double sum2 = 0;
        for (int i =1; i<matrix.length; i++) {
            for (int j=i; j<matrix.length; j++){
                sum =0;
                for (int k=0;k<i;k++) {
                    sum = sum + a[k][j] * b[i][k];
                }
                a[i][j]=matrix[i][j]-sum;
                System.out.println("U"+(i+1)+(j+1)+"="+a[i][j]);
            }
            for (int j=i+1; j<matrix.length;j++){
                sum2 = 0;
                for (int k = 0; k<i; k++){
                    sum2 = sum2 + b[j][k]*a[k][i];
                }
                b[j][i]=(matrix[j][i]-sum2)/a[i][i];
                System.out.println("L"+(j+1)+(i+1)+"="+b[j][i]);
            }
        }

        double[][] check = new double[matrix.length][matrix.length];
        double sumcheck;
        for (int i =0; i<matrix.length;i++){
            for (int j=0;j<matrix.length;j++){
                sumcheck = 0;
                for (int k =0; k<matrix.length;k++){
                    sumcheck=sumcheck+b[i][k]*a[k][j];
                }
                check[i][j]=sumcheck;
            }
        }

        String s = "";

        System.out.println();
        System.out.println("Матрица U");

        for(int i=0; i<matrix.length; i++){
            s="";
            for (int j=0; j<matrix.length; j++){
                s=s+a[i][j]+"\t";
            }
            System.out.println(s);
        }

        String s2 = "";

        System.out.println();
        System.out.println("Матрица L");

        for(int i=0; i<matrix.length; i++){
            s2="";
            for (int j=0; j<matrix.length; j++){
                s2=s2+b[i][j]+"\t";
            }
            System.out.println(s2);
        }

        String s3 = "";

        System.out.println();
        System.out.println("Проверим результат умножением матриц U*L");

        for(int i=0; i<matrix.length; i++){
            s3="";
            for (int j=0; j<matrix.length; j++){
                s3=s3+check[i][j]+"\t";
            }
            System.out.println(s3);
        }


        return new double[0][0];
    }
}
