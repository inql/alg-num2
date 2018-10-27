package ug.gauss.algorithm;

public class GaussImpl {

    public static double[] gauss(double[][] matrix) {
        int n = matrix.length;
        double[] resultVector = new double[n];
        double m = 0;
        double eps = 1e-18;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (Math.abs(matrix[i][i]) < eps) {
                    System.out.println("dzielenie przez 0, lub przez liczbe mniejszą od epsilona");
                }
                m = -matrix[j][i] / matrix[i][i];
                for (int k = i + 1; k <= n; k++)
                    matrix[j][k] += m * matrix[i][k];
            }
        }
        for (int i = n - 1; i >= 0; i--) {
            double s = matrix[i][n];
            for (int j = n - 1; j >= i + 1; j--)
                s -= matrix[i][j] * resultVector[j];
            if (Math.abs(matrix[i][i]) < eps) {
                System.out.println("dzielenie przez 0, lub przez liczbe mniejszą od epsilona");
            }
            resultVector[i] = s / matrix[i][i];
        }
        return resultVector;
    }

}
