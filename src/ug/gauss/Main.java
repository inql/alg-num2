package ug.gauss;

import ug.gauss.algorithm.GaussImpl;
import java.util.Random;

import ug.gauss.datatypes.FractionComp;

public class Main {


    public static void main(String[] args) {
        //Dane do macierzy z przykładu ze stronki https://eduinf.waw.pl/inf/alg/001_search/0076.php
        double[][] matrix = {{4,-2,4,-2,8},{3,1,4,2,7},{2,4,2,1,10},{2,-2,4,2,2}};
        double[] result = GaussImpl.gauss(matrix);
        for (double aResult : result) {
            System.out.println(aResult);
        }

        int seed = 1;
        int size = 20;
        Randomizer rand = new Randomizer(seed);
        MyMatrix<FractionComp> mm = new MyMatrix<FractionComp>();
        System.out.println(rand.randomNumber());
        System.out.println(rand.randomNumber());
    }
}
