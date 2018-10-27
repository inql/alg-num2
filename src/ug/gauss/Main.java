package ug.gauss;

import java.util.Random;

import ug.gauss.datatypes.FractionComp;

public class Main {


    public static void main(String[] args) {

        int seed = 1;
        int size = 20;
        Randomizer rand = new Randomizer(seed);
        MyMatrix<FractionComp> mm = new MyMatrix<FractionComp>();
        System.out.println(rand.randomNumber());
        System.out.println(rand.randomNumber());
    }
}
