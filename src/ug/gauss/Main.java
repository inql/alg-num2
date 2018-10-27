package ug.gauss;

import ug.gauss.algorithm.GaussImpl;

public class Main {

    public static void main(String[] args) {
        //Dane do macierzy z przykładu ze stronki https://eduinf.waw.pl/inf/alg/001_search/0076.php
        double[][] matrix = {{4,-2,4,-2,8},{3,1,4,2,7},{2,4,2,1,10},{2,-2,4,2,2}};
        double[] result = GaussImpl.gauss(matrix);
        for (double aResult : result) {
            System.out.println(aResult);
        }
    }
}
